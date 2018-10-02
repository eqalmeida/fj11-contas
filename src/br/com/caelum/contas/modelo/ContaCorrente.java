package br.com.caelum.contas.modelo;

public class ContaCorrente extends Conta implements Tributavel {
	public String getTipo(){
		return "Conta Corrente";
	}

	/**
	 * Metodo saca da conta, com uma taxa
	 * de 0,10 a cada transação.
	 */
	@Override
	public void saca(double valor) {
		super.saca((valor + 0.10));
	}

	@Override
	public double getValorImposto() {
		return this.getSaldo() * 0.01;
	}
}
