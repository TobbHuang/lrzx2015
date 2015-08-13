package com.example.hometeacher.activity;

import com.example.hometeacher.R;
import com.example.hometeacher.R.layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MatchActivity extends Activity {
	
	TextView tv_location,tv_sex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_match);
		
		IntentFilter filter = new IntentFilter("RefreshMatch");
		registerReceiver(broadcast, filter);
		
		initView();
		
	}

	private void initView() {
		// TODO Auto-generated method stub
		
		ImageView iv_back=(ImageView)findViewById(R.id.iv_match_leftarrow);
		iv_back.setOnClickListener(onClickListener);
		
		LinearLayout ll_location=(LinearLayout)findViewById(R.id.ll_match_location);
		ll_location.setOnClickListener(onClickListener);
		tv_location=(TextView)findViewById(R.id.tv_match_location);
		
		LinearLayout ll_sex=(LinearLayout)findViewById(R.id.ll_match_sex);
		ll_sex.setOnClickListener(onClickListener);
		tv_sex=(TextView)findViewById(R.id.tv_match_sex);
	}
	
	OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.iv_match_leftarrow:
				finish();
				break;
			case R.id.ll_match_location:
				Intent intent=new Intent(MatchActivity.this,LocationActivity.class);
				startActivity(intent);
				break;
			case R.id.ll_match_sex:
				final String[] str={"男","女","男女不限"};
				Dialog dialog = new AlertDialog.Builder(
						MatchActivity.this).setItems(str,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								tv_sex.setText(str[which]);
							}
						}).create();
				dialog.show();
				break;
			}
		}
	};
	
	BroadcastReceiver broadcast=new BroadcastReceiver(){

		@Override
		public void onReceive(Context arg0, Intent date) {
			// TODO Auto-generated method stub
			switch(date.getIntExtra("type",0)){
			case 0:
				tv_location.setText(date.getStringExtra("data"));
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			}
		}
		
	};
	
}
