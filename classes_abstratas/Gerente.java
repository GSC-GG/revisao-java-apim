package classes_abstratas;

public class Gerente extends Funcionario {

    private String area;

    public Gerente(String nome, Data nascimento, float Salario, String area) {
        super(nome, nascimento, Salario);
        this.area = area;
    }

    @Override
    public void imprimeDados() {
        System.out.println("Gerente");
        System.out.println("Nome: " + this.nome);
        System.out.println("Nascimento: " + this.nascimento);
        System.out.println("Salario: " + this.salario);
        System.out.println("Area: " + this.area);
    }

    @Override
    public float calculaImposto() {
        return (float) (this.salario * 0.05);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
