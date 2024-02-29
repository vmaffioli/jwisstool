package com.vmaffioli.jwisstool.engine.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Option {

	// TODO doc
	@NotBlank
	private String name;

	// TODO doc
	@NotNull
	private List<String> values;

	// TODO doc
	@Setter
	@NotNull
	private String active;

}
