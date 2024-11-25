import java.util.Random;
public class Dado {
    private int lado;

    public void jogaDado(){
        Random random = new Random();
        int lado = random.nextInt(6) + 1;
        setLado(lado);
    }

    public int somaDados(int dado1, int dado2){
        return 10; 
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }
}