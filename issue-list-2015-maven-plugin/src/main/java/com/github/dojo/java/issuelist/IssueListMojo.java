package com.github.dojo.java.issuelist;

import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import freemarker.template.TemplateException;

@Mojo(name = "create", defaultPhase = LifecyclePhase.GENERATE_RESOURCES)
public class IssueListMojo extends AbstractMojo {

	@Parameter(alias = "issues-file", required = true)
	private String issuesFile;

	@Parameter(alias = "report-file")
	private String reportFile;

	@Parameter(alias = "report-type", defaultValue = "html")
	private String reportType = "html";

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("Start creating report!");

		File inputFile = new File(issuesFile);

		if (reportFile == null) {
			reportFile = inputFile.getName() + reportType;
		}

		File outputFile = new File(reportFile);
		try {
			new IssueListRunner().execute(inputFile, outputFile);
		} catch (IOException | TemplateException e) {
			getLog().error("Unable to create report of type '" + reportType + "' from '" + issuesFile + "'", e);
		}

		getLog().info("Finished creating report: '" + reportFile + "'!");
	}

}
