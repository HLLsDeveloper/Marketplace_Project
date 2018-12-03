package br.com.crashsolutions.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crashsolutions.DAO.ProdutoDAO;
import br.com.crashsolutions.SG.ProdutoSG;

@WebServlet("/Busca")
public class BuscaNavbar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BuscaNavbar() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String busca = request.getParameter("pesquisa");
			
			ProdutoDAO produtodao = new ProdutoDAO();
			
			ArrayList<ProdutoSG> resultadoBusca = produtodao.navbar(busca,1);
			
			request.setAttribute("lista", resultadoBusca);
			
			RequestDispatcher enviarResultado = request.getRequestDispatcher("ListaCamisetas.jsp");
			enviarResultado.forward(request, response);
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}
}
