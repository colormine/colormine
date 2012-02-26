package org.colorMine.tests.colorSpace;

import java.awt.Color;
import java.text.DecimalFormat;

import org.colorMine.colorSpace.ColorSpaceConverter;
import org.colorMine.colorSpace.Lab;
import org.colorMine.colorSpace.Rgb;
import org.colorMine.colorSpace.Xyz;


import junit.framework.TestCase;

public class ColorSpaceConverterTest extends TestCase {

	public void testRgbToXyz() {
		Rgb rgb = new Rgb(1, 0, 0);
		Xyz xyz = ColorSpaceConverter.rgbToXyz(rgb);
		Xyz expected = new Xyz(41.240, 21.260, 1.930);

		match(expected.X, xyz.X);
		match(expected.Y, xyz.Y);
		match(expected.Z, xyz.Z);
	}

	public void testRgbToColor() {
		Rgb rgb = new Rgb(1, 0, 0);
		Color color = ColorSpaceConverter.rgbToColor(rgb);
		assertEquals(color, Color.RED);
	}

	public void testColorConversion() {
		Color color = new Color(12, 34, 56);
		Rgb rgb = ColorSpaceConverter.colorToRgb(color);
		Color actual = ColorSpaceConverter.rgbToColor(rgb);
		assertEquals(color, actual);
	}

	public void testXyzToLab() {
		Xyz xyz = new Xyz(41.240, 21.260, 1.930);
		Lab lab = ColorSpaceConverter.xyzToLab(xyz);
		Lab expected = new Lab(53.233, 80.109, 67.220);

		match(expected.L, lab.L);
		match(expected.A, lab.A);
		match(expected.B, lab.B);
	}

	public void testRgbToLab() {
		Rgb rgb = new Rgb(1, 0, 0);
		Lab lab = ColorSpaceConverter.rgbToLab(rgb);
		Lab expected = new Lab(53.233, 80.109, 67.220);

		match(expected.L, lab.L);
		match(expected.A, lab.A);
		match(expected.B, lab.B);
	}

	private void match(double a, double b) {
		DecimalFormat format = new DecimalFormat("#.##");
		assertEquals(Double.valueOf(format.format(a)),
				Double.valueOf(format.format(b)));
	}
}