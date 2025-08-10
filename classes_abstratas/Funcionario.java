package classes_abstratas;

public class Funcionario extends Pessoa {

    protected float salario;

    public Funcionario(String nome, Data nascimento, float salario) {
        super(nome, nascimento);
        this.salario = salario;
    }

    @Override
    public void imprimeDados() {
        System.out.println("Funcionario");
        System.out.println("Nome: " + this.nome);
        System.out.println("Nascimento: " + this.nascimento);
        System.out.println("Salario: " + this.salario);
    }

    public float calculaImposto() {
        return (float) (this.salario * 0.03);
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
