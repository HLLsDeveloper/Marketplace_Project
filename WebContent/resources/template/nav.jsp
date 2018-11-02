<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="resources/css/style.Principal.css">
<script type="text/javascript" src="resources/js/script.Nav.js"></script>

<!-- NAV -->
<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top ">
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
            
            <ul class="nav nav-pills">
              <li class="nav-item ">
                <a class="nav-link dropdown-toggle font-weight-bold text-light" href="http://localhost:8080/TShirtGames/Carrinho" role="button" aria-haspopup="true" aria-expanded="false"><img src="resources/img/icones/Shopping-cart.png" width="20" height="20" alt="Carrinho"> <span class="badge badge-pill badge-danger">3</span></a>
              </li>
              
              <c:if test="${not empty idsessao}">
              	<li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle font-weight-bold text-light" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><strong class="mr-2"><c:out value="Olá ${nome}"></c:out></strong><img src="resources/img/icones/user.svg" class="d-inline-block minhaconta-size" width="30" height="30"></a>
                <div class="dropdown-menu">
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="#">Meus Dados</a>
                  <a class="dropdown-item" href="http://localhost:8080/TShirtGames/InserirProduto.jsp">Cadastrar Produto</a>
                  <a class="dropdown-item" href="http://localhost:8080/TShirtGames/GerenciamentoEstoque.jsp">Gerenciamento Estoque</a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="http://localhost:8080/TShirtGames/Login">Sair</a>
                </div>
              </li>
              </c:if>
              <c:if test="${empty idsessao}">
              	<li class="nav-item">
	               <a class="nav-link font-weight-bold text-light" href="http://localhost:8080/TShirtGames/Login.jsp"><img src="resources/img/icones/logout.svg" class="mr-1" width="20" height="20">LOGIN</a>
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