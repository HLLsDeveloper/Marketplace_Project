package br.com.crashsolutions.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.crashsolutions.Conexao.Factory;
import br.com.crashsolutions.SG.CadastroFisicoSG;

public class CadastroFisicoDAO {
	
	private String sql;
	private Connection con;
	private CadastroFisicoSG retornoLista = new CadastroFisicoSG();
	private PreparedStatement stmConsulta, stmCadastrar, stmAlterarusu;
	private ResultSet respConsulta;
	
	public void cadastrarUsuario(CadastroFisicoSG sg) throws SQLException {
		
		con = new Factory().conBD1();
		sql = "insert into FISICO (email,senha,cpf,nome,sobrenome,datanascimento,sexo,telefone,celular,condicao) value (?,?,?,?,?,?,?,?,?,'Ativo')";
		
		try {
			
			stmCadastrar = con.prepareStatement(sql);			
			stmCadastrar.setString(1, sg.getEmail() );
			stmCadastrar.setString(2, sg.getSenha());
			stmCadastrar.setString(3, sg.getCpf());
			stmCadastrar.setString(4, sg.getNome());
			stmCadastrar.setString(5, sg.getSobrenome());
			stmCadastrar.setString(6, sg.getDatanascimento());
			stmCadastrar.setString(7, sg.getSexo());
			stmCadastrar.setString(8, sg.getTelefone());
			stmCadastrar.setString(9, sg.getCelular());
			
			stmCadastrar.execute();
			stmCadastrar.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Erro ao cadastrar"+ ex);
			con.close();
		}
	}
	
	public void cadastrarEndereco(CadastroFisicoSG sg) throws SQLException {
		
		con = new Factory().conBD1();
		sql = "insert into ENDERECO_FISICO (idenderecofisico,nomeendereco,endereco,numero,complemento,bairro,cidade,estado,cep) value (?,?,?,?,?,?,?,?,?)";
		
		try {
			
			stmCadastrar = con.prepareStatement(sql);
			
			stmCadastrar.setInt(1, sg.getIdenderecofisico());
			stmCadastrar.setString(2, sg.getNomeendereco());
			stmCadastrar.setString(3, sg.getEndereco());
			stmCadastrar.setInt(4, sg.getNumero());
			stmCadastrar.setString(5, sg.getComplemento());
			stmCadastrar.setString(6, sg.getBairro());
			stmCadastrar.setString(7, sg.getCidade());
			stmCadastrar.setString(8, sg.getEstado());
			stmCadastrar.setString(9, sg.getCep());
			
			stmCadastrar.execute();
			stmCadastrar.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Erro ao cadastrar"+ ex);
			con.close();
		}
	}
	
	public void  AlterarUsuario (CadastroFisicoSG sgfisico) throws SQLException {
		
		con = new Factory().conBD1();
		sql = "update FISICO set email = ?, senha = ?, nome = ?, sobrenome = ?, datanascimento = ?, sexo = ?, telefone = ?, celular = ?, condicao = ? where idusuario=?";
		
		try {
			
			stmAlterarusu = con.prepareStatement(sql);
			
			stmAlterarusu.setString(1, sgfisico.getEmail());
			stmAlterarusu.setString(2, sgfisico.getSenha());
			stmAlterarusu.setString(3, sgfisico.getNome());
			stmAlterarusu.setString(4, sgfisico.getSobrenome());
			stmAlterarusu.setString(5, sgfisico.getDatanascimento());
			stmAlterarusu.setString(6, sgfisico.getSexo());
			stmAlterarusu.setString(7, sgfisico.getTelefone());
			stmAlterarusu.setString(8, sgfisico.getCelular());
			stmAlterarusu.setString(9, sgfisico.getCondicao());
			stmAlterarusu.setInt(10,sgfisico.getIdusuario());
			
			stmAlterarusu.execute();
			stmAlterarusu.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("Erro ao alterar"+ e);
			con.close();
		}
	}
	
	public CadastroFisicoSG ConsultarUsuario (String geral) throws SQLException {
		
		con = new Factory().conBD1();
		sql = "select * from FISICO where email = ? or idusuario = ?";
		
		try {
			stmConsulta = con.prepareStatement(sql);
			stmConsulta.setString(1, geral);
			stmConsulta.setString(2, geral);
			respConsulta = stmConsulta.executeQuery();
			
			while (respConsulta.next()) {
				
				retornoLista.setIdusuario(respConsulta.getInt("idusuario"));
				retornoLista.setEmail(respConsulta.getString("email"));
				retornoLista.setCpf(respConsulta.getString("cpf"));
				retornoLista.setNome(respConsulta.getString("nome"));
				retornoLista.setSobrenome(respConsulta.getString("sobrenome"));
				retornoLista.setDatanascimento(respConsulta.getString("datanascimento"));
				retornoLista.setSexo(respConsulta.getString("sexo"));
				retornoLista.setTelefone(respConsulta.getString("telefone"));
				retornoLista.setCelular(respConsulta.getString("celular"));
				retornoLista.setCondicao(respConsulta.getString("condicao"));

			}
			
			stmConsulta.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Erro ao consultar o usu�rio "+ ex);
			con.close();
		}
		return retornoLista; 
	}
	
	public ArrayList<CadastroFisicoSG> buscartodos() throws SQLException {
		
		con = new Factory().conBD1();
		sql = "select * from FISICO";
		
		ArrayList<CadastroFisicoSG> lista = new ArrayList<>();
		
		try {
			stmConsulta = con.prepareStatement(sql);
			respConsulta = stmConsulta.executeQuery();
			
			while (respConsulta.next()) {
				
				CadastroFisicoSG retornoLista = new CadastroFisicoSG();
				retornoLista.setIdusuario(respConsulta.getInt("idusuario"));
				retornoLista.setEmail(respConsulta.getString("email"));
				retornoLista.setCpf(respConsulta.getString("cpf"));
				retornoLista.setNome(respConsulta.getString("nome"));
				retornoLista.setSobrenome(respConsulta.getString("sobrenome"));
				retornoLista.setDatanascimento(respConsulta.getString("datanascimento"));
				retornoLista.setSexo(respConsulta.getString("sexo"));
				retornoLista.setTelefone(respConsulta.getString("telefone"));
				retornoLista.setCelular(respConsulta.getString("celular"));
				retornoLista.setCondicao(respConsulta.getString("condicao"));
				lista.add(retornoLista);
	
			}
			
			stmConsulta.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Erro ao consultar todos "+ ex);
			con.close();
		}
		return lista; 
	}
	
	public ArrayList<CadastroFisicoSG> listarEnderecos (String geral) throws SQLException {
		
		con = new Factory().conBD1();
		sql = "select FISICO.idusuario, ENDERECO_FISICO.* from ENDERECO_FISICO join FISICO on endereco_fisico.idenderecofisico = fisico.idusuario where email = ?";
		
		ArrayList <CadastroFisicoSG> listartodos = new ArrayList<>();
		
		try {
			stmConsulta = con.prepareStatement(sql);
			stmConsulta.setString(1, geral);
			respConsulta = stmConsulta.executeQuery();
			
			while (respConsulta.next()) {
				
				CadastroFisicoSG retornoLista = new CadastroFisicoSG();
				retornoLista.setIdendereco(respConsulta.getInt("endereco_fisico.idendereco"));
				retornoLista.setNomeendereco(respConsulta.getString("endereco_fisico.nomeendereco"));
				retornoLista.setEndereco(respConsulta.getString("endereco_fisico.endereco"));
				retornoLista.setNumero(respConsulta.getInt("endereco_fisico.numero"));
				retornoLista.setComplemento(respConsulta.getString("endereco_fisico.complemento"));
				retornoLista.setBairro(respConsulta.getString("endereco_fisico.bairro"));
				retornoLista.setCidade(respConsulta.getString("endereco_fisico.cidade"));
				retornoLista.setEstado(respConsulta.getString("endereco_fisico.estado"));
				retornoLista.setCep(respConsulta.getString("endereco_fisico.cep"));
				listartodos.add(retornoLista);
	
			}
			
			stmConsulta.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Erro ao cadastrar"+ ex);
			con.close();
		}
		return listartodos;
	}
	
	
	// CONSULTA PELA BARRA DE PESQUISA DO GERENCIAMENTO FISICO
    public ArrayList<CadastroFisicoSG> gerenciamentofisico(String geral) throws SQLException {
		
    	con = new Factory().conBD1();
		
		ArrayList<CadastroFisicoSG> lista = new ArrayList<>();
		sql = "select * from FISICO where nome like ?";
		
		try {
			stmConsulta = con.prepareStatement(sql);
			stmConsulta.setString(1, "%"+ geral +"%");
			respConsulta = stmConsulta.executeQuery();
			
			while (respConsulta.next()) {
				
				CadastroFisicoSG retornoLista = new CadastroFisicoSG();
				retornoLista.setIdusuario(respConsulta.getInt("idusuario"));
				retornoLista.setEmail(respConsulta.getString("email"));
				retornoLista.setCpf(respConsulta.getString("cpf"));
				retornoLista.setNome(respConsulta.getString("nome"));
				retornoLista.setSobrenome(respConsulta.getString("sobrenome"));
				retornoLista.setDatanascimento(respConsulta.getString("datanascimento"));
				retornoLista.setSexo(respConsulta.getString("sexo"));
				retornoLista.setTelefone(respConsulta.getString("telefone"));
				retornoLista.setCelular(respConsulta.getString("celular"));
				lista.add(retornoLista);
	
			}
			
			stmConsulta.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Erro ao consultar todos "+ ex);
			con.close();
		}
		return lista; 
	}
	
	
	//PEGA O �LTIMO ID GERADO PELO BANCO DE DADOS
	public CadastroFisicoSG buscarultimo() throws SQLException {
		
		con = new Factory().conBD1();
		sql = "select max(idusuario) from FISICO";
		
		try {
			
			stmConsulta = con.prepareStatement(sql);
			respConsulta = stmConsulta.executeQuery();
			
			while (respConsulta.next()) {
				
				retornoLista.setIdusuario(respConsulta.getInt("max(idusuario)"));
			}
			
			stmConsulta.close();
			con.close(); 
			
		} catch (Exception e) {
			System.out.println("Erro ao buscar o �ltimo dado do banco: "+ e);
			con.close();
		}
		return retornoLista;
	}
}

