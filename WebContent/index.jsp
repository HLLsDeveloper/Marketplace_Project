<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>Bem vindo a T-Shirt Games</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="resources/css/owlcarousel/owl.carousel.css">
    <link rel="stylesheet" href="resources/css/owlcarousel/owl.theme.default.css">
	
	<script type="text/javascript" src="resources/js/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap/popper.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/owlcarousel/owl.carousel.js"></script>
</head>
<body>
	<c:import url="resources/template/nav.jsp"/>
	<div id="carouselSite" class="carousel slide">   
	    <ol class="carousel-indicators">
	      <li data-forget="#carouselSite" data-slide="0" class="active"></li>
	      <li data-forget="#carouselSite" data-slide="1"></li>
	      <li data-forget="#carouselSite" data-slide="2"></li>
	    </ol>
	
	<div class="carousel-inner">
		 <div class="carousel-item active">
		     <img src="resources/img/banner-1-col-12.png"class="w-100 d-block">
		 </div>
		
		 <div class="carousel-item">
		     <img src="resources/img/banner-2-col-12.png" class="w-100 d-block">
		 </div>
		
		 <div class="carousel-item">
		     <img src="resources/img/banner-3-col-12.jpg" class="w-100 d-block">
		 </div>
	</div>
	
	    <a class="carousel-control-prev" href="#carouselSite" role="button" data-slide="prev">
	        <span class="carousel-control-prev-icon"></span>
	        <span class="sr-only">Anterior</span>
	    </a>
	
	    <a class="carousel-control-next" href="#carouselSite" role="button" data-slide="next">
	        <span class="carousel-control-next-icon"></span>
	        <span class="sr-only">Avançar</span>
		</a>
	</div>
	
    <section class="info">
      <div class="container ">
          <div class="row">
              <div class="col-xs-6 col-sm-6 col-md-4 clearfix text-center textoundercarousel logosvg my-3">
                  <div class="item-container">
                      <img src="resources/img/icones/icon-frete.png">
                      <div>
                          <h2>SITE 100% SEGURO</h2>
                          <p>Site com certificado digital. <span class="line-break"></span></p>
                      </div>
                  </div>
              </div>
              <div class="col-xs-6 col-sm-6 col-md-4 clearfix text-center textoundercarousel logosvg my-3">
                  <div class="item-container">
                      <img src="resources/img/icones/icon-atendimento.png">
                      <div>
                          <h2>SATISFAÇÃO GARANTIDA</h2>
                          <p>Ou seu dinheiro de volta,<span class="line-break"></span></p>
                      </div>
                  </div>
              </div>
              <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-0 clearfix text-center textoundercarousel logosvg my-3">
                  <div class="item-container">
                      <img src="resources/img/icones/icon-24h.png">
                      <div>
                          <h2>Pagamento Facilitado</h2>
                          <p>Pague via boleto <span class="line-break"></span>sem dor de cabeça</p>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  	</section>
<<<<<<< HEAD
  	<section class="header-site">
=======
  	<section class="header-site pb-4 ">
>>>>>>> 782a62c44097715f370b903efa46ab00379ae0f2
	    <div class="container">
		   	<div class="row mb-3">
		        <div class="col-sm-12">
		          <h2 class="title line-title   border-bottom mt-4 ">Mais vendidos</h2>
		    	</div>
		    	
		    	<c:import url="resources/template/carrossel.Camisetas.jsp"/>
			</div>
		</div>
	</section> 

  	<section class="bordasection">
		<div class="container">
		  <div class="row mt-3">	
		    <div class="col-xs-6  col-md-3 my-3 text-center">
		      <a href="http://localhost:8080/TShirtGames/LinkProduto?busca=Series">
		        <img class="img-fluid mx-auto d-block" src="resources/img/utilitarios/footerseries.png" alt="Card image cap">
		       </a>     
		    </div>
		
		    <div class="col-xs-6  col-md-3 my-3">
		      <a href="http://localhost:8080/TShirtGames/LinkProduto?busca=Animes">
		        <img class="img-fluid mx-auto d-block" src="resources/img/utilitarios/footeranimes.png" alt="Card image cap">
		       </a>     
		    </div>
		
		    <div class="col-xs-6  col-md-3 my-3">
		      <a href="http://localhost:8080/TShirtGames/LinkProduto?busca=Filmes">
		        <img class="img-fluid mx-auto d-block" src="resources/img/utilitarios/footerfilmes.png" alt="Card image cap">
		       </a>     
		    </div>
		
		    <div class="col-xs-6  col-md-3 my-3">
		      <a href="http://localhost:8080/TShirtGames/LinkProduto?busca=Games">
		        <img class="img-fluid mx-auto d-block" src="resources/img/utilitarios/footergames.png" alt="Card footergames">
		       </a>     
		    </div>
		  </div>
		</div>
	</section>
	<c:import url="resources/template/footer.jsp"></c:import>
</body>
</html>