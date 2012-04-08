package org.colormine.colorspace;

public class Xyz extends ColorTuple implements Tuple {
	public final double X;
	public final double Y;
	public final double Z;

	public Xyz(double x, double y, double z) {
		X = x;
		Y = y;
		Z = z;
	}

	public double[] getTuple() {
		return new double[] { X, Y, Z };
	}

}