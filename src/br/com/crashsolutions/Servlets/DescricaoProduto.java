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
			
			// FORMATAR VALOR REAL E PARCELS
			FormatarReal fr = new FormatarReal();
			CalculoParcelas cp = new CalculoParcelas();
			
			// INSTANCIA PARA ACESSAR OS TRÊS BANCOS PELA REFERENCIA
			ProdutoDAO dao = new ProdutoDAO(); 
			
			ProdutoSG sg1 = new ProdutoSG();
			ProdutoSG sg2 = new ProdutoSG();
			ProdutoSG sg3 = new ProdutoSG();
			
			// VERIFICAÇÃO QUAL O MENOR VALOR
			Integer f1, f2, f3;
			
			ProdutoSG v1 = dao.consultarReferencia(referencia, 1);
			ProdutoSG v2  = dao.consultarReferencia(referencia, 2);
			ProdutoSG v3  = dao.consultarReferencia(referencia, 3); 
			
			if (v1.getValor_venda() < v2.getValor_venda() && v1.getValor_venda() < v3.getValor_venda()) {
				sg1 = dao.consultarReferencia(referencia, 1); f1 = 1;
				
				if(v2.getValor_venda() < v3.getValor_venda()) {
					sg2 = dao.consultarReferencia(referencia, 2); f2 = 2;
					sg3 = dao.consultarReferencia(referencia, 3); f3 = 3;
					
				} else {
					sg2 = dao.consultarReferencia(referencia, 3); f2 = 3;
					sg3 = dao.consultarReferencia(referencia, 2); f3 = 2;
				}
			} else {
				if(v2.getValor_venda() < v3.getValor_venda() && v2.getValor_venda() < v1.getValor_venda()) {
					sg1 = dao.consultarReferencia(referencia, 2); f1 = 2;
					
					if(v1.getValor_venda() < v3.getValor_venda()) {
						sg2 = dao.consultarReferencia(referencia, 1); f2 = 1;
						sg3 = dao.consultarReferencia(referencia, 3); f3 = 3;
					} else {
						sg2 = dao.consultarReferencia(referencia, 3); f2 = 3;
						sg3 = dao.consultarReferencia(referencia, 1); f3 = 1;
					}
				} else {
						sg1 = dao.consultarReferencia(referencia, 3); f1 = 3;
						
						if(v1.getValor_venda() < v2.getValor_venda()) {
							sg2 = dao.consultarReferencia(referencia, 1); f2 = 1;
							sg3 = dao.consultarReferencia(referencia, 2); f3 = 2;
							
						} else {
							sg2 = dao.consultarReferencia(referencia, 2); f2 = 2;
							sg3 = dao.consultarReferencia(referencia, 1); f3 = 1;
						}
				}
			}
			
			// LISTA DE TAMANHOS
			ArrayList<ProdutoSG> listatamanho1 = dao.consultarTamanho(referencia, f1);
			ArrayList<ProdutoSG> listatamanho2 = dao.consultarTamanho(referencia, f2);
			ArrayList<ProdutoSG> listatamanho3 = dao.consultarTamanho(referencia, f3);
			
			// PRIMEIRO BANCO DE DADOS
			request.setAttribute("fornecedor1", dao.consultarFornecedor(f1).getRazao());
			request.setAttribute("idfornecedor1", dao.consultarFornecedor(f1).getIdfornecedor());
			
			request.setAttribute("produto", sg1.getProduto());
			request.setAttribute("imagem", sg1.getImagem());
			request.setAttribute("descricao", sg1.getDescricao());
			request.setAttribute("modelo", sg1.getModelo());
			request.setAttribute("cor", sg1.getCor());
			request.setAttribute("genero", sg1.getGenero());
			request.setAttribute("categoria", sg1.getCategoria());
			request.setAttribute("id", sg1.getIdproduto());
			request.setAttribute("referencia", sg1.getReferencia());
			request.setAttribute("listatamanho1", listatamanho1);
			request.setAttribute("quantidade1", dao.Quantidade);
			
			Float valor = sg1.getValor_venda();
			request.setAttribute("valorf1", fr.formatar(valor));
			request.setAttribute("valorparcelado1", fr.formatar(cp.Calcular(valor)));
			request.setAttribute("parcela1", cp.Parcela(valor));
			
			// SEGUNDO BANCO DE DADOS
			if (dao.consultarReferencia(referencia, f2).getProduto() != null) {
				request.setAttribute("fornecedor2", dao.consultarFornecedor(f2).getRazao());
				request.setAttribute("idfornecedor2", dao.consultarFornecedor(f2).getIdfornecedor());
			}
				
			request.setAttribute("produto2", sg2.getProduto());
			request.setAttribute("modelo2", sg2.getModelo());
			request.setAttribute("id2", sg2.getIdproduto());
			request.setAttribute("referencia2", sg2.getReferencia());
			request.setAttribute("listatamanho2", listatamanho2);
			request.setAttribute("quantidade2", dao.Quantidade);
				
			Float valor2 = sg2.getValor_venda();
			request.setAttribute("valorf2", fr.formatar(valor2));
			request.setAttribute("valorparcelado2", fr.formatar(cp.Calcular(valor2)));
			request.setAttribute("parcela2", cp.Parcela(valor2));
			
			// TERCEIRO BANCO DE DADOS
			if(dao.consultarReferencia(referencia, f3).getProduto() != null) {
				request.setAttribute("fornecedor3", dao.consultarFornecedor(f3).getRazao());
				request.setAttribute("idfornecedor3", dao.consultarFornecedor(f3).getIdfornecedor());
			}
			
			request.setAttribute("produto3", sg3.getProduto());
			request.setAttribute("modelo3", sg3.getModelo());
			request.setAttribute("id3", sg3.getIdproduto());
			request.setAttribute("referencia3", sg3.getReferencia());
			request.setAttribute("listatamanho3", listatamanho3);
			
			// FORMATAR VALOR REAL E PARCELS	
			Float valor3 = sg3.getValor_venda();
			
			request.setAttribute("quantidade3", dao.Quantidade);
			request.setAttribute("valorf3", fr.formatar(valor3));
			request.setAttribute("valorparcelado3", fr.formatar(cp.Calcular(valor3)));
			request.setAttribute("parcela3", cp.Parcela(valor3));

			// BUSCA A AÇÃO NO DAO QUE BUSCA OS DADOS DO PRODUTO DO CARD
			ArrayList<ProdutoSG> lista = dao.buscaTodasReferencias(1);
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
				colocarcarrinho.setIdfornecedor(fornecedor);
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
