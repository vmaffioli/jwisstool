package com.vmaffioli.jwisstool.engine.bootstrap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.validation.Valid;

import com.vmaffioli.jwisstool.engine.configuration.GlobalCfgEnum;
import com.vmaffioli.jwisstool.engine.configuration.PluginCfgEnum;
import com.vmaffioli.jwisstool.engine.configuration.ProfileCfgEnum;
import com.vmaffioli.jwisstool.engine.constants.PostProcessorTokens;
import com.vmaffioli.jwisstool.engine.model.Configuration;
import com.vmaffioli.jwisstool.engine.model.Option;
import com.vmaffioli.jwisstool.engine.utils.CfgFileReader;

import lombok.Getter;

@Getter
public class ConfigurationLoader {

	protected Configuration globalCfg;
	protected Configuration profileCfg;
	// TODO const paths

	public ConfigurationLoader() {
		this.globalCfg = globalCfgBuild();
		this.profileCfg = profileCfgBuild();
	}

	public ConfigurationLoader(String pluginPath) {
		this.globalCfg = globalCfgBuild();
		this.profileCfg = profileCfgBuild();
	}

	// TODO docs
	private Configuration globalCfgBuild() {

		System.out.println(">>> building global config...");

		// TODO fileName and paths const
		List<Option> options = new ArrayList<>();

		Map<String, String> activeOptions = CfgFileReader.fileToMap("path/to/your/.profile"); // TODO better name and
																								// Replace
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

		List<Option> options = new ArrayList<>();

		Map<String, String> activeOptions = CfgFileReader.fileToMap("path/to/your/.profile"); // TODO better name and
																								// Replace
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
	public Configuration pluginCfgBuild(String path) throws Exception {

		List<Option> options = new ArrayList<>();

		Map<String, String> activeOptions = CfgFileReader.fileToMap(path); // TODO better names for activeOptions

		for (PluginCfgEnum cfg : PluginCfgEnum.values()) {
			String optKey = cfg.getKey();

			if (activeOptions.containsKey(optKey)) {

				@Valid
				Option opt = new Option(optKey, Arrays.asList(cfg.getValues()), null); // TODO get default value if
																						// active isnt informed
				options.add(opt);

				activeOptions.remove(optKey);

			} else {
				throw new Exception("missing mandatory configuration"); // TODO exceptiosn flow

			}
		}

		for (Entry<String, String> activeOption : activeOptions.entrySet()) { // TODO performance

			@Valid
			Option opt = new Option(activeOption.getKey(), PostProcessorTokens.OPT_VALUES, activeOption.getValue()); // TODO
																														// get
			// default
			// value if
			// active isnt informed
			options.add(opt);

		}

		@Valid
		Configuration configuration = new Configuration("profile", options); // TODO global const

		System.out.println(">>> profile config builded.");

		return configuration;
	}

}
