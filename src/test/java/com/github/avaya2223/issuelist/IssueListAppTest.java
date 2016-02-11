package com.github.avaya2223.issuelist;

import org.junit.Test;

public class IssueListAppTest {

	@Test
	public void main() throws Exception {
		String filePath = "src/test/resources/issuelist.csv";
		IssueListApp.main(new String[]{filePath});
	}
}
