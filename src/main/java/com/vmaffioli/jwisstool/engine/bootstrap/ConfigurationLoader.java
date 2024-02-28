package com.vmaffioli.jwisstool.engine.bootstrap;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.vmaffioli.jwisstool.engine.pojo.Configuration;
import com.vmaffioli.jwisstool.engine.pojo.Option;

import lombok.Getter;

@Getter
public class ConfigurationLoader {

	private Configuration globalCfg;
	// TODO const paths

	public ConfigurationLoader() {
		this.globalCfg = globalCfgBuild();
		
	}

	private Configuration globalCfgBuild() {
		List<Option> options = new ArrayList<>();

		options.add(new Option("TestOption001", new String[] { "1", "2" }, null));
		options.add(new Option("TestOption002", new String[] { "a", "b" }, null));

		@Valid
		Configuration cfg = new Configuration("global cfg", options); // TODO global const

		return cfg;
	}

}
