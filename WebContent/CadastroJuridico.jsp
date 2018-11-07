<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>T-Shirt Games - Cadastra-se</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		
	<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.css">
	<link rel="stylesheet" href="resources/css/style.ValidateFisico.css">
	
	<script src="resources/js/bootstrap/popper.min.js"></script>
	<script src="resources/js/bootstrap/bootstrap.min.js"></script>
	<script src="resources/js/jquery/jquery.min.js"></script>
	<script src="resources/js/jquery/jquery.validate.js"></script>
	<script src="resources/js/script.ValidateJuridico.js"></script>
	<script src="resources/js/jquery/jquery.mask.js"></script>
	<script src="resources/js/jquery/jquery.cpfcnpj.js"></script>
	<script src="resources/js/script.Buscacep.js"></script>
</head>
<body>

<!-- NAV -->
<c:import url="resources/template/nav.jsp"/>
    <section class="container mt-4">
        <div class="col-lg-6 offset-lg-3">
            <h2 class="text-center">Cadastre-se</h2>
            <p class="lead text-center">Venha fazer parte </p>
            <hr>
			<form id="ValidacaoCampos" accept-charset="ISO-8859-1">
		  	<div class="form-group">
		        <label for="inputEmail">E-mail:</label>
		        <input type="email" class="form-control" id="conf_email" name="conf_email" placeholder="email@email.com" onchange="form.confirmar_email.pattern = this.value;" required >
			</div>
		    <div class="form-group">
		        <label for="inputConfirmesenha">Confirme o E-mail:</label>
		        <input type="email" class="form-control" id="email" name="email" required placeholder="email@email.com" >
		    </div>
		    <div class="form-group">
		        <label for="inputSenha">Senha:</label>
		        <input type="password" class="form-control" id="conf_senha" name="conf_senha" placeholder="Digite sua senha" onchange="form.confirmar_senha.pattern = this.value;" required>
		    </div>	
		    <div class="form-group">
		        <label for="inputConfirmesenha">Confirme a Senha:</label>
		        <input type="password" class="form-control" id="senha" name="senha" placeholder="Confirme sua senha" required>
		    </div>
		    <div class="form-group">
		        <label for="inputRazaoso">Razão Social:</label>
		        <input type="text" class="form-control" name="razao" id="razao" placeholder="" required>
		    </div>
		    <div class="form-row">
		    	<div class="form-group col-md-6">
		        	<label for="inputNomefan">Nome Fantasia:</label>
		        	<input type="text" class="form-control" name="nomefantasia" id="nomefantasia" placeholder="" required>
		    	</div>
		    	<div class="form-group col-md-6">
		        	<p class="text-center cadastrar_taux"><a href="CadastroFisico.jsp">Não é pessoa Jurídica?</a></p>
		    	</div>
		    </div>
		    <div class="form-row">
		    	<div class="form-group col-md-6">
		                <label for="inputCnpj">CNPJ:</label>
		                <input type="text" class="form-control validate" id="cnpj" name="cnpj" placeholder="Digite apenas números" pattern="[0-9]+$" required />
		           </div>
		        <div class="form-group col-md-6">
		            <label for="inputInscricaoes">Inscrição Estadual:</label>
		            <input type="text" class="form-control" id="ie" name="ie" placeholder="Digite apenas números" pattern="[0-9]+$" required>
		        </div>
		    </div>
		    <div class="form-row">
		        <div class="form-group col-md-12">
		            <label for="inputZip">CEP</label>
		            <input type="text" class="form-control" id="cep" name="cep" placeholder="00000-000" required pattern="\d{5}-?\d{3}" />
		        </div>
		    </div>
		    <div class="form-row">
                <div class="form-group col-md-12">
                	<label for="inputAddress">Endereço</label>
                	<input type="text" class="form-control" name="endereco" id="endereco" placeholder="Ex: Rua das Oliveiras" required>
                </div>
             </div>
             <div class="form-row">
                <div class="form-group col-md-3">
                	<label for="inputAddress">Nº</label>
                	<input type="text" class="form-control" name="numero" id="numero" placeholder="Ex: 2001" required>
              	</div>
              	<div class="form-group col-md-3">
                	<label for="inputAddress">Comp.</label>
                	<input type="text" class="form-control" name="complemento" id="complemento" placeholder="Ex: Apto 3" required>
              	</div>
		     	<div class="form-group col-md-6">
		            <label for="inputCidade">Bairro</label>
		            <input type="text" class="form-control" name="bairro" id="bairro" placeholder="Ex: Centro" required>
		        </div>
		    </div>
		    <div class="form-row">
		     <div class="form-group col-md-6">
		            <label for="inputCidade">Cidade</label>
		            <input type="text" class="form-control" name="cidade" id="cidade" placeholder="Ex: São Paulo" required>
		        </div>
		        <div class="form-group col-md-6">
		            <label>Estado</label>
		            <select id="estado" name="estado" class="form-control" required>
	                    <option value="" selected>Selecione</option>
	                    <option value="1">Acre</option>
	                    <option value="2">Alagoas</option>
	                    <option value="3">Amazonas</option>
	                    <option value="4">Amapá</option>
	                    <option value="5">Bahia</option>
	                    <option value="6">Ceará</option>
	                    <option value="7">Distrito Federal</option>
	                    <option value="8">Espírito Santo</option>
	                    <option value="9">Goiás</option>
	                    <option value="10">Maranhão</option>
	                    <option value="11">Minas Gerais</option>
	                    <option value="12">Mato Grosso Do Sul</option>
	                    <option value="13">Mato Grosso</option>
	                    <option value="14">Pará</option>
	                    <option value="15">Paraíba</option>
	                    <option value="16">Pernambuco</option>
	                    <option value="17">Piauí</option>
	                    <option value="18">Paraná</option>
	                    <option value="19">Rio De Janeiro</option>
	                    <option value="20">Rio Grande Do Norte</option>
	                    <option value="21">Rondônia</option>
	                    <option value="22">Roraima</option>
	                    <option value="23">Rio Grande Do Sul</option>
	                    <option value="24">Santa Catarina</option>
	                    <option value="25">Sergipe</option>
	                    <option value="26">São Paulo</option>
	                    <option value="27">Tocantins</option>
	                </select>
		        </div>
		    </div>
		    <div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputCity">Telefone</label> <input type="text"
						class="form-control" name="telefone" id="telefone"
						placeholder="Ex: (99)99999999" required>
				</div>
				<div class="form-group col-md-6">
					<label for="inputCity">Celular</label> <input type="text"
						class="form-control" name="celular" id="celular"
						placeholder="Ex: (99)999999999" required>
				</div>
			</div>
		    <br>
		    <button id="cadastrar_button" type="submit" class="btn btn-lg btn-block btn-tshirt" formaction="CadastroJuridico" formmethod="post">Criar seu cadastro</button>
		    <p class="text-center cadastrar">Já tem cadastro? <a href="Login.jsp">Entrar</a></p>
		</form>		
    	</div>
	</section>
	<!-- FOOTER -->
	<c:import url="resources/template/footer.jsp"/>
	<c:import url="resources/template/modal.Mensagem.jsp"/>
</body>
</html>