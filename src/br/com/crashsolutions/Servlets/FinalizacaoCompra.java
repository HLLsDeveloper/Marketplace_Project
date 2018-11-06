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
import br.com.crashsolutions.SG.CadastroFisicoSG;

@WebServlet("/Finalizacao")
public class FinalizacaoCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FinalizacaoCompra() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			HttpSession session = request.getSession();
			request.setAttribute("carrinho", session.getAttribute("carrinho"));;
			
			CadastroFisicoDAO fisicodao = new CadastroFisicoDAO();
			CadastroFisicoSG fisicosg = fisicodao.ConsultarUsuario((String) session.getAttribute("email"));
			request.setAttribute("nome", fisicosg.getNome());
			request.setAttribute("email", fisicosg.getEmail());
			request.setAttribute("celular", fisicosg.getCelular());
			request.setAttribute("telefone", fisicosg.getTelefone());
			request.setAttribute("tipocadastro", null);
			request.setAttribute("cpf", fisicosg.getCpf());
			
			Integer validaendereco = Integer.parseInt(request.getParameter("check_endereco"));
			
			ArrayList<CadastroFisicoSG> endereco = fisicodao.listarEnderecos((String) session.getAttribute("email"));
			for(CadastroFisicoSG sg: endereco) {
				if(sg.getIdendereco() == validaendereco) {
					
					request.setAttribute("cep", sg.getCep());
					request.setAttribute("valorfrete", null);
					request.setAttribute("complemento", sg.getComplemento());
					request.setAttribute("destinatario",null);
					request.setAttribute("endereco", sg.getEndereco());
					request.setAttribute("numero", sg.getNumero());
					request.setAttribute("bairro", sg.getBairro());
					request.setAttribute("cidade", sg.getCidade());
					request.setAttribute("estado", sg.getEstado());
					
				}
			}
			
			RequestDispatcher enviar = request.getRequestDispatcher("FinalizacaoCompra.jsp");
			enviar.forward(request, response);
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
