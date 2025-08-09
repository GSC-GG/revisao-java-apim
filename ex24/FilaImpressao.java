package ex24;

import java.util.LinkedList;
import java.util.Queue;

public class FilaImpressao {

    public static void main(String[] args) {

        Queue<String> fila = new LinkedList<>();
        fila.offer("documento1.pdf");
        fila.offer("foto.png");
        fila.offer("documento2.pdf");
        fila.offer("artigo.docx");
        fila.offer("imagem.jpg");

        while (fila.peek() != null) {
            System.out.println("Imprimindo: " + fila.poll());
        }
    }
}
