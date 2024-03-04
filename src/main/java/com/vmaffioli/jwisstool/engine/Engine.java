package com.vmaffioli.jwisstool.engine;

import javax.validation.constraints.NotNull;

import com.vmaffioli.jwisstool.engine.cli.CommandLineInterface;
import com.vmaffioli.jwisstool.engine.model.Configuration;
import com.vmaffioli.jwisstool.engine.plugin.PluginReceiver;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Engine implements Runnable {

	// TODO erros msgs, exception flow
	@NotNull
	private Configuration globalCfg;

	@NotNull
	private Configuration profileCfg;

	@NotNull
	private PluginReceiver receiver;

	@NotNull
	private CommandLineInterface cli;

	@Override
	public void run() {
		// TODO start flow

		while (this.cli.isOpen()) {
			this.cli.nextLine();

		}

	}
}
