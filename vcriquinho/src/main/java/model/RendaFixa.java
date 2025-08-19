package model;

public class RendaFixa extends Produto {
	private int diasCarencia;

	public RendaFixa(int id, String nome, String descricao, int rendimento, int diasCarencia, boolean emCarencia) {
		super(id, nome, descricao, rendimento);
		this.setDiasCarencia(diasCarencia);
		this.setEmCarencia(emCarencia);
	}

	public int getDiasCarencia() {
		return diasCarencia;
	}

	public void setDiasCarencia(int diasCarencia) {
		this.diasCarencia = diasCarencia;
	}

	public void setEmCarencia(boolean emCarencia) {
		this.emCarencia = emCarencia;
	}
}
