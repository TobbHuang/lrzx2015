package com.example.hometeacher.activity;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.hometeacher.R;
import com.example.hometeacher.adapter.PhonesearchHistoryAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class PhoneSearchActivity extends Activity {

	ArrayList<HashMap<String, Object>> list;
	PhonesearchHistoryAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_phone_search);

		initView();

	}

	private void initView() {
		// TODO Auto-generated method stub
		
		ImageView iv_back=(ImageView)findViewById(R.id.iv_phonesearch_leftarrow);
		iv_back.setOnClickListener(onClickListener);
		
		initList();
	}

	private void initList() {
		// TODO Auto-generated method stub
		list = new ArrayList<HashMap<String, Object>>();
		adapter = new PhonesearchHistoryAdapter(this, list);
		for (int i = 0; i < 20; i++) {
			list.add(new HashMap<String, Object>());
			list.add(new HashMap<String, Object>());
			list.add(new HashMap<String, Object>());
			list.add(new HashMap<String, Object>());
			list.add(new HashMap<String, Object>());
		}

		ListView lv = (ListView) findViewById(R.id.lv_phonesearch);
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

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.iv_phonesearch_leftarrow:
				finish();
				break;
			}
		}
	};

}
