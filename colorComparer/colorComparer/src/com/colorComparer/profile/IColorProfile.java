package com.colorComparer.profile;

import java.awt.Color;
import java.util.Map;
import com.colorComparer.colorSpace.Lab;
import com.colorComparer.colorSpace.Rgb;

public interface IColorProfile {
	Map<Color, Integer> getColorProfile();

	Map<Rgb, Integer> getRgbProfile();

	Map<Lab, Integer> getLabProfile();

	int getPixelCount();
}
