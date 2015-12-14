package com.github.dojo.java.programming.issue.repository;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.dojo.java.programming.issue.domain.Priority;

public class PriorityRepositoryTest {
	
	@Test
	public void add() throws Exception {
		PriorityRepository priorityRepo = new PriorityRepository();
		priorityRepo.add(new Priority("high"));
		priorityRepo.add(new Priority("medium"));
		priorityRepo.add(new Priority("low"));
		
		assertNotNull(priorityRepo);
		assertEquals(3, priorityRepo.size());
		assertEquals("HIGH", priorityRepo.get("high").getName());
		assertEquals("MEDIUM", priorityRepo.get("medium").getName());
		assertEquals("LOW", priorityRepo.get("low").getName());
	}

	@Test
	public void addWithIndex() throws Exception {
		PriorityRepository priorityRepo = new PriorityRepository();
		priorityRepo.add(new Priority("high"), 0);
		priorityRepo.add(new Priority("low"), 1);
		
		assertEquals("LOW", priorityRepo.get(1).getName());
		
		priorityRepo.add(new Priority("medium"), 1);

		assertEquals("MEDIUM", priorityRepo.get(1).getName());
		assertEquals("LOW", priorityRepo.get(2).getName());

		assertNotNull(priorityRepo);
		assertEquals(3, priorityRepo.size());
		assertEquals("HIGH", priorityRepo.get("high").getName());
		assertEquals("MEDIUM", priorityRepo.get("medium").getName());
		assertEquals("LOW", priorityRepo.get("low").getName());
	}

}
