package org.colorMine.profile;

import java.util.Map;

import org.colorMine.colorSpace.Rgb;

public class MapCount {

	public static void count(Map<Rgb, Integer> map, Rgb key) {
		int quantity = map.containsKey(key) ? (int) map.get(key) + 1 : 1;
		map.put(key, quantity);
	}

}
