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
		Integer referencia = Integer.parseInt(request.getParameter("referencia"));
		
		try {
			
			HttpSession session = request.getSession();
			session.setAttribute("url", request.getRequestURI()+"?referencia="+referencia);
			
			// BUSCA NO BANCO DE DADOS 1
			ProdutoDAO dao = new ProdutoDAO(); 
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
			
			// BUSCA NO BANCO DE DADOS 2
			FornecedorDAO dao2 = new FornecedorDAO();
			ProdutoSG sg2 = dao2.consultarReferencia(referencia);
			
			// BUSCA O TAMANHO PELA REFERENCIA E MONTA A LISTA
			ArrayList<ProdutoSG> listatamanho2 = dao2.consultarTamanho(referencia);
			request.setAttribute("listatamanho2", listatamanho2);
			
			request.setAttribute("produto2", sg2.getProduto());
			request.setAttribute("modelo2", sg2.getModelo());
			request.setAttribute("id2", sg2.getIdproduto());
			request.setAttribute("referencia2", sg2.getReferencia());
			
			// FORMATAR VALOR REAL E PARCELS	
			Float valor2 = sg2.getValor_venda();
						
			request.setAttribute("valorf2", fr.formatar(valor2));
			request.setAttribute("valorparcelado2", fr.formatar(cp.Calcular(valor2)));
			request.setAttribute("parcela2", cp.Parcela(valor2));
			
			// BUSCA NO BANCO DE DADOS 3
			Fornecedor2DAO dao3 = new Fornecedor2DAO();
			ProdutoSG sg3 = dao3.consultarReferencia(referencia);
			
			// BUSCA O TAMANHO PELA REFERENCIA E MONTA A LISTA
			ArrayList<ProdutoSG> listatamanho3 = dao3.consultarTamanho(referencia);
			request.setAttribute("listatamanho3", listatamanho3);
			
			request.setAttribute("produto3", sg3.getProduto());
			request.setAttribute("modelo3", sg3.getModelo());
			request.setAttribute("id3", sg3.getIdproduto());
			request.setAttribute("referencia3", sg3.getReferencia());
			
			// FORMATAR VALOR REAL E PARCELS	
			Float valor3 = sg3.getValor_venda();
						
			request.setAttribute("valorf3", fr.formatar(valor3));
			request.setAttribute("valorparcelado3", fr.formatar(cp.Calcular(valor3)));
			request.setAttribute("parcela3", cp.Parcela(valor3));

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
			
			Integer fornecedor = Integer.parseInt(request.getParameter("fornecedor"));
			String id = request.getParameter("idproduto");
			
			ProdutoSG colocarcarrinho = new ProdutoSG();
			Integer idproduto = null;
			String produto = null;
			String imagem = null;
			String tamanho = null;
			String cor = null;
			String categoria = null;
			Integer quantidade = null;
			Float valor = null;
			
			if(fornecedor == 1) {
				
				ProdutoDAO produtodao = new ProdutoDAO();
				colocarcarrinho = produtodao.consultar(id);
				
				idproduto = colocarcarrinho.getIdproduto();
				produto = colocarcarrinho.getProduto();
				imagem = colocarcarrinho.getImagem();
				tamanho = colocarcarrinho.getTamanho();
				cor = colocarcarrinho.getCor();
				categoria = colocarcarrinho.getCategoria();
				quantidade = colocarcarrinho.getQuantidade();
				valor = colocarcarrinho.getValor_venda();
			} else { 
				
				if(fornecedor == 2) {
				
				FornecedorDAO produtodao = new FornecedorDAO();
				colocarcarrinho = produtodao.consultar(id);
				
				idproduto = colocarcarrinho.getIdproduto();
				produto = colocarcarrinho.getProduto();
				imagem = colocarcarrinho.getImagem();
				tamanho = colocarcarrinho.getTamanho();
				cor = colocarcarrinho.getCor();
				categoria = colocarcarrinho.getCategoria();
				quantidade = colocarcarrinho.getQuantidade();
				valor = colocarcarrinho.getValor_venda();				
				} else {
				
				Fornecedor2DAO produtodao = new Fornecedor2DAO();
				colocarcarrinho = produtodao.consultar(id);
				
				idproduto = colocarcarrinho.getIdproduto();
				produto = colocarcarrinho.getProduto();
				imagem = colocarcarrinho.getImagem();
				tamanho = colocarcarrinho.getTamanho();
				cor = colocarcarrinho.getCor();
				categoria = colocarcarrinho.getCategoria();
				quantidade = colocarcarrinho.getQuantidade();
				valor = colocarcarrinho.getValor_venda();	
				}	
			}
			
			Carrinho carrinho = new Carrinho();
			
			// PEGA  CARRINHO ATUAL E SE PREPARA PARA ADICIONAR O PRÓXIMO PRODUTO
			if(sessao.getAttribute("carrinho") != null) {
				
				@SuppressWarnings("unchecked")
				ArrayList<ProdutoSG> carrinhosessao = (ArrayList<ProdutoSG>) sessao.getAttribute("carrinho");	
				
				for(ProdutoSG sg: carrinhosessao) {
					
					sg.setQuantidade(1);
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
