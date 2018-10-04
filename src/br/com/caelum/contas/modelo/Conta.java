
package br.com.caelum.contas.modelo;

/**
 * Classe responsável para moldar as contas do banco.
 * 
 * @author Eduardo Almeida
 * 
 */
public abstract class Conta {
	
	private static int geradorDeIdentificacao;
	
	private int identificacao;
	private double saldo;
	private String titular;
	private int numero;
	private String agencia;
	
	public Conta() {
		super();
		this.setIdentificacao(++geradorDeIdentificacao);
	}

	private void setIdentificacao(int i) {
		this.identificacao = i;
	}

	/**
	 * Metodo que realiza um depósito na conta.
	 * @param valor Valor a ser depositado.
	 */
	public void deposita(double valor) {
		if(valor < 0) {
			throw new IllegalArgumentException("Você tentou depositar um valor negativo");
		}
		this.saldo += valor;
	}
	
	/**
	 * Metodo para sacar um valor da conta.
	 * @param valor
	 */
	public void saca(double valor) {
		if(valor < 0) {
			throw new IllegalArgumentException("Você tentou sacar um valor negativo");
		}
		this.saldo -= valor;
	}
	
	public void transfere(double valor, Conta conta){
		this.saca(valor);
		conta.deposita(valor);
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getIdentificacao() {
		return identificacao;
	}

	@Override
	public String toString() {
		return "Conta: " + this.getNumero() +" / Ag: " +this.getAgencia()+ 
				" " + "("+getTitular().toUpperCase()+")";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==null) {
			return false;
		}
		
		if(!(o instanceof Conta)) {
			return false;
		}
		
		Conta outra = (Conta)o;
		
		return this.numero == outra.numero &&
				this.agencia.equals(outra.getAgencia());
	}

	public abstract String getTipo();
}
