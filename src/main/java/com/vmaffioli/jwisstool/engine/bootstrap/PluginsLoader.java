package com.vmaffioli.jwisstool.engine.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.source.util.Plugin;
import com.vmaffioli.jwisstool.engine.plugin.PluginReceiver;

import lombok.Getter;

public class PluginsLoader {

	// TODO reflect flow
	// TODO load plugin and actions
	// TODO pluginComposite and pluginReceiver

	@Autowired
	ConfigurationLoader cfgInitializer;

	@Getter
	private PluginReceiver receiver;

	public PluginsLoader() {
		this.receiver = new PluginReceiver();
	}

	public void load(String[] pluginsPathList) {

		for (String pluginPath : pluginsPathList) { // TODO performance

		}

//		this.receiver.put(plugin.getName(), plugin);
	}

}
