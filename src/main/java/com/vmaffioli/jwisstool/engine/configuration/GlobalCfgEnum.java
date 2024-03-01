package com.vmaffioli.jwisstool.engine.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GlobalCfgEnum implements CfgEnum {

	TEST("TestGlobalConfig", "Test for Global Configurations.", new String[] { "1", "2" });

// TODO  notnull validations
	private final String key;
	private final String description;
	private final String[] values;

}
