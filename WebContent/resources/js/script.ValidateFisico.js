
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
            nome:{
                required:true,
            },
            sobrenome:{
                required:true,
            },        
            datanascimento:{
                required:true,
                minlength: 10
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
            sexo:{
                required:true,
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
            nome:{
                required: "Campo obrigatório"
            },
            sobrenome:{
                required: "Campo obrigatório",
            },          
            datanascimento:{
                required: "Campo obrigatório",
                minlength: "Formato inválido",
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
            sexo:{
                required: "*",
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
        validate: 'cpf',
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
    return this.optional(element) || /[A-Za-z0-9]+@[a-z]+\.[a-z]+/.test(value);

};


jQuery.validator.addMethod("cpf", function(value, element) {
	   value = jQuery.trim(value);

	    value = value.replace('.','');
	    value = value.replace('.','');
	    cpf = value.replace('-','');
	    while(cpf.length < 11) cpf = "0"+ cpf;
	    var expReg = /^0+$|^1+$|^2+$|^3+$|^4+$|^5+$|^6+$|^7+$|^8+$|^9+$/;
	    var a = [];
	    var b = new Number;
	    var c = 11;''
	    for (i=0; i<11; i++){
	        a[i] = cpf.charAt(i);
	        if (i < 9) b += (a[i] * --c);
	    }
	    if ((x = b % 11) < 2) { a[9] = 0 } else { a[9] = 11-x }
	    b = 0;
	    c = 11;
	    for (y=0; y<10; y++) b += (a[y] * c--);
	    if ((x = b % 11) < 2) { a[10] = 0; } else { a[10] = 11-x; }

	    var retorno = true;
	    if ((cpf.charAt(9) != a[9]) || (cpf.charAt(10) != a[10]) || cpf.match(expReg)) retorno = false;

	    return this.optional(element) || retorno;

	}, "Informe um CPF válido");


