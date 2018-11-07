// EXIBIR LISTA DE PRODUTOS
function ListaProdutos() {
	$("#ListaProdutos").modal();
}

// EXIBIR MENSAGENS
$(document).ready(function(){
	
	if($("#mensagem").val() != ""){
		$("#test_message").modal();
	}
	
});