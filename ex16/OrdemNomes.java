package ex16;

import java.util.TreeSet;

public class OrdemNomes {

    public static void main(String[] args) {
        
        TreeSet<String> set = new TreeSet<>();
        set.add("Lucas");
        set.add("William");
        set.add("Fernanda");
        set.add("Amanda");
        set.add("Guilherme");

        for (String i : set) {
            System.out.println(i);
        }
    }
}
