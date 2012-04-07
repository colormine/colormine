package org.colormine.profile.filter;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.colormine.ColorMine;
import org.colormine.profile.ColorProfile;
import org.colormine.profile.IColorProfile;
import org.colormine.profile.MapCount;

/**
 * Attempts to match an image up to an existing color profile A color is only
 * recorded if it's close enough (tolerance) to a color existing in the passed
 * in ColorProfile
 */

public class MapFilter implements IColorProfileFilter {

	private Map<Color, Integer> _mapColors;
	private int _tolerance;

	public MapFilter(IColorProfile mapProfile) {
		_mapColors = mapProfile.getColorProfile();
		_tolerance = Integer.MAX_VALUE;
	}

	public MapFilter(IColorProfile mapProfile, int tolerance) {
		_mapColors = mapProfile.getColorProfile();
		_tolerance = tolerance;
	}

	public IColorProfileFilterResult apply(IColorProfile imageProfile) {
		Map<Color, Integer> resultColors = new HashMap<Color, Integer>();
		Map<Color, Integer> modifiedColors = new HashMap<Color, Integer>();
		Map<Color, Integer> invalidColors = new HashMap<Color, Integer>();
		Map<Color, Integer> imageColors = imageProfile.getColorProfile();

		for (Color imageRgb : imageColors.keySet()) {
			double bestScore = Double.POSITIVE_INFINITY;
			Color bestMatch = null;

			for (Color mapRgb : _mapColors.keySet()) {
				double currentScore = ColorMine.compare(imageRgb, mapRgb);
				if (currentScore < bestScore) {
					bestScore = currentScore;
					bestMatch = mapRgb;
				}
			}

			if (null != bestMatch && bestScore < _tolerance) {
				// TODO This doesn't actually track what the color was changed
				// to..
				MapCount.count(modifiedColors, imageRgb);
				MapCount.count(resultColors, bestMatch);
			} else {
				MapCount.count(invalidColors, imageRgb);
			}
		}

		return new ColorProfileFilterResult(new ColorProfile(resultColors), new ColorProfile(modifiedColors), new ColorProfile(invalidColors), imageProfile);
	}
}