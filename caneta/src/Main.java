public class Main {
    public static void main(String[] args){
        Caneta c1 = new Caneta();
        c1.setModelo ("BIC");
        c1.setCor ("Azul");
        c1.setPonta (0.7f);
        c1.setCarga (10);
        c1.setTampada (true);

        c1.status();
        c1.escrever();
        c1.destampar();
        c1.escrever();
        c1.status();

        System.out.println("-----------------------");

        Caneta c2 = new Caneta();
        c2.setModelo ("Faber Castell");
        c2.setCor ("Vermelha");
        c2.setPonta (0.5f);
        c2.setCarga (5);
        c2.setTampada (true);

        c2.status();
        c2.escrever();
        c2.destampar();
        c2.escrever();
        c2.status();
    }
}
