package com.github.dojo.java.issuelist.issuelist.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IssueBuilder {

	private IssueId issueId;
	private Priority priority;
	private Status status;
	private IssueType issueType;
	private Date creationDate;
	private String title;
	private String description;

	public Issue create() {
		Issue issue = new Issue(this);
		return issue;
	}

	public IssueBuilder setIssueId(IssueId issueId) {
		this.issueId = issueId;
		return this;
	}

	public IssueBuilder setIssueId(String issueIdStr) {
		setIssueId(new IssueId(issueIdStr));
		return this;
	}

	public IssueBuilder setPriority(Priority priority) {
		this.priority = priority;
		return this;
	}

	public IssueBuilder setPriority(String priorityStr) {
		setPriority(Priority.fromText(priorityStr));
		return this;
	}

	public IssueBuilder setStatus(String statusStr) {
		setStatus(Status.fromText(statusStr));
		return this;
	}

	public IssueBuilder setStatus(Status status) {
		this.status = status;
		return this;
	}

	public IssueBuilder setIssueType(String issueTypeStr) {
		setIssueType(IssueType.fromText(issueTypeStr));
		return this;
	}

	public IssueBuilder setCreationDate(String creationDate) {
		String dateFormatStr = "yyyy.MM.dd";
		DateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
		try {
			Date parse = dateFormat.parse(creationDate);
			setCreationDate(parse);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Argument 'creationDate' with value '" + creationDate
					+ "' is invalid. Expected format '" + dateFormatStr + "'");
			// e.printStackTrace();
		}
		return this;
	}

	public IssueBuilder setIssueType(IssueType issueType) {
		this.issueType = issueType;
		return this;
	}

	public IssueBuilder setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
		return this;
	}

	public IssueBuilder setTitle(String title) {
		this.title = title;
		return this;
	}

	public IssueBuilder setDescription(String description) {
		this.description = description;
		return this;
	}

	public IssueId getIssueId() {
		return issueId;
	}

	public Priority getPriority() {
		return priority;
	}

	public Status getStatus() {
		return status;
	}

	public IssueType getType() {
		return issueType;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

}
