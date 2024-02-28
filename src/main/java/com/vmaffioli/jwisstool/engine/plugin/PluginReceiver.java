package com.vmaffioli.jwisstool.engine.plugin;

import java.util.HashMap;
import java.util.Map;

import com.vmaffioli.jwissdevkit.plugin.Plugin;

public class PluginReceiver {

	private Map<String, Plugin> receiverMap;

	public PluginReceiver() {
		this.receiverMap = new HashMap<>();
	}

	public PluginReceiver add(Plugin plugin) {
		
//		this.receiverMap.put(plugin.getKey(), command);
		return this;
	}

	public void run(String key) {
		receiverMap.get(key).run();

	}

}