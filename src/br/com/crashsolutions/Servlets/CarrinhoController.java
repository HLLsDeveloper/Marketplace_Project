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

import br.com.crashsolutions.Acoes.Carrinho;
import br.com.crashsolutions.SG.ProdutoSG;

@WebServlet("/Carrinho")
public class CarrinhoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CarrinhoController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			HttpSession sessao = request.getSession();
			
			@SuppressWarnings("unchecked")
			ArrayList<ProdutoSG> mostrarcarrinho = (ArrayList<ProdutoSG>) sessao.getAttribute("carrinho");
			
			request.setAttribute("carrinho", mostrarcarrinho);
			
			RequestDispatcher enviar = request.getRequestDispatcher("Carrinho.jsp");
			enviar.forward(request, response);
			
		} catch(Exception e) {
			System.out.println("Erro nessa caralha: " + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			HttpSession sessao = request.getSession();
			
			Carrinho carrinho = new Carrinho();
			
			Integer idproduto = Integer.parseInt(request.getParameter("excluir"));
			
			@SuppressWarnings("unchecked")
			ArrayList<ProdutoSG> produto = (ArrayList<ProdutoSG>) sessao.getAttribute("carrinho");
			
			for(ProdutoSG sg: produto) {
				
				sg.getIdproduto();
				sg.getProduto();
				sg.getImagem();
				sg.getTamanho();
				sg.getCor();
				sg.getCategoria();
				sg.getQuantidade();
				sg.getValor_venda();
				carrinho.AdicionarCarrinho(sg);
			}
			
			carrinho.DeletarCarrinho(idproduto);
			
			produto = carrinho.MostrarCarrinho();
			sessao.setAttribute("carrinho", produto);
			
			response.sendRedirect("http://localhost:8080/TShirtGames/Carrinho");
			
		} catch(Exception e) {
			System.out.println("Erro ao Excluir do carrinho: " + e);
		}
			
	}
}