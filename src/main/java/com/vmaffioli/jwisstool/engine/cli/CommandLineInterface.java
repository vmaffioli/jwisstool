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
	public void nextLine() {
		System.out.print("Enter a value: ");
		this.input = scanner.nextLine();

	}

}
