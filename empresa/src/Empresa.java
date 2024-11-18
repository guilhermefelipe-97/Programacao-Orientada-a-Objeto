import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pedido> pedidos = new ArrayList<>();
        int opcao = 0, botijoes = 0, contador = 0, cartao = 0, pedido = 0;
        String endereco;
        char confirmacao;
        int tamanho = pedidos.size();
        do{     
            System.out.println("\tMENU");
            System.out.println("--------------------");
            System.out.println("1- Fazer Pedido");
            System.out.println("2- Confirmar Entrega");
            System.out.println("3- Ver pedidos confirmados");
            System.out.println("4- Ver pedidos entregues");
            System.out.println("5- Sair");
            System.out.println("--------------------");
            System.out.println("Digite a opcao:");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    LocalTime horaAtual = LocalTime.now(); //Para pegar o horario atual do sistema
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String horarioPedido = horaAtual.format(formato);
                    LocalTime novaHora = horaAtual.plusHours(6); //Realiza a soma do horario atual + 6
                    String horarioEntrega = novaHora.format(formato);
                    System.out.println("Digite o endereco:");
                    endereco = scanner.nextLine();
                    do{
                    System.out.println("Confirma os dados? (S/N)");
                    confirmacao = scanner.next().charAt(0);
                    scanner.nextLine();
                    if (confirmacao == 'N'){
                        System.out.println("Digite o endereco correto:");
                        endereco = scanner.nextLine();
                    }
                    }while (confirmacao != 'S');
                    System.out.println("Hora do pedido: " + horarioPedido);
                    System.out.println("Endereco: " + endereco);
                    System.out.println("Digite a quantidade de botijoes:");
                    botijoes = scanner.nextInt();
                    pedidos.add(new Pedido(horarioPedido, horarioEntrega, endereco, botijoes));
                    System.out.println("O valor total e de R$ " + pedidos.get(contador).getTotal());
                    System.out.println("A hora da entrega sera as: " + horarioEntrega);
                    System.out.println("Digite o numero do cartao de credito");
                    cartao = scanner.nextInt();
                    pedidos.get(contador).setCartao(cartao);
                    pedidos.get(contador).setStatus("confirmado");
                    System.out.println("O codigo do seu pedido e: " + pedidos.get(contador).getCodigoPedido());
                    contador++;
                    tamanho = pedidos.size();
                    break;
                case 2:
                    System.out.println("Digite o numero do pedido");
                    pedido = scanner.nextInt();
                    System.out.println(Pedido.pedidoEntrega(pedido, tamanho, pedidos)); 
                    break;
                case 3:
                    System.out.println(Pedido.confirmaPedido(tamanho, pedidos)); 
                    break;
                case 4:
                    System.out.println(Pedido.confirmaEntrega(tamanho, pedidos)); 
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;    
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
        }while(opcao!=5);
        scanner.close();
    }
}