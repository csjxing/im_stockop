package com.doucome.stockop.biz.core.enums;

import java.util.HashMap;
import java.util.Map;

public enum YesOrNoEnums {
	YES("Y"), NO("N"), UNKNOWN(""), ;

	private YesOrNoEnums(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}

	private static final Map<String, YesOrNoEnums> map = new HashMap<String, YesOrNoEnums>();
	static {
		YesOrNoEnums[] enums = YesOrNoEnums.values();
		for (YesOrNoEnums e : enums) {
			map.put(e.getValue(), e);
		}
	}

	public static YesOrNoEnums toEnum(String value) {
		YesOrNoEnums e = map.get(value);
		if (e == null) {
			return UNKNOWN;
		}
		return e;
	}
}
