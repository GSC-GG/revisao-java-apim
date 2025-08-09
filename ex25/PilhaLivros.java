package ex25;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PilhaLivros {

    public static void main(String[] args) {

        ArrayDeque<String> pilha = new ArrayDeque<>();

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Empilhe 3 livros: ");
            pilha.push(input.nextLine());
            pilha.push(input.nextLine());
            pilha.push(input.nextLine());

            System.out.println("\nLivro removido: " + pilha.pop());
            System.out.println("Livro no topo: " + pilha.peek());
        }
    }
}
