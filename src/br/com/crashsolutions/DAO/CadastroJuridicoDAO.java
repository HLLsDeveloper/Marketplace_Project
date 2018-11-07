package br.com.crashsolutions.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.crashsolutions.SG.CadastroFisicoSG;
import br.com.crashsolutions.SG.CadastroJuridicoSG;
import br.com.crashsolutions.Conexao.Factory;

public class CadastroJuridicoDAO {

	private String sql;
	private Connection con;
	private CadastroJuridicoSG retornoConsulta = new CadastroJuridicoSG();
	private PreparedStatement stmtConsultar, stmtInserir;
	private ResultSet respConsulta;

	public void CadastrarUsuario(CadastroJuridicoSG sg) throws SQLException {
		
		con = new Factory().conBD1();
		sql = "insert into JURIDICO (email,senha,cnpj,razao,nomefantasia,ie,telefone,celular,condicao) value (?,?,?,?,?,?,?,?,'Ativo')";
		
		try {
			
			stmtInserir = con.prepareStatement(sql);
			stmtInserir.setString(1, sg.getEmail());
			stmtInserir.setString(2, sg.getSenha());
			stmtInserir.setString(3, sg.getCnpj());
			stmtInserir.setString(4, sg.getRazao());
			stmtInserir.setString(5, sg.getNomefantasia());
			stmtInserir.setString(6, sg.getIe());
			stmtInserir.setBigDecimal(7, sg.getTelefone());
			stmtInserir.setBigDecimal(8, sg.getCelular());
			
			stmtInserir.execute();
			stmtInserir.close();
			con.close();
			
			
		} 
		catch (Exception e) {
			con.close();
			System.out.println("Erro ao inserir o usuário" + e);
		}
	}
	
	public void CadastrarEndereco(CadastroJuridicoSG sg) throws SQLException  {
		
		con = new Factory().conBD1();
		sql = "insert into ENDERECO_JURIDICO (idenderecojuridico,nomeendereco,endereco,numero,complemento,bairro,cidade,estado,cep) value (?,?,?,?,?,?,?,?,?)";
		
		try {
			
			stmtInserir = con.prepareStatement(sql);
			stmtInserir.setInt(1, sg.getIdenderecojuridico());
			stmtInserir.setString(2, sg.getNomeendereco());
			stmtInserir.setString(3, sg.getEndereco());
			stmtInserir.setInt(4, sg.getNumero());
			stmtInserir.setString(5, sg.getComplemento());
			stmtInserir.setString(6, sg.getBairro());
			stmtInserir.setString(7, sg.getCidade());
			stmtInserir.setString(8, sg.getEstado());
			stmtInserir.setString(9, sg.getCep());
			
			stmtInserir.execute();
			stmtInserir.close();
			con.close();
			
		} catch(Exception e) {
			con.close();
			System.out.println("Erro ao inserir o endereço" + e);
		}
	}

	public CadastroJuridicoSG ConsultarUsuario (String geral) throws SQLException {
		
		con = new Factory().conBD1();
		sql = "select * from JURIDICO where email = ?";
		
		try {
			
			stmtConsultar = con.prepareStatement(sql);
			stmtConsultar.setString(1, geral);
			respConsulta = stmtConsultar.executeQuery();
			
			while (respConsulta.next()) {
				
				retornoConsulta.setIdempresa(respConsulta.getInt("idempresa"));
				retornoConsulta.setEmail(respConsulta.getString("email"));
				retornoConsulta.setSenha(respConsulta.getString("senha"));
				retornoConsulta.setCnpj(respConsulta.getString("cnpj"));
				retornoConsulta.setRazao(respConsulta.getString("razao"));
				retornoConsulta.setNomefantasia(respConsulta.getString("nomefantasia"));
				retornoConsulta.setIe(respConsulta.getString("ie"));
				retornoConsulta.setTelefone(respConsulta.getBigDecimal("telefone"));
				retornoConsulta.setCelular(respConsulta.getBigDecimal("celular"));
				retornoConsulta.setCondicao(respConsulta.getString("condicao"));
					
			}
			
			stmtConsultar.close();
			con.close();
			
		} catch (Exception e) {
			con.close();
			System.out.println("Erro ao consultar o usuário + doidera " + e);
		}
		return retornoConsulta;
	}
	
	public ArrayList<CadastroJuridicoSG> listarEnderecos (String geral) throws SQLException {
		
		con = new Factory().conBD1();
		sql = "select JURIDICO.idempresa, ENDERECO_JURIDICO.* from ENDERECO_JURIDICO join JURIDICO on endereco_juridico.idenderecojuridico = juridico.idempresa where email = ?";
		
		ArrayList <CadastroJuridicoSG> listartodos = new ArrayList<>();
		
		try {
			stmtConsultar = con.prepareStatement(sql);
			stmtConsultar.setString(1, geral);
			respConsulta = stmtConsultar.executeQuery();
			
			while (respConsulta.next()) {
				
				CadastroJuridicoSG retornoLista = new CadastroJuridicoSG();
				retornoLista.setIdempresa(respConsulta.getInt("endereco_juridico.idendereco"));
				retornoLista.setNomeendereco(respConsulta.getString("endereco_juridico.nomeendereco"));
				retornoLista.setEndereco(respConsulta.getString("endereco_juridico.endereco"));
				retornoLista.setNumero(respConsulta.getInt("endereco_juridico.numero"));
				retornoLista.setComplemento(respConsulta.getString("endereco_juridico.complemento"));
				retornoLista.setBairro(respConsulta.getString("endereco_juridico.bairro"));
				retornoLista.setCidade(respConsulta.getString("endereco_juridico.cidade"));
				retornoLista.setEstado(respConsulta.getString("endereco_juridico.estado"));
				retornoLista.setCep(respConsulta.getString("endereco_juridico.cep"));
				listartodos.add(retornoLista);
	
			}
			
			stmtConsultar.close();
			con.close();
			
		} catch (Exception ex) {
			con.close();
			System.out.println("Erro ao cadastrar"+ ex);
		}
		return listartodos;
	}
	
	public ArrayList<CadastroJuridicoSG> listar() throws SQLException {
		
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
				retornoConsulta.setCondicao(respConsulta.getString("condicao"));
				lista.add(retornoConsulta);
				
			}
			
			stmtConsultar.close();
			con.close();
			
		} catch (Exception e) {
			con.close();
			System.out.println("Erro ao buscar todos os usuários do bd " + e);
		}
		
		return lista;
	}
	
	//PEGA O ÚLTIMO ID GERADO PELO BANCO DE DADOS
		public CadastroJuridicoSG buscarultimo() throws SQLException {
			
			con = new Factory().conBD1();
			sql = "select max(idempresa) from JURIDICO";
			
			try {
				
				stmtConsultar = con.prepareStatement(sql);
				respConsulta = stmtConsultar.executeQuery();
				
				while (respConsulta.next()) {
					
					retornoConsulta.setIdempresa(respConsulta.getInt("max(idempresa)"));
				}
				
				stmtConsultar.close();
				con.close(); 
				
			} catch (Exception e) {
				con.close();
				System.out.println("Erro ao buscar o último dado do banco: "+ e);
			}
			return retornoConsulta;
		}
}
