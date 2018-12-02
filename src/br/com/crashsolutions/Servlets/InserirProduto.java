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
	                	item.write(new File(("C:\\Users\\luanl\\git\\Projeto\\TShirtGames\\WebContent\\resources\\img\\img-produtos") + File.separator + Imagem));
	                	
	                	// CADASTRAR IMAGEM NO BANCO
	                	produtosg.setImagem(Imagem);
	                } 
	                
	             // PROCESSO DE DADOS
	                if (item.isFormField()) {
	                	
	                	// CADASTRO DE DADOS NO BANCO
	                	if (item.getFieldName().equals("produto")) {
	                		
	                		produtosg.setProduto(item.getString()); 
	                	}
	                	if (item.getFieldName().equals("descricao")) {
	                		
	                		produtosg.setDescricao(item.getString());
	                	}
	                	if (item.getFieldName().equals("modelo")) {
	                		
	                		produtosg.setModelo(item.getString());
	                	}
	                	if (item.getFieldName().equals("genero")) {
	                		
	                		produtosg.setGenero(item.getString());
	                	}
	                	if (item.getFieldName().equals("categoria")) {
	                		
	                		produtosg.setCategoria(item.getString());
	                	}
	                	if (item.getFieldName().equals("tamanho")) {
	                		
	                		produtosg.setTamanho(item.getString());
	                	}
	                	if (item.getFieldName().equals("cor")) {
	                		
	                		produtosg.setCor(item.getString());
	                	}
	                	if (item.getFieldName().equals("quantidade")) {
	                		
	                		produtosg.setQuantidade(Integer.parseInt(item.getString()));
	                	}
	                	if (item.getFieldName().equals("valor_custo")) {
	                		
	                		produtosg.setValor_custo(Float.parseFloat(item.getString()));
	                	}
	                	if (item.getFieldName().equals("valor_venda")) {
	                		
	                		produtosg.setValor_venda(Float.parseFloat(item.getString()));
	                	}
	                	if (item.getFieldName().equals("referencia")) {
	                		
	                		produtosg.setReferencia(Integer.parseInt(item.getString()));
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