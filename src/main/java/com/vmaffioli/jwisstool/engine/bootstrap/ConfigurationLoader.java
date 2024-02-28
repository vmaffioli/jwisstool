package com.vmaffioli.jwisstool.engine.bootstrap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.vmaffioli.jwisstool.engine.pojo.Configuration;
import com.vmaffioli.jwisstool.engine.pojo.Option;

import lombok.Getter;

@Getter
public class ConfigurationLoader {

	private Configuration globalCfg;
	private Configuration profileCfg;
	// TODO const paths

	public ConfigurationLoader() {
		this.globalCfg = globalCfgBuild();

	}

	private Configuration globalCfgBuild() {
		List<Option> options = new ArrayList<>();

		options.add(new Option("TestOption001", new String[] { "1", "2" }, null));
		options.add(new Option("TestOption002", new String[] { "a", "b" }, null));

		@Valid
		Configuration cfg = new Configuration("global cfg", options); // TODO global const

		return cfg;
	}

	public Configuration profileCfgBuild() {
		String fileName = "path/to/your/.profile"; // TODO Replace with your .profile file path

		Map<String, String> profileMap = new HashMap<>();
		List<Option> options = new ArrayList<>();

		try {
			List<String> lines = Files.readAllLines(Paths.get(fileName));

			// TODO more performance here - Iterate through the lines and populate the map
			for (String line : lines) {
				if (!line.startsWith("#") && line.contains("=")) {
					String[] parts = line.split("=");
// TODO profile cgf builder, utils and options schema (name, values, value, active)
					if (parts[1].contains("&&")) {

					} else {

						profileMap.put(parts[0].trim(), parts[1].trim(), parts[1].trim().length() != 0 ? true : false);

						options.add(new Option(parts[0].trim(), parts[1].trim(),
								parts[1].trim().length() != 0 ? true : false));
					}

					options.add(new Option("TestOption001", new String[] { "1", "2" }, null));
					options.add(new Option("TestOption002", new String[] { "a", "b" }, null));
				}
			}

			// Print the key-value pairs
			for (Map.Entry<String, String> entry : profileMap.entrySet()) {
				System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
			}

		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}

		@Valid
		Configuration cfg = new Configuration("global cfg", options); // TODO global const

		return cfg;
	}

}
