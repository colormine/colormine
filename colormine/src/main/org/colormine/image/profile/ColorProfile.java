package org.colormine.image.profile;

import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.colormine.image.Image;

public class ColorProfile implements Profile<Color> {

	private Map<Color, Integer> _colors = new HashMap<Color, Integer>();
	private int _total = 0;

	public ColorProfile() {
	}

	public ColorProfile(Image image) {
		int width = image.getWidth();
		int height = image.getHeight();

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Color color = new Color(image.getRGB(x, y));
				put(color);
			}
		}
	}

	public ColorProfile(Map<Color, Integer> colors) {
		Iterator<Map.Entry<Color, Integer>> color = colors.entrySet().iterator();
		while (color.hasNext()) {
			Map.Entry<Color, Integer> pairs = (Map.Entry<Color, Integer>) color.next();
			put(pairs.getKey(), pairs.getValue());
		}
	}

	public ColorProfile(Profile<Color> colors) {
		Iterator<Map.Entry<Color, Integer>> color = colors.entrySet().iterator();
		while (color.hasNext()) {
			Map.Entry<Color, Integer> pairs = (Map.Entry<Color, Integer>) color.next();
			put(pairs.getKey(), pairs.getValue());
		}
	}

	@Override
	public void put(Color key) {
		int count = get(key) + 1;
		_colors.put(key, count);
		_total += count;
	}

	@Override
	public void put(Color key, int count) {
		_colors.put(key, count);
		_total += count;
	}

	@Override
	public int get(Color key) {
		return _colors.containsKey(key) ? _colors.get(key) : 0;
	}

	@Override
	public int getTotal() {
		return _total;
	}

	@Override
	public int size() {
		return _colors.size();
	}

	@Override
	public Set<Entry<Color, Integer>> entrySet() {
		return _colors.entrySet();
	}

	@Override
	public Set<Color> keySet() {
		return _colors.keySet();
	}
}