package com.colorComparer.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.colorComparer.ColorCalculator;
import com.colorComparer.colorSpace.Rgb;

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

			String color = GetColorFromParamer(request.getParameterMap());
			
			double[] colorNumbers = ColorCalculator.getRgbNumbers(color);
			
			Rgb complementColor = ColorCalculator.getComplement(new Rgb(colorNumbers));						
			
			ServletOutput.write(response, complementColor.toHex(),DATA_KEY);
			
	}
	private String  GetColorFromParamer(Map<String, String[]> parameterMap){
		
		String color = "";
		
		if (parameterMap.containsKey(DATA_KEY))
		{
			color = parameterMap.get(DATA_KEY)[0];
		}
		else{
			throw new IllegalArgumentException("Must Contain Color information!");
		}
		
		return color;
	}
	


}