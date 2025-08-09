package ex27;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Sorteio {

    public static void main(String[] args) {

        List<String> lista = new ArrayList<>();
        lista.add("Rogerio");
        lista.add("Pedro");
        lista.add("Bernardo");
        lista.add("Rogerio");
        lista.add("Fernando");
        lista.add("Fernando");
        lista.add("Alice");
        lista.add("Pedro");
        lista.add("Felipe");
        lista.add("Paula");
        lista.add("Fernando");

        Set<String> vencedores = new Sorteio().sorteio(lista);
        System.out.println("Vencedores:");
        for (String i : vencedores) {
            System.out.println(i);
        }
    }

    public Set<String> sorteio(List<String> participantes) {
        Set<String> jogadores = new HashSet<>();

        Random random = new Random();
        for (int j = 1; j <= 3; j++) {
            int rand = random.nextInt(0, participantes.size());
            if (!jogadores.add(participantes.get(rand))) {
                j--;
            }
        }
        return jogadores;
    }
}
