package com.github.dojo.java.programming.issue.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class IssueTypeTest {

	@Test
	public void add() throws Exception {
		IssueType bug = new IssueType("bug");
		IssueType improvement = new IssueType("  improvement  ");
		IssueType newFeature = new IssueType("new feature");
		
		assertNotNull(bug);
		assertNotNull(improvement);
		assertNotNull(bug);
		assertEquals("BUG", bug.getName());
		assertEquals("IMPROVEMENT", improvement.getName());
		assertEquals("NEW FEATURE", newFeature.getName());
	}

	@Test
	public void addNull() {
		try {
			new IssueType(null);
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'name' should not be null", iae.getMessage());
		}
	}

	@Test
	public void addSpaces() {
		try {
			new IssueType("   \t");
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'name' should not be null", iae.getMessage());
		}
	}

}
