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
	public void test() {
		//Object obj = AnnotationUtil.callMethod(new TestClass(), "getValue", new Object[]{new String("input")});
		Object obj = AnnotationUtil.callMethod(new TestClass(), "getValue", null);
		assertTrue(obj instanceof String && ((String)obj).equals("--returned"));
	}

}
