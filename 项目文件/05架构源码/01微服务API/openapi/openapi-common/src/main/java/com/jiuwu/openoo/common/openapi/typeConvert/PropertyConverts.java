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

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertyConverts {
	// The ordinary property converter map.
	public static Map<Class<?>, IConvert> CONVERTS = new HashMap<Class<?>, IConvert>();

	private static final Log log = LogFactory.getLog(PropertyConverts.class);
	static {
		CONVERTS.put(String.class, new StringConvert());
		CONVERTS.put(BigDecimal.class, new BigDecimalConvert());
		CONVERTS.put(double.class, new DoubleConvert());
		CONVERTS.put(Double.class, new DoubleConvert());
		CONVERTS.put(int.class, new IntegerConvert());
		CONVERTS.put(Integer.class, new IntegerConvert());
		CONVERTS.put(long.class, new LongConvert());
		CONVERTS.put(Long.class, new LongConvert());
		CONVERTS.put(boolean.class, new BooleanConvert());
		CONVERTS.put(Boolean.class, new BooleanConvert());
		CONVERTS.put(float.class, new FloatConvert());
		CONVERTS.put(Float.class, new FloatConvert());
		CONVERTS.put(short.class, new ShortConvert());
		CONVERTS.put(Short.class, new ShortConvert());
		CONVERTS.put(byte.class, new ByteConvert());
		CONVERTS.put(Byte.class, new ByteConvert());
		CONVERTS.put(char.class, new CharConvert());
		CONVERTS.put(java.util.Date.class, new DateConvert());
	}

	/**
	 * Set the property value to bean.
	 * 
	 * @param bean
	 *            the java bean.
	 * @param name
	 *            the property expression.
	 * @param value
	 *            the property value.
	 */
	public static void setProperty(Object bean, String name, String value) {
		setProperty(bean, name, new String[] { value });
	}

	public static void setProperty(Object bean, String name, String[] values) {
		try {
			char c;
			for (int i = 0; i < name.length(); i++) {
				c = name.charAt(i);
				// The sub property operation.
				if (c == '.') {
					String root = name.substring(0, i);
					Object obj = getExistedProperty(bean, root);
					if (null != obj) {
						String sub = name.substring(i + 1);
						setProperty(obj, sub, values);
					}
					return;
				}
				// The index referenced operation.
				else if (c == '[') {
					String root = name.substring(0, i);
					Object obj = getExistedProperty(bean, root);
					if (null != obj) {
						for (int j = i + 1; j < name.length(); j++) {
							c = name.charAt(j);
							if (c == ']') {
								String refer = name.substring(i + 1, j);
								// Now only array list supported.
								if (obj instanceof ArrayList) {
									Class<?> cls = getGenericClass(bean, root,
											0);
									int index = Integer.parseInt(refer);
									ArrayList array = (ArrayList) obj;
									int gap = index + 1 - array.size();
									while (gap > 0) {
										array.add(null);
										gap--;
									}
									// No additional property operation on the
									// array member.
									if (j == name.length() - 1) {
										IConvert convert = CONVERTS.get(cls);
										if (null != convert) {
											Object elem = convert
													.convert(values[0]);
											array.set(index, elem);
										}
									}
									// Has additional property operation on the
									// array member.
									else {
										Object elem = array.get(index);
										if (null == elem) {
											elem = cls.newInstance();
											array.set(index, elem);
										}
										String sub = name.substring(j + 2);
										setProperty(elem, sub, values);
									}
								}
								break;
							}
						}
					}
					return;
				}
			}
			setOrdinaryProperty(bean, name, values);
		} catch (Exception err) {
			// log.error("输入参数解析错误："+err.getMessage());
		}
	}

	/**
	 * Get the property object form bean, if property is null, create new
	 * instance.
	 * 
	 * @param bean
	 *            the bean object.
	 * @param name
	 *            the property name.
	 * @return
	 */
	private static Object getExistedProperty(Object bean, String name) {
		try {
			PropertyDescriptor prop = new PropertyDescriptor(name,
					bean.getClass());
			Method read = prop.getReadMethod();
			Object obj = read.invoke(bean);
			if (null != obj) {
				return obj;
			}
			Class<?> cls = prop.getPropertyType();
			if (cls.isArray()) {
				return null;
			}

			if (cls.getSimpleName().equals("List")) {
				obj = new ArrayList();
			} else {
				obj = cls.newInstance();
			}

			Method write = prop.getWriteMethod();
			write.invoke(bean, obj);
			return obj;
		} catch (Exception err) {
			// log.error("返回值解析错误："+err.getMessage());
		}
		return null;
	}

	public static void setObjPropertyValue(Object bean, String name, Object obj) {
		try {
			PropertyDescriptor prop = new PropertyDescriptor(name,
					bean.getClass());
			Method write = prop.getWriteMethod();
			write.invoke(bean, obj);
		} catch (Exception err) {
			log.error("设置属性值:" + name + "出错");
		}
	}

	/**
	 * Get the generic inner class of the bean property.
	 * 
	 * @param bean
	 * @param name
	 * @param index
	 * @return
	 * @throws IntrospectionException
	 */
	private static Class<?> getGenericClass(Object bean, String name, int index)
			throws IntrospectionException {
		PropertyDescriptor prop = new PropertyDescriptor(name, bean.getClass());
		Method write = prop.getWriteMethod();
		ParameterizedType type = (ParameterizedType) write
				.getGenericParameterTypes()[0];
		Class<?> cls = (Class<?>) type.getActualTypeArguments()[index];
		return cls;
	}

	/**
	 * Set ordinary property of the bean object, the name only support plain
	 * format.
	 * 
	 * @param bean
	 *            the object bean.
	 * @param name
	 *            the direct property of the bean.
	 * @param values
	 *            the values, if the property is not array, the use values[0],
	 *            otherwise, used as array.
	 */
	private static void setOrdinaryProperty(Object bean, String name,
			String[] values) {
		if (null == values) {
			return;
		}
		// The ordinary single or array property operation.
		try {
			PropertyDescriptor prop = new PropertyDescriptor(name,
					bean.getClass());
			Class<?> cls = prop.getPropertyType();
			Object obj = null;
			IConvert convert = null;
			if (cls.isArray()) {
				Class<?> subCls = cls.getComponentType();
				convert = CONVERTS.get(subCls);
				if (null != convert) {
					obj = Array.newInstance(subCls, values.length);
					for (int i = 0; i < values.length; i++) {
						Array.set(obj, i, convert.convert(values[i]));
					}
				}
			} else {
				if (values.length > 0) {
					convert = CONVERTS.get(cls);
					if (null != convert) {
						obj = convert.convert(values[0]);
					}
				}
			}
			if (null != convert) {
				Method write = prop.getWriteMethod();
				write.invoke(bean, obj);
			}
		} catch (Exception err) {
			// log.error("返回值解析错误："+err.getMessage());
		}
	}
}
