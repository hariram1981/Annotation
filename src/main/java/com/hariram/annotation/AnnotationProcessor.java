package com.hariram.annotation;

/**
 * Interface that will be implemented by various annotation processors
 * 
 * @author hariram
 * date 14-Nov-2014
 */
public interface AnnotationProcessor {
	/**
	 * Processes the annotations for the particular object passed
	 * and invokes the call back method
	 * 
	 * @param obj object that is annotated
	 * @param callbackMethodName call back method name
	 * @param callbackMethodArgs call back method argument
	 * @return Object (can be null or any value returned by call back method)
	 */
	public Object process(Object obj, String callbackMethodName, Object[] callbackMethodArgs);
}
