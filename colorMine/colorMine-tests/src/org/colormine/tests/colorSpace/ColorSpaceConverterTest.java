package org.colormine.tests.colorSpace;

import java.awt.Color;

import org.colormine.colorspace.ColorSpaceConverter;
import org.colormine.colorspace.Hsl;
import org.colormine.colorspace.Lab;
import org.colormine.colorspace.Xyz;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@Test
public class ColorSpaceConverterTest {

	public void colorToHsl_givenColorValue_returnsHsl() {

		// ARRANGE
		Hsl expected = new Hsl(.66, .44, .62);
		Color color = new Color(115, 115, 200);

		// ACT
		Hsl result = ColorSpaceConverter.colorToHsl(color);

		// ASSERT
		AssertJUnit.assertTrue(ColorSpaceConverter.isNearMatch(expected, result, .01));
	}

	public void colorToXyz_givenColor_returnsXyz() {

		// ARRANGE
		Color color = new Color(255, 0, 0);
		Xyz expected = new Xyz(41.240, 21.260, 1.930);

		// ACT
		Xyz xyz = ColorSpaceConverter.colorToXyz(color);

		// ASSERT
		AssertJUnit.assertTrue(ColorSpaceConverter.isNearMatch(xyz, expected, .001));
	}

	public void xyzToLab_givenXyz_returnsLab() {

		// ARRANGE
		Xyz xyz = new Xyz(41.240, 21.260, 1.930);
		Lab expected = new Lab(53.233, 80.109, 67.220);
		// ACT
		Lab lab = ColorSpaceConverter.xyzToLab(xyz);

		// ASSERT
		AssertJUnit.assertTrue(ColorSpaceConverter.isNearMatch(lab, expected, .001));
	}

	public void colorToLab_givenColor_returnsLab() {

		// ARRANGE
		Color color = new Color(255, 0, 0);
		Lab expected = new Lab(53.233, 80.109, 67.220);

		// ACT
		Lab lab = ColorSpaceConverter.colorToLab(color);

		// ASSERT
		AssertJUnit.assertTrue(ColorSpaceConverter.isNearMatch(lab, expected, .001));
	}

}