package com.cmcc.autotest.view;

import junit.framework.Test;

import com.cmcc.autotest.model.ResultViewDO;
import com.cmcc.autotest.model.TestResultDO;

public class TestResultDisplayView implements Runnable {
	@SuppressWarnings("unused")
	private static final String TAG = String.valueOf(TestResultDisplayView.class);

	private ResultViewDO rv;
	private TestResultDO tr;
	private Test test;
	private boolean isUpdateTitle, isUpdateList;

	public TestResultDisplayView(Test test, ResultViewDO rv, TestResultDO tr) {
		this.rv = rv;
		this.tr = tr;
		this.test = test;
		this.isUpdateTitle = true;
		this.isUpdateList = true;
	}
	
	public TestResultDisplayView(ResultViewDO rv, TestResultDO tr, boolean isUpdateTitle, boolean isUpdateList) {
		this.rv = rv;
		this.tr = tr;
		this.test = null;
		this.isUpdateTitle = isUpdateTitle;
		this.isUpdateList = isUpdateList;
	}

	@Override
	public void run() {
		if(null == tr){
			return;
		}
		if(isUpdateTitle){
			//��ȡ�ɹ�case����
			int succTestCount = tr.getTestCounter() - tr.getFailureCounter() - tr.getErrorCounter();
			// ���ý���title����
			rv.getRunTestCountView().setText("RunTest��" + succTestCount + "/" + tr.getTestCounter());
			rv.getFailTestCountView().setText("Failure��" + tr.getFailureCounter());
			rv.getErrTestCountView().setText("Error��" + tr.getErrorCounter());
		}

		if(isUpdateList){
			if(null != test){
				// �ڽ����listView�д�ӡ�����Դ���������Ϣ
				rv.getListViewAdapter().add(test.toString());
			}
			rv.getListView().setAdapter(rv.getListViewAdapter());
		}

		int height = rv.getRunTestCountView().getHeight();
		if(height > 0){
			rv.getFailTestCountView().setHeight(height);
			rv.getErrTestCountView().setHeight(height);
		}
	}
}
