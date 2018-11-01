package br.com.crashsolutions.Servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.crashsolutions.DAO.ProdutoDAO;
import br.com.crashsolutions.SG.CadastroFisicoSG;
import br.com.crashsolutions.SG.ProdutoSG;

@WebServlet("/Pedido")
public class Pedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession sessao;
	
    public Pedido() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			CadastroFisicoSG fisico = new CadastroFisicoSG();
			ProdutoDAO dao = new ProdutoDAO();
			
			sessao = request.getSession();
			Integer id = (Integer) sessao.getAttribute("idusuario");
			fisico.setIdusuario(id);
			fisico.setDestinatario(request.getParameter("destinatario"));
			
			@SuppressWarnings("unchecked")
			ArrayList<ProdutoSG> gravarpedido = (ArrayList<ProdutoSG>) sessao.getAttribute("carrinho");
			
			for(ProdutoSG sg: gravarpedido) {
				
				sg.setNumeropedido(new BigDecimal(10000));
				sg.getNumeropedido();
				fisico.getIdusuario();
				fisico.getDestinatario();
				sg.getIdproduto();
				sg.getTamanho();
				sg.getCor();
				sg.getQuantidade();
				dao.comprarFisico(sg, fisico);
				
			}
			
			sessao.removeAttribute("carrinho");
			
			RequestDispatcher enviar = request.getRequestDispatcher("NumeroPedido.jsp");
			enviar.forward(request, response);
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
