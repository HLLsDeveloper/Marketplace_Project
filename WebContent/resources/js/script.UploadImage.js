function uploadfile() {
	var imagetype = document.getElementById("imagetype");
	var visual_image = document.getElementById("visual_image");
	var file = document.querySelector("input[type=file]").files[0];
	var reader = new FileReader();
	reader.onloadend = function() {
		visual_image.src = reader.result;
		console.log(reader.result);
	}
	if(file) {
		//AJAX
		$.ajax({
            url: 'UploadImages', // Url do lado server que vai receber o arquivo
            data: new FormData(imagetype),
            cache: false,
            contentType: false,
            processData: false,
            enctype: 'multipart/form-data',
            type: 'POST',
            success: function (data) {
                var nameimagem = document.getElementById("nameimage");
                nameimage.value = data;
                console.log(nameimage.value);
            }
        });
		///////////////////////////
		reader.readAsDataURL(file);
	} else {
		image.src = "";
	}
}

