package org.colorMine;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;


import org.colorMine.colorSpace.ColorSpaceConverter;
import org.colorMine.colorSpace.Hsl;
import org.colorMine.colorSpace.Rgb;

public class ColorCalculator {

	final static String COLOR_DELIMITER = "-";
	final static String LAB_TYPE = "lab";
	final static String RGB_TYPE = "rgb";
	final static String TYPE = "type";

	public static boolean isComplement(Color firstColor, Color secondColor) {

		Color complementColor = getComplement(firstColor);

		Rgb secondRgb = new Rgb(secondColor);

		return (secondRgb.isNearMatch(new Rgb(complementColor), 1.0)) ? true : false;
	}

	public static Color getComplement(Color color) {

		Hsl hsl = ColorSpaceConverter.rgbToHsl(new Rgb(color));
		hsl = getHslComplement(hsl);

		return ColorSpaceConverter.hsltoColor(hsl);
	}

	public static Color[] getTriadic(Color color) {
		return getPointsOnColorWheel(color,120,-120);
	}
	public static Color[] getSpiltComplements(Color color) {
		return getPointsOnColorWheel(color,150,-150);
	}
	public static Color[] getAnalogous(Color color) {
		return getPointsOnColorWheel(color,30,-30);
	}
	
	public static double GetMatchScore(Color firstColor, Color secondColor) {
		return ColorMine.compare(new Rgb(firstColor), new Rgb(secondColor));
	}

	
	private static Color[] getPointsOnColorWheel(Color color,double ... points)
	{
		Collection<Color> colors = new ArrayList<Color>();

		Hsl hsl = ColorSpaceConverter.rgbToHsl(new Rgb(color));
		
		for (double point : points)
		{
			Hsl hslPoint = moveHueOncolorWheel(hsl, point);
			colors.add(ColorSpaceConverter.hsltoColor(hslPoint));
		}
	

		return colors.toArray(new Color[colors.size()]);
	}
	private static Hsl getHslComplement(Hsl hsl) {

		Hsl ComplementH = moveHueOncolorWheel(hsl, 180.0);

		return ComplementH;
	}
	private static Hsl moveHueOncolorWheel(Hsl hsl, double percent) {
		double H = hsl.H + percent / 360;

		if (H > 1) {
			H -= 1;
		}

		return new Hsl(H, hsl.S, hsl.L);
	}

}