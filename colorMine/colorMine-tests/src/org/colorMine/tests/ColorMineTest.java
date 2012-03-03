package org.colorMine.tests;

import java.awt.Color;
import java.util.Map;
import org.colorMine.ColorMine;
import org.colorMine.profile.IColoredImage;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

@Test
public class ColorMineTest {

	private IColoredImage _image;
	
	@BeforeTest
	public void setup() {
		
		_image = mock(IColoredImage.class);
		when(_image.getHeight()).thenReturn(1);
		when(_image.getWidth()).thenReturn(1);
		when(_image.getRGB(0,0)).thenReturn(0xFF0000);

	}

	public void getColorProfile_givenHeightAndWitdh1_returns1AsValue() {
		Map<Color, Integer> result = ColorMine.getColorProfile(_image);

		AssertJUnit.assertEquals(1, result.size());
	}

	public void getRgbProfile_givenRgbX_returnsRGbX_AsKey() {
		Map<Color, Integer> result = ColorMine.getColorProfile(_image);

		AssertJUnit.assertEquals(1, (int) result.get(Color.red));
	}
}