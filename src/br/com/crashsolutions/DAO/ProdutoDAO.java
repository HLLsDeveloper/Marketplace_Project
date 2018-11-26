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
	private PreparedStatement stmInserir, stmConsulta, stmAlterar, stmListaConsulta;
	private ResultSet listaConsulta, resConsulta;
	private ProdutoSG retornoLista;
	 
	public String Mensagem = null;
	public Integer Quantidade = 0;
	
	// CADASTRAR O PRODUTO
	public void inserir(ProdutoSG sgproduto) throws SQLException{
		
		con = new Factory().conBD1();
		sql = "insert into PRODUTO (produto,imagem,descricao,modelo,genero,tamanho,cor,categoria,valor_custo,valor_venda,quantidade,referencia,condicao) values (?,?,?,?,?,?,?,?,?,?,?,?,'ativo')";
		
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
			stmInserir.setFloat(9,sgproduto.getValor_custo());
			stmInserir.setFloat(10,sgproduto.getValor_venda());
			stmInserir.setInt(11,sgproduto.getQuantidade());
			stmInserir.setInt(12,sgproduto.getReferencia());
			
			stmInserir.execute();
			stmInserir.close();
			con.close();
			
			Mensagem = "Cadastrado com Sucesso!";
			
		} catch (Exception e) {
			System.out.println("Erro no inserir: "+ e);
			con.close();
			
			Mensagem = "Erro no Cadastro!";
		} 
	}
	
	// MONTA UMA LISTA DE TAMANHO PELA REFERENCIA
	public ArrayList<ProdutoSG> consultarTamanho(Integer referencia) throws SQLException{
		
		con = new Factory().conBD1();
		sql = "select idproduto, tamanho, referencia, quantidade from PRODUTO";
		
		ArrayList<ProdutoSG> listartamanho = new ArrayList<>();
		
		try {
			stmListaConsulta = con.prepareStatement(sql); 
			listaConsulta = stmListaConsulta.executeQuery();
			
			while (listaConsulta.next()) {
				
				ProdutoSG retornoLista = new ProdutoSG();
						
				retornoLista.setIdproduto(listaConsulta.getInt("idproduto"));
				retornoLista.setTamanho(listaConsulta.getString("tamanho"));
				retornoLista.setReferencia(listaConsulta.getInt("referencia"));	
				retornoLista.setQuantidade(listaConsulta.getInt("quantidade"));
				
				if (referencia == listaConsulta.getInt("referencia")) {
					
					Quantidade = listaConsulta.getInt("quantidade") + Quantidade;
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
	
	// CONSULTAR PRODUTO PELO IDPRODUTO OU PRODUTO
	public ProdutoSG consultar(String geral) throws SQLException{
		
		con = new Factory().conBD1();
		sql = "select * from PRODUTO where idproduto=? or produto=?";
		retornoLista = new ProdutoSG();
		
		try {
			stmConsulta = con.prepareStatement(sql);
			stmConsulta.setString(1, geral);
			stmConsulta.setString(2, geral);
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
			
		} catch (Exception  e) {
			System.out.println("Erro no consultar: "+ e);
			con.close();
		}
		return retornoLista;
	}
	
	// CONSULTAR PRODUTO PELA REFERENCIA
	public ProdutoSG consultarReferencia(Integer referencia) throws SQLException{
			
			con = new Factory().conBD1();
			sql = "select * from PRODUTO where referencia=?";
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
				
			} catch (Exception  e) {
				System.out.println("Erro no consultar: "+ e);
				con.close();
			}
			return retornoLista;
		}
	
	// ALTERA PRODUTO 
	public void alterar(ProdutoSG sgproduto) throws SQLException {
		
		con = new Factory().conBD1();
		sql = "update PRODUTO set produto =?, imagem =?, descricao =?, modelo =?, genero =?, tamanho =?, cor =?, categoria =?, valor_custo =?, valor_venda =?, quantidade =?, referencia =? where idproduto =?";
		
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
			stmAlterar.setInt(12,sgproduto.getReferencia());
			stmAlterar.setInt(13,sgproduto.getIdproduto());
			
			stmAlterar.execute();
			stmAlterar.close();
			con.close();
			
			Mensagem = "Alterado com Sucesso!";
			
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro ao alterar: "+ex);
			con.close();
			
			Mensagem = "Erro na Alteração!";

		} 
	}
	
	// BUSCA TODOS OS PRODUTOS
	public ArrayList<ProdutoSG> buscaTodos() throws SQLException {
		
		con = new Factory().conBD1();
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
				retornoLista.setReferencia(listaConsulta.getInt("referencia"));
				retornoLista.setCondicao(listaConsulta.getString("condicao"));
				
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
	
	// CONSULTAR QUANTIDADE TOTAL DA REFERENCIA
	public Integer quantidadeTotal(Integer referencia){
		
		Integer quantidadetotal = 0;
		
		con = new Factory().conBD1();
		sql = "select quantidade from PRODUTO where referencia=?";
		
		try {
			
			stmConsulta = con.prepareStatement(sql);
			stmConsulta.setInt(1, referencia);
			resConsulta = stmConsulta.executeQuery();
			
			while (resConsulta.next()) {
				quantidadetotal = quantidadetotal + resConsulta.getInt("quantidade");
			}
			
			stmConsulta.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("Erro no quantidadeTotal: "+e);
		}
		
		return quantidadetotal;
	}
	
	// BUSCA TODOS OS PRODUTOS
	public ArrayList<ProdutoSG> buscaTodasReferencias() throws SQLException {
		
		con = new Factory().conBD1();
		sql = "select * from PRODUTO";
		
		ArrayList <ProdutoSG> listartodos = new ArrayList<>();
		
		try {
			
			Integer referencia = 0;
			
			stmListaConsulta = con.prepareStatement(sql); 
			listaConsulta = stmListaConsulta.executeQuery();
			
			while (listaConsulta.next()) {
				
				ProdutoSG retornoLista = new ProdutoSG();
				FormatarReal fr = new FormatarReal();
				
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
				retornoLista.setValor_venda_fr(fr.formatar(listaConsulta.getFloat("valor_venda")));
				retornoLista.setQuantidade(listaConsulta.getInt("quantidade"));
				retornoLista.setReferencia(listaConsulta.getInt("referencia"));
				retornoLista.setCondicao(listaConsulta.getString("condicao"));
				
				String condicao = listaConsulta.getString("condicao");
				String ativo = "ativo";
				
				// VERIFICA SE A MAIS DE UM PRODUTO COM A REFERENCIA E ADICIONA APENAS UM
				if(referencia != listaConsulta.getInt("referencia")) {
					
					// VERIFICA SE ESTA ATIVO PARA ENVIAR 
					if (condicao.equals(ativo)) {			
						referencia = listaConsulta.getInt("referencia");
						
						retornoLista.setQuantidadetotal(quantidadeTotal(referencia));
						listartodos.add(retornoLista);	
					}
				} 
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
    
	// CONSULTA PELA BARRA DE PESQUISA
    public ArrayList<ProdutoSG> navbar(String geral) throws SQLException {
		
    	con = new Factory().conBD1();
		
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
				retornoLista.setCor(listaConsulta.getString("cor"));
				retornoLista.setCategoria(listaConsulta.getString("categoria"));
				retornoLista.setValor_venda(listaConsulta.getFloat("valor_venda"));
				retornoLista.setQuantidade(listaConsulta.getInt("quantidade"));
				retornoLista.setReferencia(listaConsulta.getInt("referencia"));
				retornoLista.setCondicao(listaConsulta.getString("condicao"));
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
    
	// CONSULTA PRODUTOS PELO GENERO OU CATEGORIA
    public ArrayList<ProdutoSG> produtoLink(String geral) throws SQLException{
		
    	con = new Factory().conBD1();
		ArrayList<ProdutoSG> produtolink = new ArrayList<>();
		
		sql = "select * from PRODUTO where categoria= ?";
		
		try {
			stmConsulta = con.prepareStatement(sql);
			stmConsulta.setString(1, geral);
			listaConsulta = stmConsulta.executeQuery();
			
			while (listaConsulta.next()) {
				
				ProdutoSG retornoLista = new ProdutoSG();
				FormatarReal fr = new FormatarReal();
				
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
				retornoLista.setValor_venda_fr(fr.formatar(listaConsulta.getFloat("valor_venda")));
				retornoLista.setQuantidade(listaConsulta.getInt("quantidade"));
				retornoLista.setReferencia(listaConsulta.getInt("referencia"));
				retornoLista.setCondicao(listaConsulta.getString("condicao"));
				
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
    
    // CADASTRA PEDIDO PESSOA FISICA
    public void PedidoFisico(ProdutoSG sgproduto, CadastroFisicoSG sgfisico) throws SQLException{
		
    	con = new Factory().conBD1();
		sql = "insert into COMPRAFISICO (numeropedido, idusuario, destinatario, idproduto, tamanho, cor, quantidade) values (?,?,?,?,?,?,?)";
		
		try {
			
			stmInserir = con.prepareStatement(sql);
			stmInserir.setBigDecimal(1,sgproduto.getNumeropedido());
			stmInserir.setInt(2,sgfisico.getIdusuario());
			stmInserir.setString(3,sgfisico.getDestinatario());
			stmInserir.setInt(4,sgproduto.getIdproduto());
			stmInserir.setString(5,sgproduto.getTamanho());
			stmInserir.setString(6,sgproduto.getCor());
			stmInserir.setInt(7,sgproduto.getQuantidade_dig());
			
			stmInserir.execute();
			stmInserir.close();
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
			
			stmInserir = con.prepareStatement(sql);
			stmInserir.setBigDecimal(1,sgproduto.getNumeropedido());
			stmInserir.setInt(2,sgjuridico.getIdempresa());
			stmInserir.setString(3, sgjuridico.getRazao());
			stmInserir.setInt(4,sgproduto.getIdproduto());
			stmInserir.setString(5,sgproduto.getTamanho());
			stmInserir.setString(6,sgproduto.getCor());
			stmInserir.setInt(7,sgproduto.getQuantidade_dig());
			
			stmInserir.execute();
			stmInserir.close();
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
    	
    	try {
    		stmConsulta = con.prepareStatement(sql);
			stmConsulta.setInt(1, id);
			resConsulta = stmConsulta.executeQuery();
			
			while (resConsulta.next()) {
				
				retornoLista.setIdfornecedor(resConsulta.getInt("idfornecedor"));
				retornoLista.setRazao(resConsulta.getString("razao"));
				retornoLista.setCnpj(resConsulta.getString("cnpj"));
				retornoLista.setIe(resConsulta.getString("ie"));
				retornoLista.setTelefone(resConsulta.getString("telefone"));
				retornoLista.setEndereco(resConsulta.getString("endereco"));
				retornoLista.setBairro(resConsulta.getString("bairro"));
				retornoLista.setCidade(resConsulta.getString("cidade"));
				retornoLista.setEstado(resConsulta.getString("estado"));
				retornoLista.setCep(resConsulta.getString("cep"));
			}
    		
    	} catch (Exception e){
    		System.out.println("Erro no ProdutoDAO em consultarFornecedor: "+e);
    	}
    	
    	return retornoLista;
    }
}
