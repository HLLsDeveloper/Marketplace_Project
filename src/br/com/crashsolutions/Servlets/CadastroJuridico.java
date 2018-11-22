package br.com.crashsolutions.Servlets;

import br.com.crashsolutions.DAO.CadastroJuridicoDAO;
import br.com.crashsolutions.SG.CadastroJuridicoSG;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
		
if(request.getAttribute("mensagemcadastro") != null) {
			
			request.setAttribute("mensagem", request.getAttribute("mensagemcadastro"));
			RequestDispatcher enviar = request.getRequestDispatcher("Login.jsp");
			enviar.forward(request, response);
		}
		else {
			
			RequestDispatcher enviar = request.getRequestDispatcher("CadastroJuridico.jsp");
			enviar.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		try {
			
			CadastroJuridicoSG juridicosg = new CadastroJuridicoSG();
		    CadastroJuridicoDAO juridicodao = new CadastroJuridicoDAO();
			
			String email = request.getParameter("email");
		    String senha = request.getParameter("senha");
		    String cnpj = request.getParameter("cnpj");
		    String razao = request.getParameter("razao");
		    String nomefantasia = request.getParameter("nomefantasia");
		    String ie = request.getParameter("ie");
		    String telefone = request.getParameter("telefone");
		    String celular = request.getParameter("celular");
		    
		    juridicosg.setEmail(email);
		    juridicosg.setSenha(senha);
		    juridicosg.setCnpj(cnpj);
		    juridicosg.setRazao(razao);
		    juridicosg.setNomefantasia(nomefantasia);
		    juridicosg.setTelefone(telefone);
		    juridicosg.setCelular(celular);
		    juridicosg.setIe(ie);
		    
		    juridicodao.CadastrarUsuario(juridicosg);
		    
		    juridicosg = juridicodao.buscarultimo();
		    
		    //PEGA OS DADOS DO JSP PARA GRAVAR NA TABELA ENDERECO
		    String endereco = request.getParameter("endereco");
		    Integer numero = Integer.parseInt(request.getParameter("numero"));
		    String complemento = request.getParameter("complemento");
		    String bairro = request.getParameter("bairro");
		    String cidade = request.getParameter("cidade");
		    String estado = request.getParameter("estado");
		    String cep = request.getParameter("cep");
		    
		    juridicosg.setIdenderecojuridico(juridicosg.getIdempresa());
		    juridicosg.setEndereco(endereco);
		    juridicosg.setNumero(numero);
		    juridicosg.setComplemento(complemento);
		    juridicosg.setBairro(bairro);
		    juridicosg.setCidade(cidade);
		    juridicosg.setEstado(estado);
		    juridicosg.setCep(cep);
		    
		    // UTILIZA O METODO CADASTRARENDERECO DO DAO
		    juridicodao.CadastrarEndereco(juridicosg);
		    
		    request.setAttribute("mensagemcadastro", "Empresa cadastrada com sucesso!");
		    
		} catch (Exception ex) {
			request.setAttribute("mensagemcadastro", "Ocorreu um erro no cadastro, verifique os campos!");
			System.out.println("Erro no CadastroJuridico: " + ex);
		}
		doGet(request, response);
	}
}
