    import java.util.Scanner;
    import java.util.ArrayList;

    public class App {
        public static void main(String[] args) throws Exception {
            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);
            ArrayList <Jogador> jogador = new ArrayList<>();
            int qtdJogadores, valorPalpite = 0, i = 0;
            Dado dado1 = new Dado();
            Dado dado2 = new Dado();
            
            System.out.println("-----------------------------");
            System.out.println("|\tDados da Sorte      |");
            System.out.println("-----------------------------");
            System.err.println();
            if (Jogador.exibirRanking() == true){
                System.out.println("--------- TOP FIVE ---------");
                System.out.println("| Nome, CPF, Vitórias      |");
                System.out.println("----------------------------");
                Jogador.lerArquivo("C:/Ranking/dados.txt");
                System.out.println();
            }
            do{
            System.out.println("Digite a quantidade de jogadores: (No maximo 11)");
            qtdJogadores = scanner.nextInt();
            }while(qtdJogadores > 11 || qtdJogadores < 1);
            scanner.nextLine();
            for (i = 0; i < qtdJogadores; i++){
                jogador.add(new Jogador(0, 0));
            }
            Jogador.cadastraJogador(jogador, valorPalpite);
            dado1.jogaDado();
            dado2.jogaDado();
            int resultado = dado1.somaDados(dado1.getLado(), dado2.getLado());
            System.out.println("O resultado foi: " + resultado);
            Jogador.verificaResultado(jogador, resultado);
            scanner.close();
        } 
    }