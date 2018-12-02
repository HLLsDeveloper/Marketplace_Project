<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>T-Shirt Games - Alterar Cadastro</title>
	<meta http-equiv="Content-Type" content="text/html">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
	<link rel="stylesheet" href="resources/css/style.Principal.css">
	
	<script type="text/javascript" src="resources/js/jquery/jquery.min.js"></script>
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
	
<div class="header-site py-5"> 
	<div class="container">
	
		<!-- FORMULÁRIO DE ALTERAR USUÁRIO -->
		<form id="form-produto" accept-charset="ISO-8859-1">
		<div class="row">
			<div class="card col-md-12 mt-4">
				<div class="row mt-3">

					<div class="form-group col-md-3">
						<h5>ID</h5> 
						<input value="${aidusuario}" type="text" class="form-control" disabled required>
					</div>
					<div class="form-group col-md-3">
						<h5>Nome</h5>
						<input name="anome" value="${anome}" id="nome" type="text" class="form-control" required>
					</div>
					<div class="form-group col-md-3">
						<h5>Sobrenome</h5>
						<input name="asobrenome" value="${asobrenome}" id="sobrenome" type="text" class="form-control" required>
					</div>
				</div>

				<div class="row">
				
					<div class="form-group col-md">
						<h5>CPF</h5> 
						<input name="acpf" value="${acpf}" id="cpf" type="text" class="form-control" disabled required>
					</div>

					<div class="form-group col-md">
						<h5>Email</h5>
						<input name="aemail" value="${aemail}" id="email" type="text" class="form-control"  required>
					</div>					
				</div>
			
				<div class="row">
				
					<div class="form-group col-md">
						<h5>Celular</h5> 
						<input name="acelular" value="${acelular}" id="celular" type="text" class="form-control"  required>
					</div>

					<div class="form-group col-md">
						<h5>Telefone</h5>
						<input name="atelefone" value="${atelefone}" id="telefone" type="text" class="form-control"  required>
					</div>
				</div>
				
				<div class="row">
				
					<div class="form-group col-md-3">
						<h5>Data de Nascimento</h5> 
						<input name="adatanascimento" value="${adatanascimento}" id="datanascimento" type="text" class="form-control"  required>
					</div>
				
					<div class="form-group col-md-3">
						<h5>Sexo</h5> 
						<input name="asexo" value="${asexo}" id="sexo" type="text" class="form-control"  required>
					</div>
					<div class="form-group col-md-3">
						<h5>Condição</h5>
						<input name="acondicao" value="${acondicao}" id="condicao" type="text" class="form-control "  required>
					</div>
				</div>			
			
				<div class="row">
					<div class="col-md-4 mt-3 mb-3 float-right">
						<div class="col-md-6 mt-3 mb-3 ">
							<button class="btn btn-warning" name="aidusuario" value="${aidusuario}" type="submit" formaction="AlterarCadastro" formmethod="post">Salvar ➔</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		</form>	
	</div>
</div>
	<c:import url="resources/template/footer.jsp"/>
</body>
</html>