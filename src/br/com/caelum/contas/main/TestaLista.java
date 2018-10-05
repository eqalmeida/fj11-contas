package br.com.caelum.contas.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;

public class TestaLista {

	public static void main(String[] args) {

		List<Conta> contas = new LinkedList<>();
		
		for(int i=0; i<50; i++) {
			Conta c = new ContaCorrente();
			c.setTitular("Nome " + (i+1));
			c.setAgencia("123-4");
			c.setNumero(i+1);
			c.deposita(Math.abs( new Random().nextInt(10000))/10.0);
			contas.add(c);
		}
		
		Collections.sort(contas);
		
		for(Conta c: contas) {
			System.out.print(c);
			System.out.println("   \t"+c.getSaldo());
		}
	}

}
