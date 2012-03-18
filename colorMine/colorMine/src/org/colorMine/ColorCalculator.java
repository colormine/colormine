package org.colorMine;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;

import org.colorMine.colorSpace.ColorSpaceConverter;
import org.colorMine.colorSpace.Hsl;

public class ColorCalculator {

	final static String COLOR_DELIMITER = "-";
	final static String LAB_TYPE = "lab";
	final static String RGB_TYPE = "rgb";
	final static String TYPE = "type";

	/**
	 * Determines if two given colors are complements of each other.
	 * 
	 * @param firstColor
	 * @param secondColor
	 * @return Returns true if secondColor is a complement of first color.
	 */
	public static boolean isComplement(Color firstColor, Color secondColor) {

		Color complementColor = getComplement(firstColor);

		return (ColorSpaceConverter.isNearMatch(complementColor, secondColor, 1.0)) ? true : false;
	}

	/**
	 * Gets the Complement of the given color,
	 * 
	 * @param color
	 * @return Returns Color's complement
	 */
	public static Color getComplement(Color color) {

		Hsl hsl = ColorSpaceConverter.colorToHsl(color);
		hsl = getHslComplement(hsl);

		return ColorSpaceConverter.hslToColor(hsl);
	}

	/**
	 * Gets the triadic harmonies of the given color.
	 * 
	 * @param color
	 * @return Array of the triadic colors for the given color
	 */
	public static Color[] getTriadic(Color color) {
		return getPointsOnColorWheel(color, 120, -120);
	}

	/**
	 * Gets the Split Complements of the given color.
	 * 
	 * @param color
	 * @return Array of the Split Complements colors for the given color
	 */
	public static Color[] getSplitComplements(Color color) {
		return getPointsOnColorWheel(color, 150, -150);
	}

	/**
	 * Gets the Analogous colors for the given color.
	 * 
	 * @param color
	 * @return Array of the Analogous colors for the given color
	 */
	public static Color[] getAnalogous(Color color) {
		return getPointsOnColorWheel(color, 30, -30);
	}

	/**
	 * returns a value that represents how well two colors match
	 * 
	 * @param firstColor
	 * @param secondColor
	 * @return a double value that represents how well two colors match
	 */
	public static double getMatchScore(Color firstColor, Color secondColor) {
		return ColorMine.compare(firstColor, secondColor);
	}

	/**
	 * returns the colors found by adjusting given color by the given points
	 * 
	 * @param color
	 * @param points
	 * @return a color array with the adjusted hue points
	 */
	private static Color[] getPointsOnColorWheel(Color color, double... points) {

		Hsl hsl = ColorSpaceConverter.colorToHsl(color);
		Collection<Color> colors = new ArrayList<Color>();

		for (double point : points) {
			Hsl hslPoint = moveHueOnColorWheel(hsl, point);
			colors.add(ColorSpaceConverter.hslToColor(hslPoint));
		}

		return colors.toArray(new Color[colors.size()]);
	}

	/**
	 * returns the given colors Complement
	 * 
	 * @param hsl
	 * @return a Hsl value that represents the complement of the given Hsl value
	 */
	private static Hsl getHslComplement(Hsl hsl) {

		Hsl ComplementH = moveHueOnColorWheel(hsl, 180.0);

		return ComplementH;
	}

	/**
	 * moves the hue of the hsl value the specified percent
	 * 
	 * @param hsl
	 * @param percent
	 * @return an adjusted hsl value
	 */
	private static Hsl moveHueOnColorWheel(Hsl hsl, double percent) {
		double H = hsl.H + percent / 360;

		if (H > 1) {
			H -= 1;
		}

		return new Hsl(H, hsl.S, hsl.L);
	}

}