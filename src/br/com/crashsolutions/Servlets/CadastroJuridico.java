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
		
		if(request.getAttribute("mensagemcadastro") == "Empresa cadastrada com sucesso!") {
			
			request.setAttribute("mensagem", request.getAttribute("mensagemcadastro"));
			RequestDispatcher enviar = request.getRequestDispatcher("/Login");
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
			
			String emailuser = request.getParameter("email");
		    String senhauser = request.getParameter("senha");
		    String cnpjuser = request.getParameter("cnpj");
		    String logouser = request.getParameter("logo");
		    String razaouser = request.getParameter("razao");
		    String nomefantasiauser = request.getParameter("nomefantasia");
		    String ieuser = request.getParameter("ie");
		    String telefoneuser = request.getParameter("telefone");
		    String celularuser = request.getParameter("celular");
		    
		    juridicosg.setEmail(emailuser);
		    juridicosg.setSenha(senhauser);
		    juridicosg.setCnpj(cnpjuser);
		    juridicosg.setLogo(logouser);
		    juridicosg.setRazao(razaouser);
		    juridicosg.setNomefantasia(nomefantasiauser);
		    juridicosg.setTelefone(telefoneuser);
		    juridicosg.setCelular(celularuser);
		    juridicosg.setIe(ieuser);
		    
		    juridicodao.CadastrarEmpresa(juridicosg);
		    
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
