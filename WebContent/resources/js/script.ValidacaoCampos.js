// VALIDAÇÃO DA TELA INSERIR PRODUTO

function ValidaCadastroProduto() {

    var produto = document.getElementById("produto");
    var imagem = document.getElementById("input-imagem");
    var descricao = document.getElementById("descricao");
    var modelo = document.getElementById("modelo");
    var genero = document.getElementById("genero");
    var tamanho = document.getElementById("tamanho");
    var cor = document.getElementById("cor");
    var categoria = document.getElementById("categoria");
    var valor_custo = document.getElementById("valor_custo");
    var valor_venda = document.getElementById("valor_venda");
    var quantidade = document.getElementById("quantidade");

    if (produto.value == ""){
    	document.getElementById("produto").style = ("box-shadow: 0px 0px 8px red;");
    } else {
    	document.getElementById("produto").style = null;
    }
    if (imagem.innerHTML == ""){
    	document.getElementById("valida_imagem").style = ("box-shadow: 0px 0px 8px red;");
		document.getElementById("msg_imagem").style = ("display: inline; color: red;");
    } 
    if (descricao.value == ""){
		document.getElementById("descricao").style = ("box-shadow: 0px 0px 8px red;");
    } else {
    	document.getElementById("descricao").style = null;
    }
    if (modelo.value == ""){
    	document.getElementById("modelo").style = ("box-shadow: 0px 0px 8px red;");
    } else {
    	document.getElementById("modelo").style = null;
    }
    if (modelo.value == ""){
    	document.getElementById("referencia").style = ("box-shadow: 0px 0px 8px red;");
    } else {
    	document.getElementById("referencia").style = null;
    }
    if (genero.value == ""){
    	document.getElementById("genero").style = ("box-shadow: 0px 0px 8px red;");
    } else {
    	document.getElementById("genero").style = null;
    }
    if (tamanho.value == ""){
    	document.getElementById("tamanho").style = ("box-shadow: 0px 0px 8px red;");
    } else {
    	document.getElementById("tamanho").style = null;
    }
    if (cor.value == ""){
    	document.getElementById("cor").style = ("box-shadow: 0px 0px 8px red;");
    } else {
    	document.getElementById("cor").style = null;
    }
    if (categoria.value == ""){
    	document.getElementById("categoria").style = ("box-shadow: 0px 0px 8px red;");
    } else {
    	document.getElementById("categoria").style = null;
    }
    if (valor_custo.value == ""){
    	document.getElementById("valor_custo").style = ("box-shadow: 0px 0px 8px red;");
    } else {
    	document.getElementById("valor_custo").style = null;
    }
    if (valor_venda.value == ""){
    	document.getElementById("valor_venda").style = ("box-shadow: 0px 0px 8px red;");
    } else {
    	document.getElementById("valor_venda").style = null;
    }
    if (quantidade.value == ""){
    	document.getElementById("quantidade").style = ("box-shadow: 0px 0px 8px red;");
    } else {
    	document.getElementById("quantidade").style = null;
    }
}

// RETORNA A VALIDAÇÃO QUANDO PREENCHIDO

function RetornoValidaImagem(){ 
	document.getElementById("valida_imagem").style = null; 
	document.getElementById("msg_imagem").style = ("display: none;");
}
function RetornoValidaProduto(){
	document.getElementById("produto").style = null;
}
function RetornoValidaDescricao(){
	document.getElementById("descricao").style = null;
}
function RetornoValidaModelo(){
	document.getElementById("modelo").style = null;
}
function RetornoValidaReferencia(){
	document.getElementById("referencia").style = null;
}
function RetornoValidaGenero(){
	document.getElementById("genero").style = null;
}
function RetornoValidaTamanho(){
	document.getElementById("tamanho").style = null;
}
function RetornoValidaCor(){
	document.getElementById("cor").style = null;
}
function RetornoValidaCategoria(){
	document.getElementById("categoria").style = null;
}
function RetornoValidaValorCusto(){
	document.getElementById("valor_custo").style = null;
}
function RetornoValidaValorVenda(){
	document.getElementById("valor_venda").style = null;
}
function RetornoValidaQuantidade(){
	document.getElementById("quantidade").style = null;
}
