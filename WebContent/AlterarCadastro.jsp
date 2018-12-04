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
<div class="header-site">
	<div class="container">
	
		<!-- FORMULÁRIO DE ALTERAR PRODUTO -->
		<form id="form-produto" enctype="multipart/form-data" accept-charset="ISO-8859-1">
		<div class="row">
			<div class="col-md-4 mt-4">
				<div class="card m-0 mb-3">
					<div class="card m-3">
						<img id="img-pre-visualiza" class="card-img-top m-4 mx-auto d-inline-block" src="resources/img/img-produtos/${imagem}">
						<p class="text-center" id="msg_imagem" style="display: none;">Insira uma imagem!</p>
					</div>

					<div class="card m-3">
						<div class="custom-file">
							<input name="pre-imagem" id="pre-imagem" onchange="PreviewImage()" class="border-tshirt w-100 custom-file-input" type="file">
							<span id="input-imagem" class="custom-file-label text-truncate">${imagem}</span>
							<input name="imagem" id="imagem" class="d-none" value="${imagem}">
						</div>
					</div>
				</div>

				<div class="card my-4 py-3">
					<div class="form-group text-center font-weight-bold m-2">
						<h4>Descrição do Produto</h4>
						<textarea name="descricao" id="descricao" class="form-control" rows="4" required>${descricao}</textarea>
					</div>
				</div>
			</div>

			<div class="card col-md-8 mt-4">
				<div class="row mt-3">
					<div class="form-group col-md">
						<h5>Produto</h5> 
						<input name="produto" value="${produto}" id="produto" type="text" class="form-control" required>
					</div>
					<div class="form-group col-md">
						<h5>Modelo</h5>
						<input name="modelo" value="${modelo}" id="modelo" type="text" class="form-control" required>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md">
						<h5>Referência</h5> 
						<input name="referencia" value="${referencia}" onkeypress="return ApenasNumeros(event)" id="referencia" type="text" class="form-control" required>
					</div>
				
					<div class="form-group col-md">
						<h5>Gênero</h5> 
						<input name="genero" value="${genero}" id="genero" type="text" class="form-control" disabled required>
					</div>

					<div class="form-group col-md">
						<h5>Categoria</h5>
						<input name="categoria" value="${categoria}" id="categoria" type="text" class="form-control" disabled required>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="form-group col-md">
						<h5>Tamanho</h5> 
						<input name="tamanho" value="${tamanho}" id="tamanho" type="text" class="form-control" disabled required>
					</div>

					<div class="form-group col-md">
						<h5>Cor</h5> 
						<input name="cor" value="${cor}" id="cor" type="text" class="form-control" required>
					</div>

					<div class="form-group col-md">
						<h5>Quantidade</h5>
						<input name="quantidade" value="${quantidade}" id="quantidade" type="number" class="form-control" min="1">
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="form-group col-md">
						<h5>Valor Custo</h5>
						<input name="valor_custo" value="${valor_custo}" id="valor_custo" type="text" class="form-control" pattern="[0-9]{,2}" title="Formato correto: 0.00" onkeypress="return BloquearCaracteres(event)" required>
					</div>

					<div class="form-group col-md">
						<h5>Valor Venda</h5>
						<input name="valor_venda" value="${valor_venda}" id="valor_venda" type="text" class="form-control" pattern="[0-9]{,2}" title="Formato correto: 0.00" onkeypress="return BloquearCaracteres(event)" required>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-md-4 mt-3 mb-3 center">
						<div class="col-md-6  center">
							<a href="InserirProduto.jsp">
								<label class="btn btn-warning">Cadastrar Produto ➔</label>
							</a>
						</div>
					</div>
					<div class="row col-md-3 mt-3 mb-3">
						<div class="ml-4">
							<label class="btn btn-tshirt" onclick="ListaProdutos()">
								<img src="resources/img/icones/list.svg">
							</label>
						</div>
						<div class="col">
							<input value="${idproduto}" name="idproduto" id="buscar" class="col form-control" required>
						</div>
					</div>
					<div class="col-md-3 mt-3 mb-3">
						<button name="bt-buscar" type="submit" class="btn btn-warning font-size-2" formaction="AlterarProduto" formmethod="post">Alterar</button>
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
