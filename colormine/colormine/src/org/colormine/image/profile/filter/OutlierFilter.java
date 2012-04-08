package org.colormine.image.profile.filter;

import java.awt.Color;

import org.colormine.image.profile.ColorProfile;
import org.colormine.image.profile.Profile;

/**
 * Removes colors that make up less than a given percentage of the image This is
 * best done after using something like the MapFilter to 'condense' the palette
 */

public final class OutlierFilter implements Filter<Profile<Color>> {

	private final int _percentage;

	public OutlierFilter(int threshHoldPercentage) {
		_percentage = threshHoldPercentage;
	}

	public FilterResult<Profile<Color>> apply(Profile<Color> colors) {
		Profile<Color> result = new ColorProfile();
		Profile<Color> removed = new ColorProfile();

		int pixelCount = colors.size();
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

		return new ProfileFilterResult<Color>(new ColorProfile(result), null, new ColorProfile(removed), colors);
	}
}