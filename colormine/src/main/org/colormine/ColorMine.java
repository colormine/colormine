package org.colormine;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;

import org.colormine.colorspace.ColorSpaceConverter;
import org.colormine.colorspace.Hsl;
import org.colormine.image.Image;
import org.colormine.image.profile.ColorProfile;

/**
 * Provides a facade that makes it easy to do the most common tasks without
 * having to know anything about the underlying classes.
 */

public class ColorMine {

	private static final double _defaultComplementTolerance = 1.0;

	// Color Comparison Methods

	/**
	 * Calculates how similar colors are to each other (delta-E), the order of
	 * the arguments doesn't matter.
	 * 
	 * @param a
	 * @param b
	 * @return score for how similar two colors are to each other, the lower the
	 *         score the more similar the colors.
	 */

	public static double calculateSimilarity(Color a, Color b) {
		return ColorSpaceConverter.colorToLab(a).compare(ColorSpaceConverter.colorToLab(b));
	}

	/**
	 * Determines if two given colors are complements of each other, the order
	 * doesn't matter
	 * 
	 * @param a
	 * @param b
	 * @param tolerance
	 * @return true if the colors are complements within passed in tolerance
	 */
	public static boolean isComplement(Color a, Color b, double tolerance) {

		Color complementColor = getComplement(a);
		return ColorSpaceConverter.isNearMatch(complementColor, b, tolerance);
	}

	/**
	 * Determines if two given colors are complements of each other using the
	 * default tolerance of 1.0
	 * 
	 * @param a
	 * @param b
	 * @return true if the colors are complements within passed in tolerance
	 */
	public static boolean isComplement(Color a, Color b) {

		Color complementColor = getComplement(a);
		return ColorSpaceConverter.isNearMatch(complementColor, b, _defaultComplementTolerance);
	}

	/**
	 * Gets the Complement of the given color.
	 * 
	 * @param color
	 * @return color representing the complement
	 */
	public static Color getComplement(Color color) {

		Hsl hsl = ColorSpaceConverter.colorToHsl(color);
		hsl = getHslComplement(hsl);

		return ColorSpaceConverter.hslToColor(hsl);
	}

	// Image Manipulation Methods

	/**
	 * Returns a ColorProfile for a given Image.
	 * 
	 * @param image
	 * @return profile containing a map of colors to how many times that color
	 *         occurred in the image.
	 */

	public static ColorProfile getColorProfile(Image image) {
		return new ColorProfile(image);
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
	 * @return array of the split complements colors for the given color
	 */
	public static Color[] getSplitComplements(Color color) {
		return getPointsOnColorWheel(color, 150, -150);
	}

	// Color Scheme Methods

	/**
	 * Gets the analogous colors for the given color.
	 * 
	 * @param color
	 * @return Array of the Analogous colors for the given color
	 */
	public static Color[] getAnalogous(Color color) {
		return getPointsOnColorWheel(color, 30, -30);
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