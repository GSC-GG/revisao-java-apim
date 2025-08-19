package model;

public class ContaCDI extends Conta implements CalculoSaldo {
	private static int cdi;
	private static final int taxa = 7;

	public ContaCDI(int id, int saldo, Cliente cliente) {
		super(id, saldo, cliente);
	}

	public static int getCdi() {
		return cdi;
	}

	public static void setCdi(int cdi) {
		ContaCDI.cdi = cdi;
	}

	@Override
	public void calcularSaldo() {
		this.saldo = cdi / 30 * (taxa / 100);
	}

}
