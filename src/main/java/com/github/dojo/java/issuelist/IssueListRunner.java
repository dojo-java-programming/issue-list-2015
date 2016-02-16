package com.github.dojo.java.issuelist;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.github.dojo.java.issuelist.repository.IssueRepository;
import com.github.dojo.java.issuelist.repository.csv.CsvIssueRepository;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

public class IssueListRunner {
	private Configuration cfg;

	public IssueListRunner() throws IOException {
		cfg = new Configuration(Configuration.VERSION_2_3_22);

		// Specify the source where the template files come from. Here I set a
		// plain directory for it, but non-file-system sources are possible too:
		cfg.setDirectoryForTemplateLoading(new File("src/test/resources/templates"));

		// Set the preferred charset template files are stored in. UTF-8 is
		// a good choice in most applications:
		cfg.setDefaultEncoding("UTF-8");

		// Sets how errors will appear.
		// During web page *development*
		// TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		// cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

	}

	public void execute(final File inputCsvFile, final File outputFile) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		if(!inputCsvFile.exists()){
			throw new IllegalArgumentException("Het bestand: '" + inputCsvFile + "' bestaat niet!");
		}

		if(!inputCsvFile.isFile()){
			throw new IllegalArgumentException("De '" + inputCsvFile + "' is geen bestand!");
		}
		
		if(!inputCsvFile.canRead()){
			throw new IllegalArgumentException("De '" + inputCsvFile + "' is niet leesbaar!");
		}
		
		IssueRepository issueRepo = CsvIssueRepository.create(inputCsvFile);
		System.out.println(issueRepo.size());
		Template temp = cfg.getTemplate("issue-list.ftl");

		System.out.println("-----[ Begin ]-----");
		Writer out = new FileWriter(outputFile);//new OutputStreamWriter(System.out);
		temp.process(createModel(issueRepo), out);
		System.out.println("\n-----[ End ]-----");
	}

	private Map<String, Object> createModel(IssueRepository issueRepo) {
		Map<String, Object> root = new HashMap<>();
		root.put("name", "Issue list");
		root.put("issues", issueRepo.getAll());
		return root;
	}

}
