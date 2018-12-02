
//Envia os dados para adicionar no carrinho e monta a lista no mesmo
$(document).ready(function(){
	
	$("#lupa").mlens({
		imgSrc: $("#lupa").attr("data-big"),	  // path of the hi-res version of the image
		imgSrc2x: $("#lupa").attr("data-big2x"),  // path of the hi-res @2x version of the image
                                                  //for retina displays (optional)
		lensShape: "circle",                // shape of the lens (circle/square)
		lensSize: ["270px","270px"],            // lens dimensions (in px or in % with respect to image dimensions)
		                                   // can be different for X and Y dimension
		borderSize: 4,                  // size of the lens border (in px)
		borderColor: "#fff",            // color of the lens border (#hex)
		borderRadius: 0,                // border radius (optional, only if the shape is square)
		imgOverlay: $("#lupa").attr("data-overlay"), // path of the overlay image (optional)
		overlayAdapt: true,    // true if the overlay image has to adapt to the lens size (boolean)
		zoomLevel: 1.1,          // zoom level multiplicator (number)
		responsive: true       // true if mlens has to be responsive (boolean)
	});
	
	//Exclui o produto da lista da tela de Finalização da Compra
	$("#excluiritem").click(function(){
		var objDados;
		id = document.getElementById("excluiritem").value;
		$.post("AlteracaoCompra", {excluir: id}, function(data){	
	    });
	});
});

//Faz o calculo do Frete
function calculafrete() {
	cep = document.getElementById("cep").value
	if(cep == "") {
		var title = document.getElementById("title");
		var mensagem = document.getElementById("text");
		title.innerHTML = "CEP";
    	mensagem.innerHTML = "Por favor, digite um CEP!";
    	$("#carrinho").modal();
	}
	else {
		if ($('.linhafrete') == null) {
			$.post("CalculoFrete", {cep: cep}, function(data, status){
				var Array = JSON.parse(data);
		    	for(var i = 0; i < Array.length; i++) {
		    		var tipo = null;
		    		$("#resultfrete").append("<tr class='linhafrete'>" + 
							"						<td><label>R$ "+Array[i].valor+"</label></td>" +
							"						<td><label>Em até "+Array[i].prazoEntrega+" dias úteis</label></td>" +
							"				</tr>");
		    	}
		    });
		}
		else {
			$('.linhafrete').remove();
			$.post("CalculoFrete", {cep: cep}, function(data, status){
				var Array = JSON.parse(data);
		    	for(var i = 0; i < Array.length; i++) {
		    		var tipo = null;
		    		$("#resultfrete").append("<tr class='linhafrete'>" +
							"						<td><label for='"+tipo+"'>R$ "+Array[i].valor+"</label></td>" +
							"						<td><label for='"+tipo+"'>Em até "+Array[i].prazoEntrega+" dias úteis</label></td>" +
							"				</tr>");
		    	}
		    });
		}
	}
}

//contador para ver qual radio button foi selecionado para gravar no banco de dados
function getRadioValor(name){
	var rads = document.getElementsByName(name);
	for(var i = 0; i < rads.length; i++){
		if(rads[i].checked){
			return rads[i].value;
		}   
	}
	return null;
}


