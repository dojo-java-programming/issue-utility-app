package com.github.dojo.java.programming.issue.repository;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.dojo.java.programming.issue.domain.IssueType;

public class IssueTypeRepositoryTest {

	@Test
	public void add() throws Exception {
		IssueTypeRepository issueTypeRepo = new IssueTypeRepository();
		issueTypeRepo.add(new IssueType("task"));
		issueTypeRepo.add(new IssueType("improvement"));
		issueTypeRepo.add(new IssueType("bug"));
		issueTypeRepo.add(new IssueType("new feature"));
		
		assertNotNull(issueTypeRepo);
		assertEquals(4, issueTypeRepo.size());
		assertEquals("BUG", issueTypeRepo.get().first().getName());
		assertEquals("TASK", issueTypeRepo.get().last().getName());
		assertEquals("TASK", issueTypeRepo.get("task").getName());
	}

	@Test
	public void getUnknownStatusType() {
		IssueTypeRepository issueTypeRepo = new IssueTypeRepository();
		issueTypeRepo.add(new IssueType("bug"));
		issueTypeRepo.add(new IssueType("improvement"));
		
		try {
			issueTypeRepo.get("task");
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'name' with value 'task' is not a known StatusType. Known status-types are [StatusType [name=BUG], StatusType [name=IMPROVEMENT]]",
					iae.getMessage());
		}
	}
}
