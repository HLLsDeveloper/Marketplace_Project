package br.com.crashsolutions.Servlets;

import br.com.crashsolutions.DAO.CadastroJuridicoDAO;
import br.com.crashsolutions.SG.CadastroJuridicoSG;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CadastroJuridico")
public class CadastroJuridico extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public CadastroJuridico() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CadastroJuridicoDAO dao = new CadastroJuridicoDAO();
		ArrayList<CadastroJuridicoSG> lista = dao.listar();
		
		request.setAttribute("lista", lista);
		
		request.getRequestDispatcher("CadastroJuridico.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		try {
		String Email = request.getParameter("email");
	    String Senha = request.getParameter("senha");
	    String Cnpj = request.getParameter("cnpj");
	    String Razao = request.getParameter("razao");
	    String Nomefantasia = request.getParameter("nomefantasia");
	    String Ie = request.getParameter("ie");
	    String Endereco = request.getParameter("endereco");
	    Integer Numero = Integer.parseInt(request.getParameter("numero"));
	    String Complemento = request.getParameter("complemento");
	    String Bairro = request.getParameter("bairro");
	    String Cidade = request.getParameter("cidade");
	    String Estado = request.getParameter("estado");
	    String Cep = request.getParameter("cep");
	    
	    CadastroJuridicoSG sg = new CadastroJuridicoSG();
	    CadastroJuridicoDAO dao = new CadastroJuridicoDAO();
	    
	    sg.setEmail(Email);
	    sg.setSenha(Senha);
	    sg.setCnpj(Cnpj);
	    sg.setRazao(Razao);
	    sg.setNomefantasia(Nomefantasia);
	    sg.setIe(Ie);
	    sg.setEndereco(Endereco);
	    sg.setNumero(Numero);
	    sg.setComplemento(Complemento);
	    sg.setBairro(Bairro);
	    sg.setCidade(Cidade);
	    sg.setEstado(Estado);
	    sg.setCep(Cep);
	    
	    dao.inserir(sg);
	    
	    System.out.println("Sucesso no CadastroJuridico: "+ Email);
		} catch (Exception ex) {
			System.out.println("Erro no CadastroJuridico: "+ ex);
		}
	    
	    request.getRequestDispatcher("CadastroJuridico.jsp").forward(request, response);
	}
}
