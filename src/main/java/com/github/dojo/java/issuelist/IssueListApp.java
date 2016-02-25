package com.github.dojo.java.issuelist;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import freemarker.template.TemplateException;

public class IssueListApp {
	private Logger logger = LoggerFactory.getLogger(IssueListApp.class);
	
	@Parameter(names = {"--issues-file", "-i"}, description = "The issues file in csv format.", required = true)
    private String issuesFileStr = "issue-list.csv";

	@Parameter(names = {"--report-type", "-t"}, description = "The output format, of the report.", required = true)
    private String reportTypeStr;

    @Parameter(names = {"--report-file", "-r"}, description = "The output file name.")
    private String reportFileStr = null;


    @Parameter(names = "--help", help = true)
    private boolean help;


	public static void main(String[] args) {
		IssueListApp app = new IssueListApp();
        JCommander commander = new JCommander(app, args);
        if (app.help) {
             commander.usage();
             return;
        }

        app.run();
	}


	private void run() {
//		System.out.println(args[0]);
		File issuesFile = new File(issuesFileStr);
		
		if (reportFileStr == null) {
			reportFileStr = issuesFile.getName() + ".html";
		}
		File reportFile = new File(reportFileStr);
		logger.info("Will create report in '" + reportFile + "'");

		try {
			new IssueListRunner().execute(issuesFile, reportFile);
		}
		catch (IOException | TemplateException e) {
			logger.error("Unable to create report of type '" + reportTypeStr + "' from '" + issuesFile + "'", e);
		}
	}

}
