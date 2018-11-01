package br.com.crashsolutions.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crashsolutions.Acoes.FormatarReal;
import br.com.crashsolutions.DAO.ProdutoDAO;
import br.com.crashsolutions.SG.ProdutoSG;

@WebServlet("/GerenciamentoEstoque")
public class GerenciamentoEstoque extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	FormatarReal fr = new FormatarReal();
   
    public GerenciamentoEstoque() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		try {
			
			ProdutoDAO dao = new ProdutoDAO();
			
			ArrayList<ProdutoSG> lista = dao.buscaTodos();
			request.setAttribute("lista_produto", lista);
			
			request.getRequestDispatcher("GerenciamentoEstoque.jsp").forward(request, response);

		} catch (SQLException e) {
			System.out.println("Erro no Gerenciamento de Estoque: " + e);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}
}
