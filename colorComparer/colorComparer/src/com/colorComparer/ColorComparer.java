package com.colorComparer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Map;
import com.colorComparer.profile.ColorProfile;
import com.colorComparer.colorSpace.ColorSpaceConverter;
import com.colorComparer.colorSpace.Lab;
import com.colorComparer.colorSpace.Rgb;

public class ColorComparer {

	public static double compare(Color a, Color b) {
		return ColorSpaceConverter.colorToLab(a).compare(ColorSpaceConverter.colorToLab(b));
	}

	public static double compare(Lab a, Lab b) {
		return a.compare(b);
	}

	public static double compare(Rgb a, Rgb b) {
		return ColorSpaceConverter.rgbToLab(a).compare(ColorSpaceConverter.rgbToLab(b));
	}

	public static Map<Rgb, Integer> getRgbProfile(BufferedImage image) {
		ColorProfile profile = new ColorProfile(image);
		return profile.getRgbProfile();
	}

	public static Map<Lab, Integer> getLabProfile(BufferedImage image) {
		ColorProfile profile = new ColorProfile(image);
		return profile.getLabProfile();
	}

	public static Map<Color, Integer> getColorProfile(BufferedImage image) {
		ColorProfile profile = new ColorProfile(image);
		return profile.getColorProfile();
	}

}