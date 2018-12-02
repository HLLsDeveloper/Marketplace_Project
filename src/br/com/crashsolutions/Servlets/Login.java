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
		
		RequestDispatcher enviar = request.getRequestDispatcher("Login.jsp");
		enviar.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String email = request.getParameter("login_email");
			String senha = request.getParameter("login_senha");
			String url = null;
			
			CadastroFisicoDAO fisicodao = new CadastroFisicoDAO();
			
			CadastroFisicoSG fisico = fisicodao.ConsultarUsuario(email);
			
			if(fisico.getEmail() != null) {
				
				ConexaoLogin conexaologin = new ConexaoLogin();
				Boolean acessofisico = conexaologin.LoginFisico(email, senha);
				
				if(acessofisico == true) {
					
					fisico = fisicodao.ConsultarUsuario(email);
					
					sessao = request.getSession();
					sessao.setAttribute("idsessaouser", sessao.getId());
					sessao.setAttribute("idusuariouser", fisico.getIdusuario());
					sessao.setAttribute("emailuser", fisico.getEmail());
					sessao.setAttribute("cpfuser", fisico.getCpf());
					sessao.setAttribute("imagemuser", fisico.getImagem());
					sessao.setAttribute("nomeuser", fisico.getNome());
					sessao.setAttribute("sobrenomeuser", fisico.getSobrenome());
					sessao.setAttribute("datanascimentouser", fisico.getDatanascimento());
					sessao.setAttribute("sexouser", fisico.getSexo());
					sessao.setAttribute("telefoneuser", fisico.getTelefone());
					sessao.setAttribute("celularuser", fisico.getCelular());
					sessao.setAttribute("condicaouser", fisico.getCondicao());
					
					if(sessao.getAttribute("url") != null) {
						url = (String) sessao.getAttribute("url");
						sessao.removeAttribute("url");
					}
					if (url != null) {
						response.sendRedirect(url);
					}
					else {
						response.sendRedirect("Home");
					}
				}
				else {
					
					request.setAttribute("mensagemlogin", "Email ou Senha incorretos, verifique se foi digitado corretamente");
					doGet(request, response);
				}
			}
			
			if(fisico.getEmail() == null) {
				
				CadastroJuridicoDAO juridicodao = new CadastroJuridicoDAO();
				
				CadastroJuridicoSG juridico = juridicodao.ConsultarEmpresa(email);
				
				if(juridico.getEmail() != null) {
					
					ConexaoLogin conexaologin = new ConexaoLogin();
					Boolean acessojuridico = conexaologin.LoginJuridico(email, senha);
					
					if(acessojuridico == true) {
						
						sessao = request.getSession();
						sessao.setAttribute("idsessaouser", sessao.getId());
						sessao.setAttribute("idempresauser", juridico.getIdempresa());
						sessao.setAttribute("emailuser", juridico.getEmail());
						sessao.setAttribute("cnpjuser", juridico.getCnpj());
						sessao.setAttribute("logouser", juridico.getLogo());
						sessao.setAttribute("razaouser", juridico.getRazao());
						sessao.setAttribute("nomefantasiauser", juridico.getNomefantasia());
						sessao.setAttribute("ieuser", juridico.getIe());
						sessao.setAttribute("telefoneuser", juridico.getTelefone());
						sessao.setAttribute("celularuser", juridico.getCelular());
						sessao.setAttribute("condicaouser", juridico.getCondicao());
						
						if(sessao.getAttribute("url") != null) {
							url = (String) sessao.getAttribute("url");
							sessao.removeAttribute("url");
						}
						if (url != null) {
							response.sendRedirect(url);
						}
						else {
							response.sendRedirect("Home");
						}
					}
					else {
						
						request.setAttribute("mensagemlogin", "Email ou Senha incorretos, verifique se foi digitado corretamente");
						doGet(request, response);
					}
				}
				if(juridico.getEmail() == null) {
					
					request.setAttribute("mensagemlogin", "Usuário não cadastrado, por favor faça o cadastro!");
					doGet(request, response);
				}
			}
		} 
		catch(Exception e) {
			System.out.println("Erro doido " + e);
		}
	}
}
