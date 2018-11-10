<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html">
<html>
<head>
	<title>T-Shirt Games - Lista de Produtos</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
	
	<script type="text/javascript" src="resources/js/jquery/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap/popper.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="resources/template/nav.jsp"/>

	<!-- CARROSEL -->
	<div class="container">
		<div class="row mt-4">
			<c:if test="${not empty lista}">
				<c:forEach var="produto" items="${lista}">
						<div class="card col-3 mb-2">
						    <img class="mt-3 mx-auto d-block" src="resources/img/img-produtos/${produto.imagem}" height="300">
							<div class="card-body">
						    	<h4 class="card-title letramaiucula text-center">${produto.produto}</h4>
							</div>
							<ul class="list-group list-group-flush text center">
								<li class="product-price">R$ ${produto.valor_venda}</li>
							</ul>
						    <div class="btn-group card-body mx-auto d-block mt-4">
						    	<form>
						    		<input name="id" value="${produto.idproduto}" class="d-none">
						    		<input name="referencia" value="${produto.referencia}" class="d-none">
									<button type="submit" formaction="Descricao" formmethod="get" class="btn btn-success btn-lg btn_sh btn_tam">Comprar</button>
							    	<button type="button" class="btn btn-outline-danger btn-lg btn_cor btn_sh border-0">♥</button>
						    	</form>
						    </div>
					    </div>
				</c:forEach>
			</c:if>

			<c:if test="${empty lista}">
				<h3 class="col-12 mt-5 mb-3">Não encontramos o que você procura :(</h3>
				<h4 class="col-12 mt-3 mb-5">Mas não se preocupe, estamos trabalhando para expandir o estoque com novos produtos.</h4>
			</c:if>
		</div>
	</div>

	<c:import url="resources/template/footer.jsp"/>
</body>
</html>