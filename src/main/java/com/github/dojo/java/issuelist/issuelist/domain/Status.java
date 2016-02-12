package com.github.dojo.java.issuelist.issuelist.domain;

import org.apache.commons.lang3.StringUtils;

public enum Status {
	CLOSED, OPEN;

	public static Status fromText(String name) {
		final String nameCln = StringUtils.trimToNull(name);
		if (nameCln == null) {
			throw new IllegalArgumentException(
					"Argument 'name' should not be null.");
		}
		try {
			return valueOf(nameCln.toUpperCase());
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Argument 'name' with value '"
					+ nameCln + "' is not a known Status. Known values are ["
					+ getValues() + "]");
		}

	}

	private static StringBuilder getValues() {
		StringBuilder resultaatBuilder = new StringBuilder();
		for (Status stat : values()) {
			if (resultaatBuilder.length() > 0) {
				resultaatBuilder.append(", ");
			}
			resultaatBuilder.append(stat.toString());

		}
		return resultaatBuilder;
	}

}
