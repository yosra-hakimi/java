package com.talan.recrutement.specification;

import lombok.Data;

@Data
public class SearchCriteria {

	private String key;
	private String operation;
	private Object value;

	public SearchCriteria(String key, String operator, Object value) {
		this.key = key;
		this.operation = operator;
		this.value = value;
	}

}
