package com.example.lrzx2015.activity;

import com.example.lrzx2015.R;
import com.example.lrzx2015.R.layout;
import com.example.lrzx2015.data.Data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

/**
 * 欢迎界面
 * 
 * @author Tobb
 * @Time 2015-08-26
 * 
 */
public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_welcome);
		
		initData();
		
		new Thread(r).start();
		
	}

	// 初始化数据
	private void initData() {
		// TODO Auto-generated method stub
		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		Data.SCREENHEIGHT = metric.heightPixels;
		Data.SCREENWIDTH = metric.widthPixels;
	}
	
	Runnable r=new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
			finish();
			
		}
	};
	
}
