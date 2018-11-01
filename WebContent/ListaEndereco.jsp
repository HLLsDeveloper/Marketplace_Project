<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>Meus Endereços</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
	<script src="resources/js/jquery/jquery.min.js" type="text/javascript"></script>
	<script src="resources/js/bootstrap/popper.min.js" type="text/javascript"></script>
	<script src="resources/js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
	
	<!-- ESTILO DO ENDEREÇO -->
	<style type="text/css"> 
	
		.card-endereco:hover, .text-endereco:hover {
			background-color: #ff6600 !important;
			color: #ffffff !important;
		}
		.card-endereco {
    		-moz-transition: width 2s !important;
    	}
    	
	</style>
</head>
	
<body>
	<c:import url="resources/template/nav.jsp"/>
	
	<div class="container">
		<form>
			<h1 class="my-4 text-center">Meus Endereços</h1>
			<div class="row card-deck">
				<!-- INICIO: CARD DE ENDEREÇO  -->
				<c:forEach var="endereco" items="${enderecos}">
				<div class="col-ms-3">
					<div class="card bg-light mb-3" style="max-width: 20rem;">
						<div class="card-header card-endereco">
							<div class="custom-control custom-checkbox">
								<input name="check_endereco" type="radio" class="custom-control-input" id="${endereco.idendereco}" value="${endereco.idendereco}">
								<label class="custom-control-label" for="${endereco.idendereco}">
									<strong id="text_endereco">Nome do Endereço: Minha casa</strong>
								</label>
							</div>
				  		</div>
				  		
					  	<div class="card-body">
						    <p class="card-text">
							    ${endereco.endereco}, ${endereco.numero} <br>
							    ${endereco.bairro} <br>
							    ${endereco.cidade} (${endereco.estado}) <br>
							    <strong>CEP:</strong> ${endereco.cep} <br>
							    <strong>Complemento:</strong> ${endereco.complemento} <br>
						    </p>
					  	</div>
			  		</div>
				</div>
				</c:forEach>
				<!-- FIM: CARD DE ENDEREÇO  -->
			</div>
			<div class="card">
				<div class="card-body">
					<button type="button" class="btn btn-tshirt btn-lg" data-toggle="modal" data-target="#CadastrarEndereco">+ Novo Endereço</button>
					<button type="submit" data-toggle="modal" class="btn btn-success btn-lg float-right" formaction="Finalizacao" formmethod="post">Continuar</button>
				</div>
			</div>
		</form>
	</div>
	<!-- MODAL MENSAGEM UPLOAD DA IMAGEM -->
	<div class="modal fade" id="CadastrarEndereco" tabindex="" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<form action="Enderecos" method="post" accept-charset="ISO-8859-1">
					<div class="modal-body">
						<h4>Novo endereço</h4>
						<label>Nome do endereço:</label>
						<input class="form-control" type="text" name="nomeendereco">
						<label>Endereço:</label>
						<input class="form-control" type="text" name="endereco">
						<div class="row">
							<div class="col-3">
								<label>Número:</label>
								<input class="form-control" type="text" name="numero">
							</div>
							<div class="col-9">
								<label>Bairro:</label>
								<input class="form-control" type="text" name="bairro">
							</div>
						</div>
						<label>Cidade:</label>
						<input class="form-control" type="text" name="cidade">
						<label>Estado:</label>
						<input class="form-control" type="text" name="estado">
						<div class="row">
							<div class="col-4">
								<label>CEP:</label>
								<input class="form-control" type="text" name="cep">
							</div>
							<div class="col-8">
								<label>Complemento:</label>
								<input class="form-control" type="text" name="complemento">
							</div>
						</div>
					</div>
					<div class="modal-footer">
				        <button type="submit" class="btn btn-success mr-auto">Cadastrar</button>
				        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>