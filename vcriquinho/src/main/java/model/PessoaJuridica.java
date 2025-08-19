package model;

public class PessoaJuridica extends Cliente {
	private String cnpj;

	public PessoaJuridica(int id, String nome, String email, String cnpj) {
		super(id, nome, email);
		this.setCnpj(cnpj);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
