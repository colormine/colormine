package org.colormine.profile.filter;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;


import org.colormine.profile.ColorProfile;
import org.colormine.profile.IColorProfile;

/**
 * Removes colors that make up less than a given percentage of the image This is
 * best done after using something like the MapFilter to 'condense' the palette
 */

public final class OutlierFilter implements IColorProfileFilter {

	private final int _percentage;

	public OutlierFilter(int threshHoldPercentage) {
		_percentage = threshHoldPercentage;
	}

	public IColorProfileFilterResult apply(IColorProfile profile) {
		Map<Color, Integer> colors = profile.getColorProfile();
		Map<Color, Integer> result = new HashMap<Color, Integer>();
		Map<Color, Integer> removed = new HashMap<Color, Integer>();

		int pixelCount = profile.getPixelCount();
		// loop through
		for (Color key : colors.keySet()) {
			int colorCount = colors.get(key);
			int actualPercentage = (colorCount / pixelCount) * 100;
			if (actualPercentage >= _percentage) {
				result.put(key, colorCount);
			} else {
				removed.put(key, colorCount);
			}
		}

		return new ColorProfileFilterResult(new ColorProfile(result), null, new ColorProfile(removed), profile);
	}

}