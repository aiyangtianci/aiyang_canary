package com.example.aiyang.aiyang;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 *  自测量
 * Created by aiyang on 2017/4/14.
 */

public class SquareGridView extends GridView {
    public SquareGridView(Context context) {
        super(context);
    }

    public SquareGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec =  MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
