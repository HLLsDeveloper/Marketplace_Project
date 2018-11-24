package br.com.crashsolutions.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

@WebServlet("/Email")
public class Email extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Email() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher enviar = request.getRequestDispatcher("Contato.jsp");
		enviar.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String email = request.getParameter("email");
			
			SimpleEmail simpleemail = new SimpleEmail();
			simpleemail.setHostName("smtp.gmail.com");
			simpleemail.setAuthenticator(new DefaultAuthenticator("hllsdeveloper@gmail.com", "HLLs1622"));
			simpleemail.setSSLOnConnect(true);
			
			//EMAIL DO CLIENTE, ASSUNTO E MENSAGEM
			simpleemail.setFrom(email);
			simpleemail.setSubject("Camiseta DragonBall");
			simpleemail.setMsg("Eu queria saber se as camisetas são de ótima qualidade.");
			//////////////////////////////////////
			
			simpleemail.addTo("hllsdeveloper@gmail.com");
			simpleemail.send();
			
			request.setAttribute("mensagem", "Obrigado pelo contato!");
			
		} catch (Exception e) {
			System.out.println("Erro no envio de e-mail " + e);
			request.setAttribute("mensagem", "Opss, algo deu errado.");
		}
		
		doGet(request, response);
	}
}
