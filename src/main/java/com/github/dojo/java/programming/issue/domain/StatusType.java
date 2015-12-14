package com.github.dojo.java.programming.issue.domain;

import org.apache.commons.lang3.StringUtils;

public class StatusType implements Comparable<StatusType>{
	private final String name;

	
	public StatusType(final String name) {
		final String nameCln = StringUtils.trimToNull(name);
		if (nameCln == null) {
			throw new IllegalArgumentException("Argument 'name' should not be null"); 
		}
		this.name = nameCln.toUpperCase();
	}


	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return "StatusType [name=" + name + "]";
	}


	@Override
	public int compareTo(final StatusType otherStatusType) {
		return this.name.compareTo(otherStatusType.getName());
	}

}
