package org.colormine.colorspace;

public abstract class ColorTuple implements Tuple<Double> {

	public abstract Double[] getTuple();

	public double compare(ColorTuple other) {
		Double[] otherData = other.getTuple();
		Double[] myData = getTuple();
		return Math.sqrt(Math.pow(myData[0] - otherData[0], 2) + Math.pow(myData[1] - otherData[1], 2) + Math.pow(myData[2] - otherData[2], 2));
	}

	public boolean isNearMatch(ColorTuple color, double nearMatchTorrerance) {
		Double[] values = color.getTuple();
		Double[] values2 = this.getTuple();

		return compareNearValue(values[0], values2[0], nearMatchTorrerance) && compareNearValue(values[1], values2[1], nearMatchTorrerance) && compareNearValue(values[2], values2[2], nearMatchTorrerance);
	}

	private boolean compareNearValue(double value, double otherValue, double nearMatchTorrerance) {
		if (value == otherValue || Math.abs(value - otherValue) <= nearMatchTorrerance) {
			return true;
		}

		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (null == o) {
			return false;
		}
		return this.hashCode() == o.hashCode();
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		Double[] tuple = getTuple();
		return "" + tuple[0] + '-' + tuple[1] + '-' + tuple[2];
	}

}
