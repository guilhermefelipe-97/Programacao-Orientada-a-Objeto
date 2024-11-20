public class Robo {
    private int linha;
    private int coluna;
    private int passo;

    public Robo (int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
        this.passo = 1;
    }

    public void mostrarPosicaoAtual (){
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 40; j++){
               if (i == getLinha() && j == getColuna()){
                    System.out.print("1");
               }else{
                System.out.print(" ");
               }
            }
            System.out.println();
        }
        System.out.println("\nCoordenada Atual: (" + getLinha() + "," + getColuna() + ")");
    }

    public void andarCima (){
        if (this.linha - this.passo >= 0){
        this.linha = this.linha - this.passo;
        }else{
            setLinha(0);
        }
    }

    public void andarBaixo (){
        if (this.linha + this.passo <= 19){
            this.linha = this.linha + this.passo ;
        }else{
            setLinha(19); 
        }
    }
    
    public void andarDireita (){
        if (this.coluna + this.passo <= 39){
            this.coluna = this.coluna + this.passo;
        }else{
            setColuna(39);
        }
    }

    public void andarEsquerda (){
        if (this.coluna - this.passo >= 0){
            this.coluna = this.coluna - this.passo;
        }else{
            setColuna(0);
        }
    }

    public void mudarPasso (int passoNovo){
            setPasso(passoNovo);
            System.out.println("Passo alterado com sucesso.");
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getPasso() {
        return passo;
    }

    public void setPasso(int passo) {
        this.passo = passo;
    }
}