package com.study.infrastructure.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.study.infrastructure.exception.ValueObjectIsInvalidException;

public abstract class ValueObjectBase {
	@JsonIgnore
	private transient List<BusinessRule> brokenRules = new ArrayList<>();
	
	public ValueObjectBase() {
	}
	
	abstract protected void validate();
	
	public void throwExceptionIfInvalid() throws ValueObjectIsInvalidException {
		brokenRules.clear();
		validate();
		if(brokenRules.size() > 0) {
			StringBuilder issues = new StringBuilder();
			for(BusinessRule businessRule : brokenRules) {
				issues.append(businessRule.getRule());
			}
			issues.append("\n");
			throw new ValueObjectIsInvalidException(issues.toString());
		}
	}
	
	public String toJSON() {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String json = gson.toJson(this);
		return json;
	}
	
	public List<BusinessRule> getBrokenRules() {
		brokenRules.clear();
		validate();
		return brokenRules;
	}
	
	public void addBrokenRule(BusinessRule businessRule) {
		brokenRules.add(businessRule);
	}
}
