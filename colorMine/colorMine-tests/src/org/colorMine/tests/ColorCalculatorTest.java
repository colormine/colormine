package org.colorMine.tests;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.awt.Color;

import org.colorMine.ColorCalculator;
import org.colorMine.colorSpace.ColorSpaceConverter;

@Test
public class ColorCalculatorTest {

	public void isComplement_GivenComplementaryColors_returnsTrue() {

		// ARRANGE
		Color color1 = new Color(144, 238, 144);
		Color color2 = new Color(238, 144, 237);
		// ACT
		boolean result = ColorCalculator.isComplement(color1, color2);
		// ASSERT
		AssertJUnit.assertEquals(true, result);

	}

	public void isComplement_GivenNonComplementaryColors_returnsFalse() {

		// ARRANGE
		Color color1 = new Color(144, 238, 144);
		Color color2 = new Color(0, 0, 255);
		// ACT
		boolean result = ColorCalculator.isComplement(color1, color2);
		// ASSERT
		AssertJUnit.assertEquals(false, result);
	}

	public void getTriadic_GivenAColor_returnsTwoValues() {

		// ARRANGE
		Color color1 = new Color(144, 238, 144);
		// ACT
		Color[] result = ColorCalculator.getTriadic(color1);
		// ASSERT
		AssertJUnit.assertEquals(2, result.length);
	}

	public void getAnalogous_GivenAColor_returnsTwoValues() {

		// ARRANGE
		Color color1 = new Color(144, 238, 144);
		// ACT
		Color[] result = ColorCalculator.getAnalogous(color1);
		// ASSERT
		AssertJUnit.assertEquals(2, result.length);
	}

	public void getSpiltComplements_GivenAColor_returnsTwoValues() {

		// ARRANGE
		Color color1 = new Color(144, 238, 144);
		// ACT
		Color[] result = ColorCalculator.getSplitComplements(color1);
		// ASSERT
		AssertJUnit.assertEquals(2, result.length);
	}

	public void getTriadic_GivenAColor_returnsTriadicColors() {

		// ARRANGE
		Color color1 = new Color(255, 0, 111);
		Color expectedColor1 = new Color(111, 255, 0);
		Color expectedColor2 = new Color(0, 110, 255);

		// ACT
		Color[] result = ColorCalculator.getTriadic(color1);

		// ASSERT
		AssertJUnit.assertTrue(contains(expectedColor1, result) && contains(expectedColor2, result));
	}

	public void getAnalogous_GivenAColor_returnsAnalogousColors() {

		// ARRANGE
		Color color1 = new Color(255, 0, 111);
		Color expectedColor1 = new Color(255, 16, 0);
		Color expectedColor2 = new Color(255, 0, 238);

		// ACT
		Color[] result = ColorCalculator.getAnalogous(color1);

		// ASSERT
		AssertJUnit.assertTrue(contains(expectedColor1, result) && contains(expectedColor2, result));
	}

	public void getSpiltComplements_GivenAColor_returnsSpiltComplements() {

		// ARRANGE
		Color color1 = new Color(255, 0, 111);
		Color expectedColor1 = new Color(0, 255, 16);
		Color expectedColor2 = new Color(0, 238, 255);

		// ACT
		Color[] result = ColorCalculator.getSplitComplements(color1);

		// ASSERT
		AssertJUnit.assertTrue(contains(expectedColor1, result) && contains(expectedColor2, result));
	}

	public void GetmatchScore_GivenExactMatchingColors_returnsZero() {
		// ARRANGE
		Color firstColor = new Color(255, 0, 0);
		Color secondColor = new Color(255, 0, 0);

		// ACT
		double result = ColorCalculator.GetMatchScore(firstColor, secondColor);
		// ASSERT
		AssertJUnit.assertEquals(result, 0.0);
	}

	// Helpers
	private boolean contains(Color color, Color[] colors) {
		for (Color c : colors) {
			if (ColorSpaceConverter.isNearMatch(c, color, 1.0)) {
				return true;
			}
		}
		return false;
	}

}
