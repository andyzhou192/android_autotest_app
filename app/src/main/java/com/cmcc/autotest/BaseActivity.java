package com.cmcc.autotest;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.cmcc.autotest.model.ResultViewDO;
import com.cmcc.autotest.model.TestResultDO;
import com.cmcc.autotest.runner.StartTest;
import com.cmcc.autotest.utils.ClickListenerUtil;
import com.cmcc.autotest.view.MainView;
import com.cmcc.autotest.view.ReflushDisplayView;

public class BaseActivity extends Activity {

	private Class<?>[] testClasses = null;
	private String testPackage = null;
	private ResultViewDO rv;
	private TestResultDO tr;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this;
		@SuppressWarnings("deprecation")
		int screenWidth = this.getWindowManager().getDefaultDisplay().getWidth();
		MainView mv = new MainView(context, screenWidth);
		setContentView(mv.getBaseLayout());
		rv = new ResultViewDO(testClasses, this, testPackage, mv);
		rv.clearListViewAdapter();
		tr = new TestResultDO();
		StartTest.testResult = null;
		initOnClickListener();
		ReflushDisplayView.reflushResultDisplay(null, rv, tr);
	}

	public void setTestClass(Class<?>[] classes) {
		this.testClasses = classes;
	}

	public void setTestPackage(String testPackage) {
		this.testPackage = testPackage;
	}
	
	private void initOnClickListener() {
		ClickListenerUtil listener = ClickListenerUtil.getInstance(context, rv, tr);
		rv.getLaunchBtn().setOnClickListener(listener.getClickListener());
		rv.getRunTestCountView().setOnClickListener(listener.getClickListener());
		rv.getFailTestCountView().setOnClickListener(listener.getClickListener());
		rv.getErrTestCountView().setOnClickListener(listener.getClickListener());
	}

}
