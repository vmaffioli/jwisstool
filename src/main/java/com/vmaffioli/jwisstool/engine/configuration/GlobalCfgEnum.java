package com.vmaffioli.jwisstool.engine.configuration;

import lombok.Getter;

@Getter
public enum GlobalCfgEnum {

	TEST("TestConfig", new String[] { "1", "2" });

	private final String key;
	private final String[] values;

	GlobalCfgEnum(String key, String[] values) {
		this.key = key;
		this.values = values;
	};

}
