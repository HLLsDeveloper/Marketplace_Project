<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Carrinho</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">

<script src="resources/js/jquery/jquery.min.js"></script>
<script src="resources/js/bootstrap/popper.min.js"></script>
<script src="resources/js/bootstrap/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="resources/template/nav.jsp" />

	<div class="header-site">
		<div class="container">
			<div class="content-wrapper p-4 mx-5">
				<div class="container-fluid">
					<div class="card">
						<div class="card-header">
							<h5>Carrinho</h5>
						</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-bordered" id="dataTable">
										<thead>
											<tr>
												<th>Imagem</th>
												<th>Produto</th>
												<th>Tamanho</th>
												<th>Quantidade</th>
												<th>Valor Unitário</th>
												<th>Excluir</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="carrinho" items="${carrinho}">
											<form>
												<input type="hidden" name="id" value="${carrinho.idproduto}">
												<tr>
													<td><img height="80" src="resources/img/img-produtos/<c:out value="${carrinho.imagem}"></c:out>"></td>
													<td>${carrinho.produto}</td>
													<td>${carrinho.tamanho}</td>
													<td>
														<div class="input-group">
															<button class="btn btn-dark amount my-auto mr-1" type="submit" formaction="Carrinho" formmethod="post" name="amount" value="anyless">
																<p class="text-white btn-smalleramount">-</p>
															</button>
															<input type="text" class="form-control text-center" name="quantidade_dig" value="${carrinho.quantidade_dig}" min="1" max="${carrinho.quantidade}" style="width: 30px;">
															<button class="btn btn-dark amount my-auto ml-1" type="submit" formaction="Carrinho" formmethod="post" name="amount" value="more">
																<p class="btn-greateramount text-white">+</p>
															</button>
														</div>
													</td>
													<td>${carrinho.valor_venda}</td>
													<td>
														<button class="btn btn-success d-block mx-auto" formaction="ExcluirCarrinho" formmethod="post" type="submit">Excluir</button>
													</td>
												</tr>
											</form>
											</c:forEach>
										</tbody>
									</table>							
								</div>
							</div>

							<!--RODAPE CARRINHO-->
							<div class="row pr-4">
								<div class="col-5 ml-auto">
									<ul class="list-group list-group-flush">
										<li class="list-group-item disabled">Detalhes:</li>
									  	<li class="list-group-item">Quantidade:<strong> ${contador}</strong></li>
									  	<li class="list-group-item">Valor Total:<strong> ${valortotal}</strong></li>
									</ul>
								</div>
							</div>
							
							<div class="card-footer small text-muted float-right">					
								<form>
									<div class="small text-muted">
										<button type="submit" class="btn btn-danger btn-lg float-left" formaction="Home">Continuar Comprando</button>
										<button type="submit" class="btn btn-danger btn-lg float-right" formaction="Enderecos">Finalizar Compra</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


	<c:import url="resources/template/footer.jsp" />
</body>
</html>