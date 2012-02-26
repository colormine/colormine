package org.colorMine.profile.filter;

import org.colorMine.profile.IColorProfile;

public interface IColorProfileFilterResult {
	IColorProfile getOriginalProfile();

	IColorProfile getFilteredProfile();

	IColorProfile getModifiedProfile();

	IColorProfile getDiscardedProfile();
}
