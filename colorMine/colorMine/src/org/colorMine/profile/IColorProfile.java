package org.colorMine.profile;

import java.awt.Color;
import java.util.Map;

import org.colorMine.colorSpace.Lab;
import org.colorMine.colorSpace.Rgb;

public interface IColorProfile {
	Map<Color, Integer> getColorProfile();

	Map<Rgb, Integer> getRgbProfile();

	Map<Lab, Integer> getLabProfile();

	int getPixelCount();
}
