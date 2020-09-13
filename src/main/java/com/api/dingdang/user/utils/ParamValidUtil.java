package com.api.dingdang.user.utils;

import com.api.dingdang.user.exception.enums.ParamEmptyAtSameTimeException;
import com.api.dingdang.user.exception.enums.ParamEmptyException;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.List;


/**
 * 校验类
 * 
 * @author marlon.luo
 *
 */
public class ParamValidUtil {
	/**
	 * 校验参数非空
	 * 1, 对象不为null<br/>
	 * 2, 如果为String, 则长度不能为0、不能全是空白、不能是null字串<br/>
	 * 3, 如果为数组和集合， 则长度不能为0
	 * @param o
	 * @param name
	 */
	public static void checkParameterNotEmpty(Object o, String name){
		if (isFieldEmpty(o)) {
			throw new ParamEmptyException(name);
		}
	}
	/**
	 * 校验参数非空
	 * 1, 对象不为null<br/>
	 * 2, 如果为String, 则长度不能为0、不能全是空白、不能是null字串<br/>
	 * 3, 如果为数组和集合， 则长度不能为0
	 * 4, 如果为int， 不能为0
	 * @param o
	 * @param fields
	 */
	public static void checkNotEmpty(Object o, String... fields) {
		if (o == null) {
			throw new NullPointerException();
		}
		try {
			Class<?> c = o.getClass();
			for (String fieldName : fields) {
				Field field = c.getDeclaredField(fieldName);
				field.setAccessible(true);
				Object value = field.get(o);
				if (isintEmpty(field, value) || isFieldEmpty(value)) {
					throw new ParamEmptyException(field.getName());
				}
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

	}

	/**
	 * 校验参数非空
	 * 1, 对象不为null<br/>
	 * 2, 如果为String, 则长度不能为0、不能全是空白、不能是null字串<br/>
	 * 3, 如果为数组和集合， 则长度不能为0
	 * 4, 如果为int， 不能为0
	 * @param o
	 * @param fields
	 */
	public static void checkNotEmptyAtSameTime(Object o, String... fields) {
		if (o == null) {
			throw new NullPointerException();
		}

		try {
			int nullCount = 0;
			Class<?> c = o.getClass();
			for (String fieldName : fields) {
				Field field = c.getDeclaredField(fieldName);
				field.setAccessible(true);
				Object value = field.get(o);
				if (isintEmpty(field, value) || isFieldEmpty(value)) {
					nullCount++;
				}
			}
			if (nullCount == fields.length) {
				throw new ParamEmptyAtSameTimeException(fields);
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

	}

	/**
	 * 校验参数非空
	 * 1, 对象不为null<br/>
	 * 2, 如果为String, 则长度不能为0、不能全是空白、不能是null字串<br/>
	 * 3, 如果为数组和集合， 则长度不能为0
	 * 4, 如果为int， 不能为0
	 * @param o
	 * @return
	 */
	public static boolean isEmpty(Object o) {
		if (o == null) {
			return true;
		}
		try {
			Class<?> c = o.getClass();
			for (Field field : c.getDeclaredFields()) {
				if (Modifier.isStatic(field.getModifiers())) {
					continue;
				}
				field.setAccessible(true);
				Object value = field.get(o);
				if (!isFieldEmpty(value)) {
					return false;
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return true;
	}
	/**
	 * int不能为0
	 * @param field
	 * @param value
	 * @return
	 */
	public static boolean isintEmpty(Field field, Object value){
		if(field.getType() == int.class){
			return (int)value == 0;
		}
		return false;
		
	}
	/**
	 * 
	 * @return
	 */
	public static boolean isFieldEmpty(Object value) {
		if (value != null) {
			if (value instanceof String) {
				String str = (String) value;
				if (!(str.length() == 0 || str.trim().length() == 0 || "null".equals(str))) {
					return false;
				}
			} else if (value.getClass().isArray()) {
				if (Array.getLength(value) > 0) {
					return false;
				}
			} else if (value instanceof Collection) {
				Collection list = (Collection) value;
				if (list.size() > 0) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}
	/**
	 * 鏍￠獙鍒楄〃鍐呭瓧娈典笉涓虹┖
	 * @param list
	 * @param fields
	 */
	public static void checkListElementNotEmpty(List<?> list, String... fields) {
		if(list == null){
			return;
		}
		for(Object o : list){
			checkNotEmpty(o, fields);
		}
	}

}