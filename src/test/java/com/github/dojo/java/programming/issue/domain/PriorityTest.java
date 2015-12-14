package com.github.dojo.java.programming.issue.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityTest {

	@Test
	public void create() throws Exception {
		Priority priority = new Priority("high");
		
		assertNotNull(priority);
		assertEquals("HIGH", priority.getName());
	}

	@Test
	public void createNull() throws Exception {
		try {
			new Priority(null);
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'name' should not be null.", iae.getMessage());
		}
	}

	@Test
	public void createSpaces() throws Exception {
		try {
			new Priority("  ");
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'name' should not be null.", iae.getMessage());
		}
	}
}
