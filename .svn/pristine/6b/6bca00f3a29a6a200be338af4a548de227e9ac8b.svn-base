package com.example.hometeacher.activity;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.hometeacher.R;
import com.example.hometeacher.adapter.MessageAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MessageActivity extends Activity {
	
	ArrayList<HashMap<String,Object>> list;
	MessageAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_message);
		
		initView();
		
	}

	private void initView() {
		// TODO Auto-generated method stub
		
		ImageView iv_back=(ImageView)findViewById(R.id.iv_message_leftarrow);
		iv_back.setOnClickListener(onClickListener);
		
		initList();
	}

	private void initList() {
		// TODO Auto-generated method stub
		list=new ArrayList<HashMap<String,Object>>();
		adapter=new MessageAdapter(this, list);
		list.add(new HashMap<String, Object>());
		list.add(new HashMap<String, Object>());
		list.add(new HashMap<String, Object>());
		list.add(new HashMap<String, Object>());
		list.add(new HashMap<String, Object>());
		
		ListView lv=(ListView)findViewById(R.id.lv_message);
		lv.setDivider(null);
		lv.setAdapter(adapter);
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.iv_message_leftarrow:
				finish();
				break;
			}
		}
	};
	
}
