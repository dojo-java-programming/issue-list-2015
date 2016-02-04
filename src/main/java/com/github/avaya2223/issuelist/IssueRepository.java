package com.github.avaya2223.issuelist;

import java.util.ArrayList;
import java.util.List;

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
	
}
