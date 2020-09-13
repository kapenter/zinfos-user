package com.api.dingdang.user.exception.enums;


/**
 * 参数不能为空
 * @author luoml
 * @date 2016年11月14日
 */
public class ParamEmptyException  extends RuntimeException implements ParamException {
	private static final long serialVersionUID = 1L;
	private String field;
	
	public ParamEmptyException(String field) {
		super(field + "参数不能为空");
		this.field = field;
	}

	@Override
	public String getParam() {
		return field;
	}
	
}
