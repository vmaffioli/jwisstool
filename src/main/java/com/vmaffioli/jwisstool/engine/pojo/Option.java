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
	private String absoluteValue;

	public Option(String name, String[] values, String absoluteValue) {
		this.name = name;
		this.values = values;
		this.absoluteValue = values == null ? "" : absoluteValue;
	}

}
