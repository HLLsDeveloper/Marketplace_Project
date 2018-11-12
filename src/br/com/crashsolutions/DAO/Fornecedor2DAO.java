package br.com.crashsolutions.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.crashsolutions.Conexao.Factory;
import br.com.crashsolutions.SG.CadastroFisicoSG;
import br.com.crashsolutions.SG.ProdutoSG;

public class Fornecedor2DAO {

	private String sql;
	private Connection con;
	private PreparedStatement stmInserir, stmConsulta, stmAlterar, stmListaConsulta;
	private ResultSet listaConsulta, resConsulta;
	private ProdutoSG retornoLista;
	
	public void inserir(ProdutoSG sgproduto) throws SQLException{
		
		con = new Factory().conBD3();
		sql = "insert into PRODUTO (produto,imagem,descricao,modelo,genero,tamanho,cor,categoria,valor_custo,valor_venda,quantidade) values (?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			stmInserir = con.prepareStatement(sql);
			
			stmInserir.setString(1,sgproduto.getProduto());
			stmInserir.setString(2,sgproduto.getImagem());
			stmInserir.setString(3,sgproduto.getDescricao());
			stmInserir.setString(4,sgproduto.getModelo());
			stmInserir.setString(5,sgproduto.getGenero());
			stmInserir.setString(6,sgproduto.getTamanho());
			stmInserir.setString(7,sgproduto.getCor());
			stmInserir.setString(8,sgproduto.getCategoria());
			stmInserir.setDouble(9,sgproduto.getValor_custo());
			stmInserir.setDouble(10,sgproduto.getValor_venda());
			stmInserir.setInt(11,sgproduto.getQuantidade());
			
			stmInserir.execute();
			stmInserir.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro ao inserir: "+ex);
			con.close();
		} 
	}
	
	public ProdutoSG consultar(String geral) throws SQLException{
		
		con = new Factory().conBD3();
		sql = "select * from PRODUTO where idproduto=? or produto=? or referencia=?";
		retornoLista = new ProdutoSG();
		
		try {
			stmConsulta = con.prepareStatement(sql);
			stmConsulta.setString(1, geral);
			stmConsulta.setString(2, geral);
			stmConsulta.setString(3, geral);
			resConsulta = stmConsulta.executeQuery();
			
			while(resConsulta.next()) {
				
				retornoLista.setIdproduto(resConsulta.getInt("idproduto"));
				retornoLista.setProduto(resConsulta.getString("produto"));
				retornoLista.setImagem(resConsulta.getString("imagem"));
				retornoLista.setDescricao(resConsulta.getString("descricao"));
				retornoLista.setModelo(resConsulta.getString("modelo"));
				retornoLista.setGenero(resConsulta.getString("genero"));
				retornoLista.setTamanho(resConsulta.getString("tamanho"));
				retornoLista.setCor(resConsulta.getString("cor"));
				retornoLista.setCategoria(resConsulta.getString("categoria"));
				retornoLista.setValor_custo(resConsulta.getFloat("valor_custo"));
				retornoLista.setValor_venda(resConsulta.getFloat("valor_venda"));
				retornoLista.setQuantidade(resConsulta.getInt("quantidade"));
				retornoLista.setReferencia(resConsulta.getInt("referencia"));
				retornoLista.setCondicao(resConsulta.getString("condicao"));
				
			}
			
			stmConsulta.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro ao consultar: "+ex);
			con.close();
		}
		return retornoLista;
	}

	// MONTA UMA LISTA DE TAMANHO PELA REFERENCIA
	public ArrayList<ProdutoSG> consultarTamanho(Integer referencia) throws SQLException{
			
		con = new Factory().conBD3();
		sql = "select idproduto, tamanho, referencia from PRODUTO";
		
		ArrayList<ProdutoSG> listartamanho = new ArrayList<>();
		
		try {
			stmListaConsulta = con.prepareStatement(sql); 
			listaConsulta = stmListaConsulta.executeQuery();
			
			while (listaConsulta.next()) {
				
				ProdutoSG retornoLista = new ProdutoSG();
							
				retornoLista.setIdproduto(listaConsulta.getInt("idproduto"));
				retornoLista.setReferencia(listaConsulta.getInt("referencia"));	
				retornoLista.setTamanho(listaConsulta.getString("tamanho"));
				
				if (referencia == listaConsulta.getInt("referencia")) {
					
					listartamanho.add(retornoLista);
				}		
			}
			
			stmListaConsulta.close();
			con.close();
			
			
		} catch (Exception e) {
			System.out.println("Erro no consultarTamanho: "+ e);
			con.close();
		}
		
		return listartamanho;
	}
	
	// CONSULTA O PRODUTO NO BANCO PELA REFERENCIA
	public ProdutoSG consultarReferencia(Integer referencia) throws SQLException{
		
		con = new Factory().conBD3();
		sql = "select * from PRODUTO where referencia =?";
		retornoLista = new ProdutoSG();
		
		try {
			stmConsulta = con.prepareStatement(sql);
			stmConsulta.setInt(1, referencia);
			resConsulta = stmConsulta.executeQuery();
			
			while(resConsulta.next()) {
				
				retornoLista.setIdproduto(resConsulta.getInt("idproduto"));
				retornoLista.setProduto(resConsulta.getString("produto"));
				retornoLista.setImagem(resConsulta.getString("imagem"));
				retornoLista.setDescricao(resConsulta.getString("descricao"));
				retornoLista.setModelo(resConsulta.getString("modelo"));
				retornoLista.setGenero(resConsulta.getString("genero"));
				retornoLista.setTamanho(resConsulta.getString("tamanho"));
				retornoLista.setCor(resConsulta.getString("cor"));
				retornoLista.setCategoria(resConsulta.getString("categoria"));
				retornoLista.setValor_custo(resConsulta.getFloat("valor_custo"));
				retornoLista.setValor_venda(resConsulta.getFloat("valor_venda"));
				retornoLista.setQuantidade(resConsulta.getInt("quantidade"));
				retornoLista.setReferencia(resConsulta.getInt("referencia"));
				retornoLista.setCondicao(resConsulta.getString("condicao"));
			}
			
			stmConsulta.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro ao consultar: "+ex);
			con.close();
		}
		return retornoLista;
	}
	
	public void alterar (ProdutoSG sgproduto) throws SQLException {
		
		con = new Factory().conBD3();
		sql = "update PRODUTO set produto =?, imagem =?, descricao =?, modelo =?, genero =?, tamanho =?, cor =?, categoria =?, valor_custo =?, valor_venda =?, quantidade =? where idproduto =?";
		
		try {
			
			stmAlterar = con.prepareStatement(sql);
			
			stmAlterar.setString(1,sgproduto.getProduto());
			stmAlterar.setString(2,sgproduto.getImagem());
			stmAlterar.setString(3,sgproduto.getDescricao());
			stmAlterar.setString(4,sgproduto.getModelo());
			stmAlterar.setString(5,sgproduto.getGenero());
			stmAlterar.setString(6,sgproduto.getTamanho());
			stmAlterar.setString(7,sgproduto.getCor());
			stmAlterar.setString(8,sgproduto.getCategoria());
			stmAlterar.setDouble(9,sgproduto.getValor_custo());
			stmAlterar.setDouble(10,sgproduto.getValor_venda());
			stmAlterar.setInt(11,sgproduto.getQuantidade());
			stmAlterar.setInt(12,sgproduto.getIdproduto());
			
			stmAlterar.execute();
			stmAlterar.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro ao alterar: "+ex);
			con.close();
		} 
	}
	
	public ArrayList<ProdutoSG> buscaTodos() throws SQLException {
		
		con = new Factory().conBD3();
		sql = "select * from PRODUTO";
		
		ArrayList <ProdutoSG> listartodos = new ArrayList<>();
		
		try {
			
			stmListaConsulta = con.prepareStatement(sql); 
			listaConsulta = stmListaConsulta.executeQuery();
			
			while (listaConsulta.next()) {
				
				ProdutoSG retornoLista = new ProdutoSG();
				retornoLista.setIdproduto(listaConsulta.getInt("idproduto"));
				retornoLista.setProduto(listaConsulta.getString("produto"));
				retornoLista.setImagem(listaConsulta.getString("imagem"));
				retornoLista.setDescricao(listaConsulta.getString("descricao"));
				retornoLista.setModelo(listaConsulta.getString("modelo"));
				retornoLista.setGenero(listaConsulta.getString("genero"));
				retornoLista.setTamanho(listaConsulta.getString("tamanho"));
				retornoLista.setCor(listaConsulta.getString("cor"));
				retornoLista.setCategoria(listaConsulta.getString("categoria"));
				retornoLista.setValor_custo(listaConsulta.getFloat("valor_custo"));
				retornoLista.setValor_venda(listaConsulta.getFloat("valor_venda"));
				retornoLista.setQuantidade(listaConsulta.getInt("quantidade"));
				listartodos.add(retornoLista);
			}
			stmListaConsulta.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("Erro " + e);
			con.close();
			return null;
		}
		return listartodos; 
	}
    
    public ArrayList<ProdutoSG> navbar (String geral) throws SQLException {
		
    	con = new Factory().conBD3();
		
		ArrayList<ProdutoSG> lista = new ArrayList<>();
		sql = "select * from PRODUTO where produto like ?";
		
		try {
			
			stmConsulta = con.prepareStatement(sql);
			stmConsulta.setString(1, "%"+ geral +"%");
			listaConsulta = stmConsulta.executeQuery();
			
			while (listaConsulta.next()) {
				
				ProdutoSG retornoLista = new ProdutoSG();
				retornoLista.setIdproduto(listaConsulta.getInt("idproduto"));
				retornoLista.setProduto(listaConsulta.getString("produto"));
				retornoLista.setImagem(listaConsulta.getString("imagem"));
				retornoLista.setDescricao(listaConsulta.getString("descricao"));
				retornoLista.setModelo(listaConsulta.getString("modelo"));
				retornoLista.setGenero(listaConsulta.getString("genero"));
				retornoLista.setTamanho(listaConsulta.getString("tamanho"));
				retornoLista.setCor(listaConsulta.getString("cor"));
				retornoLista.setCategoria(listaConsulta.getString("categoria"));
				retornoLista.setValor_custo(listaConsulta.getFloat("valor_custo"));
				retornoLista.setValor_venda(listaConsulta.getFloat("valor_venda"));
				retornoLista.setQuantidade(listaConsulta.getInt("quantidade"));
				lista.add(retornoLista);
				
			}
			stmConsulta.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("Nada Encontrado " + e);
			con.close();
			return null;
		}
		return lista;
	}
    
    public ArrayList<ProdutoSG> produtolink(String geral) throws SQLException{
		
    	con = new Factory().conBD3();
		ArrayList<ProdutoSG> produtolink = new ArrayList<>();
		
		sql = "select * from PRODUTO where genero= ? or categoria= ?";
		
		try {
			stmConsulta = con.prepareStatement(sql);
			stmConsulta.setString(1, geral);
			stmConsulta.setString(2, geral);
			resConsulta = stmConsulta.executeQuery();
			
			while (resConsulta.next()) {
				
				ProdutoSG retornoLista = new ProdutoSG();
				retornoLista.setIdproduto(resConsulta.getInt("idproduto"));
				retornoLista.setProduto(resConsulta.getString("produto"));
				retornoLista.setImagem(resConsulta.getString("imagem"));
				retornoLista.setDescricao(resConsulta.getString("descricao"));
				retornoLista.setModelo(resConsulta.getString("modelo"));
				retornoLista.setGenero(resConsulta.getString("genero"));
				retornoLista.setTamanho(resConsulta.getString("tamanho"));
				retornoLista.setCor(resConsulta.getString("cor"));
				retornoLista.setCategoria(resConsulta.getString("categoria"));
				retornoLista.setValor_custo(resConsulta.getFloat("valor_custo"));
				retornoLista.setValor_venda(resConsulta.getFloat("valor_venda"));
				retornoLista.setQuantidade(resConsulta.getInt("quantidade"));
				
				// ADICIONA OS DADOS DA LISTA
				produtolink.add(retornoLista);
	
			}
			stmConsulta.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro ao consultar: "+ex);
			con.close();
		}
		return produtolink; 
	}
    
    public void comprar(ProdutoSG sgproduto, CadastroFisicoSG sgfisico) throws SQLException{
		
    	con = new Factory().conBD3();
		sql = "insert into COMPRA (numeropedido, id, idproduto, tamanho, cor, quantidade) values (?,?,?,?,?,?)";
		
		try {
			
			stmInserir = con.prepareStatement(sql);
			stmInserir.setBigDecimal(1,sgproduto.getNumeropedido());
			stmInserir.setInt(2,sgfisico.getIdusuario());
			stmInserir.setInt(3,sgproduto.getIdproduto());
			stmInserir.setString(4,sgproduto.getTamanho());
			stmInserir.setString(5,sgproduto.getCor());
			stmInserir.setInt(6,sgproduto.getQuantidade());
			
			stmInserir.execute();
			stmInserir.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro ao inserir: "+ex);
			con.close();
		} 
	}
}
