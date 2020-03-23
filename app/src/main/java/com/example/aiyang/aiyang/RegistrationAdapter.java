package com.example.aiyang.aiyang;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 *  日历 适配器
 * Created by aiyang on 2017/4/14.
 */

public class RegistrationAdapter extends BaseAdapter {
    private Context context;
    private final int days;
    private final int week;
    private int[] dayNumber;
    private final int day;

    public RegistrationAdapter(Context context, int days, int week,int day) {
        this.context = context;
        this.days = days;
        this.week = week;
        this.day=day;
        getEveryDay();
    }



    @Override
    public int getCount() {
        return 42;
    }

    @Override
    public String getItem(int i) {

        return null;
    }

    @Override
    public long getItemId(int i) {
        return dayNumber[i];
    }//点击时

    private ViewHolder viewHolder;
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (null==view){
            view= LayoutInflater.from(context).inflate(R.layout.item_registrationadatper,null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.day.setText(dayNumber[i]==0? "" : dayNumber[i]+"");
        if (dayNumber[i]!=0&&dayNumber[i]<day&&dayNumber[i]%2==1){
            viewHolder.day.setBackgroundResource(R.mipmap.member_ok);
        }
        if (dayNumber[i]==day){
            viewHolder.day.setText("今");
            view.setBackgroundResource(R.color.colorPrimary);
            viewHolder.day.setTextColor(Color.parseColor("#ffffff"));
        }

        return view;
    }

    private class ViewHolder{
        private TextView day;

        public ViewHolder(View view) {
            this.day = (TextView) view.findViewById(R.id.day);
        }
    }

    /**
     * 得到42格子 每一格子的值
     */
    private void getEveryDay(){
        dayNumber=new int[42];

        for (int i=0;i<42;i++){
            if (i < days+week && i >= week){
                dayNumber[i]=i-week+1;
            }else{
                dayNumber[i]=0;
            }
        }
    }
}
