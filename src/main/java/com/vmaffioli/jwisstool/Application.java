package com.vmaffioli.jwisstool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vmaffioli.jwisstool.engine.JwissEngine;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		JwissEngine engine = new JwissEngine();
		engine.build().run();
	}

}
