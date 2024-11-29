public class C2 extends C1 {
    //Cachorro
    private String raca;

    public C2(String nome){ //Construtor padrão
        super(nome);
    }

    public C2(String raca, String nome){ //Sobrecarga de Construtor
        super(nome);
        this.raca = raca;
    }

    @Override //Sobreescrita de método
    void fazerSom(){
        System.out.println("O cachorro late.");
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}