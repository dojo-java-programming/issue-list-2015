package com.github.avaya2223.issuelist;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class CsvIssueRepositoryTest {

	@Test
	public void createFromFile() {
		IssueRepository issueRepository =  CsvIssueRepository.create(new File("src/test/resources/issuelist.csv"));
		assertNotNull(issueRepository);
		assertEquals(2, issueRepository.size());
		assertEquals("sample-10", issueRepository.get(0).getIssueId().getId());
		assertEquals("sample-12", issueRepository.get(1).getIssueId().getId());
	}

}
