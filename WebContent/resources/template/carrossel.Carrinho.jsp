<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>Carrinho</h3>
<div class="owl-carrinho owl-carrinhotheme">
	<c:forEach var="carrinho" items="${carrinho}">
		<div class="owl-item active">
			<div class="card d-inline-block">
				<div class="row">
					<div class="col-sm-5">
						<img height="180" width="160" src="resources/img/img-produtos/<c:out value="${carrinho.imagem}"></c:out>">
					</div>
					<div class="col-sm-6">
						<div class="text-left">
							<div class="d-block mt-2">
								<small class="d-block line"><b>Produto:</b></small>
								<p class="ml-3 line">${carrinho.produto}</p>
							</div>
							<div class="d-block mt-2">
								<small class="d-inline line"><b>Tamanho:</b></small>
								<p class="d-inline ml-1 line">${carrinho.tamanho}</p>
							</div>
							<div class="d-block mt-2">
								<small class="d-inline line"><b>Quantidade:</b></small>
								<p class="d-inline ml-1 line">${carrinho.quantidade_dig}</p>
							</div>
							<div class="d-block mt-2">
								<small class="d-inline line"><b>Valor:</b></small>
								<p class="d-inline ml-1 line">R$${carrinho.valor_venda}</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<div>
	<button class="btn btn-tshirt edit">
		<img src="resources/img/icones/edit.png">
	</button>
</div>

<!-- CONFIGURAÇÕES DO CARROSSEL -->
<script type="text/javascript" src="resources/js/owlcarousel/conf.owl.carrinho.js"></script>