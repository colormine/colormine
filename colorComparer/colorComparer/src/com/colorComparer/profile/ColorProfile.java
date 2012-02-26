package com.colorComparer.profile;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import com.colorComparer.colorSpace.ColorSpaceConverter;
import com.colorComparer.colorSpace.Rgb;
import com.colorComparer.colorSpace.Lab;

public class ColorProfile implements IColorProfile {
	private final Map<Rgb, Integer> _colors;
	private final int _pixelCount;

	public ColorProfile(BufferedImage image) {
		_colors = getProfile(image);
		_pixelCount = image.getWidth() * image.getHeight();
	}

	public ColorProfile(Map<Rgb, Integer> profileMap) {
		int count = 0;
		for (Rgb key : profileMap.keySet()) {
			count += profileMap.get(key);
		}

		_colors = profileMap;
		_pixelCount = count;
	}


	public Map<Color, Integer> getColorProfile() {
		HashMap<Color, Integer> colorProfile = new HashMap<Color, Integer>();
		for (Rgb key : _colors.keySet()) {
			colorProfile.put(ColorSpaceConverter.rgbToColor(key),
					_colors.get(key));
		}
		return colorProfile;
	}

	public Map<Rgb, Integer> getRgbProfile() {
		return _colors;
	}

	public Map<Lab, Integer> getLabProfile() {
		HashMap<Lab, Integer> labProfile = new HashMap<Lab, Integer>();
		for (Rgb key : _colors.keySet()) {
			labProfile.put(ColorSpaceConverter.rgbToLab(key), _colors.get(key));
		}
		return labProfile;
	}

	public int getPixelCount() {
		return _pixelCount;
	}

	// TODO I don't like supporting more than one type, which one to stick to?
	public Lab getAverageLab() {
		Map<Lab, Integer> labColors = getLabProfile();
		double[] coordinates =  { 0, 0, 0 };

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

	private Map<Rgb, Integer> getProfile(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		Map<Rgb, Integer> profile = new HashMap<Rgb, Integer>();

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Color color = new Color(image.getRGB(x, y));
				Rgb rgbColor = ColorSpaceConverter.colorToRgb(color);
				MapCount.count(profile, rgbColor);
			}
		}

		return profile;
	}

}