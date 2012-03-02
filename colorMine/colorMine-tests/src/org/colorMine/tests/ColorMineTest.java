package org.colorMine.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;

import java.awt.image.BufferedImage;
import java.util.Map;

import org.colorMine.ColorMine;
import org.colorMine.colorSpace.Rgb;






public class ColorMineTest  {

	private BufferedImage _image;
	
	@BeforeTest
	public void setup(){
		BufferedImage _image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		_image.setRGB(0, 0, 0xFF0000);
	}
	public void getRgbProfile_GivenhieghtAndwitdh1_returns1AsValue() {

		Map<Rgb, Integer> result = ColorMine.getRgbProfile(_image);

		AssertJUnit.assertEquals(1, result.size());
	}
	public void getRgbProfile_GivenRgbX_returnsRGbX_AsKey() {

		Map<Rgb, Integer> result = ColorMine.getRgbProfile(_image);

		AssertJUnit.assertEquals(1, (int) result.get(new Rgb(1, 0, 0)));
	}

}