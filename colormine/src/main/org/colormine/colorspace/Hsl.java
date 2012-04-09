package org.colormine.colorspace;

/**
 * ColorTuple representing the Hsl color space
 */
public class Hsl extends ColorTuple {
	public final double H;
	public final double S;
	public final double L;

	/**
	 * Create Hsl from values
	 * 
	 * @param h
	 * @param s
	 * @param l
	 */
	public Hsl(double h, double s, double l) {
		H = h;
		S = s;
		L = l;
	}

	/**
	 * Provides access to the coordinates that make up this color space in a
	 * uniform way.
	 * 
	 * @return array containing the hsl coordinates
	 */
	@Override
	public Double[] getTuple() {
		return new Double[] { H, S, L };
	}
}