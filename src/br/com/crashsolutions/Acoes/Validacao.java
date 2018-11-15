package br.com.crashsolutions.Acoes;

public class Validacao {
	
	public Boolean Caracter(String val) {
		
		String caracter = String.valueOf(val);
		return caracter.matches("[A-Z][a-z]");
	}
	
	public Boolean NumberInt(String val) {
		
		String numberint = val;
		return numberint.matches("[0-9]");	
	}
	
	public Boolean ImageExtension(String val) {
		
		String imagemextension = val.substring(val.lastIndexOf(".")+1);
		Boolean retorno = false;
		
		if(imagemextension.equals("png") || imagemextension.equals("jpg") || imagemextension.equals("jpeg") || imagemextension.equals("bmp")) {
			retorno = true;
		}
		return retorno;
	}
	
	public Boolean NumberDecimal(String val) {
		
		String numberdecimal = val;
		return numberdecimal.matches("[0-9]{2,}");	
	}
	
	public Boolean SpecialCaracter(String val) {
		
		String specialcaracter = val;
		return specialcaracter.matches("[A-Z][a-z][!@#$%¨&*]");	
	}
	
	public Boolean Full(String val) {
		
		String full = val;
		return full.matches("[A-Z][a-z][0-9][!@#$%¨&*]");
	}
}
