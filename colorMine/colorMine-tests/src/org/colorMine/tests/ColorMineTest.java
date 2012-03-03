package org.colorMine.tests;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Map;

import org.colorMine.ColorMine;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;

public class ColorMineTest {

	private BufferedImage _image;

	@BeforeTest
	public void setup() {
		BufferedImage _image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		_image.setRGB(0, 0, 0xFF0000);
	}

	public void getColorProfile_givenHeightAndWitdh1_returns1AsValue() {
		Map<Color, Integer> result = ColorMine.getColorProfile(_image);

		AssertJUnit.assertEquals(1, result.size());
	}

	public void getRgbProfile_givenRgbX_returnsRGbX_AsKey() {
		Map<Color, Integer> result = ColorMine.getColorProfile(_image);

		AssertJUnit.assertEquals(1, (int) result.get(Color.red));
	}
}