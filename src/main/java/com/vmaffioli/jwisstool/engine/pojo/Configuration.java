package com.vmaffioli.jwisstool.engine.pojo;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class Configuration {

	// TODO doc
	@NotBlank
	private String name; // TODO CriticalMessages

	// TODO doc
	@NotNull
	private List<Option> options; // TODO CriticalMessages

	public Configuration(String name, List<Option> options) {
		this.name = name;
		this.options = options;

	}

}
