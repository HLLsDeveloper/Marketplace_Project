function uploadfile() {
	var imagetype = document.getElementById("imagetype");
	var visual_image = document.getElementById("visual_image");
	var file = document.querySelector("input[type=file]").files[0];
	var reader = new FileReader();
	reader.onloadend = function() {
		visual_image.src = reader.result;
	}
	if(file) {
		//AJAX
		$.ajax({
            url: 'UploadImages',
            data: new FormData(imagetype),
            cache: false,
            contentType: false,
            processData: false,
            enctype: 'multipart/form-data',
            type: 'POST',
            success: function (data) {
                var nameimagem = document.getElementById("nameimage");
                nameimage.value = data;
            }
        });
		///////////////////////////
		reader.readAsDataURL(file);
	} else {
		image.src = "";
	}
}

