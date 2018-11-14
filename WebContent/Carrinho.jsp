<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Carrinho</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="resources/css/owlcarousel/owl.carousel.css">
<link rel="stylesheet"
	href="resources/css/owlcarousel/owl.theme.default.css">

<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/jquery/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="resources/template/nav.jsp" />

	<div class="header-site">
		<div class="container ">
			<div class="content-wrapper p-4 mx-5">
				<div class="container-fluid">
					<div class="card">
						<div class="card-header">
							<i class="fa fa-table"></i>Carrinho
						</div>
						<!-- tabela do carrinho -->
						<form>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-bordered" id="dataTable">
										<thead>
											<tr>
												<th>IMAGEM</th>
												<th>PRODUTO</th>
												<th>TAMANHO</th>
												<th>QUANTIDADE</th>
												<th>VALOR UNITÁRIO</th>
												<th>EXCLUIR</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="carrinho" items="${carrinho}">
											<input type="hidden" name="id" value="${carrinho.idproduto}">
												<tr>
													<td><img height="80"
														src="resources/img/img-produtos/<c:out value="${carrinho.imagem}"></c:out>"></td>
													<td><c:out value="${carrinho.produto}"></c:out></td>
													<td><c:out value="${carrinho.tamanho}"></c:out></td>
													<td><input type="number" name="quantidade" min="1" max="${carrinho.quantidade}"></td>
													<td><c:out value="${carrinho.valor_venda}"></c:out></td>
													<td>
														<button name="excluir" value="${carrinho.idproduto}" class="btn btn-success d-block mb-1 mx-auto" formaction="ExcluirCarrinho" formmethod="post" type="submit">Excluir</button>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<h1>
										<c:out value="${valortotal}"></c:out>
									</h1>
								</div>
							</div>

							<!--RODAPE CARRINHO-->
							<div class="card-footer  small text-muted ">
								<div class="container-fluid ">
									<div class="row">
										<div class="col-xs-6 ">Produto(s)</div>
										<div class="col-xs-6 ">1</div>
									</div>
									<div class="row">
										<div class="col-xs-6">Valor</div>
										<input type='hidden' value='' />
										<div class="col-xs-6">R$ 724,50</div>
									</div>
									<div class="row">
										<div class="col-xs-6">Frete</div>
										<div class="col-xs-6" id='divValorFreteCarrinho'>A
											calcular</div>
									</div>
									<div class="row">
										<div class="col-xs-6">Peso</div>
										<div class="col-xs-6">4,420</div>
									</div>
									<div class="row primary-color">
										<div class="col-xs-6">Total</div>
										<div class="col-xs-6" id='divValorTotalGeralCarrinho'>R$
											724,50</div>
									</div>
								</div>
							</div>

							<!--FIM RODAPE CARRINHO-->

							<div class="card-footer small text-muted">
								<button type="submit" data-toggle="modal" data-target="#" class="btn btn-danger btn-lg float-left" formaction="Home">Continuar Comprando</button>
								<button type="submit" data-toggle="modal" data-target="#" class="btn btn-danger btn-lg float-right" formaction="Enderecos">Finalizar Compra</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<c:import url="resources/template/footer.jsp" />
</body>
</html>