package ex18;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dicionario {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mapa", "map");
        map.put("codigo", "code");
        map.put("cafe", "coffee");
        map.put("agua", "water");
        map.put("Deus", "God");

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("\nBusque uma palavra: ");
            String traducao = map.get(input.nextLine());

            if (traducao == null) {
                System.out.println("\nPalavra nao encontrada\n");
            } else {
                System.out.println("Traducao: " + traducao);
            }
        } catch (InputMismatchException e) {
            System.out.println("\nEntrada invalida!\n");
        }
    }
}
