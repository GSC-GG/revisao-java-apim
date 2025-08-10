package classes_abstratas;

public class TestaCadastro {

    public static void main(String[] args) {
        
        CadastroPessoas cadastro = new CadastroPessoas();
        cadastro.cadastraPessoa(new Cliente(12345, "Reinaldo", new Data(1, 2, 1995)));
        cadastro.cadastraPessoa(new Funcionario("Ailton", new Data(25, 05, 1997), 3500));
        cadastro.cadastraPessoa(new Gerente("Fabricio", new Data(19, 9, 1983), 12500, "TI"));

        cadastro.imprimeCadastro();
    }
}