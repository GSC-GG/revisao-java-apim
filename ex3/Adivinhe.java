package ex3;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Adivinhe {

    public static void main(String[] args) {
        final int resposta = new Random().nextInt(1, 100);
        int num, tentativas = 0;

        System.out.print("Adivinhe o número de 1 a 100: ");
        try (Scanner input = new Scanner(System.in)) {
            num = input.nextInt();

            while (num != resposta) {
                if (num > resposta) {
                    System.out.print("Muito alto! ");
                } else {
                    System.out.print("Muito baixo! ");
                }
                System.out.print("Tente novamente: ");
                tentativas++;
                num = input.nextInt();
            }

            System.out.println("Acertou!\nNumero de tentativas: " + tentativas);
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida!");
        }
    }
}
