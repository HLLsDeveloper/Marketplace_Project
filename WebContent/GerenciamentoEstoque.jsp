<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
	<title>T-Shirt Games - Gerenciamento de Estoque</title>
	<meta http-equiv="Content-Type" content="text/html">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">

	<script type="text/javascript" src="resources/js/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap/popper.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="resources/template/nav.jsp"/>
<div class="header-site py-5">
	<div class="container mt-4">
		<!-- INICIO: TABELA DE PRODUTOS -->
		<div class="card bg-light mb-3">
		  	<div class="card-header">
		  		<h5 class="card-title center">Tabela de Produtos</h5>
		 	</div>
		 	
		 	<!-- CAMPO DE PESQUISA -->
		 	<div class="col-4 input-group mt-4 m-2 ml-auto">
		 		<div class="d-inline">
		 			<input type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></input>					 			
		 		</div>
		 		<div class="d-inline">
			    	<button class="btn btn-primary" type="button">Buscar</button>
			  	</div>
		 	</div>
		 		
		  	<!-- INICIO: LISTA DE PRODUTOS -->
			<div class="card-body">
					<table class="table table-hover">
						<thead class="thead-dark">
						    <tr>
						      <th scope="col" class="text-center align-middle font-weight-bold">ID</th>
						      <th scope="col" class="text-center align-middle font-weight-bold">Produto</th>
						      <th scope="col" class="text-center align-middle font-weight-bold">Tamanho</th>
						      <th scope="col" class="text-center align-middle font-weight-bold">Categoria</th>
						      <th scope="col" class="text-center align-middle font-weight-bold">Valor</th>
						      <th scope="col" class="text-center align-middle font-weight-bold">Qtd.</th>
						      <th scope="col" class="text-center align-middle font-weight-bold">Editar</th>
						    </tr>
					  	</thead>
	  					<tbody>
	  						<c:forEach var="lista" items="${lista_produto}">
							    <tr>
							      <th class="text-center align-middle font-weight-bold" scope="row"> ${lista.idproduto}</th>
								  	<td class="align-middle font-weight-bold"><img  height="80" src="resources/img/img-produtos/${lista.imagem}"> ${lista.produto}</td>	
								  	<td class="text-center align-middle font-weight-bold"> ${lista.tamanho} 	</td>	
								  	<td class="text-center align-middle font-weight-bold"> ${lista.categoria}	</td>						  									  	
								    <td class="text-center align-middle font-weight-bold">${lista.valor_venda}</td>
								    <td class="text-center align-middle font-weight-bold">
								    	<div class="d-inline">${lista.quantidade}</div>
								    </td>
								    <td class="text-center align-middle font-weight-bold">
									    <div class="d-inline">
									    	<form>
												<input type="hidden" name="idproduto" value="${lista.idproduto}">
								      			<button type="submit" formaction="AlterarProduto" formmethod="get" class="btn btn-tshirt"><img src="resources/img/icones/pencil.svg"></button>						      			
								      			
							      			</form>
							      		</div>
					      			</td>
							    </tr>
						    </c:forEach>
	  					</tbody>
					</table>
			</div>
			<!-- FIM: LISTA DE PRODUTOS -->
		</div>
		<!-- FIM: TABELA DE PRODUTOS -->
	</div>
	</div>
	<c:import url="resources/template/footer.jsp"/>
</body>
</html>
