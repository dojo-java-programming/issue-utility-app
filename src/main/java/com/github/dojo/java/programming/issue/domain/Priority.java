package com.github.dojo.java.programming.issue.domain;

import org.apache.commons.lang3.StringUtils;

public class Priority implements Comparable<Priority> {
	private final String name;


	public Priority(final String name) {
		final String nameCln = StringUtils.trimToNull(name);
		if (nameCln == null) {
			throw new IllegalArgumentException("Argument 'name' should not be null.");
		}
		
		this.name = nameCln.toUpperCase();
	}


	public String getName() {
		return name;
	}


	@Override
	public int compareTo(final Priority otherPriority) {
		return this.name.compareTo(otherPriority.getName());
	}

}
