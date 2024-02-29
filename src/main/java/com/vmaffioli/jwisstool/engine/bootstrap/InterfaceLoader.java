package com.vmaffioli.jwisstool.engine.bootstrap;

import com.vmaffioli.jwisstool.engine.cli.CommandLineInterface;

import lombok.Getter;

@Getter
public class InterfaceLoader {

	// TODO docs
	private CommandLineInterface cli;

	public InterfaceLoader() {
		this.cli = new CommandLineInterface();
	}

}
