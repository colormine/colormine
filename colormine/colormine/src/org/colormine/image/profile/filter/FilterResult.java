package org.colormine.image.profile.filter;

public interface FilterResult<K> {
	K getOriginal();

	K getFiltered();

	K getModified();

	K getDiscarded();
}
