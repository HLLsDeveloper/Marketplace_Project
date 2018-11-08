package br.com.crashsolutions.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.crashsolutions.DAO.CadastroFisicoDAO;
import br.com.crashsolutions.DAO.CadastroJuridicoDAO;
import br.com.crashsolutions.SG.CadastroFisicoSG;
import br.com.crashsolutions.SG.CadastroJuridicoSG;

@WebServlet("/Enderecos")
public class ListaEndereco extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListaEndereco() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("email");
			
			CadastroFisicoDAO fisicodao = new CadastroFisicoDAO();
			CadastroJuridicoDAO juridicodao = new CadastroJuridicoDAO();
			
			ArrayList<CadastroFisicoSG> enderecos_fisico = fisicodao.listarEnderecos(email);
			
			if(enderecos_fisico.isEmpty()) {
				
				ArrayList<CadastroJuridicoSG> enderecos_juridico = juridicodao.listarEnderecos(email);
				request.setAttribute("enderecos", enderecos_juridico);
				
			} else {
				
				request.setAttribute("enderecos", enderecos_fisico);
			}
			
			RequestDispatcher enviar = request.getRequestDispatcher("ListaEndereco.jsp");
			enviar.forward(request, response);
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		try {
			
			CadastroFisicoDAO fisicodao = new CadastroFisicoDAO();
			
			CadastroFisicoSG sgfisico = new CadastroFisicoSG();
			sgfisico.setIdenderecofisico((Integer) session.getAttribute("idusuario"));
			sgfisico.setNomeendereco(request.getParameter("nomeendereco"));
			sgfisico.setEndereco(request.getParameter("endereco"));
			sgfisico.setNumero(Integer.parseInt(request.getParameter("numero")));
			sgfisico.setComplemento(request.getParameter("complemento"));
			sgfisico.setBairro(request.getParameter("bairro"));
			sgfisico.setCidade(request.getParameter("cidade"));
			sgfisico.setEstado(request.getParameter("estado"));
			sgfisico.setCep(request.getParameter("cep"));
			fisicodao.cadastrarEndereco(sgfisico);
			
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar " + e);
		}
		
		response.sendRedirect("http://localhost:8080/TShirtGames/Enderecos");
	}
}
