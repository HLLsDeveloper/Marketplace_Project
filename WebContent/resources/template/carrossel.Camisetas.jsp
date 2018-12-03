<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- CARROSSEL DE PRODUTOS -->
<div class="owl-carousel owl-theme">
	<c:forEach  var="lista"  items="${lista_produto}">
		<div class="owl-item active">
			<div class="card">
			    <img class="mt-3 mx-auto d-block " src="resources/img/img-produtos/${lista.imagem}" height="300">
				<div class="card-body">
			    	<h4 class="card-title letramaiucula text-center">${lista.produto}</h4>
				</div>
				<c:if test="${lista.quantidadetotal > 0}">
					<ul class="list-group list-group-flush text center">
						<li class="product-price">${lista.valor_venda_fr}</li>
					</ul>
				    <div class="btn-group card-body mx-auto d-block mt-4">
				    	<form>
				    		<input name="referencia" value="${lista.referencia}" type="hidden">
							<button type="submit" formaction="Descricao" formmethod="get" class="btn btn-success btn-lg btn_sh btn_tam">Comprar</button>
				    	</form>
				    </div>
			    </c:if>
			    <c:if test="${lista.quantidadetotal <= 0}">
					<div class="btn-group card-body mx-auto d-block mt-1">
						<form>
							<input name="referencia" value="${lista.referencia}" type="hidden">
							<button type="submit" formaction="Descricao" formmethod="get" class="btn-outline-danger alert alert-danger border-0">Avise quando chegar!</button>						
						</form>
			    	</div>
			    </c:if>
		    </div>
		</div>
	</c:forEach>    
</div>

<!-- CONFIGURAÇÕES DO CARROSSEL -->
<script type="text/javascript" src="resources/js/owlcarousel/conf.owl.carousel.js"></script>