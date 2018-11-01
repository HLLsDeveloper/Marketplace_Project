package br.com.crashsolutions.Acoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.crashsolutions.Conexao.Factory;

public class ConexaoLogin {
	
	private String sql;
	private Connection con;
	private PreparedStatement stmFisico, stmJuridico;
	private ResultSet respFisico, respJuridico;
	Boolean acesso = null;
	
	 public Boolean LoginFisico(String email, String senha) {
		 
		 // BUSCA NA TABELA FISICO PELO EMAIL E SENHA
		 con = new Factory().conBD1();
		 sql = "select email, senha, condicao from FISICO where email = '" + email + "' and senha = '" + senha + "' and condicao = 'Ativo'";

		 try{

			 stmFisico = con.prepareStatement(sql);
			 respFisico = stmFisico.executeQuery();

			 // VALIDAÇÃO DE ACESSO FISICO
			 if(respFisico.next()){

				 acesso = true;
				 
			 } else {
				 
				 acesso = false;
				 
			 }

			 stmFisico.close();
			 con.close();

		 } catch (Exception ex) {
			 System.out.println("Erro no Login: "+ ex);
		 }
		
		return acesso;
	 }
	 
	 public Boolean LoginJuridico(String email, String senha) {
		 
		 // VERIFICA NA TABELA JURIDICO
		 con = new Factory().conBD1();
		 sql = "select email, senha, condicao from JURIDICO where email = '" + email + "' and senha = '" + email + "'";
		 
		 try {
			 
			stmJuridico = con.prepareStatement(sql);
			respJuridico = stmJuridico.executeQuery();

			 // VALIDAÇÃO DE ACESSO JURIDICO
			 if(respJuridico.next()){
				 
				 acesso = true;
				 
			 } else {
				 
				 acesso = false;
				 
			 }
			 
			 stmJuridico.close();
			 con.close();
			
		 } catch (Exception ex) {
			 System.out.println("Erro no Login: "+ ex);
		 }
		 
		return acesso;
	 }
}
