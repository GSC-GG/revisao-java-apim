package ex9;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ListaTarefas {

    private final ArrayList<String> tarefas;

    public static void main(String[] args) {
        ListaTarefas lista = new ListaTarefas();
        int menu;
        boolean loop = true;
        System.out.println("\tLista de Tarefas");

        try (Scanner input = new Scanner(System.in)) {
            while (loop) {
                System.out.println("\n(1) Adicionar tarefa");
                System.out.println("(2) Remover tarefa");
                System.out.println("(3) Listar tarefas");
                System.out.println("(4) Sair");

                menu = input.nextInt();
                input.nextLine();
                switch(menu) {
                    case 1:
                        System.out.print("\nInsira tarefa: ");
                        String tarefa = input.nextLine();
                        lista.getTarefas().add(tarefa);
                        System.out.println("\nTarefa inserida com sucesso!");
                        break;
                    case 2:
                        System.out.print("\nInsira indice da tarefa: ");
                        try {
                            lista.getTarefas().remove(input.nextInt());
                        System.out.println("\nTarefa removida com sucesso!");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Entrada invalida ou elemento inexistente! Remocao abortada");
                        }
                        break;
                    case 3:
                        if (lista.getTarefas().isEmpty()) {
                            System.out.println("A lista esta vazia!");
                            break;
                        }
                        System.out.println("\nTarefas:\n");
                        for (String i : lista.getTarefas()) {
                            System.out.println(i);
                        }
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        loop = false;
                        break;
                    default:
                        throw new InputMismatchException();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida!");
            System.out.println("Saindo...");
        }
    }

    public ListaTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public ArrayList<String> getTarefas() {
        return tarefas;
    }
}
