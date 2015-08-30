package com.example.lrzx2015.activity;

import java.util.ArrayList;

import com.example.lrzx2015.R;
import com.example.lrzx2015.R.layout;
import com.example.lrzx2015.adapter.MemberAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class Member1Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_member1);

		initView();

	}

	void initView() {
		
		RelativeLayout rl_back=(RelativeLayout)findViewById(R.id.rl_member1_back);
		rl_back.setOnClickListener(onClickListener);
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("杨文元");
		list.add("暴鹏飞");
		list.add("胡可奇");
		list.add("张明");
		list.add("王鹏飞");
		list.add("邓浩梁");
		list.add("张鑫");
		list.add("张浩");
		list.add("徐华");
		list.add("王彬陶");
		list.add("张路");
		list.add("李昊星");
		list.add("彭一城");
		list.add("何雨薇");
		list.add("梁海鹏");
		list.add("李赵宁");
		list.add("刘钊祎");
		list.add("胡淼");
		list.add("王宇");
		list.add("曹灿");
		list.add("黄亚菲");
		list.add("陶文元");
		list.add("钱璨");
		list.add("任远航");
		list.add("黄涛");
		list.add("苏恒");
		list.add("贾子辉");
		list.add("肖彰瑾");
		list.add("杨洋");
		list.add("邱童");
		list.add("赵菁");
		list.add("魏来");
		list.add("邱士林");
		list.add("汪聘");
		list.add("朱晴晴");

		ListView lv = (ListView) findViewById(R.id.lv_member1_list);
		MemberAdapter adapter = new MemberAdapter(this, list);
		lv.setAdapter(adapter);
		lv.setDivider(null);

	}
	
	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.rl_member1_back:
				finish();
				break;
			}
		}
	};

}
