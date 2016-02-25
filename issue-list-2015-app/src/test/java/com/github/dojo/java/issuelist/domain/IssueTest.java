package com.github.dojo.java.issuelist.domain;

import java.util.Date;

import org.junit.Test;

import com.github.dojo.java.issuelist.issuelist.domain.Issue;
import com.github.dojo.java.issuelist.issuelist.domain.IssueBuilder;
import com.github.dojo.java.issuelist.issuelist.domain.IssueId;
import com.github.dojo.java.issuelist.issuelist.domain.IssueType;
import com.github.dojo.java.issuelist.issuelist.domain.Priority;
import com.github.dojo.java.issuelist.issuelist.domain.Status;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IssueTest {

	@Test
	public void create() throws Exception {
		IssueId issueId = new IssueId("sample-22");
		String title = "My first issue title";
		String description = "Some description";
		Status status = Status.OPEN;
		Priority priority = Priority.HIGH;
		Date creationDate = new Date();
		IssueType type = IssueType.BUG;
		Issue issue = new Issue(issueId, title, description, status, priority, creationDate, type);

		assertEquals(title, issue.getTitle());
		assertEquals(description, issue.getDescription());
		assertEquals(status, issue.getStatus());
		assertEquals(priority, issue.getPriority());
		assertEquals(creationDate, issue.getCreationDate());
	}

	@Test(expected = IllegalArgumentException.class)
	public void createTitleNull() throws Exception {
		IssueId issueId = new IssueId("sample-22");
		String title = null;
		String description = "Some description";
		Status status = Status.OPEN;
		try {
			new Issue(issueId, title, description, status, null, new Date(), IssueType.BUG);
		} catch (IllegalArgumentException iae) {
			assertEquals("Argument 'title' should not be null.",
					iae.getMessage());
			throw iae;
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void createDescriptionNull() throws Exception {
		IssueId issueId = new IssueId("sample-22");
		String title = "Een titel";
		String description = null;
		Status status = Status.OPEN;
		try {
			new Issue(issueId, title, description, status, Priority.HIGH, new Date(), IssueType.BUG);
		} catch (IllegalArgumentException iae) {
			assertEquals("Argument 'description' should not be null.",
					iae.getMessage());
			throw iae;
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void createStatusNull() throws Exception {
		IssueId issueId = new IssueId("sample-22");
		String title = "Een titel";
		String description = "Some description";
		try {
			new Issue(issueId, title, description, null, Priority.HIGH, new Date(), IssueType.BUG);
		} catch (IllegalArgumentException iae) {
			assertEquals("Argument 'status' should not be null.",
					iae.getMessage());
			throw iae;
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void createPriorityNull() throws Exception {
		IssueId issueId = new IssueId("sample-22");
		String title = "Een titel";
		String description = "Some description";
		try {
			new Issue(issueId, title, description, Status.CLOSED, null, new Date(), IssueType.BUG);
		} catch (IllegalArgumentException iae) {
			assertEquals("Argument 'priority' should not be null.",
					iae.getMessage());
			throw iae;
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void createDateNull() throws Exception {
		IssueId issueId = new IssueId("sample-22");
		String title = "Een titel";
		String description = "Some description";
		try {
			new Issue(issueId, title, description, Status.CLOSED, Priority.HIGH, null, IssueType.BUG);
		} catch (IllegalArgumentException iae) {
			assertEquals("Argument 'creationDate' should not be null.",
					iae.getMessage());
			throw iae;
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void createTitleSpaces() throws Exception {
		IssueId issueId = new IssueId("sample-22");
		String title = "  \t ";
		String description = "Some description";
		try {
			new Issue(issueId, title, description, Status.OPEN, null, new Date(), IssueType.BUG);
		} catch (IllegalArgumentException iae) {
			assertEquals("Argument 'title' should not be null.",
					iae.getMessage());
			throw iae;
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void createDescriptionSpaces() throws Exception {
		IssueId issueId = new IssueId("sample-22");
		String title = "Nice tiltle";
		String description = "\n";
		try {
			new Issue(issueId, title, description, Status.OPEN, Priority.HIGH, new Date(), IssueType.BUG);
		} catch (IllegalArgumentException iae) {
			assertEquals("Argument 'description' should not be null.",
					iae.getMessage());
			throw iae;
		}
	}

	@Test
	public void createCleanDescription() throws Exception {
		IssueId issueId = new IssueId("sample-22");
		String title = "Nice title";
		String description = "  Some Nice description  \n";
		Issue issue = new Issue(issueId, title, description, Status.OPEN, Priority.HIGH, new Date(), IssueType.BUG);

		assertEquals("Some Nice description", issue.getDescription());
	}

	
	@Test
	public void equals() throws Exception {
		Issue issueA = createIssue("issue-2");
		Issue issueB = createIssue("issue-2");

		assertEquals(issueA, issueB);
		assertTrue(issueA.equals(issueB));
	}


	public static Issue createIssue(String issueId) {
		return new IssueBuilder().setCreationDate("2015.12.10 16:45").setDescription("Some description")
				.setIssueId(issueId).setIssueType(IssueType.BUG).setPriority(Priority.HIGH)
				.setTitle("My first issue title").setStatus(Status.OPEN).create();
	}

}
