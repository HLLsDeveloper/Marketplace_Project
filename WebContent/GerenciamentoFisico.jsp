<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
	<title>T-Shirt Games - Gerenciamento Fisico</title>
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
	<div class="container ">
		<!-- INICIO: TABELA DE USUÁRIO -->
		<div class="card bg-light ">
		  	<div class="card-header">
		  		<h5 class="card-title center">Tabela de Usuário</h5>
		 	</div>
		 	
		 	<!-- CAMPO DE PESQUISA -->
		 	<div class="col-4 input-group mt-4 m-2 ml-auto">
	        	<form class="form-inline ml-auto my-2 my-lg-0" action="Busca" >
	                <input name="pesquisausu" class="form-control search-text" type="text" placeholder="Search" aria-label="Search">                
	                <button class="btn my-3 mr-1 my-sm-0 btn-tshirt" type="submit"><img src="resources/img/icones/search.svg" width="20" height="25" alt="procurar"></button>
	            </form>
		 	</div>
		 		
		  	<!-- INICIO: LISTA DE USUÁRIO -->
			<div class="card-body">
					<table class="table table-hover">
						<thead class="thead-dark">
						    <tr>
						      <th scope="col">ID</th>
						      <th scope="col">Funcionário</th>
						      <th scope="col">CPF</th>
						      <th scope="col">Sexo</th>
						      <th scope="col">Email</th>
						      <th scope="col">Condição</th>
						      <th scope="col">Editar</th>
						    </tr>
					  	</thead>
	  					<tbody>
	  						<c:forEach var="lista" items="${listapessoas}">
							    <tr>
							      <th scope="row">${lista.idusuario}</th>
								  	<td>${lista.nome} ${lista.sobrenome}</td>									  									  	
								    <td>${lista.cpf}</td>
								    <td>${lista.sexo}</td>
								    <td><div class="d-inline">${lista.email}</div></td>								    
								    <td>${lista.condicao}</td>
								    <td>
									    <div class="d-inline">
									    	<form>
								      			<button name="idusuario" value="${lista.idusuario}" type="submit" formaction="AlterarCadastro" formmethod="get" class="btn btn-tshirt"><img src="resources/img/icones/pencil.svg"></button>						      			
							      			</form>
							      		</div>
					      			</td>
							    </tr>
						    </c:forEach>
	  					</tbody>
					</table>
			</div>
			<!-- FIM: LISTA DE usuário -->
		</div>
		<!-- FIM: TABELA DE USUÁRIO -->
	</div>
	</div>
	<c:import url="resources/template/footer.jsp"/>
</body>
</html>