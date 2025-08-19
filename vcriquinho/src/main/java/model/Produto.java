package model;

public abstract class Produto {
	private int id;
	private String nome;
	private String descricao;
	private int rendimento;
	protected boolean emCarencia;

	public Produto(int id, String nome, String descricao, int rendimento) {
		this.setId(id);
		this.setNome(nome);;
		this.setDescricao(descricao);
		this.setRendimento(rendimento);
		this.emCarencia = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getRendimento() {
		return rendimento;
	}

	public void setRendimento(int rendimento) {
		this.rendimento = rendimento;
	}

	public boolean isEmCarencia() {
		return emCarencia;
	}
}
