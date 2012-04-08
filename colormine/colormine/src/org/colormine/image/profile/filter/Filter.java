package org.colormine.image.profile.filter;

import java.awt.Color;

import org.colormine.image.profile.Profile;

public interface Filter<K> {
	FilterResult<K> apply(Profile<Color> profile);
}