function SelecionarAnuncio1() {
	document.getElementById("anuncio1").style = "z-index: 3;";
	document.getElementById("anuncio2").style = "z-index: 2;";
	document.getElementById("anuncio3").style = "z-index: 1;";
	var radio = document.getElementsByName("idproduto");
	for(var i=0;i<radio.length;i++) {
		radio[i].checked = false;
	}
}

function SelecionarAnuncio2() {
	document.getElementById("anuncio1").style = "z-index: 2;";
	document.getElementById("anuncio2").style = "z-index: 3;";
	document.getElementById("anuncio3").style = "z-index: 1;";
	var radio = document.getElementsByName("idproduto");
	for(var i=0;i<radio.length;i++) {
		radio[i].checked = false;
	}
}

function SelecionarAnuncio3() {
	document.getElementById("anuncio1").style = "z-index: 1;";
	document.getElementById("anuncio2").style = "z-index: 2;";
	document.getElementById("anuncio3").style = "z-index: 3;";
	var radio = document.getElementsByName("idproduto");
	for(var i=0;i<radio.length;i++) {
		radio[i].checked = false;
	}
}