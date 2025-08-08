package ex11;

import java.util.LinkedList;

public class Manipula {

    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>();

        lista.addLast("Roberto");
        lista.addLast("Arnaldo");
        lista.addLast("Maria");
        lista.addLast("Jose");
        lista.addLast("Pericles");

        System.out.println("\nLista inicial:\n");
        for (String i : lista) {
            System.out.println(i);
        }

        lista.removeFirst();
        lista.removeFirst();

        System.out.println("\nLista pos-atendimento:\n");
        for (String i : lista) {
            System.out.println(i);
        }

        lista.addFirst("Lucio");
        lista.addFirst("Adalberto");

        System.out.println("\nLista final:\n");
        for (String i : lista) {
            System.out.println(i);
        }
    }
}
