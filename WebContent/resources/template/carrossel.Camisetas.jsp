<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- CARROSSEL DE PRODUTOS -->
<div class="owl-carousel owl-theme">
	<c:forEach  var="lista"  items="${lista_produto}">
		<div class="owl-item active">
			<div class="card">
			    <img class="  mt-3 mx-auto d-block " src="resources/img/img-produtos/${lista.imagem}" height="300">
			<div class="card-body">
		    	<h4 class="card-title letramaiucula text-center">${lista.produto}</h4>
			</div>
			<ul class="list-group list-group-flush text center">
				<li class="product-price">R$ ${lista.valor_venda}</li>
			</ul>
		    <div class="btn-group card-body mx-auto d-block mt-4">
		    	<form>
		    		<input name="referencia" value="${lista.referencia}" type="hidden">
					<button type="submit" formaction="Descricao" formmethod="get" class="btn btn-success btn-lg btn_sh btn_tam">Comprar</button>
			    	<button type="button" class="btn btn-outline-danger btn-lg btn_cor btn_sh border-0">♥</button>
		    	</form>
		    </div>
		    </div>
		</div>
	</c:forEach>    
</div>