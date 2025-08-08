package ex4;

public class SomaImpares {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int soma = 0;
        for (int i : nums) {
            if (i % 2 != 0) {
                soma += i;
            }
        }
        System.out.println("Soma dos impares: " + soma);
    }
}
