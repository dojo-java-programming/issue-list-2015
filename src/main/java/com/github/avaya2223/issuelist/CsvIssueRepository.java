package com.github.avaya2223.issuelist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import org.csveed.api.CsvClient;
import org.csveed.api.CsvClientImpl;
import org.csveed.bean.BeanInstructionsImpl;
import org.csveed.bean.ColumnNameMapper;

public class CsvIssueRepository {

	public static IssueRepository create(File file) {
		IssueRepository issueRepository = new IssueRepository();
		
		// file openen
			// regel inlezen
			// van elke regel een issue maken: Issue temp = new Issue();
			//Issue toevoegen aan repository
		// Herhalen totdat de file geheel ingelezen is / file sluiten
		
		Reader reader;
		try {
			reader = new FileReader(file);

			CsvClient<CsvIssue> csvReader = new CsvClientImpl<CsvIssue>(reader,
                    new BeanInstructionsImpl(CsvIssue.class))
                .setMapper(ColumnNameMapper.class)
                .mapColumnNameToProperty("issue-id", "issueId")
                .mapColumnNameToProperty("status", "status")
                .mapColumnNameToProperty("priority", "priority")
                .mapColumnNameToProperty("issue-type", "issueType")
                .mapColumnNameToProperty("creation-date", "creationDate")
                .mapColumnNameToProperty("title", "title")
                .mapColumnNameToProperty("description", "description")
                .setDate("creationDate", "yyyy.MM.dd");

//			CsvClient<CsvIssue> csvReader = new CsvClientImpl<CsvIssue>(reader, CsvIssue.class);
			final List<CsvIssue> csvIssues = csvReader.readBeans();
			
			for (CsvIssue csvIssue : csvIssues) {
				System.out.println(csvIssue.getIssueId());
				issueRepository.add(csvIssue.create());
//				issueRepository.add(issueBuilder.create());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return issueRepository;
	}

}
