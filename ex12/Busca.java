package ex12;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Busca {

    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Guarulhos");
        lista.add("Sao Paulo");
        lista.add("Osasco");

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("\nBusque uma cidade: ");
            String cidade = input.nextLine();

            if (lista.contains(cidade)) {
                System.out.println("\nIndice na lista: "
                        + lista.indexOf(cidade)
                );
            } else {
                System.out.println("\nCidade nao encontrada");
            }
        } catch (InputMismatchException e) {
            System.out.println("\nEntrada invalida!");
        }
    }
}
