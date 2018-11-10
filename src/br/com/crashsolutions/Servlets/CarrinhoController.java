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

import br.com.crashsolutions.SG.ProdutoSG;

@WebServlet("/Carrinho")
public class CarrinhoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Float valortotal = 0f;
	private Float resultado = 0f;

    public CarrinhoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		
		@SuppressWarnings("unchecked")
		ArrayList<ProdutoSG> mostrarcarrinho = (ArrayList<ProdutoSG>) sessao.getAttribute("carrinho");
		
		valortotal = 0f;
		
		for(ProdutoSG produtosg: mostrarcarrinho) {
			
			resultado = produtosg.getValor_venda() * produtosg.getQuantidade_dig();
			
			if(valortotal == 0f) {
				valortotal = resultado;
			}
			else {
				valortotal += resultado;
			}
		}
		
		sessao.setAttribute("carrinho", mostrarcarrinho);
		request.setAttribute("valortotal", valortotal);
		
		RequestDispatcher enviar = request.getRequestDispatcher("Carrinho.jsp");
		enviar.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
