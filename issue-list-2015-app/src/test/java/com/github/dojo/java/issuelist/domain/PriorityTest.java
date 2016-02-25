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
    
    @Test(expected = IllegalArgumentException.class)
    public void createIncorrect() throws Exception {
        try {
            Priority.fromText("test");
        }
        catch (IllegalArgumentException iae) {
            assertEquals(iae.getMessage(), "Argument 'priorityStr' with value 'test' is not a known Priority. Known values are [LOW, MEDIUM, HIGH]");
            throw iae;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNull() throws Exception {
        try {
            Priority.fromText(null);
        }
        catch (IllegalArgumentException iae) {
            assertEquals(iae.getMessage(), "Argument 'priorityStr' should not be null.");
            throw iae;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void createSpaces() throws Exception {
        try {
            Priority.fromText("  \t ");
        }
        catch (IllegalArgumentException iae) {
            assertEquals(iae.getMessage(), "Argument 'priorityStr' should not be null.");
            throw iae;
        }
    }

}
