package br.com.crashsolutions.Servlets;

import br.com.crashsolutions.Acoes.CalculoParcelas;
import br.com.crashsolutions.DAO.ProdutoDAO;
import br.com.crashsolutions.SG.ProdutoSG;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Produto")
public class ListaCamisetas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ListaCamisetas() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {			
			// TRÁS O PRODUTO SELECIONADO
			String id = request.getParameter("id");
					
			ProdutoDAO produtoDAO = new ProdutoDAO();
			ProdutoSG unico;
			
			unico = produtoDAO.consultar(id);
					
			request.setAttribute("produto", unico.getProduto());
			request.setAttribute("imagem", unico.getImagem());
			request.setAttribute("descricao", unico.getDescricao());
			request.setAttribute("modelo", unico.getModelo());
			request.setAttribute("cor", unico.getCor());
			request.setAttribute("genero", unico.getGenero());
			request.setAttribute("categoria", unico.getCategoria());
			request.setAttribute("quantidade", 1);
			request.setAttribute("quantidade_bd", unico.getQuantidade());
			request.setAttribute("valorvenda", unico.getValor_venda());
			request.setAttribute("id", unico.getIdproduto());
			
			// CALCULO DE PARCELAS
			CalculoParcelas cp = new CalculoParcelas();
			
			Float valor = unico.getValor_venda();
			request.setAttribute("parcelado", "Parcelado em até "+ cp.parcela +"x "+ cp.Calcular(valor) + " sem juros");
					
			// BUSCA A AÇÃO NO DAO QUE BUSCA OS DADOS DO PRODUTO
			ProdutoDAO listar = new ProdutoDAO();
			
			ArrayList<ProdutoSG> lista = null;
			
			lista = listar.buscaTodos();
			
			request.setAttribute("lista_produto", lista);
					
			RequestDispatcher enviar = request.getRequestDispatcher("DescricaoProduto.jsp");
			enviar.forward(request, response);
			
		} catch (SQLException e) {
			System.out.println("Erro na ListaCamisetas: "+ e);
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
