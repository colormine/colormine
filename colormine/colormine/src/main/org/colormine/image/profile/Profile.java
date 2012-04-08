package org.colormine.image.profile;

import java.util.Map.Entry;
import java.util.Set;

public interface Profile<K> {
	/*
	 * Tracks an item
	 */
	void put(K key);

	/*
	 * Tracks an item
	 */
	void put(K key, int count);

	/*
	 * Returns the number of times an item has been recorded
	 */
	int get(K key);

	/*
	 * Returns the sum of all items that have been recorded
	 */
	int getTotal();

	/*
	 * Returns the count of all distinct items that have been recorded
	 */
	int size();

	Set<Entry<K, Integer>> entrySet();

	Set<K> keySet();

}