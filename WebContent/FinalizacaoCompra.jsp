<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html">
<html>
<head>
<title>T-Shirt Games - Finalização de Compra</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="resources/css/style.nav.css">
<script src="https://code.jquery.com/jquery-1.9.1.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/script.js"></script>
<script src="resources/js/bootstrap/bootstrap.js"></script>
</head>
<body>
	<c:import url="resources/template/nav.jsp" />

	<section class="container">
		<div class="row">
			<div class="col-md-12 mt-4">
				<h2 class="mb-4">Finalização de Compra</h2>
				<form>
					<div class="card">
						<h5 class="card-header">Informações</h5>
						<div class="card-body">
							<table class="table table-striped table-sm">
								<thead>
									<tr>
										<th scope="col">Produto</th>
										<th scope="col">Categoria</th>
										<th scope="col">Tamanho</th>
										<th scope="col">Preço</th>
										<th scope="col">Quantidade</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="carrinho" items="${carrinho}">
										<tr>
											<td>
												<p id="produto_row1" class="mb-0"><c:out value="${carrinho.produto}"></c:out></p>
												<p id="produto_row2" class="mb-0"><small><c:out value="${carrinho.cor}"></c:out></small></p>
											</td>
											<td><p id="categoria"><c:out value="${carrinho.categoria}"></c:out></p></td>
											<td><p id="tamanho"><c:out value="${carrinho.tamanho}"></c:out></p></td>
											<td><p id="valor"><c:out value="R$ ${carrinho.valor_venda}"></c:out></p></td>
											<td><p id="quantidade"><c:out value="${carrinho.quantidade_dig}"></c:out></p></td>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-6 mt-5">
				<div class="card">
					<h5 class="card-header">Dados de Cadastrados</h5>
					<div class="card-body">
						<ul class="list-group">
							<c:if test="${not empty idusuariouser}">
								<li class="list-group-item list-group-item-dark">Nome:<c:out value=" ${nomeuser}"></c:out></li>
								<li class="list-group-item list-group-item-dark">Email:<c:out value=" ${emailuser}"></c:out></li>
								<li class="list-group-item list-group-item-dark">Celular:<c:out value=" ${celularuser}"></c:out></li>
								<li class="list-group-item list-group-item-dark">Telefone:<c:out value=" ${telefoneuser}"></c:out></li>
								<li class="list-group-item list-group-item-dark">Tipo de cadastro:<c:out value="Fisico"></c:out></li>
								<li class="list-group-item list-group-item-dark">CPF:<c:out value=" ${cpfuser}"></c:out></li>
							</c:if>
							<c:if test="${not empty idempresauser}">
								<li class="list-group-item list-group-item-dark">Razão Social:<c:out value=" ${razaouser}"></c:out></li>
								<li class="list-group-item list-group-item-dark">Nome Fantasia:<c:out value=" ${nomefantasiauser}"></c:out></li>
								<li class="list-group-item list-group-item-dark">Email:<c:out value=" ${emailuser}"></c:out></li>
								<li class="list-group-item list-group-item-dark">Celular:<c:out value=" ${celularuser}"></c:out></li>
								<li class="list-group-item list-group-item-dark">Telefone:<c:out value=" ${telefoneuser}"></c:out></li>
								<li class="list-group-item list-group-item-dark">Tipo de cadastro:<c:out value="Juridico"></c:out></li>
								<li class="list-group-item list-group-item-dark">CNPJ:<c:out value=" ${cnpjuser}"></c:out></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>

			<div class="col-md-6 mt-5">
				<div class="card">
					<h5 class="card-header">Entrega</h5>
					<div class="card-body">
						<div class="row">

							<div class="col-sm-12 col-lg-8">
								<label class="font-weight-bold">CEP</label> <input type="text"
									class="form-control" value="${cep}" placeholder="">
							</div>

							<div class="col-sm-12 col-lg-4">
								<label class="font-weight-bold">Valor Frete</label> <input
									type="text" class="form-control" value="${valorfrete}"
									placeholder="">
							</div>

							<div class="col-sm-12 col-lg-6 mt-3">
								<label class="font-weight-bold">Complemento</label> <input
									type="text" class="form-control" value="${complemento}"
									placeholder="">
							</div>

							<div class="col-sm-12 col-lg-6 mt-3">
								<label class="font-weight-bold">Destinatario</label>
								<input type="text" class="form-control" name="destinatario" placeholder="">
							</div>

							<div class="col-sm-12 col-lg-12 mt-3">
								<label class="font-weight-bold">Endereço</label> <input
									type="text" class="form-control" value="${endereco}"
									placeholder="">
							</div>

							<div class="col-sm-12 col-lg-4 mt-3">
								<label class="font-weight-bold">Número</label> <input
									type="text" class="form-control" value="${numero}"
									placeholder="">
							</div>

							<div class="col-sm-12 col-lg-8 mt-3">
								<label class="font-weight-bold">Bairro</label> <input
									type="text" class="form-control" value="${bairro}"
									placeholder="">
							</div>

							<div class="col-sm-12 col-lg-6 mt-3">
								<label class="font-weight-bold">Cidade</label> <input
									type="text" class="form-control" value="${cidade}"
									placeholder="">
							</div>

							<div class="col-sm-12 col-lg-6 mt-3">
								<label class="font-weight-bold">Estado</label> <input
									type="text" class="form-control" value="${estado}"
									placeholder="">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-12 mt-3">
				<div class="card">
					<div class="card-body">
						<form action="Pedido" method="post">
							<button type="submit" data-toggle="modal" class="btn btn-danger btn-lg float-right">Finalização de Compra</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>

	<c:import url="resources/template/footer.jsp"/>

	<!-- MODAL PARA EXCLUSÃO DA LISTA DE PRODUTOS -->
<div class="modal fade" id="mensagemcarrinho" tabindex="" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
    <div class="modal-header">
        <h5 class="modal-title">Lista dos seus produtos</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <h4 class="center" id="textcarrinho">
        	
        </h4>
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>