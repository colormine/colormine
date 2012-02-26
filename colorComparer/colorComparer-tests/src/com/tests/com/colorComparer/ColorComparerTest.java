package com.tests.com.colorComparer;

import java.awt.image.BufferedImage;
import java.util.Map;
import com.colorComparer.ColorComparer;
import com.colorComparer.colorSpace.Rgb;

import junit.framework.TestCase;

public class ColorComparerTest extends TestCase {

	public void testColorProfileAccuracy() {
		BufferedImage image = new BufferedImage(1, 1,
				BufferedImage.TYPE_INT_RGB);
		image.setRGB(0, 0, 0xFF0000);
		Map<Rgb, Integer> result = ColorComparer.getRgbProfile(image);

		assertEquals(1, result.size());
		assertEquals(1, (int) result.get(new Rgb(1, 0, 0)));
	}

}