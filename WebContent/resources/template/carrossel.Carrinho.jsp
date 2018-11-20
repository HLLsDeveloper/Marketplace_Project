<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3 class="text-center mb-0 p-3">Carrinho</h3>
<div class="owl-carrinho owl-carrinhotheme">
	<c:forEach var="carrinho" items="${carrinho}">
		<div class="owl-item active">
			<div class="card d-inline-block w-100">
				<div class="row">
					<div class="col-sm-5">
						<img height="180" width="160" src="resources/img/img-produtos/<c:out value="${carrinho.imagem}"></c:out>">
					</div>
					<div class="col-sm-7">
						<div class="text-left">
							<div class="d-block mt-2">
								<small class="d-block line"><b>Produto:</b></small>
								<p class="ml-3 line"><small>${carrinho.produto}</small></p>
							</div>
							<div class="d-block mt-2">
								<small class="d-inline line"><b>Tamanho:</b></small>
								<p class="d-inline ml-1 line"><small>${carrinho.tamanho}</small></p>
							</div>
							<div class="d-block mt-2">
								<small class="d-inline line"><b>Quantidade:</b></small>
								<p class="d-inline ml-1 line"><small>${carrinho.quantidade_dig}</small></p>
							</div>
							<div class="d-block mt-2">
								<small class="d-inline line"><b>Valor:</b></small>
								<p class="d-inline ml-1 line"><small>R$${carrinho.valor_venda}</small></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<div class="dropdown-divider"></div>
<div class="">
	<a  class="text-center" href="Carrinho" title="Clique aqui para alterar os produtos do carrinho">
		<button class="btn btn-dark w-100 edit p-3">
			<svg xmlns="http://www.w3.org/2000/svg" width="30" viewBox="0 0 8 8">
			  <path fill="white" d="M6 0l-1 1 2 2 1-1-2-2zm-2 2l-4 4v2h2l4-4-2-2z" />
			</svg>
		</button>
	</a>
</div>

<!-- CONFIGURAÇÕES DO CARROSSEL -->
<script type="text/javascript" src="resources/js/owlcarousel/conf.owl.carrinho.js"></script>