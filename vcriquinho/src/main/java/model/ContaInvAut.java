package model;

public class ContaInvAut extends Conta implements CalculoSaldo {
	private Produto produto;

	public ContaInvAut(int id, int saldo, Produto produto, Cliente cliente) {
		super(id, saldo, cliente);
		this.setProduto(produto);
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public void calcularSaldo() {
		if (!produto.isEmCarencia()) {
			this.saldo = (int) (produto.getRendimento() * (getCliente().getClass().getName().equals("model.PessoaFisica") ? (1.0 - 0.1) : (1.0 - 0.15)));
		}
	}
}
