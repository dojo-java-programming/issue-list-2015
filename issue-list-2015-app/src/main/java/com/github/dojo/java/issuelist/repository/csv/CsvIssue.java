package com.github.dojo.java.issuelist.repository.csv;

import java.util.Date;

import org.csveed.annotations.CsvDate;

import com.github.dojo.java.issuelist.issuelist.domain.Issue;
import com.github.dojo.java.issuelist.issuelist.domain.IssueBuilder;

public class CsvIssue {
	private String priority;
	private String status;
	@CsvDate(format="yyyy.MM.dd")
	private Date creationDate;
	private String title;
	private String description;
	private String issueId;
	private String issueType;

	public String getIssueId() {
		return issueId;
	}
	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Issue create() {
		return new IssueBuilder()
				.setTitle(getTitle())
				.setDescription(getDescription())
				.setIssueId(getIssueId())
				.setIssueType(getIssueType())
				.setStatus(getStatus())
				.setPriority(getPriority())
				.setCreationDate(getCreationDate())
				.create();
	}
}
