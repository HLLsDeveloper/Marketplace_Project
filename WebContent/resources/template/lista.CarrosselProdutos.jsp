<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="owl-carousel owl-theme ">
	<form>
		<c:forEach  var="lista"  items="${lista_produto}">
			<div class="owl-item active">
				<div class="card">
				    <img class="w-100 h-50 mt-3 mx-auto d-block " src="resources/img/img-produtos/${lista.imagem}">
				<div class="card-body">
			    	<h4 class="letramaiucula text-center" style="font-size: 1rem;">${lista.produto}</h4>
				</div>
				<ul class="list-group list-group-flush text center">
					<li class="product-price">R$ ${lista.valor_venda}</li>
				</ul>
				
			    <div class="btn-group card-body mx-auto d-block mt-4">
			    	<input name="id" value="${lista.idproduto}" class="d-none">
					<button type="submit" formaction="Produto" formmethod="get" class="btn btn-success btn-lg btn_sh btn_tam">Comprar</button>
				    <button type="button" class="btn btn-outline-danger btn-lg btn_cor btn_sh border-0">♥</button></div>
			    </div>
			</div>
		</c:forEach>
	</form>       
</div>

<script type="text/javascript">



</script>

</body>
</html>