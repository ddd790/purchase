package com.purchase;

import java.util.List;

public class Utils {
	public static boolean isNullList(List<?> list) {
		if (list == null || list.size() <= 0) {
			return true;
		}
		return false;
	}
}
