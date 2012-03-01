package org.colorMine;

import java.awt.Color;

import org.colorMine.colorSpace.ColorSpaceConverter;
import org.colorMine.colorSpace.Hsl;
import org.colorMine.colorSpace.Rgb;

public class ColorCalculator {

	final static String COLOR_DELIMITER = "-";
	final static String LAB_TYPE = "lab";
	final static String RGB_TYPE = "rgb";
	final static String TYPE = "type";

	public static boolean isComplement(Color firstColor,Color secondColor) {

		Color complementColor = getComplement(firstColor);
		
		Rgb secondRgb = new Rgb(secondColor);

		return (secondRgb.isNearMatch(new Rgb(complementColor), 1.0)) ? true : false;
	}
	public static Color getComplement(Color color) {
		
		Hsl hsl = ColorSpaceConverter.rgbToHsl(new Rgb(color));
		hsl = getHslComplement(hsl);
		
		return ColorSpaceConverter.hsltoColor(hsl);
	}
	public static Color[] getTriadic(Color color){
		
		Color[] triadicColors = new Color[2];
		
		Hsl hsl = ColorSpaceConverter.rgbToHsl(new Rgb(color));
		hsl = getHslComplement(hsl);
		
		Hsl triad1 = moveHueOncolorWheel(hsl,120.0);
		Hsl triad2 = moveHueOncolorWheel(hsl,-120.0);
		
		triadicColors[0] = ColorSpaceConverter.hsltoColor(triad1);
		triadicColors[1] = ColorSpaceConverter.hsltoColor(triad2);
		
		return triadicColors;
	}
	
	public static double GetMatchScore(Color firstColor, Color secondColor) {
			return ColorMine.compare(new Rgb(firstColor), new Rgb(secondColor));
	}
//	public double[] getRgbNumbers(String value) {
//		final int max = 3;
//
//		String[] stringNumbers = value.split(COLOR_DELIMITER);
//		double[] doubleNumbers = new double[max];
//
//		for (int i = 0; i < max; i++) {
//			doubleNumbers[i] = Double.parseDouble(stringNumbers[i]);
//		}
//		return doubleNumbers;
//	}

	
	private static Hsl getHslComplement(Hsl hsl) {
		
		Hsl ComplementH = moveHueOncolorWheel(hsl,180.0);

		return ComplementH;
	}
	private static Hsl moveHueOncolorWheel(Hsl hsl,double percent) {
		double H = hsl.H + percent/360;

		if (H > 1) {
			H-= 1;
		}

		return new Hsl(H,hsl.S,hsl.L);
	}

}