<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>Carrinho</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">

	<script type="text/javascript" src="resources/js/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap/popper.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/script.FormatacaoCampos.js"></script>
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
											<c:if test="${not empty carrinho}">
											<c:forEach var="carrinho" items="${carrinho}">
											<form>
												<input type="hidden" name="id" value="${carrinho.idproduto}">
												<tr>
													<td class="align-middle"><img height="80" src="resources/img/img-produtos/<c:out value="${carrinho.imagem}"></c:out>"></td>
													<td class="align-middle">${carrinho.produto}</td>
													<td class="align-middle text-center">${carrinho.tamanho}</td>
													<td class="align-middle">
														<div class="input-group">
															<button class="btn btn-dark amount my-auto mr-1" type="submit" formaction="Carrinho" formmethod="post" name="amount" value="anyless">
																<p class="text-white btn-smalleramount">-</p>
															</button>
															<input type="text" class="form-control text-center" name="quantidade_dig" onkeypress="return ApenasNumeros(event)" value="${carrinho.quantidade_dig}" min="1" max="${carrinho.quantidade}" style="width: 30px;" disabled>
															<button class="btn btn-dark amount my-auto ml-1" type="submit" formaction="Carrinho" formmethod="post" name="amount" value="more">
																<p class="text-white btn-greateramount">+</p>
															</button>
														</div>
													</td>
													<td class="align-middle text-center">${carrinho.valor_venda}</td>
													<td class="align-middle">
														<button class="btn btn-link d-block mx-auto" formaction="ExcluirCarrinho" formmethod="post" type="submit"><img src="resources/img/icones/trash.svg"></button>
													</td>
												</tr>
											</form>
											</c:forEach>
											</c:if>
											<c:if test="${empty carrinho}">
												<td colspan="6"><p class="text-center m-4 h5">Seu carrinho está vazio...<br>clique em <strong>continuar comprando</strong> para adicionar produtos!</p></td>
											</c:if>
										</tbody>
									</table>							
								</div>
							</div>
						</div>
						<div class="card">
							<!--RODAPE CARRINHO-->
							<div class="row pr-4 m-4">
								<div class="col-5 ml-auto">
									<ul class="list-group">
										<li class="list-group-item disabled">Detalhes:</li>
									  	<li class="list-group-item">Quantidade:<strong> ${contador}</strong></li>
									  	<li class="list-group-item">Valor Total:<strong> ${valortotal}</strong></li>
									</ul>
								</div>
							</div>
						
							<div class="card-footer text-muted float-right">					
								<form>
									<div class="small text-muted">
										<button type="submit" class="btn btn-warning float-left" formaction="Home"><img src="resources/img/icones/home.svg"> <strong>Continuar comprando</strong></button>
										<button type="submit" class="btn btn-success float-right" formaction="Enderecos"><img src="resources/img/icones/circle-check.svg"> <strong>Continuar compra</strong></button>
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