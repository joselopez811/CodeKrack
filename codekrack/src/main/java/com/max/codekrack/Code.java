package com.max.codekrack;

import com.max.codekrack.databaseutil.DatabaseUtil;

public class Code {

	private String code;
	
	public Code () {
		this.code = DatabaseUtil.getCode();
	}

	public Code(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
