package com.vmaffioli.jwisstool.engine.bootstrap;

import java.io.IOException;

import com.vmaffioli.jwisstool.engine.Engine;

public class EngineLoader {

	private Engine engine;

	public EngineLoader() {
		this.engine = new Engine();
	}

	public Engine build() throws IOException {
		System.out.println(">>> building engine...");

		ConfigurationLoader configInitializer = new ConfigurationLoader();
		engine.setGlobalCfg(configInitializer.getGlobalCfg());
		engine.setProfileCfg(configInitializer.getProfileCfg());

		PluginsLoader pluginInitializer = new PluginsLoader();
		engine.setReceiver(pluginInitializer.getReceiver());

		InterfaceLoader interfaceInitializer = new InterfaceLoader();
		engine.setCli(interfaceInitializer.getCli());

		System.out.println(">>> build engine finished.");

		return engine;

	}

}
