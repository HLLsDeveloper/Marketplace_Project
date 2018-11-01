package br.com.crashsolutions.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.crashsolutions.SG.CadastroJuridicoSG;
import br.com.crashsolutions.Conexao.Factory;

public class CadastroJuridicoDAO {

	private String sql;
	private Connection con;
	private PreparedStatement stmtConsultar, stmtInserir;
	private ResultSet respConsulta;
	private CadastroJuridicoSG retornoConsulta;

	public void inserir (CadastroJuridicoSG sg) {
		
		con = new Factory().conBD1();
		sql = "insert into JURIDICO (email,senha,cnpj,razao,nomefantasia,ie,endereco,numero,complemento,bairro,cidade,estado,cep,condicao) value (?,?,?,?,?,?,?,?,?,?,?,?,?,'Ativo')";
		
		try {
			
			stmtInserir = con.prepareStatement(sql);
			stmtInserir.setString(1, sg.getEmail());
			stmtInserir.setString(2, sg.getSenha());
			stmtInserir.setString(3, sg.getCnpj());
			stmtInserir.setString(4, sg.getRazao());
			stmtInserir.setString(5, sg.getNomefantasia());
			stmtInserir.setString(6, sg.getIe());
			stmtInserir.setString(7, sg.getEndereco());
			stmtInserir.setInt(8, sg.getNumero());
			stmtInserir.setString(9, sg.getComplemento());
			stmtInserir.setString(10, sg.getBairro());
			stmtInserir.setString(11, sg.getCidade());
			stmtInserir.setString(12, sg.getEstado());
			stmtInserir.setString(13, sg.getCep());
			 
			stmtInserir.execute();
			stmtInserir.close();
			
			
		} 
		catch (Exception e) {
			System.out.println("Erro ao inserir " + e);
		}
	}

	public ArrayList<CadastroJuridicoSG> consultar (String unico) {
		
		con = new Factory().conBD1();
		sql = "select * from JURIDICO where idempresa = ?";
		
		ArrayList<CadastroJuridicoSG> unicoProduto = new ArrayList<>();
		
		try {
			
			stmtConsultar = con.prepareStatement(sql);
			stmtConsultar.setString(1, unico);
			respConsulta = stmtConsultar.executeQuery();
			
			while (respConsulta.next()) {
				
				retornoConsulta.setIdempresa(respConsulta.getInt("idempresa"));
				retornoConsulta.setEmail(respConsulta.getString("email"));
				retornoConsulta.setSenha(respConsulta.getString("senha"));
				retornoConsulta.setCnpj(respConsulta.getString("cnpj"));
				retornoConsulta.setRazao(respConsulta.getString("razaos"));
				retornoConsulta.setNomefantasia(respConsulta.getString("nomefantasia"));
				retornoConsulta.setIe(respConsulta.getString("ie"));
				retornoConsulta.setEstado(respConsulta.getString("estado"));
				retornoConsulta.setEndereco(respConsulta.getString("endereco"));
				retornoConsulta.setNumero(respConsulta.getInt("numero"));
				retornoConsulta.setComplemento(respConsulta.getString("complemento"));
				retornoConsulta.setBairro(respConsulta.getString("bairro"));
				retornoConsulta.setCidade(respConsulta.getString("cidade"));
				retornoConsulta.setCep(respConsulta.getString("cep"));
				retornoConsulta.setCondicao(respConsulta.getString("condicao"));
					
			}
			stmtConsultar.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("Erro " + e);
			return null;
		}
		return unicoProduto;
	}
	
	public ArrayList<CadastroJuridicoSG> listar() {
		
		con = new Factory().conBD1();
		
		ArrayList<CadastroJuridicoSG> lista = new ArrayList<>();
		sql = "select * from JURIDICO";
		
		try {
			
			stmtConsultar = con.prepareStatement(sql);
			respConsulta = stmtConsultar.executeQuery();
			
			while (respConsulta.next()) {
				
				retornoConsulta = new CadastroJuridicoSG();			
				
				retornoConsulta.setIdempresa(respConsulta.getInt("idempresa"));
				retornoConsulta.setEmail(respConsulta.getString("email"));
				retornoConsulta.setSenha(respConsulta.getString("senha"));
				retornoConsulta.setCnpj(respConsulta.getString("cnpj"));
				retornoConsulta.setRazao(respConsulta.getString("razaos"));
				retornoConsulta.setNomefantasia(respConsulta.getString("nomefantasia"));
				retornoConsulta.setIe(respConsulta.getString("ie"));
				retornoConsulta.setEstado(respConsulta.getString("estado"));
				retornoConsulta.setEndereco(respConsulta.getString("endereco"));
				retornoConsulta.setNumero(respConsulta.getInt("numero"));
				retornoConsulta.setComplemento(respConsulta.getString("complemento"));
				retornoConsulta.setBairro(respConsulta.getString("bairro"));
				retornoConsulta.setCidade(respConsulta.getString("cidade"));
				retornoConsulta.setCep(respConsulta.getString("cep"));
				retornoConsulta.setCondicao(respConsulta.getString("condicao"));
				
				
				lista.add(retornoConsulta);
				
			}
			
			stmtConsultar.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("Erro " + e);
			return null;
		}
		
		return lista;
		
	}
}
