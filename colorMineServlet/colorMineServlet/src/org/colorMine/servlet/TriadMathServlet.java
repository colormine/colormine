package org.colorMine.servlet;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.colorMine.ColorCalculator;
import org.colorMine.colorSpace.Rgb;

public class TriadMathServlet extends HttpServlet {

	private final String DATA_KEY = "color";

	private static final long serialVersionUID = -8332004603111071147L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String colorString = ServletHelpers.GetColorFromParamer(request.getParameterMap(), DATA_KEY);

		Color baseColor = ServletHelpers.ParseColorFromHex(colorString);

		Color[] triadColors = ColorCalculator.getTriadic(baseColor);

		List<String> colorHexStrings = new ArrayList<String>();

		for (Color c : triadColors) {
			colorHexStrings.add(new Rgb(c).toHex());
		}

		ServletOutput.write(response, colorHexStrings, DATA_KEY);

	}
}