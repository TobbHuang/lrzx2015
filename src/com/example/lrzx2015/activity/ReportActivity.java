package com.example.lrzx2015.activity;

import com.example.lrzx2015.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

/**
 * 报名
 * 
 * @author Tobb
 * @Time 2015-08-29
 * 
 */
public class ReportActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_report);

		initView();

	}

	private void initView() {
		// TODO Auto-generated method stub
		RelativeLayout rl_back = (RelativeLayout) findViewById(R.id.rl_report_back);
		rl_back.setOnClickListener(onClickListener);
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.rl_report_back:
				finish();
				break;
			}
		}
	};
}
