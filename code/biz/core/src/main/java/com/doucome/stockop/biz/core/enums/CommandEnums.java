package com.doucome.stockop.biz.core.enums;

import java.util.HashMap;
import java.util.Map;

public enum CommandEnums {

	COMMISSION("COM"), CANCELLATION("CAN"), UNKNOWN(""), ;

	private CommandEnums(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}

	private static final Map<String, CommandEnums> map = new HashMap<String, CommandEnums>();
	static {
		CommandEnums[] enums = CommandEnums.values();
		for (CommandEnums e : enums) {
			map.put(e.getValue(), e);
		}
	}

	public static CommandEnums toEnum(String value) {
		CommandEnums e = map.get(value);
		if (e == null) {
			return UNKNOWN;
		}
		return e;
	}
}
