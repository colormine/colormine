package org.colormine.tests.colorspace;

import java.text.DecimalFormat;

import org.colormine.colorspace.Lab;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@Test
public class LabComparerTest {

	public void noDistance() {
		equals(0.0, new Lab(1, 0, 0), new Lab(1, 0, 0));
		equals(0.0, new Lab(0, 1, 0), new Lab(0, 1, 0));
		equals(0.0, new Lab(0, 0, 1), new Lab(0, 0, 1));
	}

	public void distance() {
		equals(5.196, new Lab(1, 2, 3), new Lab(4, 5, 6));
	}

	private void equals(double score, Lab a, Lab b) {
		DecimalFormat format = new DecimalFormat("#.###");
		AssertJUnit.assertEquals(score, Double.valueOf(format.format(a.compare(b))));
	}

}
