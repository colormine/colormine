package org.colormine.colorspace;

public class Hsl extends ColorTuple implements IColorTuple {
	public final double H;
	public final double S;
	public final double L;

	// should probably be pulled out to a factory-ish thing
	public Hsl(double[] tuple) {
		this(tuple[0], tuple[1], tuple[2]);
	}

	public Hsl(double h, double s, double l) {
		H = h;
		S = s;
		L = l;
	}

	public Hsl(float[] vaules) {
		H = vaules[0];
		S = vaules[1];
		L = vaules[2];
	}

	public double[] getTuple() {
		return new double[] { H, S, L };
	}
}
