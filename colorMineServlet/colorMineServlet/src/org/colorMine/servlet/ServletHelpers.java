package org.colorMine.servlet;

import java.awt.Color;
import java.util.Map;

public final class ServletHelpers {

	public static Color ParseColorFromHex(String hexString){
		return Color.decode(hexString);
	}
	public static String  GetColorFromParamer(Map<String, String[]> parameterMap,String key){
		
		String color = "";
		
		if (parameterMap.containsKey(key))
		{
			color = parameterMap.get(key)[0];
		}
		else{
			throw new IllegalArgumentException("Must Contain Color information!");
		}
		
		return color;
	}
	
	
	
}
