package br.com.crashsolutions.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crashsolutions.DAO.CadastroFisicoDAO;
import br.com.crashsolutions.SG.CadastroFisicoSG;

@WebServlet("/CadastroFisico")
@MultipartConfig
public class CadastroFisico extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public CadastroFisico() {
    	super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getAttribute("mensagemcadastro") != null) {
			
			request.setAttribute("mensagem", request.getAttribute("mensagemcadastro"));
			RequestDispatcher enviar = request.getRequestDispatcher("Login.jsp");
			enviar.forward(request, response);
		}
		else {
			
			RequestDispatcher enviar = request.getRequestDispatcher("CadastroFisico.jsp");
			enviar.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			// INSTANCIA O SG E O DAO
		    CadastroFisicoDAO dao = new CadastroFisicoDAO();
		    CadastroFisicoSG sg = new CadastroFisicoSG();
			
			// BUSCA OS DADOS DO FORM JSP
			String Email = request.getParameter("email");
			String Senha = request.getParameter("senha");
		    String CPF = request.getParameter("cpf");
		    String imagem = request.getParameter("image");
		    String Nome = request.getParameter("nome");
		    String Sobrenome = request.getParameter("sobrenome");
		    String Datanascimento = request.getParameter("datanascimento");
		    String Sexo = request.getParameter("sexo");
		    String telefone = (request.getParameter("telefone"));
		    String celular = (request.getParameter("celular"));
		    
		    // ENVIA OS DADOS DA PAGINA JSP PARA O SG
		    sg.setEmail(Email);
		    sg.setSenha(Senha);
		    sg.setCpf(CPF);
		    sg.setImagem(imagem);
		    sg.setNome(Nome);
		    sg.setSobrenome(Sobrenome);
		    sg.setDatanascimento(Datanascimento);
		    sg.setSexo(Sexo);
		    sg.setTelefone(telefone);
		    sg.setCelular(celular);
		    
		    // UTILIZA O METODO CADASTRARUSUARIO DO DAO
		    dao.cadastrarUsuario(sg);
		    
		    sg = dao.buscarultimo();
		    
		    //PEGA OS DADOS DO JSP PARA GRAVAR NA TABELA ENDERECO
		    String Endereco = request.getParameter("endereco");
		    Integer Numero = Integer.parseInt(request.getParameter("numero"));
		    String Complemento = request.getParameter("complemento");
		    String Bairro = request.getParameter("bairro");
		    String Cidade = request.getParameter("cidade");
		    String Estado = request.getParameter("estado");
		    String Cep = request.getParameter("cep");
		    
		    sg.setIdenderecofisico(sg.getIdusuario());
		    sg.setEndereco(Endereco);
		    sg.setNumero(Numero);
		    sg.setComplemento(Complemento);
		    sg.setBairro(Bairro);
		    sg.setCidade(Cidade);
		    sg.setEstado(Estado);
		    sg.setCep(Cep);
		    
		    // UTILIZA O METODO CADASTRARENDERECO DO DAO
		    dao.cadastrarEndereco(sg);
		    
		    request.setAttribute("mensagemcadastro", "Usuário cadastrado com sucesso!");
		    
		} catch (Exception ex) {
			request.setAttribute("mensagemcadastro", "Ocorreu um erro no cadastro, verifique os campos!");
			System.out.println("Erro no CadastroFisico: "+ ex);
		}
	    doGet(request, response);
	}
}
