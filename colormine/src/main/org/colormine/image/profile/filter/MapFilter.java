package org.colormine.image.profile.filter;

import java.awt.Color;

import org.colormine.ColorMine;
import org.colormine.image.profile.ColorProfile;
import org.colormine.image.profile.Profile;

/**
 * Attempts to match an image up to an existing color profile A color is only
 * recorded if it's close enough (tolerance) to a color existing in the passed
 * in ColorProfile
 */

public class MapFilter implements Filter<Profile<Color>> {

	private Profile<Color> _profile;
	private int _tolerance;

	public MapFilter(Profile<Color> mapProfile) {
		_profile = mapProfile;
		_tolerance = Integer.MAX_VALUE;
	}

	public MapFilter(Profile<Color> profile, int tolerance) {
		_profile = profile;
		_tolerance = tolerance;
	}

	public FilterResult<Profile<Color>> apply(Profile<Color> imageColors) {
		Profile<Color> resultColors = new ColorProfile();
		Profile<Color> modifiedColors = new ColorProfile();
		Profile<Color> invalidColors = new ColorProfile();

		for (Color imageRgb : imageColors.keySet()) {
			double bestScore = Double.POSITIVE_INFINITY;
			Color bestMatch = null;

			for (Color mapRgb : _profile.keySet()) {
				double currentScore = ColorMine.calculateSimilarity(imageRgb, mapRgb);
				if (currentScore < bestScore) {
					bestScore = currentScore;
					bestMatch = mapRgb;
				}
			}

			if (null != bestMatch && bestScore < _tolerance) {
				// TODO This doesn't actually track what the color was changed
				// to..
				modifiedColors.put(imageRgb);
				resultColors.put(bestMatch);
			} else {
				invalidColors.put(imageRgb);
			}
		}

		return new ProfileFilterResult<Color>(resultColors, modifiedColors, invalidColors, imageColors);
	}
}