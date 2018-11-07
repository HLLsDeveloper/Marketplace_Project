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
		
		try {
			
			CadastroJuridicoDAO dao = new CadastroJuridicoDAO();
			ArrayList<CadastroJuridicoSG> lista = dao.listar();
			
			request.setAttribute("lista", lista);
			
			request.getRequestDispatcher("CadastroJuridico.jsp").forward(request, response);
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		try {
			
			CadastroJuridicoSG juridicosg = new CadastroJuridicoSG();
		    CadastroJuridicoDAO juridicodao = new CadastroJuridicoDAO();
			
			String Email = request.getParameter("email");
		    String Senha = request.getParameter("senha");
		    String Cnpj = request.getParameter("cnpj");
		    String Razao = request.getParameter("razao");
		    String Nomefantasia = request.getParameter("nomefantasia");
		    String Ie = request.getParameter("ie");
		    
		    juridicosg.setEmail(Email);
		    juridicosg.setSenha(Senha);
		    juridicosg.setCnpj(Cnpj);
		    juridicosg.setRazao(Razao);
		    juridicosg.setNomefantasia(Nomefantasia);
		    juridicosg.setIe(Ie);
		    
		    juridicodao.CadastrarUsuario(juridicosg);
		    
		    juridicosg = juridicodao.buscarultimo();
		    
		    //PEGA OS DADOS DO JSP PARA GRAVAR NA TABELA ENDERECO
		    String Endereco = request.getParameter("endereco");
		    Integer Numero = Integer.parseInt(request.getParameter("numero"));
		    String Complemento = request.getParameter("complemento");
		    String Bairro = request.getParameter("bairro");
		    String Cidade = request.getParameter("cidade");
		    String Estado = request.getParameter("estado");
		    String Cep = request.getParameter("cep");
		    
		    juridicosg.setIdenderecojuridico(juridicosg.getIdempresa());
		    juridicosg.setEndereco(Endereco);
		    juridicosg.setNumero(Numero);
		    juridicosg.setComplemento(Complemento);
		    juridicosg.setBairro(Bairro);
		    juridicosg.setCidade(Cidade);
		    juridicosg.setEstado(Estado);
		    juridicosg.setCep(Cep);
		    
		    // UTILIZA O METODO CADASTRARENDERECO DO DAO
		    juridicodao.CadastrarEndereco(juridicosg);
		    
		    request.getRequestDispatcher("CadastroJuridico.jsp").forward(request, response);
		    
		} catch (Exception ex) {
			System.out.println("Erro no CadastroJuridico: "+ ex);
		}
	}
}
