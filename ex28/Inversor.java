package ex28;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Inversor {
    
    public static void main(String[] args) {
        
        Deque<String> pilha = new ArrayDeque<>();

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Insira uma frase: ");
            String frase = input.nextLine();
            System.out.print(Arrays.toString(frase.split("[,\\.\\s]")));
            
            for (String i : frase.split("[,\\.\\s]")) {
                /*if (i.equals("") || i.equals(" ")) {
                    continue;
                }*/
                pilha.push(i);
            }
            
            System.out.println("\nFrase invertida:");
            for (String i : pilha) {
                System.out.print(pilha.pop());
            }
        }
    }
}
