package com.vmaffioli.jwisstool.engine.bootstrap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.vmaffioli.jwisstool.engine.configuration.GlobalCfgEnum;
import com.vmaffioli.jwisstool.engine.configuration.ProfileCfgEnum;
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
		this.profileCfg = profileCfgBuild();
	}

	// TODO docs
	private Configuration globalCfgBuild() {

		System.out.println(">>> building global config...");

		// TODO fileName and paths const
		List<Option> options = new ArrayList<>(); // TODO better name

		Map<String, String> activeOptions = loadActiveOptions("path/to/your/.profile"); // TODO better name and Replace
		// with your .profile file path

		for (GlobalCfgEnum cfg : GlobalCfgEnum.values()) { // TODO perfomance

			String optKey = cfg.getKey();
			List<String> optValues = Arrays.asList(cfg.getValues());

			String activeOpt = activeOptions.get(optKey);

			if (activeOptions.containsKey(optKey) && optValues.contains(activeOpt)) {

				options.add(new Option(optKey, optValues, activeOpt));

			}

		}

		@Valid
		Configuration cfg1 = new Configuration("global", options); // TODO global const

		System.out.println(">>> global config builded.");

		return cfg1;
	}

	// TODO docs
	private Configuration profileCfgBuild() {

		System.out.println(">>> building profile config...");

		List<Option> options = new ArrayList<>(); // TODO better name

		Map<String, String> activeOptions = loadActiveOptions("path/to/your/.profile"); // TODO better name and Replace
																						// with your .profile file path

		for (ProfileCfgEnum cfg : ProfileCfgEnum.values()) { // TODO perfomance

			String optKey = cfg.getKey();
			List<String> optValues = Arrays.asList(cfg.getValues());

			String activeOpt = activeOptions.get(optKey);

			if (activeOptions.containsKey(optKey) && optValues.contains(activeOpt)) {

				options.add(new Option(optKey, optValues, activeOpt));

			}

		}

		@Valid
		Configuration cfg1 = new Configuration("profile", options); // TODO global const

		System.out.println(">>> profile config builded.");

		return cfg1;
	}

	// TODO docs
	private Map<String, String> loadActiveOptions(String fileName) {
		Map<String, String> activeOptions = new HashMap<>(); // TODO better name

		try {
			List<String> lines = Files.readAllLines(Paths.get(fileName));

			// TODO more performance here - Iterate through the lines and populate the map
			for (String line : lines) {
				if (!line.startsWith("#") && line.contains("=")) {
					String[] parts = line.split("=");
					activeOptions.put(parts[0].trim(), parts[1].trim());
				}
			}

		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}
		return activeOptions;
	}

}
