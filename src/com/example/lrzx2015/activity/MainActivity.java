package com.example.lrzx2015.activity;

import com.example.lrzx2015.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.support.v4.widget.DrawerLayout;

/**
 * 主界面
 * 
 * @author Tobb
 * @Time 2015-08-26
 * 
 */
@SuppressLint("RtlHardcoded")
public class MainActivity extends Activity {

	// 用于抽屉的开启或关闭
	public static DrawerLayout mDrawerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initView();

	}

	void initView() {

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		
		RelativeLayout rl_menu=(RelativeLayout)findViewById(R.id.rl_mainpage_menu);
		rl_menu.setOnClickListener(onClickListener);

	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent;
			switch (v.getId()) {
			case R.id.rl_mainpage_menu:
				mDrawerLayout.openDrawer(Gravity.LEFT);
				break;
			}
		}
	};

	

}
