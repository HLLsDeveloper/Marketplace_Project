// PRÉ VISUALIZAR A IMAGEM

function PreviewImage() {

	var oFReader = new FileReader();
    oFReader.readAsDataURL(document.getElementById('pre-imagem').files[0]);

    oFReader.onload = function (oFREvent) {
        
    	document.getElementById('img-pre-visualiza').src = oFREvent.target.result;
    	document.getElementById('input-imagem').innerHTML = $('#pre-imagem').val()
    };
};