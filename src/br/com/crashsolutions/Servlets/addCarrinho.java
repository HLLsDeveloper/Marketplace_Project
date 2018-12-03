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
	private ArrayList<ProdutoSG> carrinhoSessao;

    public addCarrinho() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.encodeRedirectURL("Descricao?referencia=123456");
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// VARIAVEIS DE BUSCA
		Integer fornecedor = Integer.parseInt(request.getParameter("fornecedor"));
		String id = request.getParameter("idproduto");
		
		try {
			
			sessao = request.getSession();
						
			// VARIAVEIS PARA ADICIONAR NO CARRINHO
			ProdutoSG colocarcarrinho = new ProdutoSG();
			Carrinho carrinho = new Carrinho();
			
			Float valor = 0f;
			Integer idproduto = 0, quantidade = 0, contador = 0;
			String produto = null, imagem = null, tamanho = null, cor = null, categoria = null;
			
			ProdutoDAO produtodao = new ProdutoDAO();
			colocarcarrinho = produtodao.consultar(id, fornecedor);
			
			idproduto = colocarcarrinho.getIdproduto();
			produto = colocarcarrinho.getProduto();
			imagem = colocarcarrinho.getImagem();
			tamanho = colocarcarrinho.getTamanho();
			cor = colocarcarrinho.getCor();
			categoria = colocarcarrinho.getCategoria();
			quantidade = colocarcarrinho.getQuantidade();
			valor = colocarcarrinho.getValor_venda();
			
			// PEGA CARRINHO ATUAL E SE PREPARA PARA ADICIONAR O PRÓXIMO PRODUTO
			if(sessao.getAttribute("carrinho") != null) {
				
				carrinhoSessao = (ArrayList<ProdutoSG>) sessao.getAttribute("carrinho");	
				
				for(ProdutoSG sg: carrinhoSessao) {
					
					sg.getIdproduto();
					sg.getProduto();
					sg.getImagem();
					sg.getTamanho();
					sg.getCor();
					sg.getCategoria();
					sg.getQuantidade_dig();
					sg.getQuantidade();
					sg.getValor_venda();
					sg.getIdfornecedor();
					carrinho.AdicionarCarrinho(sg);
				}
			
				Boolean encontrado = carrinho.ProcurarnoCarrinho(idproduto, tamanho);
				
				if(encontrado == false) {
					
					// ADICIONA NO CARRINHO
					colocarcarrinho.setIdproduto(idproduto);
					colocarcarrinho.setProduto(produto);
					colocarcarrinho.setImagem(imagem);
					colocarcarrinho.setTamanho(tamanho);
					colocarcarrinho.setCor(cor);
					colocarcarrinho.setCategoria(categoria);
					colocarcarrinho.setQuantidade_dig(1);
					colocarcarrinho.setQuantidade(quantidade);
					colocarcarrinho.setValor_venda(valor);
					colocarcarrinho.setIdfornecedor(fornecedor);
					carrinho.AdicionarCarrinho(colocarcarrinho);
					
					carrinhoSessao = carrinho.MostrarCarrinho();
				
					sessao.setAttribute("carrinho", carrinhoSessao);
				} 
			} 
			
			else {
				
				// ADICIONA NO CARRINHO
				colocarcarrinho.setIdproduto(idproduto);
				colocarcarrinho.setProduto(produto);
				colocarcarrinho.setImagem(imagem);
				colocarcarrinho.setTamanho(tamanho);
				colocarcarrinho.setCor(cor);
				colocarcarrinho.setCategoria(categoria);
				colocarcarrinho.setQuantidade_dig(1);
				colocarcarrinho.setQuantidade(quantidade);
				colocarcarrinho.setValor_venda(valor);
				colocarcarrinho.setIdfornecedor(fornecedor);
				carrinho.AdicionarCarrinho(colocarcarrinho);
				
				carrinhoSessao = carrinho.MostrarCarrinho();
			
				sessao.setAttribute("carrinho", carrinhoSessao);
			}
			
			for(ProdutoSG sg: carrinhoSessao) {
				contador += sg.getQuantidade_dig();
			}
			
			request.setAttribute("mensagem", "Produto adicionado ao carrinho!"); 
			sessao.setAttribute("contador", contador); 
			request.setAttribute("imagem", imagem);
			request.setAttribute("produto", produto + " ("+ tamanho + ")"); 
			
			request.getRequestDispatcher("Home").forward(request, response);
            
		} catch(Exception e) {
			System.out.println("Erro no addCarrinho: "+ e);
		}
	}
}
