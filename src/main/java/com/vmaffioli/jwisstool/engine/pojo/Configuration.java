package com.vmaffioli.jwisstool.engine.pojo;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Configuration {

	// TODO doc
	@NotBlank
	private String key; // TODO CriticalMessages

	// TODO doc
	@NotNull
	private List<Option> options; // TODO CriticalMessages

	public Configuration(String key, List<Option> options) {
		this.key = key;
		this.options = options;

	}

}
