package org.colormine.colorspace;

public class Lab extends ColorTuple {
	public final double L;
	public final double A;
	public final double B;

	// should probably be pulled out to a factory-ish thing
	public Lab(double[] tuple) {
		this(tuple[0], tuple[1], tuple[2]);
	}

	public Lab(double l, double a, double b) {
		L = l;
		A = a;
		B = b;
	}

	public Double[] getTuple() {
		return new Double[] { L, A, B };
	}

}