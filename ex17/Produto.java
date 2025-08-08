package ex17;

public class Produto implements Comparable<Produto> {

    private String nome;
    private double preco;

    @Override
    public int compareTo(Produto produto) {
        return Double.compare(this.preco, produto.preco);
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", preco=" + preco + "]";
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}
