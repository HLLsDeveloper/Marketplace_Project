package br.com.crashsolutions.Conexao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.crashsolutions.Conexao.Factory;

public class TesteConexao {
	
	private static Connection con1, con2, con3;
	
	public static void main(String[] args) throws SQLException {
		con1 = new Factory().conBD1();
        System.out.println("Conexão aberta!");
        con1.close();
        con2 = new Factory().conBD2();
        System.out.println("Conexão aberta!");
        con2.close();
        con3 = new Factory().conBD3();
        System.out.println("Conexão aberta!");
        con3.close();  
     }
}
