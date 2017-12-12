package com.jiuwu.openoo.common.openapi.typeConvert;

import java.math.BigDecimal;

public class BigDecimalConvert implements IConvert {

	public Object convert(String value) {
		if (null == value) {
			return BigDecimal.valueOf(0.0);
		}
		try {
			return BigDecimal.valueOf(Double.parseDouble(value));
		} catch (NumberFormatException e) {
			return null;
		}

	}
}
