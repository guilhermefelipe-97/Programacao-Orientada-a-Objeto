public class App {
    public static void main(String[] args) throws Exception {
        C2 cachorro1 = new C2("Pitbull", "Monster");
        C3 gato = new C3("Cinza", "Netuno", 3.9f);
        C4 cachorro2 = new C4("Golden", "Apolo", 3);
        C5 cachorro3 = new C5("Cocker Spaniel", "Amora", 0.39f);
        I1 meuGato = new C3("Branco", "Mingau", 4.3f);
        I1 meuCachorro = new C5("Pastor Alemão", "Myke", 0.65f);
        I2 meuGato2 = new C3("Preto", "Pirulito", 4.45f);

        cachorro1.fazerSom(); //Sobreescrita de método
        gato.fazerSom(); //Sobreescrita de método
        cachorro2.comer(300); //Método Principal
        System.out.println(cachorro2.comer(300, 3)); //Sobrecarga de método
        cachorro3.tamanho("Golden");
        System.out.println();

        //Utilização de interface
        meuGato.dormir();
        meuGato.estado();
        meuGato.acordar();
        meuGato.estado();
        meuCachorro.dormir();
        meuCachorro.estado();
        meuCachorro.acordar();
        meuGato2.verificaCor();
        meuGato2.verificarPeso();
        meuGato2.alteraCor("Cinza Escuro");
        meuGato2.verificaCor();
    }
}