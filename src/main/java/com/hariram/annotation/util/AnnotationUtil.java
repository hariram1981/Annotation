package com.hariram.annotation.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.hariram.annotation.AnnotationException;
import com.hariram.annotation.AnnotationProcessor.AnnotationType;

/**
 * Utility class for annotation functionalities
 * 
 * @author hariram
 * date 14-Nov-2014
 */
public final class AnnotationUtil {
	
	private static Map<Class<? extends Object>, Class<? extends Object>> classMap = new HashMap<Class<? extends Object>, Class<? extends Object>>();
	static {
		classMap.put(ArrayList.class, List.class);
		classMap.put(HashSet.class, Set.class);
		classMap.put(TreeSet.class, Set.class);
		classMap.put(HashMap.class, Map.class);
		classMap.put(TreeMap.class, Map.class);
	}
	
	public static final Logger LOGGER = Logger.getLogger(AnnotationUtil.class);
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
		LOGGER.info("AnnotationUtil.callMethod, obj: " + obj +", methodName: " + methodName + ", methodArgs: " + methodArgs);
		Object returnObj = null;
		try {
			Method method = null;
			if(methodArgs == null) {
				method = obj.getClass().getMethod(methodName);
			} else {
				List<Class<? extends Object>> methodArgsClassList = getMethodArgsClassList(methodArgs, true);
				
				try {
					method = obj.getClass().getMethod(methodName, methodArgsClassList.toArray(new Class[0]));
				} catch(NoSuchMethodException e) {
					//Exception so now try without generic
					LOGGER.info("AnnotationUtil.callMethod, exception due to using generic and hence will use non-generic to get method to be invoked");
					methodArgsClassList = getMethodArgsClassList(methodArgs, false);
					method = obj.getClass().getMethod(methodName, methodArgsClassList.toArray(new Class[0]));
				}
			}
			returnObj = method.invoke(obj, methodArgs);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			LOGGER.error("AnnotationUtil.callMethod, exception: " + e.getClass() + " " + e.getMessage());
			throw new AnnotationException("AnnotationUtil.callMethod, message : " + e.getClass() + " " + e.getMessage(), AnnotationType.DBAnnotation);
		}
		LOGGER.info("AnnotationUtil.callMethod, returnObj: " + returnObj);
		return returnObj;
	}
	
	/**
	 * Return List of class of method args with option of using generic or not
	 * 
	 * @param methodArgs method arguments of the method to be invoked
	 * @param useGeneric if generic class type has to be used or not
	 * @return List list of class of the method arguments
	 */
	private static List<Class<? extends Object>> getMethodArgsClassList(Object[] methodArgs, boolean useGeneric) {
		List<Class<? extends Object>> methodArgsClassList = new ArrayList<Class<? extends Object>>();
		
		Arrays.asList(methodArgs)
			.stream()
			.forEach(e-> {
				if(useGeneric) {
					if(classMap.containsKey(e.getClass())){
						methodArgsClassList.add(classMap.get(e.getClass()));
					} else {
						methodArgsClassList.add(e.getClass());
					}
				} else {
					methodArgsClassList.add(e.getClass());
				}
			});
		return methodArgsClassList;
	}
}
