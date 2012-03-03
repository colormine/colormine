package org.colorMine.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.colorMine.ColorMine;
import org.colorMine.profile.ColoredImage;
import org.colorMine.profile.IColoredImage;
import org.colorMine.servlet.validation.IValidationResult;
import org.colorMine.servlet.validation.ImageUploadValidator;

@MultipartConfig
public class ColorProfileServlet extends HttpServlet {

	private static final long serialVersionUID = -3765738018606119921L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean profileReturned = false;

		for (Part part : request.getParts()) {
			String filename = getFilename(part);
			if (!filename.isEmpty()) {
				IValidationResult result = ImageUploadValidator.validate(part);

				if (!result.isValid()) {
					throw new IOException(result.toString());
				}

				filename = filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE
																														// fix.
				InputStream fileContent = part.getInputStream();
				BufferedImage image = ImageIO.read(fileContent);
				
				IColoredImage colorImage = new ColoredImage(image);
				

				ServletOutput.write(response, ColorMine.getColorProfile(colorImage));

				profileReturned = true;
			}
		}

		if (!profileReturned) {
			throw new IOException("An error has occured");
		}
	}

	// Yucky
	private static String getFilename(Part part) {
		for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
			if (contentDisposition.trim().startsWith("filename")) {
				return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
