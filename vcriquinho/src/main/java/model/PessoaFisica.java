package model;

public class PessoaFisica extends Cliente {
	private String cpf;

	public PessoaFisica(int id, String nome, String email, String cpf) {
		super(id, nome, email);
		this.setCpf(cpf);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
