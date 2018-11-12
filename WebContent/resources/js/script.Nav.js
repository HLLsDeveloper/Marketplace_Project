/*Serve para adicionar uma classe no html*/
$(".menu").click(function(){
    $(this).toggleClass("ativo")
});

$(document).ready(function () {
	$('#nav').affix();
});
