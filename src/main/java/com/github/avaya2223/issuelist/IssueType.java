package com.github.avaya2223.issuelist;

import org.apache.commons.lang3.StringUtils;

public enum IssueType {
	BUG, IMPROVEMENT;

	public static IssueType fromText(String issueTypeStr) {
		final String issueTypeCln = StringUtils.trimToNull(issueTypeStr);
		if (issueTypeCln == null) {
			throw new IllegalArgumentException(
					"Argument 'issueTypeStr' should not be null.");
		}
		try {
			return valueOf(issueTypeCln.toUpperCase());
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Argument 'issueTypeStr' with value '"
					+ issueTypeCln + "' is not a known IssueType. Known values are ["
					+ getValues() + "]");
		}

	}

	private static StringBuilder getValues() {
		StringBuilder resultaatBuilder = new StringBuilder();
		for (IssueType issueType : values()) {
			if (resultaatBuilder.length() > 0) {
				resultaatBuilder.append(", ");
			}
			resultaatBuilder.append(issueType.toString());

		}
		return resultaatBuilder;
	}

}
