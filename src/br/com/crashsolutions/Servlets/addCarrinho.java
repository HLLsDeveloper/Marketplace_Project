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
import br.com.crashsolutions.DAO.ProdutoDAO;
import br.com.crashsolutions.SG.ProdutoSG;

@WebServlet("/addCarrinho")
public class addCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HttpSession sessao;

    public addCarrinho() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			sessao = request.getSession();
			
			ProdutoDAO produtodao = new ProdutoDAO();
			String id = request.getParameter("id");
			ProdutoSG produtosg = produtodao.consultar(id);
			
			Integer idproduto = produtosg.getIdproduto();
			String produto = produtosg.getProduto();
			String imagem = produtosg.getImagem();
			String tamanho = request.getParameter("tamanho");
			String cor = request.getParameter("cor");
			String categoria = produtosg.getCategoria();
			Integer quantidade = Integer.parseInt(request.getParameter("quantidade"));
			Float valor = produtosg.getValor_venda();
			
			Carrinho carrinho = new Carrinho();
			
			//Pega o carrinho atual e se prepara para adicionar o próximo produto
			if(sessao.getAttribute("carrinho") != null) {
				
				ArrayList<ProdutoSG> carrinhoSessao = (ArrayList<ProdutoSG>) sessao.getAttribute("carrinho");
				
				for(ProdutoSG sg: carrinhoSessao) {
					
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
				
				Boolean encontrado = carrinho.ProcurarnoCarrinho(idproduto, tamanho);

				if(encontrado == true) {
					
					request.setAttribute("mensagem", "O produto já foi adicionado no carrinho");
					doGet(request, response);
				}
				
				if(encontrado == false) {
					
					//adiciona no carrinho
					produtosg.setIdproduto(idproduto);
					produtosg.setProduto(produto);
					produtosg.setImagem(imagem);
					produtosg.setTamanho(tamanho);
					produtosg.setCor(cor);
					produtosg.setCategoria(categoria);
					produtosg.setQuantidade(quantidade);
					produtosg.setValor_venda(valor);
					carrinho.AdicionarCarrinho(produtosg);
					
					carrinhoSessao = carrinho.MostrarCarrinho();
					
					sessao.setAttribute("carrinho", carrinhoSessao);
					
					request.setAttribute("mensagem", "Produto adicionado no carrinho com sucesso!");
					doGet(request, response);
				}
			}
			
			else {
				
				//adiciona no carrinho
				produtosg.setIdproduto(idproduto);
				produtosg.setProduto(produto);
				produtosg.setImagem(imagem);
				produtosg.setTamanho(tamanho);
				produtosg.setCor(cor);
				produtosg.setCategoria(categoria);
				produtosg.setQuantidade(quantidade);
				produtosg.setValor_venda(valor);
				carrinho.AdicionarCarrinho(produtosg);
				
				ArrayList<ProdutoSG> carrinhoSessao = carrinho.MostrarCarrinho();
				sessao.setAttribute("carrinho", carrinhoSessao);
				
				request.setAttribute("mensagem", "Produto adicionado no carrinho com sucesso!");
				doGet(request, response);
				
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
