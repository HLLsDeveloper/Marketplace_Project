package br.com.crashsolutions.Acoes;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class FormatarReal {
	
	public String formatar(Float valor) {
		
		// IDIOMA PARA FORMATA��O
		Locale br = new Locale("pt","BR");
		NumberFormat real = NumberFormat.getCurrencyInstance(br);
		
		String formatado  = null;
		
		// FORMATA��O DE VALORES MONETARIOS
		formatado = real.format(valor);
		
		return formatado;
	}
	
	// EM PRODU��O 
	public ArrayList<?> formatarLista(ArrayList<?> lista) {
		
		// IDIOMA PARA FORMATA��O
		Locale br = new Locale("pt","BR");
		NumberFormat real = NumberFormat.getCurrencyInstance(br);
		
		ArrayList<?> listaformatado = null;
		
		// FORMATA��O DE VALORES DA LISTA
		for(int i = 0; i < lista.size(); i++) {
			
			
		}
		
		real.format(lista.get(1));
		
		return listaformatado;
	}
}
