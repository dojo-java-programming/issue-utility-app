package com.github.dojo.java.programming.issue.repository;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;

import com.github.dojo.java.programming.issue.domain.IssueType;

public class IssueTypeRepository {
	private SortedSet<IssueType> issueTypes = new TreeSet<>();


	public void add(final IssueType statusType) {
		issueTypes.add(statusType);
	}


	public int size() {
		return issueTypes.size();
	}


	public SortedSet<IssueType> get() {
		return Collections.unmodifiableSortedSet(issueTypes);
	}


	public IssueType get(final String name) {
		final String nameCln = StringUtils.trimToNull(name);
		if (nameCln == null) {
			return null;
		}

		for (IssueType issueType : issueTypes) {
			if (issueType.getName().equalsIgnoreCase(nameCln)) {
				return issueType;
			}
		}

		throw new IllegalArgumentException("Argument 'name' with value '" + nameCln
				+ "' is not a known StatusType. Known status-types are " + issueTypes);
	}

}
