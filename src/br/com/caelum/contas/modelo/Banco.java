package br.com.caelum.contas.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {
	
	private Map<String, Conta> contas;
	
	public Banco() {
		contas = new HashMap<>();
	}
	
	public void adiciona(Conta c) {
		contas.put(c.getTitular(), c);
	}

	public Conta pega(int x){
		return contas.get(x);
	}
	
	public int pegaQuantidadeDeContas(){
		return contas.size();
	}
	
	public Conta buscaPorTitular(String nomeTitular) {
		return this.contas.get(nomeTitular);
	}
}
