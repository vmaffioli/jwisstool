package com.vmaffioli.jwisstool.engine.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;

import com.vmaffioli.jwisstool.engine.plugin.PluginReceiver;
import com.vmaffioli.jwisstool.engine.pojo.Configuration;

import lombok.Getter;

public class PluginsLoader {

	// TODO reflect flow
	// TODO load plugin and actions
	// TODO pluginComposite and pluginReceiver

	@Autowired
	ConfigurationLoader cfgInitializer;

	@Getter
	private PluginReceiver receiver;

	private String[] paths;

	public PluginsLoader() {

		ConfigurationLoader cfgInitializer = new ConfigurationLoader();

		this.globalCfg = cfgInitializer.globalCfg;
		this.globalCfg = cfgInitializer.globalCfg;

		this.receiver = new PluginReceiver();

	}

}
