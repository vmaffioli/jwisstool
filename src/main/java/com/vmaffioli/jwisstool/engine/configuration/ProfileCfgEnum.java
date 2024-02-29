package com.vmaffioli.jwisstool.engine.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProfileCfgEnum implements CfgEnum{

	TEST("TestProfileConfig", new String[] { "1", "2" });

	private final String key;
	private final String[] values;

}
