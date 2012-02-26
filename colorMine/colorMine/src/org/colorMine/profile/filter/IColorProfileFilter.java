package org.colorMine.profile.filter;

import org.colorMine.profile.IColorProfile;

public interface IColorProfileFilter {
	IColorProfileFilterResult apply(IColorProfile profile);
}