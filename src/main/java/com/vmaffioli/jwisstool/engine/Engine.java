package com.vmaffioli.jwisstool.engine;

import com.vmaffioli.jwissdevkit.models.configuration.Configuration;
import com.vmaffioli.jwisstool.engine.cli.CommandLineInterface;
import com.vmaffioli.jwisstool.engine.plugin.PluginReceiver;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Engine implements Runnable {

	// TODO erros msgs, exception flow
	private Configuration globalCfg;

	private Configuration profileCfg;

	private PluginReceiver receiver;

	private CommandLineInterface cli;

	@Override
	public void run() {
		// TODO start flow

		while (this.cli.isOpen()) {
			this.cli.nextLine();

		}

	}
}
