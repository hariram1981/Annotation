/**
 * 
 */
package com.hariram.annotation.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author hariram
 *
 */
public class AnnotationUtilTest {

	@Test
	public void testNoParam() {
		Object obj = AnnotationUtil.callMethod(new TestClass(), "getValueNoParam", null);
		assertTrue(obj instanceof Integer && ((Integer)obj == 1));
	}

	@Test
	public void testOneParam() {
		Object obj = AnnotationUtil.callMethod(new TestClass(), "getValueOneParam", new Object[]{new String("input")});
		assertTrue(obj instanceof String && ((String)obj).contains("--returned"));
	}


	@Test
	public void testMultiParam() {
		Object obj = AnnotationUtil.callMethod(new TestClass(), "getValueMultiParam", new Object[]{new String("input"), new Integer(1)});
		assertTrue(obj instanceof String && ((String)obj).contains("--returned"));
	}
}
