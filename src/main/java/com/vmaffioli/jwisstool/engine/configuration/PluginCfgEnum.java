package com.vmaffioli.jwisstool.engine.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PluginCfgEnum implements CfgEnum{

	TEST("TestPluginConfig", new String[] { "1", "2" });

	private final String key;
	private final String[] values;

}
