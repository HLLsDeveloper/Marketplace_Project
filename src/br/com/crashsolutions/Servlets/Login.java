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
import br.com.crashsolutions.DAO.CadastroJuridicoDAO;
import br.com.crashsolutions.SG.CadastroFisicoSG;
import br.com.crashsolutions.SG.CadastroJuridicoSG;

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
			String url = null;
			
			ConexaoLogin conexaologin = new ConexaoLogin();
			Boolean acesso = conexaologin.LoginFisico(email, senha);
			
			if(acesso == true) {
				
				CadastroFisicoDAO fisicodao = new CadastroFisicoDAO();
				CadastroFisicoSG fisico = fisicodao.ConsultarUsuario(email);
				
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
				sessao.setAttribute("condicao", fisico.getCondicao());
				
				if(sessao.getAttribute("url") != null) {
					url = (String) sessao.getAttribute("url");
					sessao.removeAttribute("url");
				}
				if (url != null) {
					response.sendRedirect(url);
				}
				else {
					response.sendRedirect("http://localhost:8080/TShirtGames/Home");
				}
			}
			
			if(acesso == false) {
				
				acesso = conexaologin.LoginJuridico(email, senha);
				
				if(acesso == true) {
					
					CadastroJuridicoDAO juridicodao = new CadastroJuridicoDAO();
					CadastroJuridicoSG juridico = juridicodao.ConsultarUsuario(email);
					
					sessao = request.getSession();
					sessao.setAttribute("idsessao", sessao.getId());
					sessao.setAttribute("idempresa", juridico.getIdempresa());
					sessao.setAttribute("email", juridico.getEmail());
					sessao.setAttribute("cnpj", juridico.getCnpj());
					sessao.setAttribute("razao", juridico.getRazao());
					sessao.setAttribute("nomefantasia", juridico.getNomefantasia());
					sessao.setAttribute("ie", juridico.getIe());
					sessao.setAttribute("condicao", juridico.getCondicao());
					
					if(sessao.getAttribute("url") != null) {
						url = (String) sessao.getAttribute("url");
						sessao.removeAttribute("url");
					}
					if (url != null) {
						response.sendRedirect(url);
					}
					else {
						response.sendRedirect("http://localhost:8080/TShirtGames/Home");
					}
				}
			}
			else {
				
				String texto = "O usuário ou a senha está incorreto, por favor, tente novamente!";
				request.setAttribute("mensagem", texto);
				/*RequestDispatcher enviar = request.getRequestDispatcher("Login.jsp");
				enviar.forward(request, response);*/
				
			}
			
		} catch(Exception e) {
			System.out.println("Erro doido " + e);
		}
	}
}
