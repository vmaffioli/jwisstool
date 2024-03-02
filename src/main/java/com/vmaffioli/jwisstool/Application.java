package com.vmaffioli.jwisstool;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vmaffioli.jwisstool.engine.Engine;
import com.vmaffioli.jwisstool.engine.bootstrap.EngineLoader;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);

		Engine engine = new EngineLoader().build();
		engine.run();

		// TODO exception flow for external file search
	}

}
