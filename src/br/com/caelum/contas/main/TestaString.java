package br.com.caelum.contas.main;

public class TestaString {
	
	String x;
	
	public void testaInit() {
		String y;
		System.out.println(x);
	//	System.out.println(y);
	}
	
	public static void main(String[] args) {
		String s = "fj11";
		s = s.replace("1", "2");
		System.out.println(s);
		
		imprimeCaracteres("EDUARDO ALMEIDA");
		
		StringBuilder sb = new StringBuilder("Eduardo");
		sb.reverse();
		System.out.println(sb);
		
		System.out.println("---------------------------");
		int valorConvertido = converteParaInt("123005");
		System.out.println(valorConvertido);
		
		new TestaString().testaInit();
		
	}
	
	public static void imprimeCaracteres(String s){
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
	}
	
	public static int converteParaInt(String s) {
		int resp = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c > '9' || c < '0') {
				throw new IllegalArgumentException("Somente números são permitidos");
			}
			resp = resp * 10 + (s.charAt(i)-'0'); 
		}
		return resp;
	}
}
