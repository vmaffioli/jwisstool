package com.vmaffioli.jwisstool.engine.pojo;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Option {

	// TODO doc
	@NotBlank
	private String name; // TODO CriticalMessages

	// TODO doc
	private String[] values; // TODO CriticalMessages

	@Setter
	private String value;

	@Setter
	private boolean active;

	// TODO use only one from values or value
	public Option(String name, String[] values, boolean active) {
		this.name = name;
		this.values = values;
		this.active = active;
	}

	public Option(String name, String value, boolean active) {
		this.name = name;
		this.value = value;
		this.active = active;
	}

}
