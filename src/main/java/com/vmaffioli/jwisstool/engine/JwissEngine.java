package com.vmaffioli.jwisstool.engine;

import com.vmaffioli.jwisstool.engine.bootstrap.ConfigurationLoader;
import com.vmaffioli.jwisstool.engine.bootstrap.InterfaceLoader;
import com.vmaffioli.jwisstool.engine.cli.CommandLineInterface;
import com.vmaffioli.jwisstool.engine.pojo.Configuration;

public class JwissEngine implements Runnable {

	private Configuration globalCfg;
	private CommandLineInterface cli;

	private boolean runnable;

	public JwissEngine() {

		build();
		this.runnable = true;
	}

	@Override // TODO docs
	public void run() {
		runnable = true;

		while (runnable)

			this.cli.nextLine();
			

	}

	// TODO docs
	public void build() {

		ConfigurationLoader cfgInitializer = new ConfigurationLoader();
		this.globalCfg = cfgInitializer.getGlobalCfg();

		InterfaceLoader itfInitializer = new InterfaceLoader();
		this.cli = itfInitializer.getCli();

	}

	// TODO docs
	public void start() {

	}

	// TODO docs
	public void stop() {

	}

}
