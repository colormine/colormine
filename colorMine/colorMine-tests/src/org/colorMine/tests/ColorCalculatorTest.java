package org.colorMine.tests;

import junit.framework.TestCase;

import org.colorMine.ColorCalculator;
import org.colorMine.colorSpace.ColorSpaceConverter;
import org.colorMine.colorSpace.Hsl;
import org.colorMine.colorSpace.Rgb;
import org.junit.Test;

public class ColorCalculatorTest extends TestCase {
	

	@Test
	public void test_Should_convert_rgb_to_hsl() {

		// ARRANGE
		Hsl expected = new Hsl(.66,.44,.62);
		Rgb rgb = new Rgb(115,115,200);
		// ACT
		Hsl result = ColorSpaceConverter.rgbToHsl(rgb);
		
		// ASSERT
		assertTrue(result.isNearMatch(expected, .01));

	}
		
	@Test
	public void test_Should_return_1_for_color_complements() {

		// ARRANGE

		// ACT
		double result = ColorCalculator
				.isComplement("rgb", "144-238-144", "238-144-237");
		// ASSERT
		assertEquals(1.0, result);
	
	}
	
	@Test
	public void test_Should_return_0_for_Noncolor_complements() {

		// ARRANGE

		// ACT
		double result = ColorCalculator
				.isComplement("rgb", "144-238-144", "0-255-0");
		// ASSERT
		assertEquals(0.0, result);
	}
	
	
	
}
