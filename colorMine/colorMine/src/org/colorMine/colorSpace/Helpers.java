package org.colorMine.colorSpace;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

 final class Helpers {

	 static double max(double... numbers) {
		Arrays.sort(numbers);
		return numbers[numbers.length - 1];
	}
	 static double min(double... numbers) {
		Arrays.sort(numbers);
		return numbers[0];
	}
	 static double roundTwoDecimals(double value) {
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		twoDForm.setRoundingMode(RoundingMode.FLOOR);
		return Double.valueOf(twoDForm.format(value));
}
}
