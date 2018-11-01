$(document).ready(function TamanhoSelecionado(id){
	
	var x = document.getElementById('idproduto').value;
	var y = document.getElementById(id).id;
	
	if(x == y){
		
		document.getElementById(id).style = 'background-color: #ff6600; color: white;';
	}	
});