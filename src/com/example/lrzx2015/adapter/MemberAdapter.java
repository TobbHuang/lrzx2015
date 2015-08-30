package com.example.lrzx2015.adapter;

import java.util.ArrayList;

import com.example.lrzx2015.R;
import com.example.lrzx2015.activity.Member2Activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MemberAdapter extends BaseAdapter {

	Context context;
	ArrayList<String> list;

	public MemberAdapter(Context context, ArrayList<String> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.list_item_member, null);
		}
		
		TextView tv=(TextView)convertView.findViewById(R.id.tv_item_member);
		tv.setText(list.get(position));
		
		convertView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(context,Member2Activity.class);
				intent.putExtra("index", position);
				context.startActivity(intent);
			}
		});
		
		return convertView;
	}

}
