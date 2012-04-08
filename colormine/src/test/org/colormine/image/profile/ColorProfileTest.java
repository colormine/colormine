package org.colormine.image.profile;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.Color;

import org.colormine.image.Image;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class ColorProfileTest {

	private Image _image;

	@BeforeTest
	public void setup() {
		_image = mock(Image.class);
	}

	public void ColorProfile() {

		// ARRANGE

		when(_image.getHeight()).thenReturn(1);
		when(_image.getWidth()).thenReturn(1);
		when(_image.getRGB(0, 0)).thenReturn(0xFF0000);

		// ACT

		ColorProfile result = new ColorProfile(_image);

		// ASSERT

		AssertJUnit.assertEquals(1, result.size());
		AssertJUnit.assertEquals(1, (int) result.get(Color.RED));
	}

	public void colorProfileQuantity() {

		// ARRANGE
		when(_image.getHeight()).thenReturn(2);
		when(_image.getWidth()).thenReturn(2);
		when(_image.getRGB(0, 0)).thenReturn(0xFF0000);
		when(_image.getRGB(0, 1)).thenReturn(0xFF0000);
		when(_image.getRGB(1, 0)).thenReturn(0xFF0000);
		when(_image.getRGB(1, 1)).thenReturn(0x000000);

		// ACT
		ColorProfile result = new ColorProfile(_image);

		// ASSERT
		AssertJUnit.assertEquals(2, result.size());
		AssertJUnit.assertEquals(3, (int) result.get(Color.RED));
		AssertJUnit.assertEquals(1, (int) result.get(Color.BLACK));
	}

	public void colorProfileAccuracy() {

		// ARRANGE
		when(_image.getHeight()).thenReturn(2);
		when(_image.getWidth()).thenReturn(2);
		when(_image.getRGB(0, 0)).thenReturn(0x123456);
		when(_image.getRGB(0, 1)).thenReturn(0xF2C4A6);
		when(_image.getRGB(1, 0)).thenReturn(0xCCCCCC);
		when(_image.getRGB(1, 1)).thenReturn(0xDDDDDD);

		// ACT
		ColorProfile result = new ColorProfile(_image);

		// ASSERT
		AssertJUnit.assertEquals(4, result.size());
		AssertJUnit.assertEquals(1, (int) result.get(new Color(0x123456)));
		AssertJUnit.assertEquals(1, (int) result.get(new Color(0xF2C4A6)));
		AssertJUnit.assertEquals(1, (int) result.get(new Color(0xCCCCCC)));
		AssertJUnit.assertEquals(1, (int) result.get(new Color(0xDDDDDD)));
	}

}