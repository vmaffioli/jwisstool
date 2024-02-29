package com.vmaffioli.jwisstool.engine.model;

import com.vmaffioli.jwisstool.engine.cli.CommandLineInterface;
import com.vmaffioli.jwisstool.engine.plugin.PluginReceiver;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Engine {

	private Configuration globalCfg;
	private Configuration profileCfg;
	private PluginReceiver receiver;
	private CommandLineInterface cli;

}
