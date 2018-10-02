package br.com.caelum.contas.modelo;

public class ContaCorrente extends Conta {
	public String getTipo(){
		return super.getTipo() + " Corrente";
	}

	/**
	 * Metodo saca da conta, com uma taxa
	 * de 0,10 a cada transação.
	 */
	@Override
	public void saca(double valor) {
		super.saca((valor + 0.10));
	}
}
