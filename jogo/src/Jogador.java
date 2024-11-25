import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Jogador {
    private String nome;
    private String cpf;
    private float aposta;
    private float premio;
    private int palpite;
    private int vitorias;
    
    public Jogador(int vitorias, float premio) {
        this.vitorias = vitorias;
        this.premio = premio;
        }

    public static void cadastraJogador (ArrayList <Jogador> jogador, int valorPalpite){
        int i = 0, j = 0, marcador = 0;
        boolean verificacpf = false;
        Scanner scanner = new Scanner(System.in);
        String numero = "0";
        for (Jogador jogadores : jogador){
            System.out.println("Digite o nome do jogador " + (i+1));
            jogadores.setNome(scanner.nextLine());
            do{     
                for (j = 0; j < jogador.size(); j++){
                    System.out.println("Digite o CPF do jogador:");
                    numero = scanner.nextLine();
                    if (jogador.get(j).getCpf() == numero){
                        System.out.println("Ja existe um jogador com esse CPF");
                        verificacpf = true;
                        j = -1;
                    }else{
                        verificacpf = false;
                        break;
                    }
                }
            }while(verificacpf == true);
            jogadores.setCpf(numero);
            System.out.println("Digite a aposta do jogador " + (i+1));
            jogadores.setAposta(scanner.nextFloat());
            do{
            System.out.println("Digite o palpite do jogador: (Valor entre 2 e 12)");
            valorPalpite = scanner.nextInt();
            }while((valorPalpite > 12 || valorPalpite < 2));
            do{
            for (j = 0; j < jogador.size(); j++){
                if (jogador.get(j).getPalpite() == valorPalpite){
                    marcador++;
                }else if(marcador > 0){
                    System.out.println("Palpite já feito por outro jogador. Digite outro palpite:");
                    valorPalpite = scanner.nextInt();
                    if ((valorPalpite > 12 || valorPalpite < 2)){
                        do{
                            System.out.println("O valor deve ser entre 2 e 12. Digite outro palpite:");
                            valorPalpite = scanner.nextInt();
                        }while ((valorPalpite > 12 || valorPalpite < 2));
                    }
                    j = -1;
                    marcador = 0;
                }
            }
            }while(marcador > 0 || (valorPalpite > 12 || valorPalpite < 2));
            jogadores.setPalpite(valorPalpite);
            scanner.nextLine();
            i++;
        }
        scanner.close();
    }

    public static void verificaResultado (ArrayList <Jogador> jogador, int resultado){
        boolean verificacao = false;
        float premio = 0;
        for (Jogador jogadores : jogador){
            premio += jogadores.getAposta();
        }

        for (Jogador jogadores : jogador){
            if (jogadores.getPalpite() == resultado){
                System.out.println("O jogador " + jogadores.getNome() + " acertou e ira receber o premio no valor de " + premio + " reais!");
                jogadores.setPremio(premio);
                verificacao = Jogador.verificarJogadores(jogadores.getNome(), jogadores.getCpf());
                if (verificacao == false){
                jogadores.setVitorias(1);
                salvarEmArquivo(jogadores.getNome(), "C:/Ranking/dados.txt", jogadores.getCpf(), jogadores.getVitorias());
                verificacao = true;
                }
            }
        }
        if (verificacao == false){
            System.out.println("A maquina venceu.");
        }
    }

    public static void salvarEmArquivo(String nome, String nomeArquivo, String cpf , int vitorias){
        if (buscarArquivo() == true){
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            writer.write(nome + "," + cpf + "," + vitorias + System.lineSeparator());
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
        }
    }

    public static void lerArquivo(String localArquivo) { //Leitura do arquivo do ranking
        try (BufferedReader leitor = new BufferedReader(new FileReader(localArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static boolean buscarArquivo(){ //Verificar se ja tem 5 pessoas no Top Five
        int contador = 0;
        String linha;
        try (BufferedReader leitor = new BufferedReader(new FileReader("C:/Ranking/dados.txt"))) {
            while ((linha = leitor.readLine()) != null) {
                if (linha.contains(",")) {
                    contador++;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        if (contador < 5){
            return true;
        }
        return false;
    }

    public static boolean exibirRanking(){
        String linha;
        try (BufferedReader leitor = new BufferedReader(new FileReader("C:/Ranking/dados.txt"))){
        while ((linha = leitor.readLine()) != null) {
            if (linha.contains(",")) { // Verifica se já existe ranking.
                return true;
            }
        }
    }catch (IOException e) {
        System.out.println("Erro ao ler o arquivo: " + e.getMessage());
    }
        return false;
    }

    public static boolean verificarJogadores (String nome, String cpf){ //Verifica se ja existe esse nome + cpf cadastrado
        List<String> linhasArquivo = new ArrayList<>();
        boolean verificador = false;
        try (BufferedReader leitor = new BufferedReader(new FileReader("C:/Ranking/dados.txt"))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                // Verifica se a linha contém o jogador específico
                if (linha.startsWith(nome + "," + cpf)) {
                    verificador = true;
                    String[] parte = linha.split(","); // Divide a linha em partes (nome e atributos)
                        int vitorias = Integer.parseInt(parte[2]);
                        vitorias++;
                        parte[2] = Integer.toString(vitorias);
                        linha = String.join(",", parte); // Recria a linha com o novo valor de vitórias
                }
                linhasArquivo.add(linha); // Adiciona a linha à lista
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter o número de vitórias: " + e.getMessage());
        }

        try (BufferedWriter leitor = new BufferedWriter(new FileWriter("C:/Ranking/dados.txt"))) {
            for (String linha : linhasArquivo) {
                leitor.write(linha);
                leitor.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
        System.out.println("Número de vitórias atualizado com sucesso.");
        return verificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getAposta() {
        return aposta;
    }

    public void setAposta(float aposta) {
        this.aposta = aposta;
    }

    public int getPalpite() {
        return palpite;
    }

    public void setPalpite(int palpite) {
        this.palpite = palpite;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias += vitorias;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf (String cpf) {
        this.cpf = cpf;
    }

    public float getPremio() {
        return premio;
    }

    public void setPremio (float premio) {
        this.premio = premio;
    }
}