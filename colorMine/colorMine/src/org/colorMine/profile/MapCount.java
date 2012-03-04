package org.colorMine.profile;

import java.awt.Color;
import java.util.Map;


public class MapCount {

	public static void count(Map<Color, Integer> map, Color key) {
		int quantity = map.containsKey(key) ? (int) map.get(key) + 1 : 1;
		map.put(key, quantity);
	}

}

