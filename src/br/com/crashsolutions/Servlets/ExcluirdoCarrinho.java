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

@WebServlet("/ExcluirCarrinho")
public class ExcluirdoCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Float valortotal = null;
	private Float resultado = null;

    public ExcluirdoCarrinho() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			HttpSession sessao = request.getSession();
			
			Carrinho carrinho = new Carrinho();
			
			Integer idproduto = Integer.parseInt(request.getParameter("excluir"));
			
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
				sg.getQuantidade_dig();
				sg.getValor_venda();
				carrinho.AdicionarCarrinho(sg);
			}
			
			carrinho.DeletarCarrinho(idproduto);
			
			mostrarcarrinho = carrinho.MostrarCarrinho();
			
			valortotal = 0f;
			
			for(ProdutoSG produtosg: mostrarcarrinho) {
				
				resultado = produtosg.getValor_venda() * produtosg.getQuantidade_dig();
				
				if(valortotal == null) {
					valortotal = resultado;
				}
				else {
					valortotal += resultado;
				}
			}
			
			sessao.setAttribute("carrinho", mostrarcarrinho);
			
			response.sendRedirect("Carrinho");
			
		} catch(Exception e) {
			System.out.println("Erro ao Excluir do carrinho: " + e);
		}
	}
}
