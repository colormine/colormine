package org.colormine.tests.profile.filter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.colormine.image.Image;
import org.colormine.image.profile.ColorProfile;
import org.colormine.image.profile.Profile;
import org.colormine.image.profile.filter.FilterResult;
import org.colormine.image.profile.filter.MapFilter;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class MapFilterTest {

	private Image _image;

	@BeforeTest
	public void setup() {

		_image = mock(Image.class);
		when(_image.getHeight()).thenReturn(1);
		when(_image.getWidth()).thenReturn(1);
		when(_image.getRGB(0, 0)).thenReturn(0xFF0000);

	}

	@Test
	public void sanity() {
		// ARRANGE
		Map<Color, Integer> colors = new HashMap<Color, Integer>();
		colors.put(new Color(255, 0, 0), 1);
		Profile<Color> map = new ColorProfile(colors);

		MapFilter filter = new MapFilter(map);
		Profile<Color> imageProfile = new ColorProfile(_image);
		FilterResult<Profile<Color>> result = filter.apply(imageProfile);

		AssertJUnit.assertTrue(result.getOriginal() == imageProfile);
		AssertJUnit.assertTrue(0 == result.getDiscarded().size());
		AssertJUnit.assertTrue(1 == result.getFiltered().size());
	}

	public void basicRounding() {

		// ARRANGE
		Map<Color, Integer> colors = getBasicProfile();
		Profile<Color> map = new ColorProfile(colors);

		MapFilter filter = new MapFilter(map);
		Profile<Color> imageProfile = new ColorProfile(_image);
		FilterResult<Profile<Color>> result = filter.apply(imageProfile);
		Profile<Color> rgbColors = result.getFiltered();

		AssertJUnit.assertTrue(rgbColors.get(new Color(128, 0, 0)) > 0);
	}

	private Map<Color, Integer> getBasicProfile() {
		Map<Color, Integer> colors = new HashMap<Color, Integer>();
		colors.put(new Color(128, 0, 0), 1);
		colors.put(new Color(0, 128, 0), 1);
		colors.put(new Color(0, 0, 128), 1);
		return colors;
	}

}