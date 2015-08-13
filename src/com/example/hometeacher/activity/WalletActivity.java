package com.example.hometeacher.activity;

import com.example.hometeacher.R;
import com.example.hometeacher.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

public class WalletActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_wallet);
		
		initView();
		
	}
	
	private void initView() {
		// TODO Auto-generated method stub
		ImageView iv_back=(ImageView)findViewById(R.id.iv_wallet_leftarrow);
		iv_back.setOnClickListener(onClickListener);
	}

	OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.iv_wallet_leftarrow:
				finish();
				break;
			}
		}
	};
	
}
