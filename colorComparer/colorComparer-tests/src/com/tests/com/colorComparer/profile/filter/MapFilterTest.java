package com.tests.com.colorComparer.profile.filter;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;
import com.colorComparer.colorSpace.Rgb;
import com.colorComparer.profile.*;
import com.colorComparer.profile.filter.IColorProfileFilterResult;
import com.colorComparer.profile.filter.MapFilter;

public class MapFilterTest extends TestCase {

	public void testSanity() {
		Map<Rgb, Integer> colors = new HashMap<Rgb, Integer>();
		colors.put(new Rgb(new double[] { 1, 0, 0 }), 1);
		IColorProfile map = new ColorProfile(colors);

		BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		image.setRGB(0, 0, 0xFF0000);
		MapFilter filter = new MapFilter(map); 
		IColorProfile imageProfile = new ColorProfile(image);
		IColorProfileFilterResult result = filter.apply(imageProfile);
		assertTrue(result.getOriginalProfile() == imageProfile);
		assertTrue(0 == result.getDiscardedProfile().getRgbProfile().size());
		assertTrue(1 == result.getFilteredProfile().getRgbProfile().size());
	}

	public void testBasicRounding() {
		Map<Rgb, Integer> colors = getBasicProfile();
		IColorProfile map = new ColorProfile(colors);
		BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		image.setRGB(0, 0, 0xFF0000);
		MapFilter filter = new MapFilter(map);
		IColorProfile imageProfile = new ColorProfile(image);
		IColorProfileFilterResult result = filter.apply(imageProfile);
		Map<Rgb,Integer> rgbColors = result.getFilteredProfile().getRgbProfile();
		assertTrue(rgbColors.containsKey(new Rgb(.5,0,0)));
	}

	private Map<Rgb, Integer> getBasicProfile() {
		Map<Rgb, Integer> colors = new HashMap<Rgb, Integer>();
		colors.put(new Rgb(new double[] { .5, 0, 0 }), 1);
		colors.put(new Rgb(new double[] { 0, .5, 0 }), 1);
		colors.put(new Rgb(new double[] { 0, 0, .5 }), 1);
		return colors;
	}
	
}