package classes_abstratas;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas {

    private List<Pessoa> pessoas;
    private int qtdAtual;

    public CadastroPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
        this.qtdAtual = pessoas.size();
    }

    public CadastroPessoas() {
        this.pessoas = new ArrayList<>();
    }

    public void cadastraPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        qtdAtual++;
    }

    public void imprimeCadastro() {
        for (Pessoa p : this.pessoas) {
            p.imprimeDados();
            System.out.println("\n");
        }
    }
}