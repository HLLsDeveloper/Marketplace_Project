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
import br.com.crashsolutions.SG.CadastroJuridicoSG;
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
			CadastroJuridicoSG juridico = new CadastroJuridicoSG();
			ProdutoDAO dao = new ProdutoDAO();
			
			sessao = request.getSession();
			
			if(sessao.getAttribute("idusuariouser") != null) {
				
				Integer idusuario = (Integer) sessao.getAttribute("idusuariouser");
				
				fisico.setIdusuario(idusuario);
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
					sg.getQuantidade_dig();
					dao.PedidoFisico(sg, fisico);
					
					String subtrair = String.valueOf(sg.getIdproduto());
					
					ProdutoSG produto = dao.consultar(subtrair,1);
					
					produto.setQuantidade(produto.getQuantidade() - sg.getQuantidade_dig());
					dao.alterar(produto,1);
				}
			}
			
			if(sessao.getAttribute("idempresauser") != null) {
				
				Integer idempresa = (Integer) sessao.getAttribute("idempresauser");
				
				juridico.setIdempresa(idempresa);
				juridico.setDestinatario(request.getParameter("destinatario"));
				
				@SuppressWarnings("unchecked")
				ArrayList<ProdutoSG> gravarpedido = (ArrayList<ProdutoSG>) sessao.getAttribute("carrinho");
				
				for(ProdutoSG sg: gravarpedido) {
					
					sg.setNumeropedido(new BigDecimal(10000));
					sg.getNumeropedido();
					juridico.getIdempresa();
					juridico.getDestinatario();
					sg.getIdproduto();
					sg.getTamanho();
					sg.getCor();
					sg.getQuantidade_dig();
					dao.PedidoJuridico(sg, juridico);
										
					String subtrair = String.valueOf(sg.getIdproduto());
					
					// DAR BAIXA NO BANCO
					ProdutoSG produto = dao.consultar(subtrair,sg.getIdfornecedor());
					produto.setQuantidade(produto.getQuantidade() - sg.getQuantidade_dig());
					dao.baixaQuantidade(produto,sg.getIdfornecedor());
				}
			}
			
			sessao.removeAttribute("carrinho");
			sessao.removeAttribute("contador");
			
			RequestDispatcher enviar = request.getRequestDispatcher("NumeroPedido.jsp");
			enviar.forward(request, response);
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
