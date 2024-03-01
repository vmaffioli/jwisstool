package com.vmaffioli.jwisstool.engine.model;

import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;

public class Configuration {

	// TODO doc
	@Getter
	@NotBlank
	private String key; // TODO CriticalMessages, better name

	// TODO doc
	@Getter
	@NotNull
	private Map<String, Option> options; // TODO CriticalMessages

	private boolean locked;

	public Configuration(String key, Map<String, Option> options) {
		this.key = key;
		this.options = options;
		this.locked = false;
	}

	// TODO docs
	public Configuration noLock() {
		this.locked = true;
		return this;
	}

	// TODO docs
	public boolean isLocked() {
		return this.locked;
	}

	// TODO docs
	public Configuration reload(Map<String, Option> options) {
		this.options = options;
		this.locked = false;

		return this;
	}

}
