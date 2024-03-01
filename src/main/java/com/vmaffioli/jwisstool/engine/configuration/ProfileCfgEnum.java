package com.vmaffioli.jwisstool.engine.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProfileCfgEnum implements CfgEnum {

	TEST("TestProfileConfig", "Test for Profile Configurations.", new String[] { "1", "2" });

	private final String key;
	private final String description;
	private final String[] values;

}
