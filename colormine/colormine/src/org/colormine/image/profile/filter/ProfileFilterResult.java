package org.colormine.image.profile.filter;

import org.colormine.image.profile.Profile;

public class ProfileFilterResult<K> implements FilterResult<Profile<K>> {

	private Profile<K> _filtered;
	private Profile<K> _modified;
	private Profile<K> _discarded;
	private Profile<K> _original;

	public ProfileFilterResult(Profile<K> filtered, Profile<K> modified, Profile<K> discarded, Profile<K> original) {
		_filtered = filtered;
		_modified = modified;
		_discarded = discarded;
		_original = original;
	}

	public Profile<K> getOriginal() {
		return _original;
	}

	public Profile<K> getFiltered() {
		return _filtered;
	}

	public Profile<K> getModified() {
		return _modified;
	}

	public Profile<K> getDiscarded() {
		return _discarded;
	}

}