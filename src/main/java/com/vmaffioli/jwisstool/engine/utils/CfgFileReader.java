package com.vmaffioli.jwisstool.engine.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CfgFileReader {

	// TODO docs
	public static Map<String, String> fileToMap(String filePath) throws IOException {

		Map<String, String> contentMap = new HashMap<>();

		Path path = Paths.get(filePath);
		List<String> fileContent;
		try {
			fileContent = Files.readAllLines(path);

			for (String str : fileContent) {
				String key = str.split("=")[0];
				String value = str.split("=")[1];

				contentMap.put(key, value);
			}

		} catch (IOException e) {
			// TODO exception flow
			e.printStackTrace();
		}

		return contentMap;
	}

}