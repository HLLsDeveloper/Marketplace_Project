<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- MODAL MENSAGEM CADASTRO DO PRODUTO -->
<div class="modal fade" id="message" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-body">
      	<input id="mensagem" type="hidden" value="${mensagem}">
        	<div class="card">
				<div class="card-header">
					<h5>Carrinho</h5>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<h5>${mensagem}</h5>						
						<table class="table table-bordered" id="dataTable">
							<thead>
								<tr>
									<th>Imagem</th>
									<th>Produto</th>
								</tr>
							</thead>
							<tbody> 
								<tr>
									<td class="align-middle"><img height="80" src="resources/img/img-produtos/${imagem}"></td>
									<td class="align-middle">${produto}</td>
								</tr>			
							</tbody>
						</table>							
					</div>
				</div>
			</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" data-dismiss="modal">Ok</button>
      </div>
    </div>
  </div>
</div>