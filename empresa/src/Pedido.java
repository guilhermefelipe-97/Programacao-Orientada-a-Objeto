import java.util.ArrayList;
import java.util.Random; //Para gerar o codigo de pedido automaticamente

public class Pedido {
    private String horaCompra;
    private String horaEntrega;
    private String endereco;
    private String status;
    private int cartao;
    private int total;
    private int codigoPedido;

    public Pedido(String horaCompra, String horaEntrega, String endereco, int botijoes) {
        Random random = new Random();
        this.horaCompra = horaCompra;
        this.horaEntrega = horaEntrega;
        this.endereco = endereco;
        this.total = (botijoes * 100);
        this.codigoPedido = 100000 + random.nextInt(900000); // Para gerar um codigo de 6 digitos
    }

    public static String pedidoEntrega(int pedido, int tamanho, ArrayList<Pedido> pedidos) { // (Static) Para não ser necessario instaciar objeto para realizar esse método.
        if (tamanho == 0) {
            return "Ainda nao existem pedidos.";
        } else {
            for (int i = 0; i < tamanho; i++) {
                if (pedido == pedidos.get(i).getCodigoPedido()) {
                    pedidos.get(i).setStatus("entregue");
                    return "Pedido encontrado. Status atualizado para entregue.";
                }
            }
        }
        return "Pedido nao localizado.";
    }

    public static String confirmaPedido(int tamanho, ArrayList<Pedido> pedidos) {
        int j = 0;
        if (tamanho == 0) {
            return "Ainda nao existem pedidos.";
        } else {
            for (int i = 0; i < tamanho; i++) {
                if ("confirmado".equals(pedidos.get(i).getStatus())) {
                    pedidos.get(i).estado();
                    j++;
                } else if ((i == (tamanho - 1)) && (j == 0)) {
                    return "Nao ha pedidos confirmados.";
                }
            }
            j = 0;
        }
        return "Pedidos confirmados listados com sucesso.";
    }

    public static String confirmaEntrega(int tamanho, ArrayList<Pedido> pedidos) {
        int j = 0;
        if (tamanho == 0) {
            return "Ainda nao existem pedidos.";
        } else {
            for (int i = 0; i < tamanho; i++) {
                if ("entregue".equals(pedidos.get(i).getStatus())) {
                    pedidos.get(i).estado();
                    j++;
                } else if ((i == (tamanho - 1)) && (j == 0)) {
                    return "Pedido nao localizado.";
                }
            }
            j = 0;
        }
        return "Pedidos entregues listados com sucesso.";
    }

    public void estado() {
        System.out.println("Codigo do Pedido: " + this.codigoPedido);
        System.out.println("Hora da compra: " + this.horaCompra);
        System.out.println("Hora da entrega: " + this.horaEntrega);
        System.out.println("Cartao n°: " + this.cartao);
        System.out.println("Endereco: " + this.endereco);
        System.out.println("Valor da Compra: R$ " + this.total);
        System.out.println("Status: " + this.status);
        System.out.println("-----------------------");
    }

    public String getHoraCompra() {
        return horaCompra;
    }

    public void setHoraCompra(String horaCompra) {
        this.horaCompra = horaCompra;
    }

    public String getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCartao() {
        return cartao;
    }

    public void setCartao(int cartao) {
        this.cartao = cartao;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }
}