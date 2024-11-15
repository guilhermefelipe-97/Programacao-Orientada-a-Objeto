public class Caneta {
    private String modelo;
    private String cor;
    private float ponta;
    private int carga;
    private boolean tampada;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getPonta() {
        return ponta;
    }

    public void setPonta(float ponta) {
        this.ponta = ponta;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public boolean isTampada() {
        return tampada;
    }

    public void setTampada(boolean tampada) {
        this.tampada = tampada;
    }

    void status(){
        System.out.println("Modelo " + this.modelo);
        System.out.println("Cor " + this.cor);
        System.out.println("Ponta " + this.ponta);
        System.out.println("Carga " + this.carga);
        if (this.tampada){
        System.out.println("Esta tampada");
        }else{
            System.out.println("Esta destampada");
        }
    }

    void escrever(){
        if (this.tampada == true){
            System.out.println("A caneta esta tampada.");
        }else if (this.carga > 0){
            System.out.println("Escrevendo...");
            this.carga -= - 1;
        }else{
            System.out.println("Caneta sem carga.");
        }
    }

    void destampar(){
        this.tampada = false;
    }
  
}