package ex1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraMedia {

    public static void main(String[] args) {
        float n1, n2, n3, media;

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("\tCalculadora de Média de Notas\n");

            System.out.print("Insira a primeira nota: ");
            n1 = input.nextFloat();

            System.out.print("Insira a segunda nota: ");
            n2 = input.nextFloat();

            System.out.print("Insira a terceira nota: ");
            n3 = input.nextFloat();

            media = (n1 + n2 + n3) / 3;
            System.out.print("\nMedia: " + media);

            if (media >= 7) {
                System.out.println("\t(Aprovado)");
            } else if (media < 5) {
                System.out.println("\t(Reprovado)");
            } else {
                System.out.println("\t(Recuperacao)");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida!");
        }
    }
}
