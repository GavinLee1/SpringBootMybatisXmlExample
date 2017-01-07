package com.study.infrastructure.domain;

public class BusinessRule {
	private String property;
	private String rule;

	public BusinessRule(String property, String rule) {
		this.property = property;
		this.rule = rule;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

}
