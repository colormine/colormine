package com.colorComparer.profile.filter;

import com.colorComparer.profile.IColorProfile;

public interface IColorProfileFilterResult {
	IColorProfile getOriginalProfile();

	IColorProfile getFilteredProfile();

	IColorProfile getModifiedProfile();

	IColorProfile getDiscardedProfile();
}
