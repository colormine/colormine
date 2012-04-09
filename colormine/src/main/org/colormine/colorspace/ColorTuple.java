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
	 * @return the distance in 3d space
	 */
	public double compare(ColorTuple other) {
		Double[] otherData = other.getTuple();
		Double[] myData = getTuple();
		return Math.sqrt(Math.pow(myData[0] - otherData[0], 2) + Math.pow(myData[1] - otherData[1], 2) + Math.pow(myData[2] - otherData[2], 2));
	}

	/**
	 * Determines if two items are "close enough" given a tolerance.
	 * 
	 * @param color
	 * @param tolerance
	 * @return true if images are "close enough"
	 */
	public boolean isNearMatch(ColorTuple color, double tolerance) {
		return ColorSpaceConverter.isNearMatch(this, color, tolerance);
	}

	/**
	 * Uses the result of the toString method so we can treat ColorTuples like a
	 * value type, meaning that two ColorTuples of the same value will have the
	 * same hash code even though they are different objects.
	 * 
	 * @return true if objects contain the same coordinates
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
	 * 
	 * @return hascode based on the value of the coordinates
	 */
	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	/**
	 * Get easily readable string representation.
	 * 
	 * @return returns the coordinates in format %d-%d-%d for readability
	 */
	@Override
	public String toString() {
		Double[] tuple = getTuple();
		return "" + tuple[0] + '-' + tuple[1] + '-' + tuple[2];
	}

}