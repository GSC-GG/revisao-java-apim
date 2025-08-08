package ex14;

import java.util.HashSet;

public class UnicidadeEmails {

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();
        set.add("maria@hotmail.com");
        set.add("maria@hotmail.com");
        set.add("fernando.silva@gmail.com");

        System.out.println("\nColecao:\n");
        for (String i : set) {
            System.out.println(i);
        }

        System.out.println("\nTamanho da colecao: " + set.size());
    }
}
