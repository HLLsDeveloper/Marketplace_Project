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
		
		HttpSession sessao = request.getSession();
		
		if(sessao.getAttribute("carrinho") != null) {
			
			@SuppressWarnings("unchecked")
			ArrayList<ProdutoSG> mostrarcarrinho = (ArrayList<ProdutoSG>) sessao.getAttribute("carrinho");
			
			Float valortotal = 0f;
			Integer contador = 0;
			
			for(ProdutoSG produtosg: mostrarcarrinho) {
				
				Float resultado = produtosg.getValor_venda() * produtosg.getQuantidade_dig();
				
				if(valortotal == 0f) {
					valortotal = resultado;
				}
				else {
					valortotal += resultado;
				}
				contador ++;
			}
			
			sessao.setAttribute("carrinho", mostrarcarrinho);
			sessao.setAttribute("contador", contador);
			request.setAttribute("valortotal", valortotal);
			
			RequestDispatcher enviar = request.getRequestDispatcher("Carrinho.jsp");
			enviar.forward(request, response);
		}
		else {
			
			RequestDispatcher enviar = request.getRequestDispatcher("Carrinho.jsp");
			enviar.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idproduto = 0;
		Integer quantidade = 0;
		
		HttpSession sessao = request.getSession();
		
		Carrinho carrinho = new Carrinho();
		
		@SuppressWarnings("unchecked")
		ArrayList<ProdutoSG> carrinhoalterado = (ArrayList<ProdutoSG>) sessao.getAttribute("carrinho");
		
		for(ProdutoSG produtosg: carrinhoalterado) {
			
			produtosg.getIdproduto();
			produtosg.getProduto();
			produtosg.getImagem();
			produtosg.getTamanho();
			produtosg.getCor();
			produtosg.getCategoria();
			produtosg.getQuantidade_dig();
			produtosg.getQuantidade();
			produtosg.getValor_venda();
			carrinho.AdicionarCarrinho(produtosg);
			
		}
		
		if(request.getParameter("amount").equals("more")) {
			
			idproduto = Integer.parseInt(request.getParameter("id"));
			carrinho.GreaterAmount(idproduto);
			
		} else if(request.getParameter("amount").equals("anyless")) {
			
			idproduto = Integer.parseInt(request.getParameter("id"));
			carrinho.SmallerAmount(idproduto);
		}
		
		carrinhoalterado = carrinho.MostrarCarrinho();
		
		sessao.setAttribute("carrinho", carrinhoalterado);
		
		doGet(request, response);	
	}
}
