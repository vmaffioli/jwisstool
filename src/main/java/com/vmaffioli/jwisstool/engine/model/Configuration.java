package com.vmaffioli.jwisstool.engine.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
public class Configuration {

	// TODO doc
	@NotBlank
	private String key; // TODO CriticalMessages

	// TODO doc
	@NotNull
	private List<Option> options; // TODO CriticalMessages

}
