package com.github.avaya2223.issuelist;

import java.io.File;

import com.github.avaya2223.issuelist.repository.IssueRepository;
import com.github.avaya2223.issuelist.repository.csv.CsvIssueRepository;

public class IssueListRunner {

	public static void execute(File file) {
		if(!file.exists()){
			throw new IllegalArgumentException("Het bestand: '" + file + "' bestaat niet!");
		}

		if(!file.isFile()){
			throw new IllegalArgumentException("De '" + file + "' is geen bestand!");
		}
		
		if(!file.canRead()){
			throw new IllegalArgumentException("De '" + file + "' is niet leesbaar!");
		}
		
		IssueRepository issueRepo = CsvIssueRepository.create(file);
		System.out.println(issueRepo.size());
	}

}
