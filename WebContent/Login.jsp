<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>Realize o Login com seu e-mail - T-Shirt Games</title>
	<meta http-equiv="Content-Type" content="text/html">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  
	<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
	
	<script src="resources/js/jquery/jquery.min.js" type="text/javascript"></script>
	<script src="resources/js/bootstrap/popper.min.js" type="text/javascript"></script>
	<script src="resources/js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="resources/js/script.ExibirModal.js"></script>
	<script type="text/javascript" src="resources/js/script.LoginFace.js" ></script>
</head>
<body>

<!-- NAVBAR -->
<c:import url="resources/template/nav.jsp"/>

	<section id="form_login" class="container">
        <div class="col-lg-12 offset-lg-2">
           <!-- INICIO DO FORMULÁRIO -->
           <form>
                <div class="row">
                	<h2 class="text-center col-8 mb-5">Login:</h2>
                    <div class="col-lg-8 mx-auto" >
                        <div class="form-group col-md-6">
                            <label for="login_email">Email:</label>
                            <input type="email" class="form-control" name="email" id="login_email" aria-describedby="login_email_ajuda" placeholder="" required>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="login_senha">Senha do seu usuário</label>
                            <input type="password" class="form-control" id="login_senha" name="senha" placeholder="" required>
                            <small id="login_email_ajuda" class="form-text text-muted">Nunca compartilharemos.</small>
                        </div>
                        <div class="form-group col-md-6">
	                        <button id="login_button" type="submit" formaction="Login" formmethod="post" class="btn btn-primary btn-lg btn-block mt-5 color-btn">Continuar</button>
	                        <hr>
	                        	  
	                          <!-- Facetruck Botao -->                      
							<div class="fb-login-button"  data-size="large" data-button-type="login_with" data-show-faces="false" data-auto-logout-link="false" data-use-continue-as="true"></div>	                        
	                        
	                        <p class="text-center cadastrar">Não tem cadastro?<a href="CadastroFisico.jsp">Cadastre-se</a></p>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </section>
        
	<!-- NAVBAR -->
	<c:import url="resources/template/footer.jsp"/>
	<c:import url="resources/template/modal.Mensagem.jsp"/>
</body>
</html>