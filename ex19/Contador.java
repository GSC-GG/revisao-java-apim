package ex19;

import java.util.HashMap;

public class Contador {

    public static void main(String[] args) {
        String texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum vel risus a lacus consequat gravida eu id ex. Vestibulum vel imperdiet eros. Cras at mi nec lectus eleifend egestas ut et lectus. Proin dolor magna, bibendum et tortor id, commodo sodales arcu. Quisque pretium tellus a tortor malesuada, a consequat purus faucibus. Nunc sit amet interdum metus. Morbi accumsan orci a nisl mollis condimentum. Fusce eget sapien arcu. Nullam a lacus justo. Aliquam gravida consectetur ex et ullamcorper. Nulla faucibus mauris in congue dictum. In vestibulum imperdiet quam ac ultrices. Praesent eget dui purus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus mollis posuere lorem pulvinar imperdiet.";

        HashMap<String, Integer> map = new HashMap<>();
        for (String i : texto.split("[,\\.\\s]")) {
            if (i.equals("") || i.equals(" ")) {
                continue;
            }
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        for (String i : map.keySet()) {
            System.out.println(i + ": " + map.get(i) + " ocorrencias");
        }
    }
}
