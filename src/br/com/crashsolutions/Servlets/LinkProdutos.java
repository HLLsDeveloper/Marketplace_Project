package br.com.crashsolutions.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crashsolutions.DAO.ProdutoDAO;
import br.com.crashsolutions.SG.ProdutoSG;

@WebServlet("/LinkProduto")
public class LinkProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LinkProdutos() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// RECEBE A CATEGORIA PARA BUSCA
		String busca = request.getParameter("busca");
	 
		try {
			// BUSCA OS DADOS NO BANCO DE ACORDO COM A CATEGORIA
			ProdutoDAO dao = new ProdutoDAO();
			ArrayList<ProdutoSG> resultadoLinkProduto;
			
			resultadoLinkProduto = dao.produtoLink(busca,1);
			request.setAttribute("lista", resultadoLinkProduto);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher r = request.getRequestDispatcher("ListaCamisetas.jsp");
		r.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}
}
