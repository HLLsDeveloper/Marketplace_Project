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
	private Integer referencia;
	
    public DescricaoProduto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Passei pelo metodo get amigo, estava enganado seu porra!");
		
		if(request.getParameter("referencia").equals("0") || request.getParameter("referencia").equals(null)) {
			// VARIAVEIS ID E REFERENCIA
			referencia = (Integer) request.getAttribute("referencia");
		} else {
			// VARIAVEIS ID E REFERENCIA
			referencia = Integer.parseInt(request.getParameter("referencia"));
		}
		
		try {
			
			HttpSession session = request.getSession();
			session.setAttribute("url", request.getRequestURI()+"?referencia="+referencia);
			
			// INSTANCIA PARA ACESSAR OS TRÊS BANCOS PELA REFERENCIA
			ProdutoDAO dao1 = new ProdutoDAO(); 
			FornecedorDAO dao2 = new FornecedorDAO();
			Fornecedor2DAO dao3 = new Fornecedor2DAO();
			
			ProdutoSG sg1 = new ProdutoSG();
			ProdutoSG sg2 = new ProdutoSG();
			ProdutoSG sg3 = new ProdutoSG();
			
			// VERIFICAÇÃO QUAL O MENOR VALOR
			Integer f1, f2, f3;
			
			ProdutoSG v1 = dao1.consultarReferencia(referencia);
			ProdutoSG v2  = dao2.consultarReferencia(referencia);
			ProdutoSG v3  = dao3.consultarReferencia(referencia); 
			
			if (v1.getValor_venda() < v2.getValor_venda()) {
				sg1 = dao1.consultarReferencia(referencia); f1 = 1;
				
				if(v2.getValor_venda() < v3.getValor_venda()) {
					sg2 = dao2.consultarReferencia(referencia); f2 = 2;
					sg3 = dao3.consultarReferencia(referencia); f3 = 3;
					
				} else {
					sg2 = dao3.consultarReferencia(referencia); f2 = 3;
					sg3 = dao2.consultarReferencia(referencia); f3 = 2;
				}
			} else {
				if(v2.getValor_venda() < v3.getValor_venda()) {
					sg1 = dao2.consultarReferencia(referencia); f1 = 2;
					
					if(v1.getValor_venda() < v3.getValor_venda()) {
						sg2 = dao3.consultarReferencia(referencia); f2 = 3;
						sg3 = dao2.consultarReferencia(referencia); f3 = 2;
					} else {
						sg2 = dao2.consultarReferencia(referencia); f2 = 2;
						sg3 = dao3.consultarReferencia(referencia); f3 = 3;
					}
				} else {
						sg1 = dao3.consultarReferencia(referencia); f1 = 3;
						
						if(v1.getValor_venda() < v2.getValor_venda()) {
							sg2 = dao1.consultarReferencia(referencia); f2 = 1;
							sg3 = dao2.consultarReferencia(referencia); f3 = 2;
							
						} else {
							sg2 = dao2.consultarReferencia(referencia); f2 = 2;
							sg3 = dao1.consultarReferencia(referencia); f3 = 1;
						}
				}
			}
			
			// BUSCA NO BANCO DE DADOS 1
			ArrayList<ProdutoSG> listatamanho = dao1.consultarTamanho(referencia);
			request.setAttribute("listatamanho", listatamanho);
			
			request.setAttribute("produto", sg1.getProduto());
			request.setAttribute("imagem", sg1.getImagem());
			request.setAttribute("descricao", sg1.getDescricao());
			request.setAttribute("modelo", sg1.getModelo());
			request.setAttribute("cor", sg1.getCor());
			request.setAttribute("genero", sg1.getGenero());
			request.setAttribute("categoria", sg1.getCategoria());
			request.setAttribute("id", sg1.getIdproduto());
			request.setAttribute("referencia", sg1.getReferencia());
			request.setAttribute("fornecedor1", dao1.consultarFornecedor(f1).getRazao());
			request.setAttribute("idfornecedor1", dao1.consultarFornecedor(f1).getIdfornecedor());
			
			// FORMATAR VALOR REAL E PARCELS
			FormatarReal fr = new FormatarReal();
			CalculoParcelas cp = new CalculoParcelas();
			
			Float valor = sg1.getValor_venda();
			
			request.setAttribute("quantidade1", dao1.Quantidade);
			request.setAttribute("valorf1", fr.formatar(valor));
			request.setAttribute("valorparcelado1", fr.formatar(cp.Calcular(valor)));
			request.setAttribute("parcela1", cp.Parcela(valor));
			
			// BUSCA NO BANCO DE DADOS 2
			ArrayList<ProdutoSG> listatamanho2 = dao2.consultarTamanho(referencia);
			request.setAttribute("listatamanho2", listatamanho2);
			
			// CASO NÃO EXISTA O PRODUTO NÃO EXIBE O FORNECEDOR2
			if (dao2.consultar(String.valueOf((referencia))).getProduto() != null) {
				request.setAttribute("fornecedor2", dao1.consultarFornecedor(f2).getRazao());
				request.setAttribute("idfornecedor2", dao1.consultarFornecedor(f2).getIdfornecedor());
			}
				
			request.setAttribute("produto2", sg2.getProduto());
			request.setAttribute("modelo2", sg2.getModelo());
			request.setAttribute("id2", sg2.getIdproduto());
			request.setAttribute("referencia2", sg2.getReferencia());
			
			// FORMATAR VALOR REAL E PARCELS	
			Float valor2 = sg2.getValor_venda();
			
			request.setAttribute("quantidade2", dao2.Quantidade);
			request.setAttribute("valorf2", fr.formatar(valor2));
			request.setAttribute("valorparcelado2", fr.formatar(cp.Calcular(valor2)));
			request.setAttribute("parcela2", cp.Parcela(valor2));
			
			// BUSCA NO BANCO DE DADOS 3
			ArrayList<ProdutoSG> listatamanho3 = dao3.consultarTamanho(referencia);
			request.setAttribute("listatamanho3", listatamanho3);
				
			// CASO NÃO EXISTA O PRODUTO NÃO EXIBE O FORNECEDOR3
			if(dao3.consultar(String.valueOf((referencia))).getProduto() != null) {
				request.setAttribute("fornecedor3", dao1.consultarFornecedor(f3).getRazao());
				request.setAttribute("idfornecedor3", dao1.consultarFornecedor(f3).getIdfornecedor());
			}
			
			request.setAttribute("produto3", sg3.getProduto());
			request.setAttribute("modelo3", sg3.getModelo());
			request.setAttribute("id3", sg3.getIdproduto());
			request.setAttribute("referencia3", sg3.getReferencia());
			
			// FORMATAR VALOR REAL E PARCELS	
			Float valor3 = sg3.getValor_venda();
			
			request.setAttribute("quantidade3", dao3.Quantidade);
			request.setAttribute("valorf3", fr.formatar(valor3));
			request.setAttribute("valorparcelado3", fr.formatar(cp.Calcular(valor3)));
			request.setAttribute("parcela3", cp.Parcela(valor3));

			// BUSCA A AÇÃO NO DAO QUE BUSCA OS DADOS DO PRODUTO DO CARD
			ArrayList<ProdutoSG> lista = dao1.buscaTodasReferencias();
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
						
			// VARIAVEIS PARA ADICIONAR NO CARRINHO
			ProdutoSG colocarcarrinho = new ProdutoSG();
			Float valor = 0f;
			Integer idproduto = 0, quantidade = 0;
			String produto = null, imagem = null, tamanho = null, cor = null, categoria = null; 
			
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
			
			// PEGA CARRINHO ATUAL E SE PREPARA PARA ADICIONAR O PRÓXIMO PRODUTO
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
					sg.getQuantidade_dig();
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
					colocarcarrinho.setQuantidade_dig(1);
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
				colocarcarrinho.setQuantidade_dig(1);
				colocarcarrinho.setQuantidade(quantidade);
				colocarcarrinho.setValor_venda(valor);
				carrinho.AdicionarCarrinho(colocarcarrinho);
				
				ArrayList<ProdutoSG> carrinhoSessao = carrinho.MostrarCarrinho();
				
				sessao.setAttribute("carrinho", carrinhoSessao);
			}
						
			response.sendRedirect("Carrinho");
			
		} catch(Exception e) {
			System.out.println("Erro na DescriçãoProduto ação de comprar: "+ e);
		}
	}
}
