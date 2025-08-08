package ex15;

import java.util.LinkedHashSet;

public class OrdemInsercao {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("Quarta");
        set.add("Segunda");
        set.add("Sexta");
        set.add("Sabado");
        set.add("Quinta");
        set.add("Domingo");
        set.add("Terca");

        for (String i : set) {
            System.out.println(i);
        }
    }
}
