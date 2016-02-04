package com.github.avaya2223.issuelist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class IssueBuilderTest {

	@Test
	public void testCreate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		String issueId = "test-22";
		String title = "issue 1";
		String description = "desc 1";
		String priority = "medium";
		String status = "open";
		String issueType = "BUG";
		String creationDate = "2016.02.04";

		Issue issue = new IssueBuilder()
				.setIssueId(issueId).setTitle(title)
				.setDescription(description)
				.setPriority(priority)
				.setStatus(status)
				.setIssueType(issueType)
				.setCreationDate(creationDate)
				.create();
		
		assertNotNull(issue);
		assertEquals(issueId, issue.getIssueId().getId());
		assertEquals(title, issue.getTitle());
		assertEquals(description, issue.getDescription());
		assertEquals(priority.toUpperCase(), issue.getPriority().name());
		assertEquals(status.toUpperCase(), issue.getStatus().name());
		assertEquals(issueType.toUpperCase(), issue.getType().name());
		assertEquals(creationDate, dateFormat.format(issue.getCreationDate()));

	}

	@Test
	public void testSetIssueId() {
		IssueId issueId = new IssueId("test-23");
		String title = "issue 2";
		String description = "desc 2";
		Priority priority = Priority.LOW;
		Status status = Status.CLOSED;
		IssueType issueType = IssueType.IMPROVEMENT;
		Date creationDate = new Date();

		Issue issue = new IssueBuilder()
				.setIssueId(issueId)
				.setTitle(title)
				.setDescription(description)
				.setPriority(priority)
				.setStatus(status)
				.setIssueType(issueType)
				.setCreationDate(creationDate).create();

		assertNotNull(issue);
		assertEquals(title, issue.getTitle());
		assertEquals(description, issue.getDescription());
		assertEquals(issueId, issue.getIssueId());
		assertEquals(priority, issue.getPriority());
		assertEquals(status, issue.getStatus());
		assertEquals(issueType, issue.getType());
		assertEquals(creationDate.getTime(), issue.getCreationDate().getTime());
	}

}
