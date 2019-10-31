package com.cmcc.autotest.utils;

import android.app.Activity;
import android.util.Log;

import com.cmcc.autotest.handler.ObtainClassHandler;
import com.cmcc.autotest.model.ResultViewDO;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;

public class AllTestUtil {
	private final static String TAG = String.valueOf(AllTestUtil.class);
	
	@SuppressWarnings("unchecked")
	public static Test suite(ResultViewDO rv){
        TestSuite s = new TestSuite();
        if(null == rv.getTestClass() || rv.getTestClass().length < 1){
        	rv.setTestClass(getTestClass(rv.getMainActivity(), rv.getTestPackage()));
		}
        for(Class<?> cl:rv.getTestClass()){
        	//Log.d(TAG, cl.getName());
        	s.addTestSuite((Class<? extends TestCase>) cl);
        }
        
        return s;
    }
	
	private static Class<?>[] getTestClass(Activity activity, String testPackage) {
		Log.w(TAG, "测试类数组为空");
		List<Class<?>> list = ObtainClassHandler.scan(activity, testPackage);
		Class<?>[] testClasses = new Class<?>[list.size()];
		for(int i=0; i<list.size(); i++){
			testClasses[i] = list.get(i);
		}
		return testClasses;
	}

}
