public class C4 extends C2{
    private int idade;

    public C4 (String raca, String nome, int idade){
        super(raca, nome);
        this.idade = idade;
    }
    
    public void comer(double pesoComida){ //Sobrecarga de método
        System.out.println("Um cachorro come " + pesoComida + " g de racao;");
    }

    public String comer(double pesoComida, int idade){ //Sobrecarga de método
        pesoComida = idade * 0.5 * pesoComida;
        return "Um cachorro com " + idade + " anos come " + pesoComida + " g de racao";
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}