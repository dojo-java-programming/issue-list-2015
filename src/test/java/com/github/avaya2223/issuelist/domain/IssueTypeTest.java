package com.github.avaya2223.issuelist.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.github.avaya2223.issuelist.domain.IssueType;

public class IssueTypeTest {
	
	@Test
	public void createBug() {
		String issueTypeStr = "Bug";
		IssueType issueType = IssueType.fromText(issueTypeStr);
		
		assertNotNull(issueType);
		assertEquals(issueTypeStr.toUpperCase(), issueType.name());
	}
	
	@Test
	public void createImprovement() {
		String issueTypeStr = "Improvement";
		IssueType issueType = IssueType.fromText(issueTypeStr);
		
		assertNotNull(issueType);
		assertEquals(issueTypeStr.toUpperCase(), issueType.name());
	}
	
	@Test //(expected = IllegalArgumentException.class)
	public void createHelp() throws Exception {
		try {
			IssueType.fromText("help");
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'issueTypeStr' with value 'help' is not a known IssueType. Known values are [BUG, IMPROVEMENT]", iae.getMessage());
			//throw iae;
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void createNull() throws Exception {
		try {
			IssueType.fromText(null);
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'issueTypeStr' should not be null.", iae.getMessage());
			throw iae;
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void createSpaces() throws Exception {
		try {
			IssueType.fromText("   ");
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'issueTypeStr' should not be null.", iae.getMessage());
			throw iae;
		}
	}
}
