import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Robo R1 = new Robo(0, 0);
        Scanner scanner = new Scanner(System.in);
        char opcao;
        int passoNovo;
        R1.mostrarPosicaoAtual();
        do{
            System.out.println("Digite a direcao: W - cima, S - baixo, A - esquerda, D- direita, M - alterar passo, X - sair do programa :");
            opcao = scanner.next().charAt(0);
            switch (opcao) {
                case 'W':
                    R1.andarCima();
                    R1.mostrarPosicaoAtual();
                    break;

                case 'S':
                    R1.andarBaixo();
                    R1.mostrarPosicaoAtual();
                    break;

                case 'A':
                    R1.andarEsquerda();
                    R1.mostrarPosicaoAtual();
                    break;

                case 'D':
                    R1.andarDireita();
                    R1.mostrarPosicaoAtual();
                    break;

                case 'X':
                    System.out.println("Programa Finalizado.");
                    break;

                case 'M':
                    System.out.println("Digite a quantidade de passos:");
                    passoNovo = scanner.nextInt();
                    R1.mudarPasso(passoNovo);
                    break;
                
                default:
                    System.out.println("Opcao nao existente.");
                    break;
            }
        }while(opcao!='X');
        scanner.close(); 
    }
}