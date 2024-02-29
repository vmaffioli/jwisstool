package com.vmaffioli.jwisstool.engine;

import com.vmaffioli.jwisstool.engine.bootstrap.ConfigurationLoader;
import com.vmaffioli.jwisstool.engine.bootstrap.InterfaceLoader;
import com.vmaffioli.jwisstool.engine.cli.CommandLineInterface;
import com.vmaffioli.jwisstool.engine.model.Configuration;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JwissEngine {

	private Configuration globalCfg;
	private Configuration profileCfg;

	private CommandLineInterface cli;

	private boolean runnable;

	// TODO docs
	public void run() {
		System.out.println(">>> running engine...");
		this.runnable = true;

		while (runnable) {
			System.out.println(">>> type something: ");
			this.cli.nextLine();

			if (this.cli.getInput().equals("exit")) {
				System.out.println(">>> stoping engine...");
				this.runnable = false;
				System.out.println(">>> engine stopped, bye!");

			} else if (this.cli.getInput().equals("globalcfg")) {
				System.out.println(">>> getting global config...");
				System.out.println(globalCfg.toString());
			} else if (this.cli.getInput().equals("profilecfg")) {
				System.out.println(">>> getting profile config...");
				System.out.println(profileCfg.toString());
			}
		}

	}

	// TODO docs
	public JwissEngine build() {

		System.out.println(">>> build engine...");

		ConfigurationLoader cfgInitializer = new ConfigurationLoader();
		this.globalCfg = cfgInitializer.getGlobalCfg();
		this.profileCfg = cfgInitializer.getProfileCfg();

		InterfaceLoader itfInitializer = new InterfaceLoader();
		this.cli = itfInitializer.getCli();

		System.out.println(">>> build engine finished.");

		return this;

	}

}
