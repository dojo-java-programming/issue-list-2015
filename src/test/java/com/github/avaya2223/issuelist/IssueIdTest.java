package com.github.avaya2223.issuelist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.github.avaya2223.issuelist.domain.IssueId;

public class IssueIdTest {
	
	@Test
	public void createSample11() {
		String issueIdStr = "Sample-11";
		IssueId issueId = new IssueId(issueIdStr);
		
		assertNotNull(issueId);
		assertEquals(issueIdStr, issueId.getId());
	}

	@Test
	public void createTest11() {
		String issueIdStr = "test-11";
		IssueId issueId = new IssueId(issueIdStr);
		
		assertNotNull(issueId);
		assertEquals(issueIdStr, issueId.getId());
	}
	
//	@Test
//	public void createImprovement() {
//		String issueIdStr = "123";
//		IssueId issueId = new IssueId(issueIdStr);
//		
//		assertNotNull(issueId);
//		assertEquals(issueIdStr, issueId.getId());
//	}
//	
	@Test //(expected = IllegalArgumentException.class)
	public void create123() throws Exception {
		try {
			new IssueId("123");
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'issueIdStr' with value '123' is not a known IssueId. Expecting value '<word>-<number>' (regular expression '\\w+-\\d+')", iae.getMessage());
//			throw iae;
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createNull() throws Exception {
		try {
			new IssueId(null);
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'issueIdStr' with value 'null' should not be null", iae.getMessage());
			throw iae;
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void createSpaces() throws Exception {
		try {
			new IssueId("  \t");
		}
		catch (IllegalArgumentException iae) {
			assertEquals("Argument 'issueIdStr' with value 'null' should not be null", iae.getMessage());
			throw iae;
		}
	}
//
//	@Test(expected = IllegalArgumentException.class)
//	public void createNull() throws Exception {
//		try {
//			IssueType.fromText(null);
//		}
//		catch (IllegalArgumentException iae) {
//			assertEquals("Argument 'issueTypeStr' should not be null.", iae.getMessage());
//			throw iae;
//		}
//	}
//
//	@Test(expected = IllegalArgumentException.class)
//	public void createSpaces() throws Exception {
//		try {
//			IssueType.fromText("   ");
//		}
//		catch (IllegalArgumentException iae) {
//			assertEquals("Argument 'issueTypeStr' should not be null.", iae.getMessage());
//			throw iae;
//		}
//	}
}
