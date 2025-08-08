package ex21;

import java.util.LinkedHashMap;

public class OrdemCadastro {

    public static void main(String[] args) {

        LinkedHashMap<Integer, String> produtos = new LinkedHashMap<>();
        produtos.put(3, "chocolate");
        produtos.put(1, "bolacha");
        produtos.put(2, "cookie");
        produtos.put(5, "vinagre");
        produtos.put(4, "acucar");

        for (int i : produtos.keySet()) {
            System.out.println(produtos.get(i));
        }
    }
}
