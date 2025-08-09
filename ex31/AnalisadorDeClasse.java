package ex31;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnalisadorDeClasse {

    public static void inspecionar(Object obj) {

        Class classe = obj.getClass();
        System.out.println("Classe: " + classe.getName());

        Field[] atributos = classe.getDeclaredFields();
        System.out.println("\nAtributos: ");
        for (Field atributo : atributos) {
            System.out.println("- " + atributo.getName());
        }

        Method[] metodos = classe.getDeclaredMethods();
        System.out.println("\nMetodos: ");
        for (Method metodo : metodos) {
            System.out.println("- " + metodo.getName());
        }
    }
}
