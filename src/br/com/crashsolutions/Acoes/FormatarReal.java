package br.com.crashsolutions.Acoes;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatarReal {
	
	public String formatar(Float valor1) {
		
		// IDIOMA PARA FORMATAÇÃO
		Locale br = new Locale("pt","BR");
		NumberFormat real = NumberFormat.getCurrencyInstance(br);
		
		String formatado  = null;
		
		// FORMATAÇÃO DE VALORES MONETARIOS
		formatado = real.format(valor1);
		
		return formatado;
	}
}
