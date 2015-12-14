package com.github.dojo.java.programming.issue.domain;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class IssueTest {

	@Test
	public void createId() throws Exception {
		Issue issue = new Issue.Builder()
				.setId("sample-10")
				.setIssueType(new IssueType("bug"))
				.setPriority(new Priority("low"))
				.setCreationDate(createDate("2015.08.21"))
				.create();
		
		assertNotNull(issue);
		assertEquals(issue.getId(), "SAMPLE-10");
		assertEquals(issue.getIssueType().getName(), "BUG");
		assertEquals(issue.getPriority().getName(), "LOW");
		final DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		assertEquals(dateFormat.format(issue.getCreationDate()), "21/Aug/2015");
	}

	@Test ( expected = IllegalArgumentException.class )
	public void createIdNull() throws Exception {
		Issue issue = new Issue.Builder().create();
		
		assertNotNull(issue);
	}

	@Test // (expected = IllegalArgumentException.class)
	public void createIdIncorrect() {
		try {
			new Issue.Builder().setId("12").create();
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'bldr.getId()', with value '12' does not follow the pattern '\\w+-\\d+'.", iae.getMessage());
		}
	}

	@Test // (expected = IllegalArgumentException.class)
	public void createMissingIssueType() {
		try {
			new Issue.Builder().setId("sample-10").create();
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'bldr.getIssueType()' should not be null.", iae.getMessage());
		}
	}

	@Test // (expected = IllegalArgumentException.class)
	public void createMissingPriority() {
		try {
			new Issue.Builder().setId("sample-10").setIssueType(new IssueType("bug")).create();
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'bldr.getPriority()' should not be null.", iae.getMessage());
		}
	}

	@Test
	public void createMissingCreationDate() throws Exception {
		try {
			new Issue.Builder().setId("sample-10").setIssueType(new IssueType("bug")).setPriority(new Priority("high")).create();
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'bldr.getCreationDate()' should not be null.", iae.getMessage());
		}
	}

	// Helper methods:

	private Date createDate(final String dateStr) {
		final String datePatternStr = "yyyy.MM.dd";
		final DateFormat dateFormat = new SimpleDateFormat(datePatternStr);
		try {
			return dateFormat.parse(dateStr);
		}
		catch (ParseException pe) {
			throw new IllegalArgumentException("Argument 'dateStr' with value '" + dateStr
					+ "' is not a date following the pattern '" + datePatternStr + "'", pe);
		}
	}

}
