package com.example.hometeacher.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.hometeacher.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MessageAdapter extends BaseAdapter {

	Context mContext;
	ArrayList<HashMap<String, Object>> list;

	public MessageAdapter(Context mContext, ArrayList<HashMap<String, Object>> list) {
		this.mContext = mContext;
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
	public View getView(int position, View v, ViewGroup arg2) {
		// TODO Auto-generated method stub
		try {
			if (v == null) {
				v = LayoutInflater.from(mContext).inflate(R.layout.item_message,
						null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

}
