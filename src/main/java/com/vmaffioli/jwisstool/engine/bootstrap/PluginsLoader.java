package com.vmaffioli.jwisstool.engine.bootstrap;

import static org.assertj.core.api.Assertions.entry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vmaffioli.jwisstool.engine.plugin.PluginReceiver;

public class PluginsLoader {

	// TODO reflect flow
	// TODO load plugin and actions
	// TODO pluginComposite and pluginReceiver

	private PluginReceiver receiver;

	public PluginsLoader() {
		this.receiver = new PluginReceiver();
	}
	
	public static void main(String[] args) {
        String fileName = "path/to/your/.profile"; // TODO Replace with your .profile file path

        Map<String, String> profileMap = new HashMap<>();

        try {
            // Read lines from the .profile file
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            // Iterate through the lines and populate the map
            for (String line : lines) {
                if (!line.startsWith("#") && line.contains("=")) {
                    String[] parts = line.split("=");
                    profileMap.put(parts[0].trim(), parts[1].trim());
                }
            }

            // Print the key-value pairs
            for (Map.Entry<String, String> entry : profileMap.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

}
