package com.github.avaya2223.issuelist;

import java.io.File;

public class IssueListApp {

	public static void main(String[] args) {
		System.out.println(args[0]);
		File file = new File(args[0]);

		IssueListRunner.execute(file);
	}

}
