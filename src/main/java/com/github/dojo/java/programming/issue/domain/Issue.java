package com.github.dojo.java.programming.issue.domain;

import java.util.Date;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class Issue {
	private final String ID_REG_EXP = "\\w+-\\d+";
	private final String id;
	private final IssueType issueType;
	private final Priority priority;
	private final Date creationDate;


	public Issue(final Builder bldr) {
		final String idCln = StringUtils.trimToNull(bldr.getId());
		if (idCln == null) {
			throw new IllegalArgumentException("Argument 'bldr.getId()' should not be null.");
		}
		else if (! Pattern.matches(ID_REG_EXP, idCln)) {
			throw new IllegalArgumentException("Argument 'bldr.getId()', with value '" + idCln 
					+ "' does not follow the pattern '" + ID_REG_EXP + "'.");
		}
		if (bldr.getIssueType() == null) {
			throw new IllegalArgumentException("Argument 'bldr.getIssueType()' should not be null.");
		}
		if (bldr.getPriority() == null) {
			throw new IllegalArgumentException("Argument 'bldr.getPriority()' should not be null.");
		}
		if (bldr.getCreationDate() == null) {
			throw new IllegalArgumentException("Argument 'bldr.getCreationDate()' should not be null.");
		}

		id = idCln.toUpperCase();
		issueType = bldr.getIssueType();
		priority = bldr.getPriority();
		creationDate = bldr.getCreationDate();
	}


	public String getId() {
		return id;
	}

	public IssueType getIssueType() {
		return issueType;
	}

	public Priority getPriority() {
		return priority;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}

	
	// Builder

	public static class Builder {
		private String id;
		private IssueType issueType;
		private Priority priority;
		private Date creationDate;

		public Issue create() {
			return new Issue(this);
		}


		public String getId() {
			return id;
		}

		public IssueType getIssueType() {
			return issueType;
		}

		public Priority getPriority() {
			return priority;
		}

		public Date getCreationDate() {
			return creationDate;
		}


		public Builder setId(final String id) {
			this.id = id;
			return this;
		}

		public Builder setIssueType(final IssueType issueType) {
			this.issueType = issueType;
			return this;
		}

		public Builder setPriority(final Priority priority) {
			this.priority = priority;
			return this;
		}

		public Builder setCreationDate(final Date date) {
			this.creationDate = date;
			return this;
		}

	}

}
