package com.vmaffioli.jwisstool.engine.plugin;

import java.util.HashMap;
import java.util.Map;

import com.vmaffioli.jwissdevkit.interfaces.Plugin;

public class PluginReceiver {

	private Map<String, Plugin> receiverMap;

	public PluginReceiver() {
		this.receiverMap = new HashMap<>();
	}

	public void put(String key, Plugin plugin) {
		this.receiverMap.put(key, plugin);
	}

	public void run(String key) {
		receiverMap.get(key).run();

	}

}