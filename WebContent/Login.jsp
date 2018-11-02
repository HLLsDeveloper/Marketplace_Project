<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>Realize o Login com seu e-mail - T-Shirt Games</title>
	<meta http-equiv="Content-Type" content="text/html">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  
	<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
	<link rel="stylesheet" href="resources/css/style.home.css">
    <link rel="stylesheet" href="resources/css/owl.carousel.css">
    <link rel="stylesheet" href="resources/css/owl.theme.default.css">
	<link rel="stylesheet" href="resources/css/style.cadastro-fisico.css">
	<link rel="stylesheet" href="resources/css/style.cadastro-produto.css">
	<link rel="stylesheet" href="resources/css/style.cadastro-juridico-login.css">
  
  	<script src="resources/js/jquery.min.js"></script>
  	<script src="resources/js/popper.min.js"></script>
  	<script src="resources/js/bootstrap.min.js"></script>
  	<script src="resources/js/script.js"></script>
	<script src="resources/js/script-cadastro_produto.js"></script>
</head>
<body>

<!-- NAVBAR -->
<c:import url="resources/template/nav.jsp"/>

	<section id="form_login" class="header-site py-5">
	 <div class="container ">
	
        <div class="col-md-8 mx-auto ">
           <!-- INICIO DO FORMULÁRIO -->
           <form>
            <div class="card">
                <div class="">
                	<h2 class="text-center ">Login:</h2>
                    <div class="col-lg-8 mx-auto" >
                        <div class="form-group ">
                            <label for="login_email">Email:</label>
                            <input type="email" class="form-control" name="email" id="login_email" aria-describedby="login_email_ajuda" placeholder="" required>
                        </div>
                        <div class="form-group ">
                            <label for="login_senha">Senha do seu usuário</label>
                            <input type="password" class="form-control" id="login_senha" name="senha" placeholder="" required>
                            <small id="login_email_ajuda" class="form-text text-muted">Nunca compartilharemos.</small>
                        </div>
                        <div class="form-group ">
	                        <button id="login_button" type="submit" formaction="Login" formmethod="post" class="btn btn-primary btn-lg btn-block mt-5 color-btn">Continuar</button>
	                        <hr>
	                        <p class="text-center cadastrar">Não tem cadastro?<a href="CadastroFisico.jsp">Cadastre-se</a></p>
                        </div>
                    </div>
                </div>
                   </div>
            </form>
        </div>
       </div>
       
    
    </section>
    
    <!-- MODAL PARA MOSTRAR SE FOI ADICIONADO NO CARRINHO OU NÃO -->
<div class="modal fade" id="mensagem" tabindex="" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
    <div class="modal-header">
        <h5 class="modal-title">Carrinho</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <h4 class="center" id="textcarrinho">
        	<c:out  value="${mensagem}"></c:out>
        </h4>
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
    
<!-- NAVBAR -->
<c:import url="resources/template/footer.jsp"/>

</body>
</html>