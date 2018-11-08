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

import br.com.crashsolutions.Acoes.CalculoParcelas;
import br.com.crashsolutions.Acoes.Carrinho;
import br.com.crashsolutions.Acoes.FormatarReal;
import br.com.crashsolutions.DAO.ProdutoDAO;
import br.com.crashsolutions.SG.ProdutoSG;


@WebServlet("/Descricao")
public class DescricaoProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession sessao;
	
    public DescricaoProduto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// VARIAVEIS ID E REFERENCIA
		Integer referencia = Integer.parseInt(request.getParameter("referencia"));
		
		try {
			
			HttpSession session = request.getSession();
			session.setAttribute("url", request.getRequestURI()+"?referencia="+referencia);
			
			ProdutoDAO dao = new ProdutoDAO(); 
			
			// BUSCA NO BANCO DE DADOS 1
			ProdutoSG sg = dao.consultarReferencia(referencia);
			
			// BUSCA O TAMANHO PELA REFERENCIA E MONTA A LISTA
			ArrayList<ProdutoSG> listatamanho = dao.consultarTamanho(referencia);
			request.setAttribute("listatamanho", listatamanho);
			
			request.setAttribute("produto", sg.getProduto());
			request.setAttribute("imagem", sg.getImagem());
			request.setAttribute("descricao", sg.getDescricao());
			request.setAttribute("modelo", sg.getModelo());
			request.setAttribute("cor", sg.getCor());
			request.setAttribute("genero", sg.getGenero());
			request.setAttribute("categoria", sg.getCategoria());
			request.setAttribute("id", sg.getIdproduto());
			request.setAttribute("referencia", sg.getReferencia());

			// FORMATAR VALOR REAL E PARCELS
			FormatarReal fr = new FormatarReal();
			CalculoParcelas cp = new CalculoParcelas();
			
			Float valor = sg.getValor_venda();
			
			request.setAttribute("valorf1", fr.formatar(valor));
			request.setAttribute("valorparcelado1", fr.formatar(cp.Calcular(valor)));
			request.setAttribute("parcela1", cp.Parcela(valor));
			
			// BUSCA A AÇÃO NO DAO QUE BUSCA OS DADOS DO PRODUTO DO CARD
			ArrayList<ProdutoSG> lista = dao.buscaTodos();
			request.setAttribute("lista_produto", lista);
			
			RequestDispatcher enviar = request.getRequestDispatcher("DescricaoProduto.jsp");
			enviar.forward(request, response);
			
		} catch(Exception e) {
			System.out.println("Erro na busca da DescriçãoProduto: "+ e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			sessao = request.getSession();
			
			ProdutoDAO produtodao = new ProdutoDAO();
			String id = request.getParameter("idtamanho");
			ProdutoSG colocarcarrinho = produtodao.consultar(id);
			
			Integer idproduto = colocarcarrinho.getIdproduto();
			String produto = colocarcarrinho.getProduto();
			String imagem = colocarcarrinho.getImagem();
			String tamanho = colocarcarrinho.getTamanho();
			String cor = colocarcarrinho.getCor();
			String categoria = colocarcarrinho.getCategoria();
			Integer quantidade = colocarcarrinho.getQuantidade();
			Float valor = colocarcarrinho.getValor_venda();
			
			Carrinho carrinho = new Carrinho();
			
			// PEGA  CARRINHO ATUAL E SE PREPARA PARA ADICIONAR O PRÓXIMO PRODUTO
			if(sessao.getAttribute("carrinho") != null) {
				
				@SuppressWarnings("unchecked")
				ArrayList<ProdutoSG> carrinhosessao = (ArrayList<ProdutoSG>) sessao.getAttribute("carrinho");	
				
				for(ProdutoSG sg: carrinhosessao) {
					
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
				
				if(encontrado == false) {
					// ADICIONA NO CARRINHO
					colocarcarrinho.setIdproduto(idproduto);
					colocarcarrinho.setProduto(produto);
					colocarcarrinho.setImagem(imagem);
					colocarcarrinho.setTamanho(tamanho);
					colocarcarrinho.setCor(cor);
					colocarcarrinho.setCategoria(categoria);
					colocarcarrinho.setQuantidade(quantidade);
					colocarcarrinho.setValor_venda(valor);
					carrinho.AdicionarCarrinho(colocarcarrinho);
					
					ArrayList<ProdutoSG> carrinhoSessao = carrinho.MostrarCarrinho();
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
				colocarcarrinho.setQuantidade(quantidade);
				colocarcarrinho.setValor_venda(valor);
				carrinho.AdicionarCarrinho(colocarcarrinho);
				
				ArrayList<ProdutoSG> carrinhoSessao = carrinho.MostrarCarrinho();
				sessao.setAttribute("carrinho", carrinhoSessao);
				
			}

			response.sendRedirect("http://localhost:8080/TShirtGames/Carrinho");
			
		} catch(Exception e) {
			System.out.println("Erro na DescriçãoProduto ação de comprar:"+ e);
		}
	}
}
