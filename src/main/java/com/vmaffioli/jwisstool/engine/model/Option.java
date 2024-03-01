package com.vmaffioli.jwisstool.engine.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Option {

	// TODO doc
	private String key;

	// TODO doc
	private String description;

	// TODO doc
	private List<String> values;

	// TODO doc
	@Setter
	private String active;

	public Option(String key, String description, List<String> values, String active) {
		this.key = key;
		this.description = description;
		this.values = values;
		this.active = active;
	}

}
