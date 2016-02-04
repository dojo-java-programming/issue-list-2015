package com.github.avaya2223.issuelist;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IssueRepositoryTest {

	@Test
	public void createEmpty() {
		IssueRepository repo = new IssueRepository();
		assertEquals(0, repo.size()); 
	}

	@Test
	public void create() {
		IssueRepository repo = new IssueRepository();
		Issue issueA = IssueTest.createIssue();
		repo.add(issueA);

		assertEquals(1, repo.size()); 
		assertEquals("sample-22", repo.get(0).getIssueId().getId());
		assertEquals(issueA, repo.get(0));
	}

}
