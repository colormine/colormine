package org.colormine;

import java.awt.Color;

import org.colormine.colorspace.ColorSpaceConverter;
import org.colormine.image.Image;
import org.colormine.image.profile.ColorProfile;
import org.colormine.image.profile.Profile;

public class ColorMine {

	public static double compare(Color a, Color b) {
		return ColorSpaceConverter.colorToLab(a).compare(ColorSpaceConverter.colorToLab(b));
	}

	public static Profile<Color> getColorProfile(Image image) {
		return new ColorProfile(image);
	}
}