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
		Issue issueA = IssueTest.createIssue("sample-1");
		repo.add(issueA);

		assertEquals(1, repo.size()); 
		assertEquals("sample-1", repo.get(0).getIssueId().getId());
		assertEquals(issueA, repo.get(0));
	}


	@Test
	public void createMoreThenOne() {
		IssueRepository repo = new IssueRepository();
		Issue issueA = IssueTest.createIssue("test-1");
		Issue issueB = IssueTest.createIssue("test-2");
		Issue issueC = IssueTest.createIssue("test-3");
		repo.add(issueA);
		repo.add(issueB);
		repo.add(issueC);

		assertEquals(3, repo.size()); 
		assertEquals("test-1", repo.get(0).getIssueId().getId());
		assertEquals(issueA, repo.get(0));
		assertEquals("test-2", repo.get(1).getIssueId().getId());
		assertEquals(issueB, repo.get(1));
		assertEquals("test-3", repo.get(2).getIssueId().getId());
		assertEquals(issueC, repo.get(2));
	}

}
