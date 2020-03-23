package com.example.aiyang.aiyang;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 本月日历
 *
 *  @author aiyang
 *
 */
public class MainActivity extends AppCompatActivity implements GridView.OnItemClickListener{
    private GridView registration_calendar_gv;
    private TextView today;
    private RegistrationAdapter adapter;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
    int mYear=0;//年
    int mMonth=0;//月
    int mDay=0;//日
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registration_calendar_gv=(GridView)findViewById(R.id.registration_calendar_gv);
        today=(TextView)findViewById(R.id.today);

        Calendar calendar=Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR); // 获取当前年份
        mMonth = calendar.get(Calendar.MONTH) ;// 获取当前月份以（0开头）
        mDay = calendar.get(Calendar.DAY_OF_MONTH) ;// 获取当前天以（0开头）

        SpecialCalendar mCalendar=new SpecialCalendar();
        boolean isLeapYear =mCalendar.isLeapYear(mYear);
        int mDays=mCalendar.getDaysOfMonth(isLeapYear,mMonth+1);
        int week =mCalendar.getWeekdayOfMonth(mYear,mMonth);

        adapter=new RegistrationAdapter(this,mDays,week,mDay);
        registration_calendar_gv.setAdapter(adapter);
        registration_calendar_gv.setOnItemClickListener(this);
        today.setText(mYear+"年"+mMonth+"月"+mDay+"日");
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String today=mYear+"-"+mMonth+"-"+l;
        if (l!=0){
            if (l==mDay){
                TextView today_tv= (TextView) view.findViewById(R.id.day);
                today_tv.setBackgroundResource(R.mipmap.member_ok);
                today_tv.setTextColor(Color.BLACK);
                today_tv.setText(l+"");
                view.setBackgroundColor(Color.parseColor("#ffffff"));
                Toast.makeText(view.getContext(),"签到成功",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(view.getContext(),"您选择的日期："+today,Toast.LENGTH_SHORT).show();

            }
        }
    }
}
