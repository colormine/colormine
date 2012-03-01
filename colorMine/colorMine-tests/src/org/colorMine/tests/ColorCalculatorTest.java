package org.colorMine.tests;

import java.awt.Color;

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
		Color color1 = new Color(144,238,144);
		Color color2 = new Color(238,144,237);
		// ACT
		boolean result = ColorCalculator
			.isComplement(color1,color2);
		// ASSERT
		assertEquals(true, result);
	
	}
	
	@Test
	public void test_Should_return_0_for_Noncolor_complements() {

		// ARRANGE
		Color color1 = new Color(144,238,144);
		Color color2 = new Color(0,0,255);
		// ACT
		boolean result = ColorCalculator
			.isComplement(color1,color2);
		// ASSERT
		assertEquals(true, result);
	}
	
	
	
}
