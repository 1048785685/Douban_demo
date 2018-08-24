package com.soully.doudemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Soully on 2017/4/8.
 */


public class Draw extends View {

    private Paint mPaint;
    public Draw (Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.YELLOW);
        canvas.drawCircle(getWidth()/2,getWidth()/2,getWidth()/2,mPaint);
    }
}