package br.com.crashsolutions.Servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import org.tempuri.CResultado;
import org.tempuri.CServico;
import org.tempuri.CalcPrecoPrazoWSLocator;
import org.tempuri.CalcPrecoPrazoWSSoap;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/CalculoFrete")
public class CalculoFrete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CalculoFrete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			CalcPrecoPrazoWSSoap soap = new CalcPrecoPrazoWSLocator().getCalcPrecoPrazoWSSoap();
			CResultado resultado = soap.calcPrecoPrazo("09546875", "123456", "40010,41106", "09780650", request.getParameter("cep"), "1", 1, new BigDecimal("20"), new BigDecimal("18"), new BigDecimal("20"), new BigDecimal("0"), "n", new BigDecimal("0"), "n");
			
			CServico[] service = resultado.getServicos();
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(service);
			
			response.getWriter().println(json);
				
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
