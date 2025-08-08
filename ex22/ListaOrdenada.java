package ex22;

import java.util.TreeMap;

public class ListaOrdenada {

    public static void main(String[] args) {

        TreeMap<String, Double> notas = new TreeMap<>();
        notas.put("Luis", 7.5);
        notas.put("Camila", 9.0);
        notas.put("Aline", 6.5);
        notas.put("Rogerio", 7.0);
        notas.put("Lara", 5.75);

        for (String i : notas.keySet()) {
            System.out.println(i + ": " + notas.get(i));
        }
    }
}
