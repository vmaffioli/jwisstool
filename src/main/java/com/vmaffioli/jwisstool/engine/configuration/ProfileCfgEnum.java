package com.vmaffioli.jwisstool.engine.configuration;

import lombok.Getter;

@Getter
public enum ProfileCfgEnum {

	TEST("TestProfileConfig", new String[] { "1", "2" });

	private final String key;
	private final String[] values;

	ProfileCfgEnum(String key, String[] values) {
		this.key = key;
		this.values = values;
	};

}
