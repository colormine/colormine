package org.colorMine.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.colorMine.ColorCalculator;
import org.colorMine.colorSpace.Rgb;


public class TriadMathServlet extends HttpServlet {


	private static final long serialVersionUID = -8332004603111071147L;
	
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
			
			Rgb[] triadColors = ColorCalculator.GetTriadic((new Rgb(colorNumbers)));
			
			List<String> colorHexStrings = new ArrayList<String>();
			
			for (Rgb c : triadColors)
			{
				colorHexStrings.add(c.toHex());
			}
		
			ServletOutput.write(response, colorHexStrings,"color");
			
	}
	private String  GetColorFromParamer(Map<String, String[]> parameterMap){
		
		String color = "";
		
		if (parameterMap.containsKey("color"))
		{
			color = parameterMap.get("color")[0];
		}
		else{
			throw new IllegalArgumentException("Must Contain Color information!");
		}
		
		return color;
	}
	


}