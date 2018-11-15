package br.com.crashsolutions.Servlets;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.com.crashsolutions.DAO.ProdutoDAO;
import br.com.crashsolutions.SG.ProdutoSG;
import br.com.crashsolutions.Acoes.Validacao;

@WebServlet("/InserirProduto")
public class InserirProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InserirProduto() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher enviar = request.getRequestDispatcher("InserirProduto.jsp");
		enviar.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// INSTANCIO DAO E SG
		ProdutoDAO produtodao = new ProdutoDAO();
		ProdutoSG produtosg = new ProdutoSG();
		Validacao validacao = new Validacao();
		
		// UPLOAD DA IMAGEM 
		if (ServletFileUpload.isMultipartContent(request)) {
	        try {
	            // FAZ O PARSE DO REQUEST
	            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	            
	            // ENVIA O ARQUIVO PARA A PASTA DESEJADA
	            for (FileItem item : multiparts) {
	            	
	            	// PROCESSO DE ARQUIVOS  
	                if (!item.isFormField()) {
	                	// BUSCA O CAMINHO DO ARQUIVO DA IMAGEM
	                	String caminho = item.getName().toString();
	                	String Imagem = caminho.substring(caminho.lastIndexOf("\\")+1);
	                	
	                	// LOCAL DE UPLOAD 
	                	item.write(new File(("D:\\Users\\Hugo\\Documents\\Workspace\\TShirtGames\\WebContent\\resources\\img\\img-produtos") + File.separator + Imagem));
	                	
	                	// CADASTRAR IMAGEM NO BANCO
	                	produtosg.setImagem(Imagem);
	                } 
	                
	                // PROCESSO DE DADOS
	                if (item.isFormField()) {
	                	
	                	// CADASTRO DE DADOS NO BANCO
	                	if (item.getFieldName().equals("produto")) {
	                		
	                		if(validacao.SpecialCaracter(item.getString()) == true) {
	                			produtosg.setProduto(item.getString());
	                		}
	                		else if(validacao.SpecialCaracter(item.getString()) == false) {
	                			request.setAttribute("mensagem", "Erro no nome do Produto");
	                			doGet(request, response);
	                		}
	                		
	                	}
	                	if (item.getFieldName().equals("descricao")) {
	                		
	                		if(validacao.Full(item.getString()).equals(true)) {
	                			produtosg.setDescricao(item.getString()); 
	                			
	                		}
	                		else if(validacao.Full(item.getString()).equals(false)) {
	                			request.setAttribute("mensagem", "Erro ao preencher a Descrição");
	                			doGet(request, response);
	                		}
	                		
	                	}
	                	if (item.getFieldName().equals("modelo")) {
	                		
	                		if(validacao.Caracter(item.getString()) == true) {
	                			produtosg.setModelo(item.getString()); 
	                			
	                		}
	                		else if(validacao.Caracter(item.getString()) == false) {
	                			request.setAttribute("mensagem", "Erro ao preencher a Modelo");
	                			doGet(request, response);
	                		}
	                		
	                	}
	                	if (item.getFieldName().equals("genero")) {
	                		if(validacao.Caracter(item.getString()) == true) {
	                			
	                			produtosg.setGenero(item.getString()); 
	                			
	                		}
	                		else if(validacao.Caracter(item.getString()) == false) {
	                			request.setAttribute("mensagem", "Erro ao preencher a Genero");
	                			doGet(request, response);
	                		}
	                		
	                	}
	                	if (item.getFieldName().equals("categoria")) {
	                		
	                		if(validacao.Caracter(item.getString()) == true) {
	                			
	                			produtosg.setCategoria(item.getString());
	                			
	                		}
	                		else if(validacao.Caracter(item.getString()) == false) {
	                			request.setAttribute("mensagem", "Erro ao preencher a Categoria");
	                			doGet(request, response);
	                		}
	                		
	                	}
	                	if (item.getFieldName().equals("tamanho")) {
	                		
	                		if(validacao.Caracter(item.getString()) == true) {
	                			
	                			produtosg.setTamanho(item.getString());
	                			
	                		}
	                		else if(validacao.Caracter(item.getString()) == false) {
	                			request.setAttribute("mensagem", "Erro ao preencher a Tamanho");
	                			doGet(request, response);
	                		}
	                		
	                	}
	                	if (item.getFieldName().equals("cor")) {
	                		
	                		if(validacao.Caracter(item.getString()) == true) {
	                			
	                			produtosg.setCor(item.getString());
	                			
	                		}
	                		else if(validacao.Caracter(item.getString()) == false) {
	                			request.setAttribute("mensagem", "Erro ao preencher a Cor");
	                			doGet(request, response);
	                		}
	                		
	                	}
	                	if (item.getFieldName().equals("quantidade")) {
	                		
	                		if(validacao.NumberInt(item.getString()) == true) {
	                			
	                			produtosg.setQuantidade(Integer.parseInt(item.getString()));
	                			
	                		}
	                		else if(validacao.NumberInt(item.getString()) == false) {
	                			request.setAttribute("mensagem", "Erro ao preencher a Quantidade");
	                			doGet(request, response);
	                		}
	                		
	                	}
	                	if (item.getFieldName().equals("valor_custo")) {
	                		
	                		if(validacao.NumberDecimal(item.getString()) == true) {
	                			
	                			produtosg.setValor_custo(Float.parseFloat(item.getString()));
	                			
	                		}
	                		else if(validacao.NumberInt(item.getString()) == false) {
	                			request.setAttribute("mensagem", "Erro ao preencher a Valor Custo");
	                			doGet(request, response);
	                		}
	                		
	                	}
	                	if (item.getFieldName().equals("valor_venda")) {
	                		
	                		if(validacao.NumberDecimal(item.getString()) == true) {
	                			produtosg.setValor_venda(Float.parseFloat(item.getString()));
	                			
	                		}
	                		else if(validacao.NumberDecimal(item.getString()) == false) {
	                			request.setAttribute("mensagem", "Erro ao preencher a Valor venda");
	                			doGet(request, response);
	                		}
	                		
	                	}
	                	if (item.getFieldName().equals("referencia")) {
	                		
	                		if(validacao.NumberInt(item.getString()) == true) {
	                			produtosg.setReferencia(Integer.parseInt(item.getString()));
	                			
	                		}
	                		else if(validacao.NumberInt(item.getString()) == false) {
	                			request.setAttribute("mensagem", "Erro ao preencher a Referência");
	                			doGet(request, response);
	                		}
	                	}
	                } 
	            }
	            
	        } catch (Exception ex) {
	        	// MENSAGEM DE ERRO NO CADASTRO DA IMAGEM
	        	System.out.println("Erro no InserirProduto: "+ ex);
	        }
	 
	        } else {
	        	// MENSAGEM DE ERRO NO UPLOAD DA IMAGEM
	        	System.out.println("Este Servlet realiza apenas upload de arquivos");
	    }

    	// UTILIZA A AÇÃO DE INSERIR
    	try {
			produtodao.inserir(produtosg);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	// MENSAGEM DE CADASTRADO COM SUCESSO
    	request.setAttribute("mensagem", produtodao.Mensagem);
		
		// ENVIAR DADOS PARA A PÁGINA JSP
    	doGet(request, response);
	}
	
}