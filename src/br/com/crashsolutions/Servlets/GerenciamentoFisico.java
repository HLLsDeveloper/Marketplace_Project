package br.com.crashsolutions.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crashsolutions.DAO.CadastroFisicoDAO;
import br.com.crashsolutions.SG.CadastroFisicoSG;

/**
 * Servlet implementation class GerenciamentoFisico
 */
@WebServlet("/GerenciamentoFisico")
public class GerenciamentoFisico extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GerenciamentoFisico() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {			
			CadastroFisicoDAO dao = new CadastroFisicoDAO();
			
			ArrayList<CadastroFisicoSG> lista = dao.buscartodos();
			request.setAttribute("listapessoas", lista);
			
			request.getRequestDispatcher("GerenciamentoFisico.jsp").forward(request, response);

		} catch (SQLException e) {
			System.out.println("Erro no Gerenciamento Fisico: " + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
