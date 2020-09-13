package com.api.dingdang.user.exception.enums;

import java.util.Arrays;

/**
 * 
 * @author luoml
 * @date 2016年11月16日
 */
public class ParamEmptyAtSameTimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private final String[] fields;
	public String[] getFields() {
		return fields;
	}
	public ParamEmptyAtSameTimeException(String... fields) {
		super(Arrays.toString(fields));
		this.fields = fields;
	}
	
}