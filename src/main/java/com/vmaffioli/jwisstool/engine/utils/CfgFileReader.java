package com.vmaffioli.jwisstool.engine.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CfgFileReader {

	// TODO docs
	public static Map<String, String> fileToMap(String path) throws IOException {
		
		// TODO exception flow
		File folder = new File(path);
		if (!folder.isDirectory()) {
			throw new IllegalArgumentException("The provided path is not a valid directory.");
		}

		File configFile = new File(folder, "config.ini");
		if (!configFile.exists() || !configFile.isFile()) {
			throw new IllegalArgumentException("The config.ini file does not exist in the provided directory.");
		}

		Map<String, String> config = new HashMap<>();

			InputStream input = new FileInputStream(configFile);
			Properties props = new Properties();
			props.load(input);
			for (String key : props.stringPropertyNames()) {
				config.put(key, props.getProperty(key));
			}
	
		return config;
	}

}