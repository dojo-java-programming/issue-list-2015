package com.github.avaya2223.issuelist.domain;

import org.apache.commons.lang3.StringUtils;

public enum Priority {
	LOW, MEDIUM, HIGH;

	public static Priority fromText(String priorityStr) {
		final String priorityCln = StringUtils.trimToNull(priorityStr);
		if (priorityCln == null) {
			throw new IllegalArgumentException(
					"Argument 'priorityStr' should not be null.");
		}
		try {
			return valueOf(priorityCln.toUpperCase());
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Argument 'priorityStr' with value '"
					+ priorityCln + "' is not a known Priority. Known values are ["
					+ getValues() + "]");
		}

	}

	private static StringBuilder getValues() {
		StringBuilder resultaatBuilder = new StringBuilder();
		for (Priority priority : values()) {
			if (resultaatBuilder.length() > 0) {
				resultaatBuilder.append(", ");
			}
			resultaatBuilder.append(priority.toString());

		}
		return resultaatBuilder;
	}

}
