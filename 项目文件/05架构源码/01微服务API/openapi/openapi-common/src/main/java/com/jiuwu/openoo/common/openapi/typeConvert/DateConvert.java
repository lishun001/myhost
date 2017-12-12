/**
 * 
 * Copyright 2006 bsmith@qq.com, zjulhs
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either def or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.jiuwu.openoo.common.openapi.typeConvert;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConvert implements IConvert {
	public static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

	public Object convert(String value) {
		if (null == value) {
			return null;
		}
		SimpleDateFormat fmt = new SimpleDateFormat(PATTERN);
		try {
			return fmt.parse(value);

		} catch (ParseException err) {
		}
		return null;
	}
}
