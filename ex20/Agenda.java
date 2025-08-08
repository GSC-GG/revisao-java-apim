package ex20;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Agenda {

    private HashMap<String, String> map;

    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        HashMap<String, String> map = agenda.getMap();
        int menu;
        boolean loop = true;
        String nome, numero;
        System.out.println("\tAgenda de Contatos");

        try (Scanner input = new Scanner(System.in)) {
            while (loop) {
                System.out.println("\n(1) Adicionar contato");
                System.out.println("(2) Buscar contato");
                System.out.println("(3) Listar contatos");
                System.out.println("(4) Sair");

                menu = input.nextInt();
                input.nextLine();
                switch (menu) {
                    case 1:
                        System.out.print("\nNome: ");
                        nome = input.nextLine();
                        System.out.print("Numero: ");
                        numero = input.nextLine();
                        map.put(nome, numero);
                        System.out.println("\nContato inserido com sucesso!");
                        break;
                    case 2:
                        System.out.print("\nNome: ");
                        nome = input.nextLine();
                        numero = map.get(nome);
                        if (numero == null) {
                            System.out.println("\nContato nao encontrado!");
                        } else {
                            System.out.print("\nNome: " + nome);
                            System.out.print("\nNumero: " + numero + "\n");
                        }
                        break;
                    case 3:
                        if (map.isEmpty()) {
                            System.out.println("A agenda esta vazia!");
                            break;
                        }
                        System.out.println("\nContatos:");
                        for (String i : map.keySet()) {
                            System.out.print("\nNome: " + i);
                            System.out.print("\nNumero: " + map.get(i) + "\n");
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

    public Agenda() {
        this.map = new HashMap<>();
    }

    public HashMap<String, String> getMap() {
        return map;
    }
}
