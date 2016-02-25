package com.github.dojo.java.issuelist;

import org.junit.Test;

public class IssueListAppTest {
	private static final String ISSUES_FILE = "--issues-file";
	private static final String REPORT_TYPE = "--report-type";
	private static final String REPORT_FILE = "--report-file";

	@Test
	public void main() throws Exception {
		String filePath = "src/test/resources/issuelist.csv";
		String outputFile = "target/issue-list.html";
		IssueListApp.main(new String[]{ ISSUES_FILE, filePath, REPORT_TYPE, "xyz", REPORT_FILE, outputFile });
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void mainNonExistingFile() throws Exception {
		String filePath = "src/test/resources/issuelistNonExisting.csv";
		String outputFile = "target/issue-list.html";
		IssueListApp.main(new String[]{ ISSUES_FILE, filePath, REPORT_TYPE, "xyz", REPORT_FILE, outputFile });
	}
	
	//filePath is geen file (maar een map)
	@Test(expected=IllegalArgumentException.class)
	public void mainNotFile() throws Exception {
		String outputFile = "target/issue-list.html";
		String filePath = "src/test/resources";
		IssueListApp.main(new String[]{ ISSUES_FILE, filePath, REPORT_TYPE, "xyz", REPORT_FILE, outputFile });
	}
	
}
