package ex17;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        

        TreeSet<Produto> set = new TreeSet<>();
        set.add(new Produto("Chocolate", 9.50));
        set.add(new Produto("Bolacha", 2.50));
        set.add(new Produto("Cookies", 4.50));

        for (Produto i : set) {
            System.out.println(i);
        }
    }
}
