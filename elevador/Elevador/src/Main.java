import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        Elevador elevador = new Elevador();
        do{
            System.out.println("Menu");
            System.out.println("---------------");
            System.out.println("1 - Inicializa");
            System.out.println("2 - Entra");
            System.out.println("3 - Sai");
            System.out.println("4 - Status");
            System.out.println("5 - Subir andar");
            System.out.println("6 - Descer andar");
            System.out.println("7 - Encerrar");
            System.out.println("Digite a opcao:");
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                elevador.inicializa();    
                    break;    
                case 2:
                if (elevador.getPessoas() < elevador.getCapacidade()){
                elevador.entra();
                }else{
                    System.out.println("O elevador esta cheio.");    
                }      
                    break;
                case 3:
                if (elevador.getPessoas() > 0){
                    elevador.sai();
                }else{
                    System.out.println("O elevador esta vazio."); 
                }      
                    break;
                case 4:
                    elevador.status();      
                    break;
                case 5:
                    if (elevador.getAndar() < elevador.getTotal()){
                        elevador.setAndar(elevador.getAndar() + 1);
                    }else{
                        System.out.println("Voce esta no ultimo andar.");
                    }      
                    break;
                case 6:
                    if (elevador.getAndar() > 0){
                        elevador.setAndar(elevador.getAndar() - 1);
                    }else{
                        System.out.println("Voce esta no terreo.");
                    }       
                    break;
                case 7:      
                    break;
                default:
                System.out.println("Opcao invalida.");
                    break;
            }
        }while(opcao!=7);
        scanner.close();
    }
}
