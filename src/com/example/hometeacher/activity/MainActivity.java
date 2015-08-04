package com.example.hometeacher.activity;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.hometeacher.R;
import com.example.hometeacher.adapter.MaingoodteacherAdapter;
import com.example.hometeacher.data.Data;
import com.example.hometeacher.util.CodeDecompress;
import com.example.hometeacher.util.HttpPost;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.support.v4.widget.DrawerLayout;

@SuppressLint("RtlHardcoded")
public class MainActivity extends Activity {

	// 用于抽屉的开启或关闭
	public static DrawerLayout mDrawerLayout;

	ArrayList<HashMap<String, Object>> list;
	MaingoodteacherAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		Data.SCREENHEIGHT = metric.heightPixels;
		Data.SCREENWIDTH = metric.widthPixels;

		initView();

	}

	void initView() {

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		RelativeLayout rl_head = (RelativeLayout) findViewById(R.id.rl_main_head);
		rl_head.setOnClickListener(onClickListener);

		RelativeLayout rl_msg = (RelativeLayout) findViewById(R.id.rl_main_msg);
		rl_msg.setOnClickListener(onClickListener);

		LinearLayout ll_bottom = (LinearLayout) findViewById(R.id.ll_main_bottom);
		ll_bottom.getLayoutParams().height = (int) (Data.SCREENWIDTH * 0.35);

		RelativeLayout rl_match = (RelativeLayout) findViewById(R.id.rl_main_match);
		rl_match.setOnClickListener(onClickListener);

		RelativeLayout rl_phone = (RelativeLayout) findViewById(R.id.rl_main_phone);
		rl_phone.setOnClickListener(onClickListener);

		ImageView iv_match = (ImageView) findViewById(R.id.iv_main_match);
		iv_match.getLayoutParams().width = (int) (Data.SCREENWIDTH * 0.27);
		iv_match.getLayoutParams().height = (int) (Data.SCREENWIDTH * 0.27);

		ImageView iv_phone = (ImageView) findViewById(R.id.iv_main_phone);
		iv_phone.getLayoutParams().width = (int) (Data.SCREENWIDTH * 0.27);
		iv_phone.getLayoutParams().height = (int) (Data.SCREENWIDTH * 0.27);

		initList();

	}

	void initList() {
		ListView lv = (ListView) findViewById(R.id.lv_main);
		lv.setDivider(null);

		list = new ArrayList<HashMap<String, Object>>();
		adapter = new MaingoodteacherAdapter(this, list);
		lv.setAdapter(adapter);

		list.add(new HashMap<String, Object>());
		list.add(new HashMap<String, Object>());
		list.add(new HashMap<String, Object>());
		list.add(new HashMap<String, Object>());
		list.add(new HashMap<String, Object>());

	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.rl_main_head:
				mDrawerLayout.openDrawer(Gravity.LEFT);
				break;
			case R.id.rl_main_msg:
				break;
			case R.id.rl_main_match:
				break;
			case R.id.rl_main_phone:
				break;
			}
		}
	};

	

}
