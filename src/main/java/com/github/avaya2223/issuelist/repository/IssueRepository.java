package com.github.avaya2223.issuelist.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.avaya2223.issuelist.domain.Issue;

public class IssueRepository {
	private List<Issue> issues = new ArrayList<Issue>();


	public int size() {
		return issues.size();
	}

	public void add(Issue issue) {
		issues.add(issue);
	}

	public Issue get(int index) {
		return issues.get(index);
	}

	public List<Issue> getAll() {
		return Collections.unmodifiableList(issues);
	}
	
}
