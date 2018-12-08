package br.com.crashsolutions.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Factory {

	Connection conBD1, conBD2, conBD3;

	public Connection conBD1(){
		if(conBD1 == null){
			try{
				
				Class.forName("com.mysql.jdbc.Driver");
				conBD1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tshirt_games_web_1", "root", "1234");
			} catch  (Exception e){
				System.out.println("Erro ao conectar: " + e.getMessage());
			}
		}
		return conBD1;
	}
	
	public Connection conBD2(){
		if(conBD2 == null){
			try{
				
				Class.forName("com.mysql.jdbc.Driver");
				conBD2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tshirt_games_web_2", "root", "1234");

			} catch  (Exception e){
				System.out.println("Erro ao conectar: " + e.getMessage());
			}
		}
		return conBD2;
	}
	
	public Connection conBD3(){
		if(conBD3 == null){
			try{
				
				Class.forName("com.mysql.jdbc.Driver");
				conBD3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tshirt_games_web_3", "root", "1234");

			} catch  (Exception e){
				System.out.println("Erro ao conectar: " + e.getMessage());
			}
		}
		return conBD3;
	}
}
