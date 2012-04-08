package org.colormine.tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.Color;

import org.colormine.ColorMine;
import org.colormine.image.Image;
import org.colormine.image.profile.Profile;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class ColorMineTest {

	private Image _image;

	@BeforeTest
	public void setup() {

		_image = mock(Image.class);
		when(_image.getHeight()).thenReturn(1);
		when(_image.getWidth()).thenReturn(1);
		when(_image.getRGB(0, 0)).thenReturn(0xFF0000);

	}

	public void getColorProfile_givenHeightAndWitdh1_returns1AsValue() {
		Profile<Color> result = ColorMine.getColorProfile(_image);

		AssertJUnit.assertEquals(1, result.size());
	}

	public void getRgbProfile_givenColorX_returnColorX_AsKey() {
		Profile<Color> result = ColorMine.getColorProfile(_image);

		AssertJUnit.assertEquals(1, (int) result.get(Color.red));
	}
}