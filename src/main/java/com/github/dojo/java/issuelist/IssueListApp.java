package com.github.dojo.java.issuelist;

import java.io.File;
import java.io.IOException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class IssueListApp {

	public static void main(String[] args) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		System.out.println(args[0]);
		File inputCsvFile = new File(args[0]);
		File outputHtmlFile = new File(args[1]);

		new IssueListRunner().execute(inputCsvFile, outputHtmlFile);
	}

}
