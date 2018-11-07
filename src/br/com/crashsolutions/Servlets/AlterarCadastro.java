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
 * Servlet implementation class AlterarCadastro
 */
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

				// CONSULTA PELO ID DO USUÁRIO
				try {
					sg = dao.ConsultarUsuario(request.getParameter("idusuario"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				if (request.getParameter("idusuario") != null) {
					
					try {
						
						// BUSCA OS DADOS NO BANCO COM O SG
						Integer Idusuario = sg.getIdusuario();
						String Nome = sg.getNome();
						String Sobrenome = sg.getSobrenome();
						String Cpf = sg.getCpf();
						String saEmail = sg.getEmail();			
						
						// INSERE OS DADOS NOS CAMPOS DA PÁGINA JSP
						request.setAttribute("idusuario", Idusuario);
						request.setAttribute("nome", Nome);
						request.setAttribute("sobrenome", Sobrenome);
						request.setAttribute("cpf", Cpf);

					
					} catch (Exception ex) {
						System.out.println("Erro ao consultar os dados:"+ ex);
					}
				}
				
				// EXIBIR TELA APÓS CADASTRAR A PESSOA FÍSICA
				request.getRequestDispatcher("AlterarCadastro.jsp").forward(request, response);
			}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
