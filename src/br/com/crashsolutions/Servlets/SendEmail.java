package br.com.crashsolutions.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;

@WebServlet("/Email")
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public SendEmail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher enviar = request.getRequestDispatcher("Contato.jsp");
		enviar.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String email = request.getParameter("email");
			String remetente = "Hugo";
			
			HtmlEmail sendemail = new HtmlEmail();
			sendemail.setHostName("smtp.gmail.com");
			sendemail.setSmtpPort(465);
			sendemail.setSSLOnConnect(true);
			sendemail.setAuthentication("hllsdeveloper@gmail.com", "HLLs1622");
			
			//EMAIL DO CLIENTE, ASSUNTO E MENSAGEM
			sendemail.addTo("hllsdeveloper@gmail.com");
			sendemail.setFrom(email, remetente);
			sendemail.setSubject("Camiseta DragonBall");
			sendemail.setMsg("Eu queria saber se as camisetas são de ótima qualidade.");
			//////////////////////////////////////
			
			sendemail.send();
			
			request.setAttribute("mensagem", "Obrigado pelo contato!");
			
		} catch (Exception e) {
			System.out.println("Erro no envio de e-mail " + e);
			request.setAttribute("mensagem", "Opss, algo deu errado.");
		}
		
		doGet(request, response);
	}
}
