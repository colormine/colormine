package org.colorMine.servlet;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.colorMine.ColorCalculator;


public class ColorMineServlet extends HttpServlet {

	private static final long serialVersionUID = -1864511099400018228L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	final String METHOD = "method";
	final String COMPARISON_METHOD = "compare";
	final static String VALUE_1 = "value1";
	final static String VALUE_2 = "value2";
	final static String TYPE = "type";

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> parameterMap = request.getParameterMap();

		// Use "out" to send content to browser
		String method = parameterMap.get(METHOD)[0];

		double result = 0;

		if (COMPARISON_METHOD.equals(method)) {
			result = ColorCalculator.compare(parameterMap.get(TYPE)[0],
					parameterMap.get(VALUE_1)[0], parameterMap.get(VALUE_2)[0]);
		} else {
			throw new IllegalArgumentException(COMPARISON_METHOD
					+ " is the only " + METHOD
					+ " currently available. Given method was " + method);
		}

		ServletOutput.write(response, result,"score");
	}

}