package com.bnp.showroom.common;

/**
 * Enum representing the possible values for the status of a project.
 */
public enum ProjectStatus {
	CONCEPTION("Conception"), DEVELOPMENT("Development"), DONE("Done");

	private final String value;

	private ProjectStatus(String val) {
		this.value = val;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}
