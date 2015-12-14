package com.github.dojo.java.programming.issue.repository;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;

import com.github.dojo.java.programming.issue.domain.StatusType;

public class StatusTypeRepository {
	private SortedSet<StatusType> statusTypes = new TreeSet<>();


	public void add(final StatusType statusType) {
		statusTypes.add(statusType);
	}


	public int size() {
		return statusTypes.size();
	}


	public SortedSet<StatusType> get() {
		return Collections.unmodifiableSortedSet(statusTypes);
	}


	public StatusType get(final String name) {
		final String nameCln = StringUtils.trimToNull(name);
		if (nameCln == null) {
			return null;
		}

		for (StatusType statusType : statusTypes) {
			if (statusType.getName().equalsIgnoreCase(nameCln)) {
				return statusType;
			}
		}

		throw new IllegalArgumentException("Argument 'name' with value '" + nameCln
				+ "' is not a known StatusType. Known status-types are " + statusTypes);
	}

}
