package br.com.crashsolutions.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crashsolutions.DAO.CadastroFisicoDAO;
import br.com.crashsolutions.SG.CadastroFisicoSG;

@WebServlet("/CadastroFisico")
public class CadastroFisico extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public CadastroFisico() {
    	super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			// INSTANCIA O SG E O DAO
		    CadastroFisicoDAO dao = new CadastroFisicoDAO();
		    CadastroFisicoSG sg = new CadastroFisicoSG();
			
			// BUSCA OS DADOS DO FORM JSP
			String Email = request.getParameter("email");
		    String Senha = request.getParameter("senha");
		    String CPF = request.getParameter("cpf");
		    String Nome = request.getParameter("nome");
		    String Sobrenome = request.getParameter("sobrenome");
		    String Datanascimento = request.getParameter("datanascimento");
		    String Sexo = request.getParameter("sexo");
		    
		    // ENVIA OS DADOS DA PAGINA JSP PARA O SG
		    sg.setEmail(Email);
		    sg.setSenha(Senha);
		    sg.setCpf(CPF);
		    sg.setNome(Nome);
		    sg.setSobrenome(Sobrenome);
		    sg.setDatanascimento(Datanascimento);
		    sg.setSexo(Sexo);
		    
		    // UTILIZA O METODO CADASTRARUSUARIO DO DAO
		    dao.cadastrarUsuario(sg);
		    
		    Integer id = null;
		    
		    ArrayList<CadastroFisicoSG> lista = dao.buscartodos();
		    
		    for(CadastroFisicoSG fisicosg: lista) {
		    	id = fisicosg.getIdusuario();
		    }
		    
		    //PEGA OS DADOS DO JSP PARA GRAVAR NA TABELA ENDERECO
		    String Endereco = request.getParameter("endereco");
		    Integer Numero = Integer.parseInt(request.getParameter("numero"));
		    String Complemento = request.getParameter("complemento");
		    String Bairro = request.getParameter("bairro");
		    String Cidade = request.getParameter("cidade");
		    String Estado = request.getParameter("estado");
		    String Cep = request.getParameter("cep");
		    
		    sg.setIdenderecofisico(id);
		    sg.setEndereco(Endereco);
		    sg.setNumero(Numero);
		    sg.setComplemento(Complemento);
		    sg.setBairro(Bairro);
		    sg.setCidade(Cidade);
		    sg.setEstado(Estado);
		    sg.setCep(Cep);
		    
		    // UTILIZA O METODO CADASTRARENDERECO DO DAO
		    dao.cadastrarEndereco(sg);
		    
		    System.out.println("Sucesso no CadastroFisico: "+ Email);
		} catch (Exception ex) {
			System.out.println("Erro no CadastroFisico: "+ ex);
		}
	    // EXIBI A TELA JSP
	    request.getRequestDispatcher("CadastroFisico.jsp").forward(request, response);
	}
}
