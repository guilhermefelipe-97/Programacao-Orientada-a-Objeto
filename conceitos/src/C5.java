public class C5 extends C2 implements I1{
    private float tamanho;
    private boolean marcador;

    public C5 (String raca, String nome, float tamanho){
        super(raca, nome);
        this.tamanho = tamanho;
    }

    public void dormir(){
        setMarcador(true);
    }

    public void acordar(){
        setMarcador(false);
    }

    public void estado(){
        System.out.println("Um cachorro que mede " + getTamanho() + " dorme " + getTamanho() * 10 + " horas.");
        if (getMarcador() == false){
            System.out.println("O cachorro esta acordado.");
        }else{
            System.out.println("O cachorro esta dormindo.");
        }
    }

    public void tamanho(String raca){
        if (raca == "Cocker Spaniel"){
            System.out.println("Um cachorro da raça" + raca + " deve medir entre 38 a 41 cm (macho e fêmea)");
        }else if (raca == "Pitbull"){
            System.out.println("Um cachorro da raça" + raca + "  deve medir entre 45 a 53 cm (macho) / 43 a 50 cm (fêmea)");
        }else if (raca == "Golden"){
            System.out.println("Um cachorro da raça" + raca + "  deve medir entre 56 a 61 cm (macho) / 51 a 56 cm (fêmea)");
        }
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public boolean getMarcador() {
        return marcador;
    }

    public void setMarcador(boolean marcador) {
        this.marcador = marcador;
    }
}