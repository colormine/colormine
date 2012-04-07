package org.colormine.profile;

import java.awt.Color;
import java.util.Map;

import org.colormine.colorspace.Lab;


public interface IColorProfile {
	Map<Color, Integer> getColorProfile();
	Map<Lab, Integer> getLabProfile();

	int getPixelCount();
}
