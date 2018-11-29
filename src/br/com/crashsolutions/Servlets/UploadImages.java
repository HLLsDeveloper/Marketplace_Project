package br.com.crashsolutions.Servlets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadImages")
@MultipartConfig()
public class UploadImages extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UploadImages() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*Obtem o caminho relatorio da pasta img*/
        String path = request.getServletContext().getRealPath("img")+ File.separator;
         
        File files = new File(path);
        response.setContentType("image/jpeg");
         
        /*Mostra o arquivo que está na pasta img onde foi realizado o upload*/
        for (String file : files.list()) {
            File f = new File(path + file);
            BufferedImage bi = ImageIO.read(f);
            OutputStream out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
            out.close();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// pegando a imagem
		Part imagem = request.getPart("image");
		String convertPart = String.valueOf(imagem);
		String name = imagem.getSubmittedFileName();
		
		///verificando se a pasta onde o upload será salvo existe, se não existir vamos criar
	    File pasta = new File("C:" + File.separator + "Images");
	    if(!pasta.exists()){
	    //não existe, bora criar
	    pasta.mkdir();
	    } else {
	        // criando referencia do arquivo
	        File img = new File("C:" + File.separator + "Images" + File.separator + imagem + name.substring(name.lastIndexOf(".")));
	        // criando arquivo em si
	        img.createNewFile();
	    }
		// gravando imagem no arquivo
		imagem.write("C:" + File.separator + "Images" + File.separator + imagem + name.substring(name.lastIndexOf(".")));
		
		response.getWriter().write(convertPart.substring(convertPart.lastIndexOf("@")+1) + name.substring(name.lastIndexOf(".")));
		//response.getWriter().write(convertPart.substring(convertPart.lastIndexOf("@")+1) + name.substring(name.lastIndexOf(".")));
	}
}
