package com.github.avaya2223.issuelist;

import java.io.File;
import java.io.IOException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class IssueListApp {

	public static void main(String[] args) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		System.out.println(args[0]);
		File file = new File(args[0]);

		new IssueListRunner().execute(file);
	}

}
