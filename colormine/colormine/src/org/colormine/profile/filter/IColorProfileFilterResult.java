package org.colormine.profile.filter;

import org.colormine.profile.IColorProfile;

public interface IColorProfileFilterResult {
	IColorProfile getOriginalProfile();

	IColorProfile getFilteredProfile();

	IColorProfile getModifiedProfile();

	IColorProfile getDiscardedProfile();
}
