<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
	<title>T-Shirt Games - Cadastrar Produtos</title>
	<meta http-equiv="Content-Type" content="text/html">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">

	<script type="text/javascript" src="resources/js/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery/jquery.mask.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap/popper.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="resources/js/script.PreImagem.js"></script>
	<script type="text/javascript" src="resources/js/script.ValidacaoCampos.js"></script>
	<script type="text/javascript" src="resources/js/script.FormatacaoCampos.js"></script>
	<script type="text/javascript" src="resources/js/script.ExibirModal.js"></script>
</head>

<body>
	<c:import url="resources/template/modal.Mensagem.jsp"/>
	
	<c:import url="resources/template/nav.jsp"/>
	
	<div class="container">

		<!-- FORMULÁRIO DE CASTRO DO PRODUTO -->
		<form name="form-produto" enctype="multipart/form-data" accept-charset="ISO-8859-1">
		<div class="row">
			<div class="col-md-4 mt-4">
				<div class="card m-2 mb-4">
					<div id="valida_imagem" class="card m-3">
						<img id="img-pre-visualiza" class="card-img-top m-4 mx-auto d-inline-block">
						<p class="text-center" id="msg_imagem" style="display: none;">Insira uma imagem!</p>
					</div>

					<div class="card m-3">
						<div class="custom-file">
							<input name="imagem" id="pre-imagem" onchange="PreviewImage(); RetornoValidaImagem();" class="w-100 custom-file-input" type="file">
							<span id="input-imagem" class="custom-file-label text-truncate"></span>
						</div>
					</div>
				</div>

				<div class="card m-2">
					<div class="form-group m-2">
						<h4><label for="exampleFormControlTextarea1">Descrição do Produto</label></h4>
						<textarea name="descricao" id="descricao" onfocus="RetornoValidaDescricao()" class="form-control" rows="4" placeholder="Digite a descrição do produto..." required>${descricao}</textarea>
					</div>
				</div>
			</div>

			<div class="card col-md-8 mt-4">
				<div class="row mt-3">
					<div class="form-group col-md">
						<h5><label for="formGroupExampleInput">Produto</label></h5>
						<input name="produto" id="produto" onfocus="RetornoValidaProduto()" type="text" class="form-control" placeholder="Nome do Produto" required>
					</div>
					<div class="form-group col-md">
						<h5><label for="formGroupExampleInput">Modelo</label></h5>
						<input name="modelo" id="modelo" onfocus="RetornoValidaModelo()" type="text" class="form-control" placeholder="Modelo do Produto" required>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md">
						<h5><label for="formGroupExampleInput">Referência</label></h5>
						<input name="referencia" id="referencia" onfocus="RetornoValidaReferencia()" onkeypress="return ApenasNumeros(event)" type="text" class="form-control" placeholder="Referencia do Produto" required>
					</div>
				
					<div class="form-group col-md">
						<h5><label for="exampleFormControlSelect1">Genero</label></h5>
						<select name="genero" id="genero" onfocus="RetornoValidaGenero()" class="form-control" required>
							<option value="" label="Selecione o Genero">
							<option value="Feminino" label="Feminino">
							<option value="Masculino" label="Masculino">
						</select>
					</div>

					<div class="form-group col-md">
						<h5><label for="exampleFormControlSelect1">Categoria</label></h5>
						<select name="categoria" id="categoria" onfocus="RetornoValidaCategoria()" class="form-control" required>
							<option value="" label="Selecione uma Categoria">
							<option value="Series" label="Series">
							<option value="Games" label="Games">
							<option value="Animes" label="Animes">
							<option value="Filmes" label="Filmes">
						</select>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="form-group col-md">
						<h5><label for="formGroupExampleInput">Tamanho</label></h5>
						<select name="tamanho" id="tamanho" onfocus="RetornoTamanho()" class="form-control" required>
							<option value="" label="Selecione um Tamanho">
							<option value="PP" label="PP">
							<option value="P" label="P">
							<option value="M" label="M">
							<option value="G" label="G">
							<option value="GG" label="GG">
						</select>
					</div>

					<div class="form-group col-md">
						<h5><label for="formGroupExampleInput">Cor</label></h5>
						<input name="cor" id="cor" onfocus="RetornoValidaCor()" type="text" class="form-control" placeholder="Cor do Produto" required>
					</div>

					<div class="form-group col-md">
						<h5><label for="formGroupExampleInput">Quantidade</label></h5>
						<input name="quantidade" id="quantidade" onfocus="RetornoValidaQuantidade()" type="number" class="form-control" placeholder="00" min="1" required>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="form-group col-md">
						<h5><label for="formGroupExampleInput">Valor Custo</label></h5>
						<input name="valor_custo" id="valor_custo" onfocus="RetornoValidaValorCusto()" onkeypress="return Decimal(event)" type="text" class="form-control" placeholder="R$ 00.00" pattern="[0-9]{,2}" title="Formato deve ser 0.00" required>
					</div>

					<div class="form-group col-md">
						<h5><label for="formGroupExampleInput">Valor Venda</label></h5>
						<input name="valor_venda" id="valor_venda" onfocus="RetornoValidaValorVenda()" onkeypress="return Decimal(event)" type="text" class="form-control" placeholder="R$ 00.00" pattern="[0-9]{,2}" title="Formato deve ser 0.00" required>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-md-4 mt-3 mb-3 center">
						<button formaction="AlterarProduto" formmethod="get" class="btn btn-warning" formnovalidate>Alterar Produto ➔</button>
					</div>
					<div class="col-md-8 ml-auto center mb-3 mt-3">
 						<button id="CadastrarProduto" type="submit" class="btn btn-success" formaction="InserirProduto" formmethod="post" name="button" onclick="ValidaCadastroProduto()">Cadastrar</button>
						<a href="index.jsp"><button type="button" class="btn btn-danger">Cancelar</button></a>
					</div>
				</div>
			</div>
		</div>
		</form>
	</div>

	<c:import url="resources/template/footer.jsp"/>
</body>
</html>
