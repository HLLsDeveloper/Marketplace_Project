package br.com.crashsolutions.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.crashsolutions.Acoes.ConexaoLogin;
import br.com.crashsolutions.DAO.CadastroFisicoDAO;
import br.com.crashsolutions.SG.CadastroFisicoSG;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession sessao;
	
    public Login() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().invalidate();
        response.sendRedirect("Home");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			ConexaoLogin conexaologin = new ConexaoLogin();
			Boolean acesso = conexaologin.LoginFisico(email, senha);
			
			if(acesso == true) {
				
				CadastroFisicoDAO fisicodao = new CadastroFisicoDAO();
				CadastroFisicoSG fisico = fisicodao.consultar(email);
				
				sessao = request.getSession();
				sessao.setAttribute("idsessao", sessao.getId());
				sessao.setAttribute("idusuario", fisico.getIdusuario());
				sessao.setAttribute("email", fisico.getEmail());
				sessao.setAttribute("cpf", fisico.getCpf());
				sessao.setAttribute("nome", fisico.getNome());
				sessao.setAttribute("sobrenome", fisico.getSobrenome());
				sessao.setAttribute("datanascimento", fisico.getDatanascimento());
				sessao.setAttribute("sexo", fisico.getSexo());
				sessao.setAttribute("telefone", fisico.getTelefone());
				sessao.setAttribute("celular", fisico.getCelular());
				response.sendRedirect("http://localhost:8080/TShirtGames/Home");
			}
			else {
				
				String texto = "O usuário ou a senha está incorreto, por favor, tente novamente!";
				request.setAttribute("mensagem", texto);
				RequestDispatcher enviar = request.getRequestDispatcher("Login.jsp");
				enviar.forward(request, response);
				
			}
			
		} catch(Exception e) {
			System.out.println("Erro " + e);
		}
	}
}
