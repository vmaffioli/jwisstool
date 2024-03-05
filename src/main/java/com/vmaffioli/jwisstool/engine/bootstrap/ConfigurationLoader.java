package com.vmaffioli.jwisstool.engine.bootstrap;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.validation.Valid;

import org.springframework.cache.annotation.Cacheable;

import com.vmaffioli.jwissdevkit.models.configuration.Configuration;
import com.vmaffioli.jwissdevkit.models.configuration.Option;
import com.vmaffioli.jwisstool.engine.configuration.GlobalCfgEnum;
import com.vmaffioli.jwisstool.engine.configuration.PluginCfgEnum;
import com.vmaffioli.jwisstool.engine.configuration.ProfileCfgEnum;
import com.vmaffioli.jwisstool.engine.utils.CfgFileReader;

import lombok.Getter;

@Getter
public class ConfigurationLoader {

	private Configuration globalCfg;
	private Configuration profileCfg;
	// TODO const paths

	public ConfigurationLoader() throws IOException {
		// TODO exception flow

		this.globalCfg = globalCfgBuild();
		this.profileCfg = profileCfgBuild();
	}

	public ConfigurationLoader(String pluginPath) throws IOException {
		// TODO exception flow

		this.globalCfg = globalCfgBuild();
		this.profileCfg = profileCfgBuild();
	}

	// TODO docs
	@Cacheable(value = "configurations", key = "global")
	private Configuration globalCfgBuild() throws IOException {
// TODO exception flow
		System.out.println(">>> building global config...");

		// TODO fileName and paths const
		Map<String, Option> options = new HashMap<>();

		Map<String, String> activeOptions = CfgFileReader.fileToMap("C:\\jwisstool\\config.ini"); // TODO better name
																									// and
																									// Replace
		// with your .profile file path

		for (GlobalCfgEnum cfg : GlobalCfgEnum.values()) { // TODO perfomance

			String optKey = cfg.getKey();
			List<String> optValues = Arrays.asList(cfg.getValues());

			String activeOpt = activeOptions.get(optKey);

			if (activeOptions.containsKey(optKey) && optValues.contains(activeOpt)) {
				Option opt = new Option(optKey, cfg.getDescription(), Arrays.asList(cfg.getValues()), activeOpt);
				options.put(optKey, opt);

			} // TODO invalid option flow

		}

		@Valid
		Configuration cfg1 = new Configuration("global", options); // TODO global const

		System.out.println(">>> global config builded.");

		return cfg1;
	}

	// TODO doc
	@Cacheable(value = "configurations", key = "") // TODO how can I set multiples keys from some list (profile list in this case)
	private Configuration profileCfgBuild() throws IOException {

		System.out.println(">>> building profile config...");

		Map<String, Option> options = new HashMap<>();

		Map<String, String> activeOptions = CfgFileReader.fileToMap("C:\\jwisstool\\profiles\\default\\config.ini"); // TODO
																														// better
																														// name
																														// and
		// Replace
		// with your .profile file path

		for (ProfileCfgEnum cfg : ProfileCfgEnum.values()) { // TODO perfomance

			String optKey = cfg.getKey();
			List<String> optValues = Arrays.asList(cfg.getValues());

			String activeOpt = activeOptions.get(optKey);

			if (activeOptions.containsKey(optKey) && optValues.contains(activeOpt)) {
				Option opt = new Option(optKey, cfg.getDescription(), Arrays.asList(cfg.getValues()), activeOpt);
				options.put(optKey, opt);

			} // TODO invalid option flow

		}

		@Valid
		Configuration cfg1 = new Configuration("profile", options); // TODO global const

		System.out.println(">>> profile config builded.");

		return cfg1;
	}

	// TODO docs
	public Configuration pluginCfgBuild(String path) throws Exception {

		Map<String, Option> options = new HashMap<>();

		Map<String, String> activeOptions = CfgFileReader.fileToMap(path); // TODO better names for activeOptions

		for (PluginCfgEnum cfg : PluginCfgEnum.values()) {
			String optKey = cfg.getKey();

			if (activeOptions.containsKey(optKey)) {

				Option opt = new Option(optKey, cfg.getDescription(), Arrays.asList(cfg.getValues()), null);
				options.put(optKey, opt);

				activeOptions.remove(optKey);

			} else {
				throw new Exception("missing mandatory configuration"); // TODO exceptiosn flow

			}
		}

		for (Entry<String, String> activeOption : activeOptions.entrySet()) { // TODO performance
			String key = activeOption.getKey();
			Option opt = new Option(key, null, null, activeOption.getValue());
			options.put(key, opt);

		}

		@Valid
		Configuration configuration = new Configuration("profile", options); // TODO global const

		System.out.println(">>> profile config builded.");

		return configuration;
	}

}
