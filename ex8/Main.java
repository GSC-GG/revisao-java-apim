package ex8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(200);
        try (Scanner input = new Scanner(System.in)){
            System.out.print("Insira valor a sacar: ");
            double valor = input.nextDouble();
            conta.sacar(valor);
            System.out.println("Valor sacado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida!");
        } catch (SaldoInsuficienteException e) {
            System.out.println("Saldo insuficiente!");
        } finally {
            System.out.println("\nOperacao finalizada.");
        }
    }
}
