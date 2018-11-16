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
	private Float valortotal = 0f;
	private Float resultado = 0f;
	private Integer quantidade = 0;
	private Integer contador = 0;
    public CarrinhoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		
		@SuppressWarnings("unchecked")
		ArrayList<ProdutoSG> mostrarcarrinho = (ArrayList<ProdutoSG>) sessao.getAttribute("carrinho");
		
		valortotal = 0f;
		quantidade = 1;
		contador = 0;
		
		for(ProdutoSG produtosg: mostrarcarrinho) {
			
			resultado = produtosg.getValor_venda() * quantidade;
			
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			HttpSession sessao = request.getSession();
			
			Carrinho carrinho = new Carrinho();
			
			@SuppressWarnings("unchecked")
			ArrayList<ProdutoSG> mostrarcarrinho = (ArrayList<ProdutoSG>) sessao.getAttribute("carrinho");
			
			for(ProdutoSG sg: mostrarcarrinho) {
				
				sg.getIdproduto();
				sg.getProduto();
				sg.getImagem();
				sg.getTamanho();
				sg.getCor();
				sg.getCategoria();
				sg.getQuantidade_dig();
				sg.getQuantidade();
				sg.getValor_venda();
				carrinho.AdicionarCarrinho(sg);
			}
			
			request.setAttribute("carrinho", mostrarcarrinho);
			
			doGet(request, response);
			
		} catch(Exception e) {
			System.out.println("Erro nessa caralha: " + e);
		}	
	}
}
