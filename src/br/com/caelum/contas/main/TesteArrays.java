package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;

public class TesteArrays {
	public static void main(String[] args) {
		Conta[] contas = new Conta[10];
		for (int i = 0; i < contas.length; i++) {
			contas[i] = new ContaCorrente();
			contas[i].deposita(i * 100 +50);
		}
		
		/*Calcula média*/
		double soma = 0;
		for (Conta c: contas) {
			soma += c.getSaldo();
		}
		System.out.println("Média de saldos: " + (soma/contas.length));
	}
}
