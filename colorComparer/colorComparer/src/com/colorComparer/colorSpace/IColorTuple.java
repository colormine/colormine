package com.colorComparer.colorSpace;

public interface IColorTuple {
	public double[] getTuple();

	public abstract boolean isNearMatch(IColorTuple color, double nearMatchTorrerance);
}