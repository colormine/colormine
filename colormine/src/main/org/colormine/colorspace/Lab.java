package org.colormine.colorspace;

/**
 * ColorTuple representing the Lab color space
 */
public class Lab extends ColorTuple {
	public final double L;
	public final double A;
	public final double B;

	/**
	 * Create Lab from values
	 * 
	 * @param l
	 * @param a
	 * @param b
	 */
	public Lab(double l, double a, double b) {
		L = l;
		A = a;
		B = b;
	}

	/**
	 * Provides access to the coordinates that make up this color space in a
	 * uniform way.
	 * 
	 * @return array containing the lab coordinates
	 */
	@Override
	public Double[] getTuple() {
		return new Double[] { L, A, B };
	}

}