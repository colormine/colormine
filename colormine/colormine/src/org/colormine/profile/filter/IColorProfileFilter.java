package org.colormine.profile.filter;

import org.colormine.profile.IColorProfile;

public interface IColorProfileFilter {
	IColorProfileFilterResult apply(IColorProfile profile);
}