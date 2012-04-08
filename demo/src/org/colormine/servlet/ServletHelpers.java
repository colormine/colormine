package org.colormine.servlet;

import java.awt.Color;
import java.util.Map;

public final class ServletHelpers {

	public static Color parseColorFromHex(String hexString) {
		return Color.decode(hexString);
	}

	public static String getColorFromParameter(Map<String, String[]> parameterMap, String key) {

		String color = "";

		if (parameterMap.containsKey(key)) {
			color = parameterMap.get(key)[0];
		} else {
			throw new IllegalArgumentException("Must Contain Color information!");
		}

		return color;
	}

}
