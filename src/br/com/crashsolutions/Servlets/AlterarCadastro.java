package br.com.crashsolutions.Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crashsolutions.DAO.CadastroFisicoDAO;
import br.com.crashsolutions.SG.CadastroFisicoSG;

@WebServlet("/AlterarCadastro")
public class AlterarCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlterarCadastro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// INTANCIA O SG E DAO
				CadastroFisicoDAO dao = new CadastroFisicoDAO();
				CadastroFisicoSG sg = new CadastroFisicoSG();

			
					try {
						sg = dao.ConsultarUsuario(request.getParameter("idusuario"));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
				
				// EXIBIR TELA APÓS CADASTRAR A PESSOA FÍSICA
				request.getRequestDispatcher("AlterarCadastro.jsp").forward(request, response);
			}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
