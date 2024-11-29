public class C3 extends C1 implements I1, I2{
    //Gato
    private String cor;
    private Boolean estado;
    private float peso;

    public C3(String cor, String nome, float peso){
        super(nome);
        this.cor = cor;
        this.estado = true;
        this.peso = peso;
    }

    public void dormir(){
        setEstado(true);
    }

    public void acordar(){
        setEstado(false);
    }

    public void estado(){
        if (this.getEstado() == true){
            System.out.println("O gato esta dormindo.");
        }else{
            System.out.println("O gato esta acordado.");
        }
    }

    public void alteraCor(String cor){
        setCor(cor);
    }

    public void verificaCor(){
        System.out.println("A cor do gato " + getNome() + " e " + getCor());
    }

    public void verificarPeso(){
        System.out.println("O gato " + getNome() + " da cor " + getCor() + " pesa " + getPeso() + " kg");
    }

    @Override //Sobreescrita de método
    void fazerSom(){
        System.out.println("O gato mia.");
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

}