package com.vmaffioli.jwisstool.engine.bootstrap;

import static org.assertj.core.api.Assertions.entry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vmaffioli.jwisstool.engine.plugin.PluginReceiver;

public class PluginsLoader {

	// TODO reflect flow
	// TODO load plugin and actions
	// TODO pluginComposite and pluginReceiver

	private PluginReceiver receiver;

	public PluginsLoader() {
		this.receiver = new PluginReceiver();
	}
	
	

}
