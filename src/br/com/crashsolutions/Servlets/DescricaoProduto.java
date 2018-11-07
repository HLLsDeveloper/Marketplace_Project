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
import br.com.crashsolutions.DAO.Fornecedor2DAO;
import br.com.crashsolutions.DAO.FornecedorDAO;
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
		String id = request.getParameter("id");
		Integer referencia = Integer.parseInt(request.getParameter("referencia"));
		
		try {
			
			HttpSession session = request.getSession();
			session.setAttribute("url", request.getRequestURI()+"?id="+id+"&referencia="+referencia);
			
			ProdutoDAO pdao = new ProdutoDAO();
			FornecedorDAO fdao = new FornecedorDAO();
			Fornecedor2DAO f2dao = new Fornecedor2DAO();
			ProdutoSG unico = pdao.consultar(id);
			
			// BUSCA O TAMANHO PELA REFERENCIA E MONTA A LISTA
			ArrayList<ProdutoSG> listatamanho = pdao.consultarTamanho(referencia);
			request.setAttribute("listatamanho", listatamanho);
			
			request.setAttribute("produto", unico.getProduto());
			request.setAttribute("imagem", unico.getImagem());
			request.setAttribute("descricao", unico.getDescricao());
			request.setAttribute("modelo", unico.getModelo());
			request.setAttribute("cor", unico.getCor());
			request.setAttribute("genero", unico.getGenero());
			request.setAttribute("categoria", unico.getCategoria());
			request.setAttribute("id", unico.getIdproduto());
			request.setAttribute("referencia", unico.getReferencia());
						
			// VARIAVEIS DOS VALORES E LOGÍCA DE ORDENAÇÃO
			Float valor1 = null, valor2 = null, valor3 = null, x = null;
			
			valor1 = unico.getValor_venda();
			
			unico = fdao.consultar(id);
			valor2 = unico.getValor_venda();
			
			unico = f2dao.consultar(id);
			valor3 = unico.getValor_venda();
			
			if(valor1 > valor2) {
				
				x = valor1;
				valor1 = valor2;
				valor2 = x;
				x = null;
			}
			
			if(valor1 > valor3) {
				
				x = valor1;
				valor1 = valor3;
				valor3 = x;
				x = null;
			}
			
			if(valor2 < valor1) {
				
				x = valor2;
				valor2 = valor1;
				valor1 = x;
				x = null;
			}
			
			if(valor2 > valor3) {
				
				x = valor2;
				valor2 = valor3;
				valor3 = x;
				x = null;
			}
			
			// FORMATAR VALOR REAL
			FormatarReal fr = new FormatarReal();
			
			request.setAttribute("valorf1", fr.formatar(valor1));
			request.setAttribute("valorf2", fr.formatar(valor2));
			request.setAttribute("valorf3", fr.formatar(valor3));
			
			// VALORES PARCELADOS E PARCELAS
			CalculoParcelas cp = new CalculoParcelas();
			
			request.setAttribute("valorparcelado1", fr.formatar(cp.Calcular(valor1)));
			request.setAttribute("valorparcelado2", fr.formatar(cp.Calcular(valor2)));
			request.setAttribute("valorparcelado3", fr.formatar(cp.Calcular(valor3)));
			
			request.setAttribute("parcela1", cp.Parcela(valor1));
			request.setAttribute("parcela2", cp.Parcela(valor2));
			request.setAttribute("parcela3", cp.Parcela(valor3));
			
			// BUSCA A AÇÃO NO DAO QUE BUSCA OS DADOS DO PRODUTO DO CARD
			ArrayList<ProdutoSG> lista = pdao.buscaTodos();
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
