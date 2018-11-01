package br.com.crashsolutions.Servlets;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.com.crashsolutions.Acoes.FormatarReal;
import br.com.crashsolutions.DAO.ProdutoDAO;
import br.com.crashsolutions.SG.ProdutoSG;

@WebServlet("/AlterarProduto")
public class AlterarProduto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	static String Genero, Categoria, Tamanho;
	
    public AlterarProduto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// INTANCIA O SG E DAO
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoSG sg = new ProdutoSG();
		
		// FORMATAÇÃO DE VALOR
		FormatarReal fr = new FormatarReal(); 
		
		// BUSCA A AÇÃO NO DAO QUE BUSCA OS DADOS DO PRODUTO
		ArrayList<ProdutoSG> lista;
		
		try {
			lista = dao.buscaTodos();
			request.setAttribute("lista_produto", lista);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		
		// CONSULTA PELO ID DO PRODUTO
		try {
			sg = dao.consultar(request.getParameter("idproduto"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (request.getParameter("idproduto") != null) {
			
			try {
				
				// BUSCA OS DADOS NO BANCO COM O SG
				Integer Idproduto = sg.getIdproduto();
				String Produto = sg.getProduto();
				String Imagem = sg.getImagem();
				String Descricao = sg.getDescricao();
				String Modelo = sg.getModelo();
				Genero = sg.getGenero();
				Tamanho = sg.getTamanho();
				String Cor = sg.getCor();
				Categoria = sg.getCategoria();
				Float ValorCusto = sg.getValor_custo();
				Float ValorVenda = sg.getValor_venda();
				Integer Quantidade = sg.getQuantidade();
				Integer Referencia = sg.getReferencia();
				
				// INSERE OS DADOS NOS CAMPOS DA PÁGINA JSP
				request.setAttribute("idproduto", Idproduto);
				request.setAttribute("produto", Produto);
				request.setAttribute("imagem", Imagem);
				request.setAttribute("descricao", Descricao);
				request.setAttribute("modelo", Modelo);
				request.setAttribute("genero", Genero);
				request.setAttribute("tamanho", Tamanho);
				request.setAttribute("cor", Cor);
				request.setAttribute("categoria", Categoria);
				request.setAttribute("valor_custo", fr.formatar(ValorCusto));
				request.setAttribute("valor_venda", fr.formatar(ValorVenda));
				request.setAttribute("quantidade", Quantidade);	
				request.setAttribute("referencia", Referencia);
			
			} catch (Exception ex) {
				System.out.println("Erro ao consultar os dados:"+ ex);
			}
		}
		
		// EXIBIR TELA APÓS CADASTRAR O PRODUTO
		request.getRequestDispatcher("AlterarProduto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// INSTANCIO AS CLASSES DAO E SG
		ProdutoDAO produtodao = new ProdutoDAO();
		ProdutoSG produtosg = new ProdutoSG();
		
		// VARIAVEIS DO UPLOAD DA IMAGEM
		String caminho = null, Imagem = null;
		
		// UPLOAD DA IMAGEM
		if (ServletFileUpload.isMultipartContent(request)) {
	        try {
	            // FAZ O PARSE DO REQUEST
	            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	            
	            for (FileItem item : multiparts) {
	            	
	           		// PROCESSO DE ARQUIVOS  
	                if (!item.isFormField()) {
	                	
	                	// BUSCA O CAMINHO DO ARQUIVO 
	                	caminho  = item.getName().toString();
	                 
	                	// CADASTRA APENAS QUANDO HÁ UM ARQUIVO FOI SELECIONADO
	                    if (caminho != "") {
		                	
		                    // BUSCA O NOME DO ARQUIVO 
			                Imagem = caminho.substring(caminho.lastIndexOf("\\")+1);
		                    	
		                	// ENVIA O ARQUIVO PARA A PASTA DESEJADA
		                	item.write(new File(("Resolver com Luan!!!!!!!!!") + File.separator + Imagem));		                	
	                    } 
	                }
	                
	                // PROCESSO DE DADOS
	                if (item.isFormField()) {
	                	
	                	// CADASTRO DE DADOS NO BANCO
	                	if (item.getFieldName().equals("idproduto")) {
	                		
	                		produtosg.setIdproduto(Integer.parseInt(item.getString())); 
	                	}
	                	if (item.getFieldName().equals("produto")) {
	                		
	                		produtosg.setProduto(item.getString()); 
	                	}
	                	if (caminho == "") {
	                		if (item.getFieldName().equals("imagem")) {
		                		
		                		produtosg.setImagem(item.getString());
		                	} 
	                	} else {
	                		// CADASTRA APENAS SE A IMAGEM É ALTERADO
		                	produtosg.setImagem(Imagem);
	                	}
	                	if (item.getFieldName().equals("descricao")) {
	                		
	                		produtosg.setDescricao(item.getString());
	                	}
	                	if (item.getFieldName().equals("modelo")) {
	                		
	                		produtosg.setModelo(item.getString());
	                	}
	                	if (item.getFieldName().equals("cor")) {
	                		
	                		produtosg.setCor(item.getString());
	                	}
	                	if (item.getFieldName().equals("valor_custo")) {
	                		
	                		produtosg.setValor_custo(Float.parseFloat(item.getString()));
	                	}
	                	if (item.getFieldName().equals("valor_venda")) {
	                		
	                		produtosg.setValor_venda(Float.parseFloat(item.getString()));
	                	}
	                	if (item.getFieldName().equals("quantidade")) {
	                		
	                		produtosg.setQuantidade(Integer.parseInt(item.getString()));
	                	}
	                	if (item.getFieldName().equals("referencia")) {
	                		
	                		produtosg.setReferencia(Integer.parseInt(item.getString()));
	                	}	
	                }
	            }
	            
	        } catch (Exception ex) {
	        	System.out.println("Erro na Alteração:"+ ex); 
	        }
	 
	        } else {
	        	System.out.println("Este Servlet realiza apenas upload de arquivos");
	    }
		
		// RECEBE OS VALORES QUE NÃO SERÃO ALTERADOS
		produtosg.setTamanho(Tamanho);
		produtosg.setCategoria(Categoria);
		produtosg.setGenero(Genero);
		
		// UTILIZA O METODO DE ALTERAR DO DAO 
		try {
			
			produtodao.alterar(produtosg);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// USA A AÇÃO NO DAO QUE BUSCA OS DADOS DO PRODUTO
		ProdutoDAO listar = new ProdutoDAO();
		ArrayList<ProdutoSG> lista;
		
		try {
			lista = listar.buscaTodos();
			request.setAttribute("lista_produto", lista);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		
		// MENSAGEM DE ALTERADO COM SUCESSO
    	request.setAttribute("mensagem", produtodao.Mensagem);
		
		// EXIBIR TELA APÓS CADASTRAR O PRODUTO
		request.getRequestDispatcher("AlterarProduto.jsp").forward(request, response);
	}
}
