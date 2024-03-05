package com.vmaffioli.jwisstool.engine.plugin;

import java.util.HashMap;
import java.util.Map;

import com.vmaffioli.jwissdevkit.interfaces.IPlugin;

public class PluginReceiver {

	private Map<String, IPlugin> receiverMap;

	public PluginReceiver() {
		this.receiverMap = new HashMap<>();
	}

	public void put(String key, IPlugin plugin) {
		this.receiverMap.put(key, plugin);
	}

	public void run(String key) {
		receiverMap.get(key).run();

	}

}