package org.colormine.profile;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.colormine.colorspace.ColorSpaceConverter;
import org.colormine.colorspace.Lab;


public class ColorProfile implements IColorProfile {
	private final Map<Color, Integer> _colors;
	private final int _pixelCount;

	public ColorProfile(IColoredImage image) {
		_colors = getProfile(image);
		_pixelCount = image.getWidth() * image.getHeight();
	}

	public ColorProfile(Map<Color, Integer> profileMap) {
		int count = 0;
		for (Color key : profileMap.keySet()) {
			count += profileMap.get(key);
		}

		_colors = profileMap;
		_pixelCount = count;
	}

	public Map<Color, Integer> getColorProfile() {
		HashMap<Color, Integer> colorProfile = new HashMap<Color, Integer>();
		for (Color key : _colors.keySet()) {
			colorProfile.put(key, _colors.get(key));
		}
		return colorProfile;
	}

	public Map<Lab, Integer> getLabProfile() {
		HashMap<Lab, Integer> labProfile = new HashMap<Lab, Integer>();
		for (Color key : _colors.keySet()) {
			labProfile.put(ColorSpaceConverter.colorToLab(key), _colors.get(key));
		}
		return labProfile;
	}

	public int getPixelCount() {
		return _pixelCount;
	}

	// TODO I don't like supporting more than one type, which one to stick to?
	public Lab getAverageLab() {
		Map<Lab, Integer> labColors = getLabProfile();
		double[] coordinates = { 0, 0, 0 };

		for (Lab key : labColors.keySet()) {
			coordinates[0] += key.L;
			coordinates[1] += key.A;
			coordinates[2] += key.B;
		}

		coordinates[0] /= labColors.size();
		coordinates[1] /= labColors.size();
		coordinates[2] /= labColors.size();

		return new Lab(coordinates);
	}

	private Map<Color, Integer> getProfile(IColoredImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		Map<Color, Integer> profile = new HashMap<Color, Integer>();

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Color color = new Color(image.getRGB(x, y));
				MapCount.count(profile, color);
			}
		}

		return profile;
	}

}