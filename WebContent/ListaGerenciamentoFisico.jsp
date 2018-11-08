<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html">
<html>
<head>
	<title>T-Shirt Games - Lista de Produtos</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
 	<link rel="stylesheet" href="resources/css/style.Principal.css">
	
	<script type="text/javascript" src="resources/js/jquery/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap/popper.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="resources/template/nav.jsp"/>

	<!-- CARROSEL -->
	<div class="container">
		<div class="row">
			<c:if test="${not empty lista}">
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
									<input type="hidden" name="idproduto" value="${lista.idusuario}">
					      			<button type="submit" formaction="AlterarCadastro" formmethod="get" class="btn btn-tshirt"><img src="resources/img/icones/pencil.svg"></button>						      			
					      			<button class="btn btn-secundary">Ativo</button>
				      			</form>
				      		</div>
		      			</td>
				    </tr>
			    </c:forEach>
			</c:if>

			<c:if test="${empty lista}">
				<h3 class="col-12 mt-5 mb-3">Não encontrado</h3>
			</c:if>
		</div>
	</div>

	<c:import url="resources/template/footer.jsp"/>
</body>
</html>