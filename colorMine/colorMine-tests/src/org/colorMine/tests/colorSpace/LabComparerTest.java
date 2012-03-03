package org.colorMine.tests.colorSpace;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.text.DecimalFormat;

import org.colorMine.colorSpace.Lab;

@Test
public class LabComparerTest {

	public void NoDistance() {
		equals(0.0, new Lab(1, 0, 0), new Lab(1, 0, 0));
		equals(0.0, new Lab(0, 1, 0), new Lab(0, 1, 0));
		equals(0.0, new Lab(0, 0, 1), new Lab(0, 0, 1));
	}

	public void Distance() {
		equals(5.196, new Lab(1, 2, 3), new Lab(4, 5, 6));
	}

	private void equals(double score, Lab a, Lab b) {
		DecimalFormat format = new DecimalFormat("#.###");
		AssertJUnit.assertEquals(score, Double.valueOf(format.format(a.compare(b))));
	}

}
