package org.colorMine.profile.filter;

import org.colorMine.profile.IColorProfile;

public class ColorProfileFilterResult implements IColorProfileFilterResult {

	private IColorProfile _filtered;
	private IColorProfile _modified;
	private IColorProfile _discarded;
	private IColorProfile _original;

	public ColorProfileFilterResult(IColorProfile filtered,
			IColorProfile modified, IColorProfile discarded,
			IColorProfile original) {
		_filtered = filtered;
		_modified = modified;
		_discarded = discarded;
		_original = original;
	}

	public IColorProfile getOriginalProfile() {
		return _original;
	}

	public IColorProfile getFilteredProfile() {
		return _filtered;
	}

	public IColorProfile getModifiedProfile() {
		return _modified;
	}

	public IColorProfile getDiscardedProfile() {
		return _discarded;
	}

}