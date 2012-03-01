package org.colorMine.servlet;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.colorMine.ColorCalculator;
import org.colorMine.colorSpace.Rgb;


public class ComplementMathServlet extends HttpServlet {

	private static final long serialVersionUID = 3468346824556223543L;
	
	private final String DATA_KEY = "color";
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			String colorString = ServletHelpers.GetColorFromParamer(request.getParameterMap(),DATA_KEY);
			
			Color baseColor = ServletHelpers.ParseColorFromHex(colorString);

			Color complementColor = ColorCalculator.getComplement(baseColor);	

			ServletOutput.write(response, new Rgb(complementColor).toHex(),DATA_KEY);
			
	}

	


}