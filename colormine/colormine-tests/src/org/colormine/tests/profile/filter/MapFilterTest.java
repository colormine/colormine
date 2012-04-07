package org.colormine.tests.profile.filter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.colormine.profile.ColorProfile;
import org.colormine.profile.IColorProfile;
import org.colormine.profile.IColoredImage;
import org.colormine.profile.filter.IColorProfileFilterResult;
import org.colormine.profile.filter.MapFilter;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class MapFilterTest {

	private IColoredImage _image;

	@BeforeTest
	public void setup() {

		_image = mock(IColoredImage.class);
		when(_image.getHeight()).thenReturn(1);
		when(_image.getWidth()).thenReturn(1);
		when(_image.getRGB(0, 0)).thenReturn(0xFF0000);

	}

	@Test
	public void sanity() {
		// ARRANGE
		Map<Color, Integer> colors = new HashMap<Color, Integer>();
		colors.put(new Color(255, 0, 0), 1);
		IColorProfile map = new ColorProfile(colors);

		MapFilter filter = new MapFilter(map);
		IColorProfile imageProfile = new ColorProfile(_image);
		IColorProfileFilterResult result = filter.apply(imageProfile);

		AssertJUnit.assertTrue(result.getOriginalProfile() == imageProfile);
		AssertJUnit.assertTrue(0 == result.getDiscardedProfile().getColorProfile().size());
		AssertJUnit.assertTrue(1 == result.getFilteredProfile().getColorProfile().size());
	}

	public void basicRounding() {

		// ARRANGE
		Map<Color, Integer> colors = getBasicProfile();
		IColorProfile map = new ColorProfile(colors);

		MapFilter filter = new MapFilter(map);
		IColorProfile imageProfile = new ColorProfile(_image);
		IColorProfileFilterResult result = filter.apply(imageProfile);
		Map<Color, Integer> rgbColors = result.getFilteredProfile().getColorProfile();

		AssertJUnit.assertTrue(rgbColors.containsKey(new Color(128, 0, 0)));
	}

	private Map<Color, Integer> getBasicProfile() {
		Map<Color, Integer> colors = new HashMap<Color, Integer>();
		colors.put(new Color(128, 0, 0), 1);
		colors.put(new Color(0, 128, 0), 1);
		colors.put(new Color(0, 0, 128), 1);
		return colors;
	}

}