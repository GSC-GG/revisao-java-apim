package ex6;

public class Circulo {

    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        if (raio <= 0) {
            throw new IllegalArgumentException("Raio nao pode ser negativo ou zero");
        }
        this.raio = raio;
    }

    public double calcularArea() {
        return Math.PI * raio * 2;
    }
}
