<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- MODAL LISTA DE PRODUTOS -->
<div class="modal fade" id="ListaProdutos" tabindex="" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
	     <div class="modal-body">
	       <h5 class="center">Lista de Produtos</h5>
	       <table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Produto</th>
			      <th scope="col">Imagem</th>
			      <th scope="col">Buscar</th>
			    </tr>
			  </thead>
			  <tbody id="lista_produto">
			    <!-- CONTEÚDO DA LISTA DE PRODUTO  -->
			  	<c:forEach var="lista" items="${lista_produto}">
				    <tr> <!-- data-dismiss="modal" -->
			      		<th class="align-middle" id="${lista.idproduto}" scope="row">${lista.idproduto}</th>
			      		<td class="align-middle col-2">${lista.produto}</td>
			      		<td class="align-middle"><img class="img-fluid w-100" src="resources/img/img-produtos/${lista.imagem}"></td>
			      		<td class="align-middle center"><a style="text-decoration: none;" href="http://localhost:8080/TShirtGames/AlterarProduto?idproduto=${lista.idproduto}">🔍</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>	  
		   </table>
	    </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-tshirt" data-dismiss="modal">Fechar</button>
      </div>
    </div>
  </div>
</div>