package br.com.crashsolutions.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crashsolutions.DAO.CadastroFisicoDAO;
import br.com.crashsolutions.DAO.ProdutoDAO;
import br.com.crashsolutions.SG.CadastroFisicoSG;
import br.com.crashsolutions.SG.ProdutoSG;

@WebServlet("/BuscaGerenciamentoFisico")
public class BuscaGerenciamentoFisico extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BuscaGerenciamentoFisico() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String busca = request.getParameter("pesquisa");
			
			CadastroFisicoDAO fisicodao = new CadastroFisicoDAO();
			
			ArrayList<CadastroFisicoSG> resultadoBusca = fisicodao.gerenciamentofisico(busca);
			
			request.setAttribute("lista", resultadoBusca);
			
			RequestDispatcher enviarResultado = request.getRequestDispatcher("GerenciamentoFisico.jsp");
			enviarResultado.forward(request, response);
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
