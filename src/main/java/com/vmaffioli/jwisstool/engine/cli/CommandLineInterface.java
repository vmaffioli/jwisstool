package com.vmaffioli.jwisstool.engine.cli;

import java.util.Scanner;

import lombok.Getter;

public class CommandLineInterface {

	private Scanner scanner;

	@Getter
	private String input;

	public CommandLineInterface() {
		this.scanner = new Scanner(System.in);
		this.input = new String();
	}

	// TODO docs
	public CommandLineInterface nextLine() {
		System.out.print("Enter a value: ");
		this.input = scanner.nextLine();

		switch (this.input) {
		case "exit": { // TODO const
			this.scanner.close();
			this.scanner = null;

			System.out.println("BYE!");

		}
		default:
			System.out.println();

		}

		return this;
	}

	public boolean isOpen() {
		return scanner == null ? false : true;
	};

}
