package ex2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        int num, produto;
        try (Scanner input = new Scanner(System.in)) {

            System.out.println("\tTabuada\n");
            System.out.print("Digite um numero inteiro: ");
            num = input.nextInt();

            for (int i = 1; i <= 10; i++) {
                produto = num*i;
                System.out.println(num + " x " + i + " = " + produto);
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida!");
        }
    }
}

