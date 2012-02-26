package com.colorComparer.profile;

import java.util.Map;
import com.colorComparer.colorSpace.Rgb;

public class MapCount {

	public static void count(Map<Rgb, Integer> map, Rgb key) {
		int quantity = map.containsKey(key) ? (int) map.get(key) + 1 : 1;
		map.put(key, quantity);
	}

}
