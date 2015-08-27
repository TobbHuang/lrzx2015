package com.example.hometeacher.activity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.example.hometeacher.R;
import com.example.hometeacher.view.CalendarView;
import com.example.hometeacher.view.CalendarView.OnItemClickListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TimetableActivity extends Activity {
	

	
	TextView tv_month;
	TextView tv_date;
	CalendarView calendar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_timetable);

		initView();

	}

	@SuppressLint("SimpleDateFormat")
	private void initView() {
		// TODO Auto-generated method stub
		
		ImageView iv_back=(ImageView)findViewById(R.id.iv_timetable_leftarrow);
		iv_back.setOnClickListener(onClickListener);
		
		RelativeLayout rl_leftarrow=(RelativeLayout)findViewById(R.id.rl_timetable_leftarrow);
		rl_leftarrow.setOnClickListener(onClickListener);
		
		RelativeLayout rl_rightarrow=(RelativeLayout)findViewById(R.id.rl_timetable_rightarrow);
		rl_rightarrow.setOnClickListener(onClickListener);
		
		calendar = (CalendarView) findViewById(R.id.calendar_timetable);
		calendar.setOnItemClickListener(new calendarItemClickListener());
		
		tv_month=(TextView)findViewById(R.id.tv_timetable_month);
		tv_date=(TextView)findViewById(R.id.tv_timetable_date);

		String[] month = calendar.getYearAndmonth().split("-");
		tv_month.setText(month[0]+"年"+month[1]+"月");
		
		// 初始化为当前日期
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("MM月dd日，");
		tv_date.setText(df.format(date)+getWeekOfDate(date));
	}

	class calendarItemClickListener implements OnItemClickListener {
		@SuppressLint("SimpleDateFormat")
		@Override
		public void OnItemClick(Date date) {
			SimpleDateFormat df=new SimpleDateFormat("MM月dd日，");
			tv_date.setText(df.format(date)+getWeekOfDate(date));
		}
	}
	
	OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.iv_timetable_leftarrow:
				finish();
				break;
			case R.id.rl_timetable_leftarrow:
				calendar.clickLeftMonth();
				String[] month = calendar.getYearAndmonth().split("-");
				tv_month.setText(month[0]+"年"+month[1]+"月");
				break;
			case R.id.rl_timetable_rightarrow:
				calendar.clickRightMonth();
				String[] month1 = calendar.getYearAndmonth().split("-");
				tv_month.setText(month1[0]+"年"+month1[1]+"月");
				break;
			}
		}
	};
	
	public static String getWeekOfDate(Date dt) {
		String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

}
