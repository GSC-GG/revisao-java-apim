package model;

public abstract class Conta {
	private final Cliente cliente;
	private int id;
	protected int saldo;

	public Conta(int id, int saldo, Cliente cliente) {
		this.setId(id);
		this.setSaldo(saldo);
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getSaldo() {
		return saldo;
	}
	
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
