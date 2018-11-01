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
	private PreparedStatement stmConsulta, stmCadastrar;
	private ResultSet respConsulta;
	
	public void cadastrarUsuario(CadastroFisicoSG sg) throws SQLException {
		
		con = new Factory().conBD1();
		sql = "insert into FISICO (email,senha,cpf,nome,sobrenome,datanascimento,sexo,condicao) value (?,?,?,?,?,?,?,'Ativo')";
		
		try {
			
			stmCadastrar = con.prepareStatement(sql);
			
			stmCadastrar.setString(1, sg.getEmail() );
			stmCadastrar.setString(2, sg.getSenha());
			stmCadastrar.setString(3, sg.getCpf());
			stmCadastrar.setString(4, sg.getNome());
			stmCadastrar.setString(5, sg.getSobrenome());
			stmCadastrar.setString(6, sg.getDatanascimento());
			stmCadastrar.setString(7, sg.getSexo());
			
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
	
	public CadastroFisicoSG consultar (String geral) throws SQLException {
		
		con = new Factory().conBD1();
		sql = "select * from FISICO where email = ?";
		
		try {
			stmConsulta = con.prepareStatement(sql);
			stmConsulta.setString(1, geral);
			respConsulta = stmConsulta.executeQuery();
			
			while (respConsulta.next()) {
				
				retornoLista.setIdusuario(respConsulta.getInt("idusuario"));
				retornoLista.setEmail(respConsulta.getString("email"));
				retornoLista.setCpf(respConsulta.getString("cpf"));
				retornoLista.setNome(respConsulta.getString("nome"));
				retornoLista.setSobrenome(respConsulta.getString("sobrenome"));
				retornoLista.setDatanascimento(respConsulta.getString("datanascimento"));
				retornoLista.setSexo(respConsulta.getString("sexo"));
				retornoLista.setTelefone(respConsulta.getBigDecimal("telefone"));
				retornoLista.setCelular(respConsulta.getBigDecimal("celular"));
	
			}
			
			stmConsulta.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Erro ao cadastrar"+ ex);
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
				retornoLista.setTelefone(respConsulta.getBigDecimal("telefone"));
				retornoLista.setCelular(respConsulta.getBigDecimal("celular"));
				lista.add(retornoLista);
	
			}
			
			stmConsulta.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Erro ao cadastrar"+ ex);
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
}

