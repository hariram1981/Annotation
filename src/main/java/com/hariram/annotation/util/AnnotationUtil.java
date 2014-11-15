package com.hariram.annotation.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Utility class for annotation functionalities
 * 
 * @author hariram
 * date 14-Nov-2014
 */
public final class AnnotationUtil {
	/**
	 * Utility class and hence private constructor
	 */
	private AnnotationUtil() {
	}
	
	/**
	 * Invokes a method of a particular object using reflection
	 * 
	 * @param obj object whose method is to be invoked
	 * @param methodName method to be invoked
	 * @param methodArgs arguments of method to be invoked
	 * @return Object (can be null or any value returned by the method to be invoked)
	 */
	public static Object callMethod(Object obj, String methodName, Object[] methodArgs) {
		Object returnObj = null;
		try {
			Method method = obj.getClass().getMethod(methodName, null);
			returnObj = method.invoke(obj, methodArgs);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return returnObj;
	}
}
