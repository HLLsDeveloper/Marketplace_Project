<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<?xml version="1.0" encoding="utf-8"?>

<link rel="stylesheet" href="resources/css/style.Principal.css">
<link rel="stylesheet" href="resources/css/owlcarousel/owl.carrinho.css">
<link rel="stylesheet" href="resources/css/owlcarousel/owl.theme.carrinho.css">

<script type="text/javascript" src="resources/js/script.Nav.js"></script>
<script type="text/javascript" src="resources/js/owlcarousel/owl.carrinho.js"></script>

<!-- NAV -->
<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
	<div class="container">	
		<a href="http://localhost:8080/TShirtGames/Home"><img src="resources/img/logo.png" class="d-inline-block align-top logo-size" width="40" height="40" alt=""></a>  
		
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>
  		
		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
        	<form class="form-inline ml-auto my-2 my-lg-0" action="Busca" >
                <input name="pesquisa" class="form-control search-text" type="text" placeholder="Search" aria-label="Search">                
                <button class="btn my-3 mr-1 my-sm-0 btn-tshirt" type="submit"><img src="resources/img/icones/search.svg" width="20" height="25" alt="procurar"></button>
            </form>
            
            <ul class="nav form-inline my-2 my-lg-0">
            	<c:if test="${not empty idsessaouser}">
              	<li class="nav-item">
              		<c:if test="${contador le 0 or empty contador}">
	                	<div class="my-sm-0 font-weight-bold text-light btn btn-dark" role="button" aria-haspopup="true" aria-expanded="false" data-toggle="modal" data-target=".bd-example-modal-lg">
		                	<img src="resources/img/icones/Shopping-cart.png" width="25" height="25" alt="Carrinho">
		                	<span class="badge badge-pill badge-tshirt"><c:out value="0"></c:out></span>
	                	</div>
                	</c:if>
                	<c:if test="${contador gt 0}">
	                	<div class="drop">
	                		<div class="font-weight-bold text-light btn btn-dark" onclick="tohide()">
			                	<img src="resources/img/icones/Shopping-cart.png" width="25" height="25" alt="Carrinho">
			                	<span class="badge badge-pill badge-tshirt"><c:out value="${contador}"></c:out></span>
		                	</div>
		                	<div class="dropdown-pers">
		                		<c:import url="resources/template/carrossel.Carrinho.jsp"/>
		                	</div>
	                	</div>
	                </c:if>
              	</li>
              </c:if>
              <c:if test="${not empty idsessaouser}">
              	<li class="nav-item dropdown">
                <c:if test="${not empty nomeuser}">
                	<a class="nav-link btn btn-dark dropdown-toggle font-weight-bold text-light" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><strong class="mr-2"><c:out value="Olá, ${nomeuser}"></c:out></strong><img src="resources/img/imagens/${imagemuser}" class="d-inline-block minhaconta-size" width="45" height="45" style="border-radius: 50%;"></a>
                </c:if>
                <c:if test="${empty nomeuser}">
                	<a class="nav-link btn btn-dark dropdown-toggle font-weight-bold text-light" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><strong class="mr-2"><c:out value="${nomefantasiauser}"></c:out></strong><img src="resources/img/imagens/${logouser}" class="d-inline-block minhaconta-size" width="30" height="30"></a>
                </c:if>
                <div class="dropdown-menu">
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="#">Meus Dados</a>
                  <a class="dropdown-item" href="http://localhost:8080/TShirtGames/InserirProduto">Cadastrar Produto</a>
                  <a class="dropdown-item" href="http://Localhost:8080/TShirtGames/CadastroFisico">Cadastro Físico</a>                  
                  <a class="dropdown-item" href="http://Localhost:8080/TShirtGames/CadastroJuridico">Cadastro Jurídico</a>
                  <a class="dropdown-item" href="http://localhost:8080/TShirtGames/GerenciamentoEstoque">Gerenciamento Estoque</a>                  
                  <a class="dropdown-item" href="http://localhost:8080/TShirtGames/GerenciamentoFisico">Gerenciamento Fisico</a>

                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="http://localhost:8080/TShirtGames/Logout">Sair</a>
                </div>
              </li>
              </c:if>
              <c:if test="${empty idsessaouser}">
              	<li class="nav-item">
	               <a class="nav-link font-weight-bold text-light" href="Login"><img src="resources/img/icones/logout.svg" class="mr-1" width="20" height="20">LOGIN</a>
	            </li>
              </c:if>
            </ul>
    	</div>
	</div>
      
    <input type="checkbox" id="checar">
    <label class="menu" for="checar">
	<span class="acao-menu"></span>
   	</label>
 	<a href="#"><img class="item d-lg-none" id="item-1"></a>
   	<a href="#"><img class="item d-lg-none" id="item-2"></a>
	<a href="#"><img class="item d-lg-none" id="item-3"></a>
</nav>
