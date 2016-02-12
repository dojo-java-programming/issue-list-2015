package com.github.dojo.java.issuelist.issuelist.domain;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class IssueId {
	private final String regExpStr = "\\w+-\\d+"; 

	private final String issueId;

	public IssueId(String issueIdStr) {
		String issueIdCln = StringUtils.trimToNull(issueIdStr);
		if (issueIdCln == null) {
			throw new IllegalArgumentException(
					"Argument 'issueIdStr' with value '" + issueIdCln + "' should not be null");
		} else if (! Pattern.matches(regExpStr, issueIdCln)) {
					throw new IllegalArgumentException(
							"Argument 'issueIdStr' with value '123' is not a known IssueId. Expecting value '<word>-<number>' (regular expression '\\w+-\\d+')");
		}
		
		this.issueId = issueIdStr;
	}

	public String getId() {
		return issueId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((issueId == null) ? 0 : issueId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IssueId other = (IssueId) obj;
		if (issueId == null) {
			if (other.issueId != null)
				return false;
		} else if (!issueId.equals(other.issueId))
			return false;
		return true;
	}

}
