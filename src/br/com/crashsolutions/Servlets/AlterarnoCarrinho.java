package br.com.crashsolutions.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.crashsolutions.Acoes.Carrinho;
import br.com.crashsolutions.SG.ProdutoSG;

@WebServlet("/AlterarCarrinho")
public class AlterarnoCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AlterarnoCarrinho() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
				sg.getQuantidade();
				sg.getValor_venda();
				carrinho.AdicionarCarrinho(sg);
			}
			
			sessao.setAttribute("carrinho", mostrarcarrinho);
			
			response.sendRedirect("Carrinho");
			
		} catch(Exception e) {
			System.out.println("Erro nessa caralha: " + e);
		}	
	}
}