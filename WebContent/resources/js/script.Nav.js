$(document).ready(function() {
	$('.owl-previous').attr('src', 'data:image/svg+xml;charset=utf8,<svg xmlns="http://www.w3.org/2000/svg" fill="gray" viewBox="0 0 8 8"><path d="M5.25 0l-4 4 4 4 1.5-1.5-2.5-2.5 2.5-2.5-1.5-1.5z"/></svg>');
	$('.owl-advanced').attr('src', 'data:image/svg+xml;charset=utf8,<svg xmlns="http://www.w3.org/2000/svg" fill="gray" viewBox="0 0 8 8"><path d="M2.75 0l-1.5 1.5 2.5 2.5-2.5 2.5 1.5 1.5 4-4-4-4z"/></svg>');
});

/*Serve para adicionar uma classe no html*/
$(".menu").click(function(){
    $(this).toggleClass("ativo");
});

function tohide(){
    $(".dropdown-pers").toggleClass("show-menu");
}
