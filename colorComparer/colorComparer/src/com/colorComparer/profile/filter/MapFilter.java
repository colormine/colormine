package com.colorComparer.profile.filter;

import java.util.HashMap;
import java.util.Map;
import com.colorComparer.ColorComparer;
import com.colorComparer.colorSpace.Rgb;
import com.colorComparer.profile.ColorProfile;
import com.colorComparer.profile.IColorProfile;
import com.colorComparer.profile.MapCount;

/**
 * Attempts to match an image up to an existing color profile A color is only
 * recorded if it's close enough (tolerance) to a color existing in the passed
 * in ColorProfile
 */

public class MapFilter implements IColorProfileFilter {

	private Map<Rgb, Integer> _mapColors;
	private int _tolerance;

	public MapFilter(IColorProfile mapProfile) {
		_mapColors = mapProfile.getRgbProfile();
		_tolerance = Integer.MAX_VALUE;
	}
	
	public MapFilter(IColorProfile mapProfile, int tolerance) {
		_mapColors = mapProfile.getRgbProfile();
		_tolerance = tolerance;
	}

	public IColorProfileFilterResult apply(IColorProfile imageProfile) {
		Map<Rgb, Integer> resultColors = new HashMap<Rgb, Integer>();
		Map<Rgb, Integer> modifiedColors = new HashMap<Rgb, Integer>();
		Map<Rgb, Integer> invalidColors = new HashMap<Rgb, Integer>();
		Map<Rgb, Integer> imageColors = imageProfile.getRgbProfile();

		for (Rgb imageRgb : imageColors.keySet()) {
			double bestScore = Double.POSITIVE_INFINITY;
			Rgb bestMatch = null;

			for (Rgb mapRgb : _mapColors.keySet()) {
				double currentScore = ColorComparer.compare(imageRgb, mapRgb);
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

		return new ColorProfileFilterResult(new ColorProfile(resultColors),
				new ColorProfile(modifiedColors), new ColorProfile(
						invalidColors), imageProfile);
	}
}