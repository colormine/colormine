package com.tests.com.colorComparer.colorSpace;

import java.text.DecimalFormat;
import com.colorComparer.colorSpace.Lab;
import junit.framework.TestCase;

public class LabComparerTest extends TestCase {

	public void testNoDistance() {
		equals(0.0, new Lab(1, 0, 0), new Lab(1, 0, 0));
		equals(0.0, new Lab(0, 1, 0), new Lab(0, 1, 0));
		equals(0.0, new Lab(0, 0, 1), new Lab(0, 0, 1));
	}

	public void testDistance() {
		equals(5.196, new Lab(1, 2, 3), new Lab(4, 5, 6));
	}

	private void equals(double score, Lab a, Lab b) {
		DecimalFormat format = new DecimalFormat("#.###");
		assertEquals(score,
				Double.valueOf(format.format(a.compare(b))));
	}

}
