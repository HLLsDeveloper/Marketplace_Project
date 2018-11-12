<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- FOOTER -->
<footer class="page-footer bg-dark text-white">
    <div class="container text-center">
      <div class="row text-center text-md-left">
        <div class="col-md-4 mx-auto mt-3">
          <h6 class="text-uppercase mb-4 font-weight-bold text-tshirt">T-Shirt</h6>
          <p>Nossa loja é mais do que apenas uma loja de camisetas. Nós vendemos não só produtos de alta qualidade, mas sim queremos dar aos nossos clientes uma experiência positiva de atendimento.</p>
        </div>

        <hr class="w-100 clearfix d-md-none">
	
        <div class="col-sm-2 mx-auto mt-3">
          <h6 class="text-uppercase mb-4 font-weight-bold text-tshirt">Produtos</h6>
          <p><a class="text-white" href="http://localhost:8080/Crash_Solutions_Web/LinkProduto?busca=Masculino">Masculino</a></p>
          <p><a class="text-white" href="http://localhost:8080/Crash_Solutions_Web/LinkProduto?busca=Feminino">Feminino</a></p>
        </div>
        <div class="col-sm-2 mx-auto mt-3">
          <h6 class="text-uppercase mb-4 font-weight-bold text-tshirt">Categorias</h6>
          <p><a class="text-white" href="http://localhost:8080/Crash_Solutions_Web/LinkProduto?busca=Séries">Séries</a></p>
          <p><a class="text-white" href="http://localhost:8080/Crash_Solutions_Web/LinkProduto?busca=Animes">Animes</a></p>
          <p><a class="text-white" href="http://localhost:8080/Crash_Solutions_Web/LinkProduto?busca=Filmes">Filmes</a></p>
          <p><a class="text-white" href="http://localhost:8080/Crash_Solutions_Web/LinkProduto?busca=Games">Games</a></p>
        </div>

        <hr class="w-100 clearfix d-md-none">

        <div class="col-md-4 mx-auto mt-3">
          <h6 class="text-uppercase mb-4 font-weight-bold text-tshirt">Contato</h6>
          <img src="resources/img/icones/map-marker.svg"><span><a class="text-white" href="https://goo.gl/maps/Sjki4Mma1M72"> Avenida Ramiro Corleone, 151<br>Vila Dora, Santo André<br>CEP: 08440-650</a></span>
          <p><img src="resources/img/icones/envelope-closed.svg"> sac@t-shirt.com.br</p>
          <p><img src="resources/img/icones/phone.svg"> (11) 2381-4000 (11) 2381-4001</p>
        </div>
      </div>
      <hr>
      <div class="row py-3 d-flex align-items-center">
        <div class="col-md-7">
          <p class="text-center text-md-left grey-text">T-SHIRT 2017, Todos os direitos reservados<strong style="color:rgb(255,102,20);"> Crash Solutions</strong></p>
        </div>
        <!-- Imagem do Certificado de Segurança-->
        <div class="col-md-5 text-black">
          <img src="resources/img/siteblindado.png" alt="logo site blindado" data-toggle="modal" data-target="#ModalSeguranca" class="w-25">
        </div>
        <!-- INÍCIO - Modal com as Informações do Certificado de Segurança -->
        <div class="modal fade text-black" id="ModalSeguranca" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h4 class="modal-title" id="exampleModalLabel">Certificado de Segurança</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <h5>Site protegido por SiteBlindado.com</h5>
                <p>Este site é protegido com um certificado do servidor web <strong>SiteBlindado.com</strong> todas as transações no site são protegidas com uma criptografia Secure Sockets Layer de 256 bits.</p>
                <hr>
                <div class="text-left">
                  <strong>Nome do site: </strong><br>tshirtgames.com<br>
                  <strong>Status do certificado: </strong><br>O certificado é válido de 05/04/18 14:19 a 19/10/19 14:19.<br><br>
                  <strong>Entidade detentora do certificado: </strong>
                  <br>Organização: T-Shirt Games LTDA Eireli<br>
                  Localidade: Santo André - São Paulo - Brasil<br>
                  Números do registro:<br>
                  CNPJ: 00.619.841/0001-00<br>
                  IE: 146.576.325.115<br>
                  <div>
                    <img src="resources/img/siteblindado.png" alt="logo site blindado">
                  </div>
                </div>

              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-success" data-dismiss="modal">Fechar</button>
              </div>
            </div>
          </div>
        </div>
        <!-- FIM - Modal com as Informações do Certificado de Segurança -->
      </div>
    </div>
    <c:import url="resources/template/modal.LargeCarrinho.jsp"></c:import>
</footer>
