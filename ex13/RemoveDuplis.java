package ex13;

import java.util.ArrayList;
import java.util.HashSet;

public class RemoveDuplis {

    public static void main(String[] args) {
        
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(3);

        System.out.println("\nLista inicial:\n");
        for (int i : lista) {
            System.out.println(i);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i : lista) {
            set.add(i);
        }

        System.out.println("\nColecao final:\n");
        for (int i : set) {
            System.out.println(i);
        }
    }
}
