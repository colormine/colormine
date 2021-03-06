package org.colormine.servlet;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.colormine.image.ColorImage;
import org.colormine.image.profile.ColorProfile;
import org.colormine.image.profile.Profile;
import org.colormine.image.profile.filter.Filter;
import org.colormine.image.profile.filter.FilterResult;
import org.colormine.image.profile.filter.MapFilter;
import org.colormine.servlet.validation.IValidationResult;
import org.colormine.servlet.validation.ImageUploadValidator;

@MultipartConfig
public class ColorMappingServlet extends HttpServlet {

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

				ColorImage colorImage = new ColorImage(image);

				Filter<Profile<Color>> filter = new MapFilter(getPalette());
				FilterResult<Profile<Color>> filterResult = filter.apply(new ColorProfile(colorImage));

				ServletOutput.write(response, filterResult.getFiltered());

				profileReturned = true;
			}
		}

		if (!profileReturned) {
			throw new IOException("An error has occured");
		}
	}

	private static Profile<Color> getPalette() {
		Map<Color, Integer> colors = new HashMap<Color, Integer>();

		colors.put(Color.WHITE, 1);
		colors.put(Color.LIGHT_GRAY, 1);
		colors.put(Color.GRAY, 1);
		colors.put(Color.DARK_GRAY, 1);
		colors.put(Color.BLACK, 1);

		return new ColorProfile(colors);
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
