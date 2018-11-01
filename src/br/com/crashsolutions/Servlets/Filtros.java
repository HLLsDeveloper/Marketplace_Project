package br.com.crashsolutions.Servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName="Filtros", urlPatterns={"/Finalizacao", "/Enderecos", "/addCarrinho", "/Carrinho"})
public class Filtros implements Filter {

    public Filtros() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest servletrequest = (HttpServletRequest) request;
		String url = servletrequest.getRequestURI();
		HttpSession s = servletrequest.getSession();
		
		if(s.getAttribute("idsessao")!=null || url.lastIndexOf("Login.jsp")>-1 || url.lastIndexOf("Login")>-1) {
			chain.doFilter(request, response);
		}
		else {
			((HttpServletResponse) response).sendRedirect("Login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
