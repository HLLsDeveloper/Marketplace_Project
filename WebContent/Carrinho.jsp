<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<title>Carrinho</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="resources/css/owlcarousel/owl.carousel.css">
<link rel="stylesheet" href="resources/css/owlcarousel/owl.theme.default.css">
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/jquery/bootstrap.min.js"></script>
</head>
<body>
<c:import url="resources/template/nav.jsp"/>
<div class="header-site">
  <div class="container">
  	<div class="content-wrapper p-4 mx-5">
    <div class="container-fluid">
      <div class="card">
        <div class="card-header"><i class="fa fa-table"></i>Carrinho.</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable">
              <thead>
                <tr>
                  <th>IMAGEM</th>
                  <th>PRODUTO</th>
                  <th>TAMANHO</th>
                  <th>QUANTIDADE</th>
                  <th>VALOR UNITÁRIO</th>
                  <th>EXCLUIR</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach var="carrinho" items="${carrinho}">
                <tr>
                  <td><img height="80" src="resources/img/img-produtos/<c:out value="${carrinho.imagem}"></c:out>"></td>
                  <td><c:out value="${carrinho.produto}"></c:out></td>
                  <td><c:out value="${carrinho.tamanho}"></c:out></td>
                  <td><p id="quantidade"><c:out value="${carrinho.quantidade}"></c:out></td>
                  <td><c:out value="R$ ${carrinho.valor_venda}"></c:out></td>
                  <td> 	
                  <form>				
						<button name="excluir" value="${carrinho.idproduto}" class="btn btn-success d-block mb-1 mx-auto" formaction="Carrinho" formmethod="post" type="submit">Excluir</button>
				  </form>	
				  </td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted">
        <form>
        		<button type="submit" data-toggle="modal" data-target="#" class="btn btn-danger btn-lg float-left" formaction="Home">Continuar Comprando</button> 
				<button type="submit" data-toggle="modal" data-target="#" class="btn btn-danger btn-lg float-right" formaction="Enderecos">Finalizar Compra</button>
		</form>
		</div>
      </div>
     </div>
    </div>
  </div>
</div>
<c:import url="resources/template/footer.jsp"/>
</body>
</html>