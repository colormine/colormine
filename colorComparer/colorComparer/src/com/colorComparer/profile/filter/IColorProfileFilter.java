package com.colorComparer.profile.filter;

import com.colorComparer.profile.IColorProfile;

public interface IColorProfileFilter {
	IColorProfileFilterResult apply(IColorProfile profile);
}