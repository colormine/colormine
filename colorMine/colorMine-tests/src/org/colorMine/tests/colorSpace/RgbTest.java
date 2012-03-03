package org.colorMine.tests.colorSpace;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.colorMine.colorSpace.Rgb;


@Test
public class RgbTest {

	@Test
	public void Rgb() {
		Rgb rgb = new Rgb(1, 0xCB / 255, 1 / 255);

		double redExpected = 0xFF / 255;
		double greenExpected = 0xCB / 255;
		double blueExpected = 0x01 / 255;

		AssertJUnit.assertEquals(redExpected, rgb.R);
		AssertJUnit.assertEquals(greenExpected, rgb.G);
		AssertJUnit.assertEquals(blueExpected, rgb.B);
	}
}
