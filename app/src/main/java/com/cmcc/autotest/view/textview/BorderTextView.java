package com.cmcc.autotest.view.textview;

import android.widget.TextView;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

public class BorderTextView extends TextView {

	@SuppressLint("DrawAllocation") 
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Paint paint = new Paint();
		// ���߿���Ϊ��ɫ
		paint.setColor(android.graphics.Color.BLACK);
		// ��TextView��4����
		canvas.drawLine(0, 0, this.getWidth() - 1, 0, paint); //�±߿�
		canvas.drawLine(0, 0, 0, this.getHeight() - 1, paint); //��߿�
		canvas.drawLine(this.getWidth() - 1, 0, this.getWidth() - 1,
				this.getHeight() - 1, paint); //�ұ߿�
		canvas.drawLine(0, this.getHeight() - 1, this.getWidth() - 1,
				this.getHeight() - 1, paint); //�ϱ߿�
	}

	public BorderTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
}
