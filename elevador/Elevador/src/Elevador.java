public class Elevador {
    private int andar;
    private int total;
    private int capacidade;
    private int pessoas;

    public int getAndar() {
        return andar;
    }
    public void setAndar(int andar) {
        this.andar = andar;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    public int getPessoas() {
        return pessoas;
    }
    public void setPessoas(int pessoas) {
        this.pessoas = pessoas;
    }

    public void inicializa (){
        this.andar = 0;
        this.total = 9; 
        this.capacidade = 5;  
        this.pessoas = 0;
    }

    public void entra (){
        this.pessoas += 1;
    }
    
    public void sai (){
        this.pessoas -= 1; 
    }

    public void status (){
        System.out.println("Andar atual " + this.andar);
        System.out.println("Total de andares " + this.total);
        System.out.println("Capacidade total de pessoas " + this.capacidade);
        System.out.println("Pessoas no elevador " + this.pessoas);
    }
}