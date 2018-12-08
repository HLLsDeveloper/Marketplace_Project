package br.com.crashsolutions.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.crashsolutions.Acoes.FormatarReal;
import br.com.crashsolutions.Conexao.Factory;
import br.com.crashsolutions.SG.CadastroFisicoSG;
import br.com.crashsolutions.SG.CadastroJuridicoSG;
import br.com.crashsolutions.SG.ProdutoSG;

public class ProdutoDAO {
	
	private String sql;
	private Connection con;
	public String Mensagem = null;
	public Integer Quantidade = 0;
	
	// CADASTRAR O PRODUTO
	public void inserir(ProdutoSG sgproduto, Integer bd) throws SQLException{
		
		if(bd == 1) { 
			con = new Factory().conBD1(); 
		}
		if(bd == 2) {
			con = new Factory().conBD2(); 		
		}
		if(bd == 3) {
			con = new Factory().conBD3(); 			
		}		
		
		sql = "insert into PRODUTO (produto,imagem,descricao,modelo,genero,tamanho,cor,categoria,valor_custo,valor_venda,quantidade,referencia,condicao) values (?,?,?,?,?,?,?,?,?,?,?,?,'ativo')";
		
		try {
			
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setString(1,sgproduto.getProduto());
			stm.setString(2,sgproduto.getImagem());
			stm.setString(3,sgproduto.getDescricao());
			stm.setString(4,sgproduto.getModelo());
			stm.setString(5,sgproduto.getGenero());
			stm.setString(6,sgproduto.getTamanho());
			stm.setString(7,sgproduto.getCor());
			stm.setString(8,sgproduto.getCategoria());
			stm.setFloat(9,sgproduto.getValor_custo());
			stm.setFloat(10,sgproduto.getValor_venda());
			stm.setInt(11,sgproduto.getQuantidade());
			stm.setInt(12,sgproduto.getReferencia());
			
			stm.execute();
			stm.close();
			con.close();
			
			Mensagem = "Cadastrado com Sucesso!";
			
		} catch (Exception e) {
			System.out.println("Erro no inserir: "+ e);
			con.close();
			
			Mensagem = "Erro no Cadastro!";
		} 
	}
	
	// MONTA UMA LISTA DE TAMANHO PELA REFERENCIA
	public ArrayList<ProdutoSG> consultarTamanho(Integer referencia, Integer bd) throws SQLException{
		
		if(bd == 1) { 
			con = new Factory().conBD1(); 
		}
		if(bd == 2) {
			con = new Factory().conBD2(); 		
		}
		if(bd == 3) {
			con = new Factory().conBD3(); 			
		}	
		
		sql = "select idproduto, tamanho, referencia, quantidade from PRODUTO";
		
		ArrayList<ProdutoSG> listartamanho = new ArrayList<>();
		
		try {
			PreparedStatement stm = con.prepareStatement(sql); 
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				
				ProdutoSG retornoLista = new ProdutoSG();
						
				retornoLista.setIdproduto(rs.getInt("idproduto"));
				retornoLista.setTamanho(rs.getString("tamanho"));
				retornoLista.setReferencia(rs.getInt("referencia"));	
				retornoLista.setQuantidade(rs.getInt("quantidade"));
				
				if (referencia == rs.getInt("referencia")) {
					
					Quantidade = rs.getInt("quantidade") + Quantidade;
					listartamanho.add(retornoLista);
				}		
			}
			
			stm.close();
			con.close();
			
			
		} catch (Exception e) {
			System.out.println("Erro no consultarTamanho: "+ e);
			con.close();
		}
		
		return listartamanho;
	}
	
	// CONSULTAR PRODUTO PELO IDPRODUTO OU PRODUTO
	public ProdutoSG consultar(String geral, Integer bd) throws SQLException{
		
		if(bd == 1) { 
			con = new Factory().conBD1(); 
		}
		if(bd == 2) {
			con = new Factory().conBD2(); 		
		}
		if(bd == 3) {
			con = new Factory().conBD3(); 			
		}	
		
		sql = "select * from PRODUTO where idproduto=? or produto=?";
		ProdutoSG retornoLista = new ProdutoSG();
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, geral);
			stm.setString(2, geral);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				
				retornoLista.setIdproduto(rs.getInt("idproduto"));
				retornoLista.setProduto(rs.getString("produto"));
				retornoLista.setImagem(rs.getString("imagem"));
				retornoLista.setDescricao(rs.getString("descricao"));
				retornoLista.setModelo(rs.getString("modelo"));
				retornoLista.setGenero(rs.getString("genero"));
				retornoLista.setTamanho(rs.getString("tamanho"));
				retornoLista.setCor(rs.getString("cor"));
				retornoLista.setCategoria(rs.getString("categoria"));
				retornoLista.setValor_custo(rs.getFloat("valor_custo"));
				retornoLista.setValor_venda(rs.getFloat("valor_venda"));
				retornoLista.setQuantidade(rs.getInt("quantidade"));
				retornoLista.setReferencia(rs.getInt("referencia"));
				retornoLista.setCondicao(rs.getString("condicao"));
			}
			
			stm.close();
			con.close();
			
		} catch (Exception  e) {
			System.out.println("Erro no consultar: "+ e);
			con.close();
		}
		return retornoLista;
	}
	
	// CONSULTAR PRODUTO PELA REFERENCIA
	public ProdutoSG consultarReferencia(Integer referencia, Integer bd) throws SQLException{
		
		if(bd == 1) { 
			con = new Factory().conBD1(); 
		}
		if(bd == 2) {
			con = new Factory().conBD2(); 		
		}
		if(bd == 3) {
			con = new Factory().conBD3(); 			
		}	
		
		sql = "select * from PRODUTO where referencia=?";
		ProdutoSG retornoLista = new ProdutoSG();
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, referencia);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
								
					retornoLista.setIdproduto(rs.getInt("idproduto"));
					retornoLista.setProduto(rs.getString("produto"));
					retornoLista.setImagem(rs.getString("imagem"));
					retornoLista.setDescricao(rs.getString("descricao"));
					retornoLista.setModelo(rs.getString("modelo"));
					retornoLista.setGenero(rs.getString("genero"));
					retornoLista.setTamanho(rs.getString("tamanho"));
					retornoLista.setCor(rs.getString("cor"));
					retornoLista.setCategoria(rs.getString("categoria"));
					retornoLista.setValor_custo(rs.getFloat("valor_custo"));
					retornoLista.setValor_venda(rs.getFloat("valor_venda"));
					retornoLista.setQuantidade(rs.getInt("quantidade"));
					retornoLista.setReferencia(rs.getInt("referencia"));
					retornoLista.setCondicao(rs.getString("condicao"));
			}
			
			stm.close();
			con.close();
			
		} catch (Exception  e) {
			System.out.println("Erro no consultar: "+ e);
			con.close();
		}
		return retornoLista;
	}
	
	// ALTERA PRODUTO 
	public void alterar(ProdutoSG sgproduto, Integer bd) throws SQLException {
		
		if(bd == 1) { 
			con = new Factory().conBD1(); 
		}
		if(bd == 2) {
			con = new Factory().conBD2(); 		
		}
		if(bd == 3) {
			con = new Factory().conBD3(); 			
		}	
		
		sql = "update PRODUTO set produto =?, imagem =?, descricao =?, modelo =?, genero =?, tamanho =?, cor =?, categoria =?, valor_custo =?, valor_venda =?, quantidade =?, referencia =? where idproduto =?";
		
		try {
			
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setString(1,sgproduto.getProduto());
			stm.setString(2,sgproduto.getImagem());
			stm.setString(3,sgproduto.getDescricao());
			stm.setString(4,sgproduto.getModelo());
			stm.setString(5,sgproduto.getGenero());
			stm.setString(6,sgproduto.getTamanho());
			stm.setString(7,sgproduto.getCor());
			stm.setString(8,sgproduto.getCategoria());
			stm.setDouble(9,sgproduto.getValor_custo());
			stm.setDouble(10,sgproduto.getValor_venda());
			stm.setInt(11,sgproduto.getQuantidade());
			stm.setInt(12,sgproduto.getReferencia());
			stm.setInt(13,sgproduto.getIdproduto());
			
			stm.execute();
			stm.close();
			con.close();
			
			Mensagem = "Alterado com Sucesso!";
			
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro ao alterar: "+ex);
			con.close();
			
			Mensagem = "Erro na Alteração!";

		} 
	}
	
	// ALTERA PRODUTO 
		public void baixaQuantidade(ProdutoSG sg, Integer bd) throws SQLException {
			
			if(bd == 1) { 
				con = new Factory().conBD1(); 
			}
			if(bd == 2) {
				con = new Factory().conBD2(); 		
			}
			if(bd == 3) {
				con = new Factory().conBD3(); 			
			}	
			
			sql = "update PRODUTO set quantidade =? where referencia=? and tamanho=?";
			
			try {
				
				PreparedStatement stm = con.prepareStatement(sql);
				
				stm.setInt(1, sg.getQuantidade());
				stm.setInt(2, sg.getReferencia());
				stm.setString(3, sg.getTamanho());
				
				stm.execute();
				stm.close();
				con.close();
				
				
			} catch (Exception ex) {
				System.out.println("Ocorreu um erro ao alterar: "+ex);
				con.close();
			} 
		}
	
	// BUSCA TODOS OS PRODUTOS
	public ArrayList<ProdutoSG> buscaTodos(Integer bd) throws SQLException {
		
		if(bd == 1) { 
			con = new Factory().conBD1(); 
		}
		if(bd == 2) {
			con = new Factory().conBD2(); 		
		}
		if(bd == 3) {
			con = new Factory().conBD3(); 			
		}	
		
		sql = "select * from PRODUTO";
		
		ArrayList <ProdutoSG> listartodos = new ArrayList<>();
		
		try {
			
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				
				ProdutoSG retornoLista = new ProdutoSG();
				
				retornoLista.setIdproduto(rs.getInt("idproduto"));
				retornoLista.setProduto(rs.getString("produto"));
				retornoLista.setImagem(rs.getString("imagem"));
				retornoLista.setDescricao(rs.getString("descricao"));
				retornoLista.setModelo(rs.getString("modelo"));
				retornoLista.setGenero(rs.getString("genero"));
				retornoLista.setTamanho(rs.getString("tamanho"));
				retornoLista.setCor(rs.getString("cor"));
				retornoLista.setCategoria(rs.getString("categoria"));
				retornoLista.setValor_custo(rs.getFloat("valor_custo"));
				retornoLista.setValor_venda(rs.getFloat("valor_venda"));
				retornoLista.setQuantidade(rs.getInt("quantidade"));
				retornoLista.setReferencia(rs.getInt("referencia"));
				retornoLista.setCondicao(rs.getString("condicao"));
				
				listartodos.add(retornoLista);
			}
			
			stm.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("Erro " + e);
			con.close();
			return null;
		}
		return listartodos; 
	}
	
	// CONSULTAR QUANTIDADE TOTAL DA REFERENCIA
	public Integer quantidadeTotal(Integer referencia, Integer bd){
		
		Integer quantidadetotal = 0;
		
		if(bd == 1) { 
			con = new Factory().conBD1(); 
		}
		if(bd == 2) {
			con = new Factory().conBD2(); 		
		}
		if(bd == 3) {
			con = new Factory().conBD3(); 			
		}	
		
		sql = "select quantidade from PRODUTO where referencia=?";
		
		try {
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, referencia);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				quantidadetotal = quantidadetotal + rs.getInt("quantidade");
			}
			
			stm.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("Erro no quantidadeTotal: "+e);
		}
		
		return quantidadetotal;
	}
	
	// BUSCA TODOS OS PRODUTOS
	public ArrayList<ProdutoSG> buscaTodasReferencias(Integer bd) throws SQLException {
		
		if(bd == 1) { 
			con = new Factory().conBD1(); 
		}
		if(bd == 2) {
			con = new Factory().conBD2(); 		
		}
		if(bd == 3) {
			con = new Factory().conBD3(); 			
		}	
		
		sql = "select * from PRODUTO";
		
		ArrayList <ProdutoSG> listartodos = new ArrayList<>();
		
		try {
			
			Integer referencia = 0;
			
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				
				ProdutoSG retornoLista = new ProdutoSG();
				FormatarReal fr = new FormatarReal();
				
				retornoLista.setIdproduto(rs.getInt("idproduto"));
				retornoLista.setProduto(rs.getString("produto"));
				retornoLista.setImagem(rs.getString("imagem"));
				retornoLista.setDescricao(rs.getString("descricao"));
				retornoLista.setModelo(rs.getString("modelo"));
				retornoLista.setGenero(rs.getString("genero"));
				retornoLista.setTamanho(rs.getString("tamanho"));
				retornoLista.setCor(rs.getString("cor"));
				retornoLista.setCategoria(rs.getString("categoria"));
				retornoLista.setValor_custo(rs.getFloat("valor_custo"));
				retornoLista.setValor_venda_fr(fr.formatar(rs.getFloat("valor_venda")));
				retornoLista.setQuantidade(rs.getInt("quantidade"));
				retornoLista.setReferencia(rs.getInt("referencia"));
				retornoLista.setCondicao(rs.getString("condicao"));
				
				String condicao = rs.getString("condicao");
				String ativo = "ativo";
				
				// VERIFICA SE A MAIS DE UM PRODUTO COM A REFERENCIA E ADICIONA APENAS UM
				if(referencia != rs.getInt("referencia")) {
					
					// VERIFICA SE ESTA ATIVO PARA ENVIAR 
					if (condicao.equals(ativo)) {			
						referencia = rs.getInt("referencia");
						
						retornoLista.setQuantidadetotal(quantidadeTotal(referencia, 1));
						listartodos.add(retornoLista);	
					}
				} 
			}
					
			stm.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("Erro " + e);
			con.close();
			return null;
		}
		return listartodos; 
	}
    
	// CONSULTA PELA BARRA DE PESQUISA
    public ArrayList<ProdutoSG> navbar(String geral, Integer bd) throws SQLException {
		
		if(bd == 1) { 
			con = new Factory().conBD1(); 
		}
		if(bd == 2) {
			con = new Factory().conBD2(); 		
		}
		if(bd == 3) {
			con = new Factory().conBD3(); 			
		}	
		
		ArrayList<ProdutoSG> lista = new ArrayList<>();
		sql = "select * from PRODUTO where produto like ?";
		
		try {
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, "%"+ geral +"%");
			ResultSet rs = stm.executeQuery();
			
			Boolean mostra = false;
			Integer referencia = 0;
			
			while (rs.next()) {
				
				ProdutoSG retornoLista = new ProdutoSG();
				FormatarReal fr = new FormatarReal();
				
				retornoLista.setIdproduto(rs.getInt("idproduto"));
				retornoLista.setProduto(rs.getString("produto"));
				retornoLista.setImagem(rs.getString("imagem"));
				retornoLista.setDescricao(rs.getString("descricao"));
				retornoLista.setModelo(rs.getString("modelo"));
				retornoLista.setGenero(rs.getString("genero"));
				retornoLista.setCor(rs.getString("cor"));
				retornoLista.setCategoria(rs.getString("categoria"));
				retornoLista.setValor_venda_fr(fr.formatar(rs.getFloat("valor_venda")));
				retornoLista.setQuantidade(rs.getInt("quantidade"));
				retornoLista.setReferencia(rs.getInt("referencia"));
				retornoLista.setCondicao(rs.getString("condicao"));
				
				if (referencia != rs.getInt("referencia")) {
					mostra = true;
				}
				
				if (mostra == true) {
					lista.add(retornoLista);
					referencia = rs.getInt("referencia");
					mostra = false;
				}
			}
			
			stm.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("Nada Encontrado " + e);
			con.close();
			return null;
		}
		return lista;
	}
    
	// CONSULTA PRODUTOS PELO GENERO OU CATEGORIA
    public ArrayList<ProdutoSG> produtoLink(String geral, Integer bd) throws SQLException{
		
		if(bd == 1) { 
			con = new Factory().conBD1(); 
		}
		if(bd == 2) {
			con = new Factory().conBD2(); 		
		}
		if(bd == 3) {
			con = new Factory().conBD3(); 			
		}	
		
		ArrayList<ProdutoSG> produtolink = new ArrayList<>();
		
		Boolean mostra = false;
		Integer referencia = 0;
		
		sql = "select * from PRODUTO where categoria= ?";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, geral);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				
				ProdutoSG retornoLista = new ProdutoSG();
				FormatarReal fr = new FormatarReal();
				
				retornoLista.setIdproduto(rs.getInt("idproduto"));
				retornoLista.setProduto(rs.getString("produto"));
				retornoLista.setImagem(rs.getString("imagem"));
				retornoLista.setDescricao(rs.getString("descricao"));
				retornoLista.setModelo(rs.getString("modelo"));
				retornoLista.setGenero(rs.getString("genero"));
				retornoLista.setTamanho(rs.getString("tamanho"));
				retornoLista.setCor(rs.getString("cor"));
				retornoLista.setCategoria(rs.getString("categoria"));
				retornoLista.setValor_custo(rs.getFloat("valor_custo"));
				retornoLista.setValor_venda_fr(fr.formatar(rs.getFloat("valor_venda")));
				retornoLista.setQuantidade(rs.getInt("quantidade"));
				retornoLista.setReferencia(rs.getInt("referencia"));
				retornoLista.setCondicao(rs.getString("condicao"));
				
				if (referencia != rs.getInt("referencia")) {
					mostra = true;
				}
				
				if (mostra == true) {
					produtolink.add(retornoLista);
					referencia = rs.getInt("referencia");
					mostra = false;
				}
			}
			stm.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro ao consultar: "+ex);
			con.close();
		}
		return produtolink; 
	}
    
    // CADASTRA PEDIDO PESSOA FISICA
    public void PedidoFisico(ProdutoSG sgproduto, CadastroFisicoSG sgfisico) throws SQLException{
		
    	con = new Factory().conBD1();
		sql = "insert into COMPRAFISICO (numeropedido, idusuario, destinatario, idproduto, tamanho, cor, quantidade) values (?,?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setBigDecimal(1,sgproduto.getNumeropedido());
			stm.setInt(2,sgfisico.getIdusuario());
			stm.setString(3,sgfisico.getDestinatario());
			stm.setInt(4,sgproduto.getIdproduto());
			stm.setString(5,sgproduto.getTamanho());
			stm.setString(6,sgproduto.getCor());
			stm.setInt(7,sgproduto.getQuantidade_dig());
			
			stm.execute();
			stm.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro ao inserir: "+ex);
			con.close();
		}
	}
    
    // CADASTRA PEDIDO PESSOA JURIDICA
    public void PedidoJuridico(ProdutoSG sgproduto, CadastroJuridicoSG sgjuridico) throws SQLException{
		
    	con = new Factory().conBD1();
		sql = "insert into COMPRAJURIDICO (numeropedido, idempresa, destinatario, idproduto, tamanho, cor, quantidade) values (?,?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setBigDecimal(1,sgproduto.getNumeropedido());
			stm.setInt(2,sgjuridico.getIdempresa());
			stm.setString(3, sgjuridico.getRazao());
			stm.setInt(4,sgproduto.getIdproduto());
			stm.setString(5,sgproduto.getTamanho());
			stm.setString(6,sgproduto.getCor());
			stm.setInt(7,sgproduto.getQuantidade_dig());
			
			stm.execute();
			stm.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro ao inserir: "+ex);
			con.close();
		}
	}
    
    // CONSULTA FORNECEDOR 
    public ProdutoSG consultarFornecedor(Integer id) throws SQLException {
		
    	con = new Factory().conBD1();
    	sql = "select * from FORNECEDORES where idfornecedor = ?";
    	
    	ProdutoSG retornoLista = new ProdutoSG();
    	
    	try {
    		
    		PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
			
				retornoLista.setIdfornecedor(rs.getInt("idfornecedor"));
				retornoLista.setRazao(rs.getString("razao"));
				retornoLista.setCnpj(rs.getString("cnpj"));
				retornoLista.setIe(rs.getString("ie"));
				retornoLista.setTelefone(rs.getString("telefone"));
				retornoLista.setEndereco(rs.getString("endereco"));
				retornoLista.setBairro(rs.getString("bairro"));
				retornoLista.setCidade(rs.getString("cidade"));
				retornoLista.setEstado(rs.getString("estado"));
				retornoLista.setCep(rs.getString("cep"));
			}
    		
    	} catch (Exception e){
    		System.out.println("Erro no ProdutoDAO em consultarFornecedor: "+e);
    	}
    	
    	return retornoLista;
    }
}
