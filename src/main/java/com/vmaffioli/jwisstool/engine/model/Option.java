package com.vmaffioli.jwisstool.engine.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Option {

	// TODO doc
	private String name;

	// TODO doc
	private List<String> values;

	// TODO doc
	@Setter
	private String active;

	// TODO check if notblank or other validations are trigering when using in
	// method inputs
	public Option(@NotBlank String name, @Size(min = 1) List<String> values, String active) {
		this.name = name;
		this.values = values;
		this.active = active.isBlank() ? this.values.get(0) : active; // TODO doc
	}

}
