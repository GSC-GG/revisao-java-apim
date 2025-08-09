package ex31;

public class Main {
    
    public static void main(String[] args) {
        
        Produto p = new Produto(101, "Notebook Gamer", 8500.0);
        AnalisadorDeClasse.inspecionar(p);
    }
}
