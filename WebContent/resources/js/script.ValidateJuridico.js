
$(document).ready(function () {
    $("#ValidacaoCampos").validate({
        debug: false,
        
        rules: {
        	conf_email: {
                required: true,
                email: true
            },
            email: {
                required: true,
                email: true,
                equalTo: '#conf_email'
            },
            conf_senha: {
                required: true,
                minlength: 6
            },
            senha: {
                required: true,
                minlength: 6,
                equalTo: '#conf_senha'
            },            
            cpf: {
                required: true,
                minlength: 14,
                cpf: true
            },
            cnpj: {
                required: true,
                minlength: 18,
                cnpj: true
            },
            ie: {
                required: true,
                minlength: 15,               
            },
            razao:{
                required:true,
            },
            nomefantasia:{
                required:true,
            },
            endereco:{
                required:true,
            },
            cidade:{
                required:true,
            },
            bairro:{
                required:true,
            },
            estado:{
                required:true,
            },
            cep:{
                required:true,
                minlength: 9
            },
            telefone:{
            	required: true,
                minlength: 14
            },
            celular:{
            	required: true,
                minlength: 15
            },
},

        messages: {
        	email: {
                required: "Por favor, campo obrigatório",
                email: "Exemplo seuemail@email.com",
                equalTo: "Por favor verificar o email digitado!"
            },
            conf_email: {
                required: "Por favor, campo obrigatório",
                email: "Exemplo seuemail@email.com"
            },
            senha: {
                required: "Por favor, insira a sua senha",
                minlength: "Insira no mínimo 6 caracteres!",
                equalTo: "Por favor verificar a senha digitada!"
            },
            conf_senha: {
                required: "Por favor, insira a sua senha",
                minlength: "Insira no mínimo 6 caracteres!"
            },
            cpf: {
                required: "Campo obrigatório",
                minlength: "Formato inválido",
                cpf: "CPF inválido"
            },
            cnpj: {
                required: "Campo obrigatório",
                minlength: "Formato inválido",
                cnpj: "CNPJ inválido"
            },
            ie: {
                required: "Campo obrigatório",
                minlength: "Formato inválido"
            },
            razao:{
                required: "Campo obrigatório"
            },
            nomefantasia:{
                required: "Campo obrigatório",
            },
            endereco:{
                required: "Campo obrigatório",
            },
            numero:{
                required: "Campo obrigatório",
            },
            complemento:{
                required: "Campo obrigatório",
            },
            bairro:{
                required: "Campo obrigatório",
            },
            cidade:{
                required: "Campo obrigatório",
            },
            estado:{
                required: "Campo obrigatório",
            },
            cep:{
                required: "Campo obrigatório",
                minlength: "Formato inválido"
            },
            telefone:{
                required: "Campo obrigatório",
                minlength: "Telefone inválido"
            },
            celular:{
                required: "Campo obrigatório",
                minlength: "Celular inválido"
            },
            
            
    },
            
        highlight: function (element) {
            $(element).parent().addClass('error')
        },
        unhighlight: function (element) {
            $(element).parent().removeClass('error')
        }
    });
});

$(document).ready(function () {
    $('.validate').cpfcnpj({
        mask: true,
        validate: 'cnpj',
        event: 'focusout',
        
        ifValid: function (input) {
            input.removeClass("error");
        },
        ifInvalid: function (input) {
            input.addClass("error"); 
        }
    });
});

$.validator.methods.email = function (value, element) {
    return this.optional(element) || /[a-z]+@[a-z]+\.[a-z]+/.test(value);

};


jQuery.validator.addMethod("cnpj", function(cnpj, element) {
   cnpj = jQuery.trim(cnpj);
	

   cnpj = cnpj.replace('/','');
   cnpj = cnpj.replace('.','');
   cnpj = cnpj.replace('.','');
   cnpj = cnpj.replace('-','');

   var numeros, digitos, soma, i, resultado, pos, tamanho, digitos_iguais;
   digitos_iguais = 1;

   if (cnpj.length < 14 && cnpj.length < 15){
      return this.optional(element) || false;
   }
   for (i = 0; i < cnpj.length - 1; i++){
      if (cnpj.charAt(i) != cnpj.charAt(i + 1)){
         digitos_iguais = 0;
         break;
      }
   }

   if (!digitos_iguais){
      tamanho = cnpj.length - 2
      numeros = cnpj.substring(0,tamanho);
      digitos = cnpj.substring(tamanho);
      soma = 0;
      pos = tamanho - 7;

      for (i = tamanho; i >= 1; i--){
         soma += numeros.charAt(tamanho - i) * pos--;
         if (pos < 2){
            pos = 9;
         }
      }
      resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
      if (resultado != digitos.charAt(0)){
         return this.optional(element) || false;
      }
      tamanho = tamanho + 1;
      numeros = cnpj.substring(0,tamanho);
      soma = 0;
      pos = tamanho - 7;
      for (i = tamanho; i >= 1; i--){
         soma += numeros.charAt(tamanho - i) * pos--;
         if (pos < 2){
            pos = 9;
         }
      }
      resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
      if (resultado != digitos.charAt(1)){
         return this.optional(element) || false;
      }
      return this.optional(element) || true;
   }else{
      return this.optional(element) || false;
   }
}, "Informe um CNPJ válido.");


var SPMaskBehavior = function (val) {
	  return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
	},
	spOptions = {
	  onKeyPress: function(val, e, field, options) {
	      field.mask(SPMaskBehavior.apply({}, arguments), options);
	    }
	};