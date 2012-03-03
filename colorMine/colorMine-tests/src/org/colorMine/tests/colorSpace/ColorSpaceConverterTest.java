package org.colorMine.tests.colorSpace;

import static org.testng.AssertJUnit.*;

import java.awt.Color;

import org.colorMine.colorSpace.ColorSpaceConverter;
import org.colorMine.colorSpace.Hsl;
import org.colorMine.colorSpace.Lab;
import org.colorMine.colorSpace.Rgb;
import org.colorMine.colorSpace.Xyz;
import org.testng.annotations.Test;

@Test
public class ColorSpaceConverterTest {

	
	public void rgbToHsl_GivenHslValue_ReturnsRgb() {

		// ARRANGE
		Hsl expected = new Hsl(.66, .44, .62);
		Rgb rgb = new Rgb(115, 115, 200);
		// ACT
		Hsl result = ColorSpaceConverter.rgbToHsl(rgb);

		// ASSERT

		assert(ColorSpaceConverter.isNearMatch(expected,result, .01));


	}

	public void RgbToXyz_givenRgb_ReturnsXyz() {
		Rgb rgb = new Rgb(1, 0, 0);
		Xyz xyz = ColorSpaceConverter.rgbToXyz(rgb);
		Xyz expected = new Xyz(41.240, 21.260, 1.930);
		
		assert(ColorSpaceConverter.isNearMatch(xyz,expected, .001));

		
	}

	public void XyzToLab_givenXyz_ReturnsLab() {
		Xyz xyz = new Xyz(41.240, 21.260, 1.930);
		Lab lab = ColorSpaceConverter.xyzToLab(xyz);
		Lab expected = new Lab(53.233, 80.109, 67.220);


		assert(ColorSpaceConverter.isNearMatch(lab,expected, .001));

	}

	public void test_RgbToLab_givenRgb_ReturnsLab() {
		Rgb rgb = new Rgb(1, 0, 0);
		Lab lab = ColorSpaceConverter.rgbToLab(rgb);
		Lab expected = new Lab(53.233, 80.109, 67.220);

		assert(ColorSpaceConverter.isNearMatch(lab,expected, .001));

	}

	public void RgbToColor_givenRgb_ReturnsColor() {
		Rgb rgb = new Rgb(1, 0, 0);
		Color color = ColorSpaceConverter.rgbToColor(rgb);
		assertEquals(color, Color.RED);
	}

	public void ColorConversion() {
		Color color = new Color(12, 34, 56);
		Rgb rgb = ColorSpaceConverter.colorToRgb(color);
		Color actual = ColorSpaceConverter.rgbToColor(rgb);
		assertEquals(color, actual);
	}

}