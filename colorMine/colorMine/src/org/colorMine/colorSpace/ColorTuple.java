package org.colorMine.colorSpace;

public abstract class ColorTuple implements IColorTuple {

	public abstract double[] getTuple();

	@Override
	public boolean equals(Object o) {
		if (null == o) {
			return false;
		}
		return this.hashCode() == o.hashCode();
	}

	@Override
	public int hashCode() {
		double[] tuple = getTuple();
		StringBuilder result = new StringBuilder();
		for (double d : tuple) {
			result.append(d);
			result.append("-");
		}
		return result.toString().hashCode();
	}

	public double compare(IColorTuple other) {
		double[] otherData = other.getTuple();
		double[] myData = getTuple();
		return Math.sqrt(Math.pow(myData[0] - otherData[0], 2) + Math.pow(myData[1] - otherData[1], 2) + Math.pow(myData[2] - otherData[2], 2));
	}

	@Override
	public String toString() {
		double[] tuple = getTuple();

		// ghetto, and it only really works for rgb...
		return String.format("%02x", dToI(tuple[0])) + String.format("%02x", dToI(tuple[1])) + String.format("%02x", dToI(tuple[2]));
	}

	private static int dToI(double d) {
		return (int) (255 * d);
	}

	public boolean isNearMatch(IColorTuple color, double nearMatchTorrerance) {
		double[] values = color.getTuple();
		double[] values2 = this.getTuple();

		return compareNearValue(values[0], values2[0], nearMatchTorrerance) && compareNearValue(values[1], values2[1], nearMatchTorrerance) && compareNearValue(values[2], values2[2], nearMatchTorrerance);
	}

	private boolean compareNearValue(double value, double otherValue, double nearMatchTorrerance) {
		if (value == otherValue || Math.abs(value - otherValue) <= nearMatchTorrerance) {
			return true;
		}

		return false;
	}

}
