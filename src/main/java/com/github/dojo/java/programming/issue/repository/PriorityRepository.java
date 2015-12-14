package com.github.dojo.java.programming.issue.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;

import com.github.dojo.java.programming.issue.domain.Priority;

public class PriorityRepository {
	private final Set<Priority> priorities = new TreeSet<>();
	private final List<Priority> priorityIndex = new ArrayList<>();

	public void add(final Priority priority) {
		priorities.add(priority);
		priorityIndex.add(priority);
	}
	public void add(final Priority priority, int index) {
		priorities.add(priority);
		priorityIndex.add(index, priority);
	}

	public int size() {
		return priorities.size();
	}

	public Priority get(final String name) {
		final String nameCln = StringUtils.trimToNull(name);
		if (nameCln == null) {
			return null;
		}

		for (Priority priority : priorities) {
			if (priority.getName().equalsIgnoreCase(nameCln)) {
				return priority;
			}
		}

		throw new IllegalArgumentException("Argument 'name' with value '" 
				+ nameCln + "', is not a known Priority.");
	}
	public Priority get(int index) {
		return priorityIndex.get(index);
	}

}
