$(document).ready(function () {
    $("#LoginValidate").validate({
        debug: false,
        
        rules: {        	       
        	login_email: {
                required: true,
                email: true
            },
            login_senha: {
                required: true,
                minlength: 6,
               },
   
},
        messages: {
       	             	
        	login_email: {
                required: "Por favor, campo obrigatório",
                email: "Exemplo seuemail@email.com",
                equalTo: "Por favor verificar o email digitado!",
            },
            
            login_senha: {
                required: "Por favor, insira a sua senha",
                minlength: "Insira no mínimo 6 caracteres!",
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
