package org.colorMine.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.awt.Color;

import org.colorMine.ColorCalculator;


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
	public void getTriadic_GivenAColor_returnsTriadicColors() {

		// ARRANGE
		Color color1 = new Color(255, 0, 111);
		Color expectedColor1 = new Color(104,180,255);
		Color ExpectedColor2 = new Color(144, 238, 144);
		// ACT
		Color[] result = ColorCalculator.getTriadic(color1);
		// ASSERT
		AssertJUnit.assertEquals(false, result);
	}
}
