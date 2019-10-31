package com.cmcc.autotest.testscript;

import com.cmcc.autotest.annotation.Parameters;
import com.cmcc.autotest.annotation.TargetSheet;
import com.cmcc.autotest.annotation.ApiTest;

import android.test.AndroidTestCase;

@ApiTest//(paramFile="test.xls")
public class TestClass extends AndroidTestCase {

	@TargetSheet(sheetIndex=0)
	public void test_01(String arg1){
		assertTrue(false);
	}

	@TargetSheet(sheetIndex=0)
	public void test_02(){
		assertEquals("", null);
	}

	@TargetSheet(sheetIndex=0)
	public void test_03(){
		assertTrue(true);
	}

	public void test_04(){
		String str = getString();
		boolean isContain = str.contains("111");
		assertTrue(isContain);
	}

	@Parameters(value="abc")
	public void test_05(String str){
		assertEquals("abc", str);
	}

	private String getString() {
		// TODO Auto-generated method stub
		return null;
	}
}
