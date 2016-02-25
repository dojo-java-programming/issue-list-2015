package com.github.dojo.java.issuelist.repository.csv;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.github.dojo.java.issuelist.repository.IssueRepository;
import com.github.dojo.java.issuelist.repository.csv.CsvIssueRepository;

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
