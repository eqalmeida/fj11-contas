package br.com.caelum.contas.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class TestaPerformanceDeAdicionarNaPrimeiraPosicao {
	
	public static void testar(List<Integer> teste) {
		System.out.println("Iniciando "+ teste.getClass().getName() +" ...");
		long inicio = System.currentTimeMillis();
		
		int total = 100000;
		
		for(int i=0; i< total; i++) {
			teste.add(0,i);
		}
		
		System.out.println("Tempo gasto total: " + (System.currentTimeMillis() - inicio) + " ms");
		System.out.println();
	}

	public static void main(String[] args) {
		testar(new ArrayList<Integer>());
		testar(new LinkedList<Integer>());
	}

}
