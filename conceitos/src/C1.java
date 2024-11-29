public abstract class C1 {
    //Animal
    private String nome;

    public C1 (String nome){
        this.nome = nome;
    }

    abstract void fazerSom(); //Sobreescrita de método

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}