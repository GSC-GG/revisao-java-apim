package model;

public class RendaVariavel extends Produto {
	final boolean emCarencia = false;

	public RendaVariavel(int id, String nome, String descricao, int rendimento) {
		super(id, nome, descricao, rendimento);
	}

	public void calculoRenda() {
		// cálculo segundo o histórico
		// this.setRendimento() = 
	}
}
