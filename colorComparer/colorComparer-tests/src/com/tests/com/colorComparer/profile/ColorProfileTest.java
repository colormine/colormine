package com.tests.com.colorComparer.profile;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Map;
import com.colorComparer.profile.ColorProfile;
import junit.framework.TestCase;

public class ColorProfileTest extends TestCase {

	public void testColorProfile() {
		BufferedImage image = new BufferedImage(1, 1,
				BufferedImage.TYPE_INT_RGB);
		image.setRGB(0, 0, 0xFF0000);
		ColorProfile profile = new ColorProfile(image);
		Map<Color, Integer> result = profile.getColorProfile();

		assertEquals(1, result.size());
		assertTrue(result.containsKey(Color.RED));
		assertEquals(1, (int) result.get(Color.RED));
	}

	public void testColorProfileQuantity() {
		BufferedImage image = new BufferedImage(2, 2,
				BufferedImage.TYPE_INT_RGB);
		image.setRGB(0, 0, 0xFF0000);
		image.setRGB(0, 1, 0xFF0000);
		image.setRGB(1, 0, 0xFF0000);
		image.setRGB(1, 1, 0x000000);
		ColorProfile profile = new ColorProfile(image);
		Map<Color, Integer> result = profile.getColorProfile();

		assertEquals(2, result.size());

		assertTrue(result.containsKey(Color.RED));
		assertEquals(3, (int) result.get(Color.RED));

		assertTrue(result.containsKey(Color.BLACK));
		assertEquals(1, (int) result.get(Color.BLACK));
	}

	public void testColorProfileAccuracy() {
		BufferedImage image = new BufferedImage(2, 2,
				BufferedImage.TYPE_INT_RGB);
		image.setRGB(0, 0, 0x123456);
		image.setRGB(0, 1, 0xF2C4A6);
		image.setRGB(1, 0, 0xCCCCCC);
		image.setRGB(1, 1, 0xDDDDDD);

		ColorProfile profile = new ColorProfile(image);
		Map<Color, Integer> result = profile.getColorProfile();

		assertEquals(4, result.size());

		assertEquals(1, (int) result.get(new Color(0x123456)));
		assertEquals(1, (int) result.get(new Color(0xF2C4A6)));
		assertEquals(1, (int) result.get(new Color(0xCCCCCC)));
		assertEquals(1, (int) result.get(new Color(0xDDDDDD)));
	}

}