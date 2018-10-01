
package br.com.caelum.contas.modelo;

/**
 * Classe responsável para moldar as contas do banco.
 * 
 * @author Eduardo Almeida
 * 
 */
public class Conta {
	
	private static int geradorDeIdentificacao;
	
	private int identificacao;
	protected double saldo;
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
		this.saldo += valor;
	}
	
	/**
	 * Metodo para sacar um valor da conta.
	 * @param valor
	 */
	public void saca(double valor) {
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
		return this.getTipo() + "("+getTitular()+")";
	}

	public String getTipo() {
		return "Conta";
	}
}
