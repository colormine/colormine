package org.colorMine.colorSpace;

import java.awt.Color;

public class Rgb extends ColorTuple implements IColorTuple {
	public final double R;
	public final double G;
	public final double B;

	// should probably be pulled out to a factory-ish thing
	public Rgb(double[] tuple) {
		this(tuple[0], tuple[1], tuple[2]);
	}

	public Rgb(Color color) {
		R = color.getRed();
		G = color.getGreen();
		B = color.getBlue();
	}

	public Rgb(double r, double g, double b) {
		R = r;
		G = g;
		B = b;
	}

	public Rgb(Double[] rgb) {
		R = rgb[0];
		G = rgb[1];
		B = rgb[2];
	}

	public double[] getTuple() {
		return new double[] { R, G, B };
	}

	public String toHex() {
		return "#" + toBrowserHexValue((int) R) + toBrowserHexValue((int) G) + toBrowserHexValue((int) B);
	}

	private static String toBrowserHexValue(int number) {
		StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
		while (builder.length() < 2) {
			builder.append("0");
		}
		return builder.toString().toUpperCase();
	}

}