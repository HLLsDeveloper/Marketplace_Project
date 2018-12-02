package br.com.crashsolutions.Servlets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

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

        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			// PEGANDO A IMAGEM
			Part imagem = request.getPart("image");
			String convertPart = String.valueOf(imagem);
			String name = imagem.getSubmittedFileName();
			
			//PEGA O CAMINHO DO PROJETO NO TOMCAT
			String path = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Workspace" + File.separator + "TShirtGames" + File.separator + "WebContent" + File.separator + "resources" + File.separator + "img" + File.separator + "imagens" + File.separator;
			
			//VERIFICANDO SE A PASTA ONDE O UPLOAD SERÁ SALVO EXISTE, SE NÃO EXISTIR VAMOS CRIAR
		    File pasta = new File(path);
		    if(!pasta.exists()){
		    //NÃO EXISTE, BORA CRIAR
		    pasta.mkdir();
		    } else {
		        //CRIANDO REFERENCIA DO ARQUIVO
		        File img = new File(path + convertPart.substring(convertPart.lastIndexOf("@")+1) + name.substring(name.lastIndexOf(".")));
		        //CRIANDO ARQUIVO EM SI
		        img.createNewFile();
		    }
			//GRAVANDO IMAGEM NO ARQUIVO
			imagem.write(path + convertPart.substring(convertPart.lastIndexOf("@")+1) + name.substring(name.lastIndexOf(".")));
			
			response.getWriter().write(convertPart.substring(convertPart.lastIndexOf("@")+1) + name.substring(name.lastIndexOf(".")));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
