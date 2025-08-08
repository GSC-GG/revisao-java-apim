package ex10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class OrdenaNumeros {

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            lista.add(random.nextInt(0, 100));
        }

        System.out.print("\nLista desordenada:");
        for (int i : lista) {
            System.out.print(" " + i);
        }

        Collections.sort(lista);

        System.out.print("\nLista ordenada:");
        for (int i : lista) {
            System.out.print(" " + i);
        }
    }
}
