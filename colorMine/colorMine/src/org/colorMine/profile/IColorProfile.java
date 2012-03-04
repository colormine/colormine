package org.colorMine.profile;

import java.awt.Color;
import java.util.Map;

import org.colorMine.colorSpace.Lab;


public interface IColorProfile {
	Map<Color, Integer> getColorProfile();
	Map<Lab, Integer> getLabProfile();

	int getPixelCount();
}
