package com.colorComparer.profile.filter;

import java.util.HashMap;
import java.util.Map;

import com.colorComparer.colorSpace.Rgb;
import com.colorComparer.profile.ColorProfile;
import com.colorComparer.profile.IColorProfile;

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
		Map<Rgb, Integer> colors = profile.getRgbProfile();
		Map<Rgb, Integer> result = new HashMap<Rgb, Integer>();
		Map<Rgb, Integer> removed = new HashMap<Rgb, Integer>();

		int pixelCount = profile.getPixelCount();
		// loop through
		for (Rgb key : colors.keySet()) {
			int colorCount = colors.get(key);
			int actualPercentage = (colorCount / pixelCount) * 100;
			if (actualPercentage >= _percentage) {
				result.put(key, colorCount);
			} else {
				removed.put(key, colorCount);
			}
		}

		return new ColorProfileFilterResult(new ColorProfile(result), null,
				new ColorProfile(removed), profile);
	}

}