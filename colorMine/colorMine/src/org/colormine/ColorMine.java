package org.colormine;

import java.awt.Color;
import java.util.Map;

import org.colormine.colorspace.ColorSpaceConverter;
import org.colormine.profile.ColorProfile;
import org.colormine.profile.IColoredImage;

public class ColorMine {

	public static double compare(Color a, Color b) {
		return ColorSpaceConverter.colorToLab(a).compare(ColorSpaceConverter.colorToLab(b));
	}

	public static Map<Color, Integer> getColorProfile(IColoredImage image) {
		ColorProfile profile = new ColorProfile(image);
		return profile.getColorProfile();
	}

}