package com.github.dojo.java.issuelist;

import org.junit.Test;

public class IssueListAppTest {

	@Test
	public void main() throws Exception {
		String filePath = "src/test/resources/issuelist.csv";
		String outputFile = "target/issue-list.html";
		IssueListApp.main(new String[]{filePath, outputFile});
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void mainNonExistingFile() throws Exception {
		String filePath = "src/test/resources/issuelistNonExisting.csv";
		String outputFile = "target/issue-list.html";
		IssueListApp.main(new String[]{filePath, outputFile});
	}
	
	//filePath is geen file (maar een map)
	@Test(expected=IllegalArgumentException.class)
	public void mainNotFile() throws Exception {
		String outputFile = "target/issue-list.html";
		String filePath = "src/test/resources";
		IssueListApp.main(new String[]{filePath, outputFile});
	}
	
}
