package ex26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalogo {

    public static void main(String[] args) {

        Map<String, List<Produto>> catalogo = new HashMap<>();

        List<Produto> doces = new ArrayList<>();
        doces.add(new Produto("bala", 0.50));
        doces.add(new Produto("cookies", 4.50));
        doces.add(new Produto("chocolate", 9.50));
        catalogo.put("doces", doces);

        List<Produto> eletronicos = new ArrayList<>();
        eletronicos.add(new Produto("celular", 1229.79));
        eletronicos.add(new Produto("notebook", 3549.99));
        eletronicos.add(new Produto("videogame", 6179.49));
        catalogo.put("eletronicos", eletronicos);

        System.out.println("Eletronicos:");
        for (Produto i : catalogo.get("eletronicos")) {
            System.out.println(i);
        }
    }
}
