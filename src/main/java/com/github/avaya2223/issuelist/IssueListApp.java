package com.github.avaya2223.issuelist;

import java.io.File;

import com.github.avaya2223.issuelist.repository.IssueRepository;
import com.github.avaya2223.issuelist.repository.csv.CsvIssueRepository;

public class IssueListApp {

	public static void main(String[] args) {
		System.out.println(args[0]);
		
		File file = new File(args[0]);
		IssueRepository issueRepo = CsvIssueRepository.create(file);
		
		System.out.println(issueRepo.size());
	}

}
