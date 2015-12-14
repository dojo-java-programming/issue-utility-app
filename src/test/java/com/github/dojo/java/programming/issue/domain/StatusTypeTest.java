package com.github.dojo.java.programming.issue.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class StatusTypeTest {

	@Test
	public void add() throws Exception {
		StatusType open = new StatusType("open");
		StatusType closed = new StatusType("  closed  ");
//		StatusType newFeature = new StatusType("new feature");
		
		assertNotNull(open);
//		assertNotNull(closed);
		assertNotNull(closed);
		assertEquals("OPEN", open.getName());
		assertEquals("CLOSED", closed.getName());
//		assertEquals("new feature", newFeature.getName());
	}

	@Test
	public void addNull() {
		try {
			new StatusType(null);
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'name' should not be null", iae.getMessage());
		}
	}

	@Test
	public void addSpaces() {
		try {
			new StatusType("   \t");
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'name' should not be null", iae.getMessage());
		}
	}

}
