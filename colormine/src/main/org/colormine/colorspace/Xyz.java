package org.colormine.colorspace;

/**
 * ColorTuple representing the Xyz color space
 */
public class Xyz extends ColorTuple {
	public final double X;
	public final double Y;
	public final double Z;

	/**
	 * Create Xyz from values
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Xyz(double x, double y, double z) {
		X = x;
		Y = y;
		Z = z;
	}

	/**
	 * Provides access to the coordinates that make up this color space in a
	 * uniform way.
	 * 
	 * @return array containing the xyz coordinates
	 */
	@Override
	public Double[] getTuple() {
		return new Double[] { X, Y, Z };
	}

}