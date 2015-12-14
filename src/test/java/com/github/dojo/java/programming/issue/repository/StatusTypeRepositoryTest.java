package com.github.dojo.java.programming.issue.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.github.dojo.java.programming.issue.domain.StatusType;

public class StatusTypeRepositoryTest {

	@Test
	public void add() throws Exception {
		StatusTypeRepository statusTypeRepo = new StatusTypeRepository();
		statusTypeRepo.add(new StatusType("open"));
		statusTypeRepo.add(new StatusType("closed"));
		statusTypeRepo.add(new StatusType("can not reproduce"));
//		statusTypeRepo.add(new StatusType("xxx"));
		
		assertNotNull(statusTypeRepo);
		assertEquals(3, statusTypeRepo.size());
		assertEquals("CAN NOT REPRODUCE", statusTypeRepo.get().first().getName());
		assertEquals("OPEN", statusTypeRepo.get().last().getName());
		assertEquals("CLOSED", statusTypeRepo.get("closed").getName());
	}

	@Test
	public void getUnknownStatusType() {
		StatusTypeRepository statusTypeRepo = new StatusTypeRepository();
		statusTypeRepo.add(new StatusType("open"));
		statusTypeRepo.add(new StatusType("closed"));
		
		try {
			statusTypeRepo.get("can not reproduce");
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'name' with value 'can not reproduce' is not a known StatusType. Known status-types are [StatusType [name=CLOSED], StatusType [name=OPEN]]",
					iae.getMessage());
		}
	}
}
