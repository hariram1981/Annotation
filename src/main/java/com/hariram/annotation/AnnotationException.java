package com.hariram.annotation;

import com.hariram.annotation.AnnotationProcessor.AnnotationType;

/**
 * Exception to be used with annotations.
 * 
 * @author hariram
 * date 24-Nov-2014
 */
public class AnnotationException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private String message = null;
	private AnnotationType annotationType = null;

	/**
	 * Default constructor
	 */
	public AnnotationException() {
		this.message = "";
		this.annotationType = AnnotationType.DBAnnotation;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param message exception message
	 * @param annotationType type of annotation
	 */
	public AnnotationException(String message, AnnotationType annotationType) {
		this.message = message;
		this.annotationType = annotationType;
	}
	
	/**
	 * Return exception message
	 * 
	 * @return String exception message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets exception message
	 * 
	 * @param message exception message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Return the annotation type
	 * 
	 * @return String annotation type
	 */
	public AnnotationType getAnnotationType() {
		return annotationType;
	}

	/**
	 * Sets the annotation type
	 * 
	 * @param annotationType annotation type
	 */
	public void setAnnotationType(AnnotationType annotationType) {
		this.annotationType = annotationType;
	}
}
