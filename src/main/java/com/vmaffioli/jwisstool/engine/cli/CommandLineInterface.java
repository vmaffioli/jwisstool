package com.vmaffioli.jwisstool.engine.cli;

import java.util.Scanner;

import lombok.Getter;

public class CommandLineInterface {

	private Scanner scanner;
//	private ReentrantLock lock;
//	private Condition inputCondition;
//	private volatile boolean paused = false;

	@Getter
	private String input;

	public CommandLineInterface() {
		this.scanner = new Scanner(System.in);
//		this.lock = new ReentrantLock();
//		this.inputCondition = lock.newCondition();

		this.input = new String();
	}

	// TODO docs
	public void nextLine() {
		System.out.print("Enter a value: ");
		this.input = scanner.nextLine();
		System.out.println("You entered" + input);

	}

}
