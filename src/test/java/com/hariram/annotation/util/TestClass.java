package com.hariram.annotation.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class
 * 
 * @author hariram
 *
 */
public class TestClass {
	/**
	 * Get value with appended string
	 * 
	 * @return String return with appended string
	 */
	public String getValueOneParam(String value) {
		return value + "--returned";
	}

	/**
	 * Get value without parameters
	 * 
	 * @return int value
	 */
	public int getValueNoParam() {
		return 1;
	}

	/**
	 * Get value with appended string and integer
	 * 
	 * @param value string value
	 * @param n integer value
	 * @return String return with appended string and integer
	 */
	public String getValueMultiParam(String value, Integer n) {
		return value + "--returned--" + n;
	}
	
	/**
	 * Get value with arraylist
	 * 
	 * @param list list of string
	 * @return String return with appended list
	 *//*
	public String getValueList(ArrayList<String> arraylist) {
		return "--returned--arraylist--" + arraylist.toString();
	}*/
	
	/**
	 * Get value with list
	 * 
	 * @param list list of string
	 * @return String return with appended list
	 */
	public String getValueList(ArrayList<String> list) {
		return "--returned--list--" + list.toString();
	}

}	
