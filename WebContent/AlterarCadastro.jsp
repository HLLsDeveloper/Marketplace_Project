<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>T-Shirt Games - Alterar Produtos</title>
	<meta http-equiv="Content-Type" content="text/html">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
	<link rel="stylesheet" href="resources/css/style.Principal.css">
	
	<script type="text/javascript" src="resources/js/jquery/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/jquery/jquery.mask.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="resources/js/script.PreImagem.js"></script>
	<script type="text/javascript" src="resources/js/script.ValidacaoCampos.js"></script>
	<script type="text/javascript" src="resources/js/script.FormatacaoCampos.js"></script>
	<script type="text/javascript" src="resources/js/script.ExibirModal.js"></script>
</head>

<body>
	<c:import url="resources/template/modal.Mensagem.jsp"/>
	<c:import url="resources/template/modal.ListaProdutos.jsp"/>
	
	<c:import url="resources/template/nav.jsp"/>

	<div class="container">
	
		<!-- FORMULÁRIO DE ALTERAR PRODUTO -->
		<form id="form-produto" enctype="multipart/form-data" accept-charset="ISO-8859-1">
		<div class="row">
			<div class="col-md-4 mt-4">
				<div class="card m-2">
					<div class="form-group m-2">
						<h4>Descrição do Usuário</h4>
						<textarea name="descricao" id="descricao" class="form-control" rows="4" required>${nome}</textarea>
					</div>
				</div>
			</div>

			<div class="card col-md-8 mt-4">
				<div class="row mt-3">
					<div class="form-group col-md">
						<h5>Nome</h5> 
						<input name="usuario" value="${nome}" id="usuario" type="text" class="form-control" required>
					</div>
					<div class="form-group col-md">
						<h5>Sobrenome</h5>
						<input name="sobrenome" value="${sobrenome}" id="sobrenome" type="text" class="form-control" required>
					</div>
				</div>

				<div class="row">
				
					<div class="form-group col-md">
						<h5>CPF</h5> 
						<input name="cpf" value="${cpf}" id="cpf" type="text" class="form-control" disabled required>
					</div>

					<div class="form-group col-md">
						<h5>Email</h5>
						<input name="email" value="${email}" id="email" type="text" class="form-control" disabled required>
					</div>
				</div>
			
				<div class="row">
				
					<div class="form-group col-md">
						<h5>Idade:</h5> 
						<input name="idade" value="${idade}" id="cpf" type="text" class="form-control" disabled required>
					</div>

					<div class="form-group col-md">
						<h5>Idade</h5>
						<input name="idade" value="${idade}" id="email" type="text" class="form-control" disabled required>
					</div>
				</div>
			
				<div class="row">
					<div class="col-md-4 mt-3 mb-3 float-right">
						<div class="col-md-6 mt-3 mb-3 ">
							<a href="CadastroFisico.jsp">
								<label class="btn btn-warning">Cadastrar Pessoa Física ➔</label>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		</form>	
	</div>

	<c:import url="resources/template/footer.jsp"/>
</body>
</html>