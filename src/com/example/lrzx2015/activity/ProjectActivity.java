package com.example.lrzx2015.activity;

import com.example.lrzx2015.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;

/**
 * 项目与竞赛
 * 
 * @author Tobb
 * @Time 2015-08-29
 * 
 */
public class ProjectActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_project);
		
		initView();
		
	}
	
	private void initView() {
		// TODO Auto-generated method stub
		RelativeLayout rl_back=(RelativeLayout)findViewById(R.id.rl_project_back);
		rl_back.setOnClickListener(onClickListener);
	}

	OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.rl_project_back:
				finish();
				break;
			}
		}
	};
	
}
