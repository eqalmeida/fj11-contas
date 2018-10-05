
package br.com.caelum.contas.modelo;

/**
 * Classe responsável para moldar as contas do banco.
 * 
 * @author Eduardo Almeida
 * 
 */
public abstract class Conta implements Comparable<Conta> {
	
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

	public abstract String getTipo();
/*	
	@Override
	public int compareTo(Conta o) {
		return this.titular.compareTo(o.titular);
	}
	*/
	
	@Override
	public int compareTo(Conta o) {
		return Double.compare(this.getSaldo(), o.getSaldo());
	}
}
