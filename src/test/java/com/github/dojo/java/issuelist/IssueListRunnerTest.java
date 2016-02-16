package com.github.dojo.java.issuelist;

import java.io.File;

import org.junit.Test;

public class IssueListRunnerTest {

	@Test
	public void create() throws Exception {
		IssueListRunner runner = new IssueListRunner();
		File inputFile = new File("src/test/resources/issuelist.csv");
		File outputFile = new File("target/issue-list.html");
		runner.execute(inputFile, outputFile);
	}
}
