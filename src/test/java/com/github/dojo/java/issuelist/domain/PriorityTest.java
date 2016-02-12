package com.github.dojo.java.issuelist.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.dojo.java.issuelist.issuelist.domain.Priority;

public class PriorityTest {
 
	@Test
	public void create() throws Exception {
		
	}
	
	@Test
	public void createLow() throws Exception {
		String priorityStr = "low";
		Priority priority = Priority.fromText(priorityStr);
		
		assertNotNull(priority);
		assertEquals(priorityStr.toUpperCase(), priority.name());
	}
	
	@Test
	public void createMedium() throws Exception {
		String priorityStr = "medium";
		Priority priority = Priority.fromText(priorityStr);
		
		assertNotNull(priority);
		assertEquals(priorityStr.toUpperCase(), priority.name());
	}

}
