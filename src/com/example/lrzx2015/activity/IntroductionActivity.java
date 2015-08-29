package com.example.lrzx2015.activity;

import com.example.lrzx2015.R;
import com.example.lrzx2015.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;

/**
 * 工作室介绍界面
 * 
 * @author Tobb
 * @Time 2015-08-27
 * 
 */
public class IntroductionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_introduction);
		
		initView();
		
	}

	private void initView() {
		// TODO Auto-generated method stub
		RelativeLayout rl_back=(RelativeLayout)findViewById(R.id.rl_introduction_back);
		rl_back.setOnClickListener(onClickListener);
	}
	
	OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.rl_introduction_back:
				finish();
				break;
			}
		}
	};
	
}
