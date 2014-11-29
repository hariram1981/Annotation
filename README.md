Annotation
==========
Base annotation project

- Used as base project for other annotations to be defined.

Interfaces
----------
###1. com.hariram.annotation.AnnotationProcessor 
 - this is the interface that will be implemented by other processors. It has one method process which is called for processing the annotation. The signature of the process method is as below:
  
Object process(Object obj, String callbackMethodName, Object[] callbackMethodArgs)
 - processes the annotation in the particular object and after processing, calls the callbackmethod with the provided arguments (useful in order to not just process the annotation but call a method of the object after processing).
 
Classes
----------
###1. com.hariram.annotation.util.AnnotationUtil
 - Utility class for annotation functionalities.

####static Object callMethod(Object obj, String methodName, Object[] methodArgs)
 - Invokes the method of the particular object with provided arguments using reflection.
 
###2. com.hariram.annotation.AnnotationException
 - Exception that extends RuntimeException and handles exceptions related to annotations
 
Usage
----------
- Usage can be checked in the JUnit test case that has been written for it but below is a sample:

		Object obj = AnnotationUtil.callMethod(new TestClass(), "getValueOneParam", new Object[]{new String("input")});

- In above, callMethod is called passing an object of TestClass and in order to trigger the getValueOneParam method that has one input parameter as String (first parameter is the object of the class, second is the name of the method and third is an array of objects that are the parameters for the method).

License
==========
Copyright (c) 2014 GitHub, Inc. See the LICENSE file for license rights and limitations (GNU GPL v2.0)