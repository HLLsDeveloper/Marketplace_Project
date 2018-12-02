<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Realize o Login - T-Shirt Games</title>
    <meta http-equiv="Content-Type" content="text/html">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="resources/css/style.ValidateLogin.css"> 
    <script  type="text/javascript" src="resources/js/jquery/jquery.min.js"></script>
    <script  type="text/javascript" src="resources/js/bootstrap/popper.min.js"></script>
    <script  type="text/javascript" src="resources/js/bootstrap/bootstrap.min.js"></script>    
    <script  type="text/javascript" src="resources/js/jquery/jquery.validate.js"></script>
    <script  type="text/javascript" src="resources/js/script.ValidateLogin.js"></script>    
    <script  type="text/javascript" src="resources/js/script.ExibirModal.js"></script>
    <script  type="text/javascript" src="resources/js/script.LoginFace.js"></script>
</head>

<body>
    <c:import url="resources/template/nav.jsp" />
	
	<div class="header-site">
    	<section id="form_login" class="container">
        	<div class="col-12">
        	
				<form id="LoginValidate" accept-charset="ISO-8859-1">
			    	<div class="row">               
			        	<div class="card col-md-5 mx-auto">
			            	<div class="card-body">
			                	<h2 class="text-center">Login:</h2>
			                    <div class="col">
			                        <div class="form-group">
			                            <label for="login_email">E-mail:</label>
			                            <input type="email" class="form-control" name="login_email" id="login_email" aria-describedby="login_email_ajuda" required>			                        
			                            <label for="login_senha">Senha:</label>
			                            <input type="password" class="form-control" name="login_senha" id="login_senha" required>
			                         	<small id="login_email_ajuda" class="form-text text-muted">Nunca compartilhe sua senha!</small>
			                         </div>
			                         <div class="form-group">
			                            <button id="login_button" type="submit" formaction="Login" formmethod="post" class="btn btn-lg btn-block btn-tshirt">Continuar</button>
			                            <hr>                   
										<!-- Facetruck Botao <div class="fb-login-button"  data-size="large" data-button-type="login_with" data-show-faces="false" data-auto-logout-link="false" data-use-continue-as="true"></div>-->
			                            <p class="text-center cadastrar">Não é cadastrado?<a href="CadastroFisico"> Cadastre-se</a></p>
			                        </div>
			                    </div>
			              	</div>
			          	</div>
			        </div>
			 	</form>
       		</div>
    	</section>
    </div>

    <c:import url="resources/template/footer.jsp" />
    <c:import url="resources/template/modal.Mensagem.jsp" />
</body>
</html>