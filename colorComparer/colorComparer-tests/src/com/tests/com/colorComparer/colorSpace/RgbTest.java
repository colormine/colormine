package com.tests.com.colorComparer.colorSpace;

import com.colorComparer.colorSpace.Rgb;

import junit.framework.TestCase;

public class RgbTest extends TestCase {

	public void testRgb() {
		Rgb rgb = new Rgb(1, 0xCB / 255, 1 / 255);

		double redExpected = 0xFF / 255;
		double greenExpected = 0xCB / 255;
		double blueExpected = 0x01 / 255;

		assertEquals(redExpected, rgb.R);
		assertEquals(greenExpected, rgb.G);
		assertEquals(blueExpected, rgb.B);
	}
}
