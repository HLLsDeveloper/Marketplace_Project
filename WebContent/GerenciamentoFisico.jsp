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

	<script type="text/javascript" src="resources/js/jquery/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/jquery/jquery.mask.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap/popper.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="resources/template/nav.jsp"/>

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
						<thead>
						    <tr>
						      <th scope="col">ID</th>
						      <th scope="col">Funcionário</th>
						      <th scope="col">CPF</th>
						      <th scope="col">Email</th>
						      <th scope="col"></th>
						    </tr>
					  	</thead>
	  					<tbody>
	  						<c:forEach var="lista" items="${listapessoas}">
							    <tr>
							      <th scope="row">${lista.idusuario}</th>
								  	<td>${lista.nome} ${lista.sobrenome}</td>									  									  	
								    <td>${lista.cpf}</td>
								    <td>
								    	<div class="d-inline">${lista.email}</div>
								    </td>
								    <td>
									    <div class="d-inline">
									    	<form>
												<input type="hidden" name="idusuario" value="${lista.idusuario}">
								      			<button type="submit" formaction="AlterarCadastro" formmethod="get" class="btn btn-tshirt"><img src="resources/img/icones/pencil.svg"></button>						      			
								      			<button class="btn btn-secundary">Ativo</button>
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
	
	<c:import url="resources/template/footer.jsp"/>
</body>
</html>