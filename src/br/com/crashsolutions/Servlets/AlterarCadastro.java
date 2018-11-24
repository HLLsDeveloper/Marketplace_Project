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
	
		// INSTANCIA O SG E DAO
				CadastroFisicoDAO dao = new CadastroFisicoDAO();
				CadastroFisicoSG sg = new CadastroFisicoSG();

				// BUSCA A A��O NO DAO QUE BUSCA OS DADOS DO PRODUTO
				ArrayList<CadastroFisicoSG> lista;
				
				try {
					lista = dao.buscartodos();
					request.setAttribute("lista_usuario", lista);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}  
				
				// CONSULTA PELO ID DO USUARIO
				try {
					sg = dao.ConsultarUsuario(request.getParameter("idusuario"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				if (request.getParameter("idusuario") != null) {
					
					try {
						
						// BUSCA OS DADOS NO BANCO COM O SG 
						Integer idusuario = sg.getIdusuario();
						String anome = sg.getNome(); 
						String asobrenome = sg.getSobrenome();
						String acpf = sg.getCpf();
						String aemail = sg.getEmail();
						String adatanascimento = sg.getDatanascimento();
						String atelefone = sg.getTelefone();
						String acelular = sg.getCelular();
						String acondicao = sg.getCondicao();
						
						
						
						// INSERE OS DADOS NOS CAMPOS DA P�GINA JSP
						request.setAttribute("aidusuario", idusuario);
						request.setAttribute("anome", anome);
						request.setAttribute("asobrenome", asobrenome);
						request.setAttribute("acpf", acpf);
						request.setAttribute("aemail", aemail);
						request.setAttribute("adatanascimento", adatanascimento);
						request.setAttribute("atelefone", atelefone);
						request.setAttribute("acelular", acelular);
						request.setAttribute("acondicao", acondicao);
						
					
					} catch (Exception ex) {
						System.out.println("Erro ao consultar os dados:"+ ex);
					}
				
				// EXIBIR TELA AP�S CADASTRAR A PESSOA F�SICA
				request.getRequestDispatcher("AlterarCadastro.jsp").forward(request, response);
			}}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CadastroFisicoSG sgfisico = new CadastroFisicoSG();
		CadastroFisicoDAO daofisico = new CadastroFisicoDAO();
		
		try {
			
			sgfisico.setNome(request.getParameter("anome"));
			sgfisico.setSobrenome(request.getParameter("asobrenome"));
			sgfisico.setEmail(request.getParameter("aemail"));
			sgfisico.setCelular(request.getParameter("acelular"));
			sgfisico.setTelefone(request.getParameter("atelefone"));
			sgfisico.setDatanascimento(request.getParameter("adatanascimento"));
			sgfisico.setCondicao(request.getParameter("acondicao"));
			sgfisico.setIdusuario(Integer.parseInt(request.getParameter("aidusuario")));
			
			daofisico.AlterarUsuario(sgfisico);
			request.setAttribute("mensagem", "Alterado com sucesso!");
			
		} catch (Exception e) {
			System.out.println("Erro ao alterar os dados:"+ e);
			request.setAttribute("mensagem", "Erro ao alterar!");
		}
		doGet(request, response);
	}

}
