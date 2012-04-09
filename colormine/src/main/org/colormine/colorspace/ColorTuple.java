package org.colormine.colorspace;

/**
 * Abstract class that provides the color space classes with common
 * functionality and implements the Tuple<Double> interface
 */

public abstract class ColorTuple implements Tuple<Double> {

	/**
	 * All ColorTuple descendants must provide a way to access the coordinates
	 * that make up the color space in a uniform way.
	 */
	public abstract Double[] getTuple();

	/**
	 * Determine how close two ColorTuples are to each other using the distance
	 * formula in three dimensional space.
	 * 
	 * @param other
	 * @return
	 */
	public double compare(ColorTuple other) {
		Double[] otherData = other.getTuple();
		Double[] myData = getTuple();
		return Math.sqrt(Math.pow(myData[0] - otherData[0], 2) + Math.pow(myData[1] - otherData[1], 2) + Math.pow(myData[2] - otherData[2], 2));
	}

	/**
	 * Determines if two items are "close enough" given a tolerance
	 * 
	 * @param firstColor
	 * @param secondColor
	 * @param nearMatchTolerance
	 * @return
	 */
	public boolean isNearMatch(ColorTuple color, double tolerance) {
		Double[] values = color.getTuple();
		Double[] values2 = this.getTuple();

		return ColorSpaceConverter.compareNearValue(values[0], values2[0], tolerance) && ColorSpaceConverter.compareNearValue(values[1], values2[1], tolerance) && ColorSpaceConverter.compareNearValue(values[2], values2[2], tolerance);
	}

	/**
	 * Uses the result of the toString method so we can treat ColorTuples like a
	 * value type, meaning that two ColorTuples of the same value will have the
	 * same hash code even though they are different objects.
	 */
	@Override
	public boolean equals(Object o) {
		if (null == o) {
			return false;
		}
		return this.hashCode() == o.hashCode();
	}

	/**
	 * Uses the result of the toString method so we can treat ColorTuples like a
	 * value type, meaning that two ColorTuples of the same value will have the
	 * same hash code even though they are different objects.
	 */
	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	/**
	 * Returns a pretty-formatted version of the ColorTuple
	 */
	@Override
	public String toString() {
		Double[] tuple = getTuple();
		return "" + tuple[0] + '-' + tuple[1] + '-' + tuple[2];
	}

}