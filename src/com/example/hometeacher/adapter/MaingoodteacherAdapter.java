package com.example.hometeacher.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.hometeacher.R;
import com.example.hometeacher.view.RoundImageView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MaingoodteacherAdapter extends BaseAdapter {

	ArrayList<HashMap<String, Object>> list;
	Context mContext;

	public MaingoodteacherAdapter(Context context, ArrayList<HashMap<String, Object>> list) {
		this.mContext = context;
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
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		
		MaingoodteacherHolder holder;

		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.item_main_goodteacher, null);
			
			holder=new MaingoodteacherHolder();
			holder.iv_head=(ImageView)convertView.findViewById(R.id.iv_item_maingoodteacher_head);
			holder.tv_nickname=(TextView)convertView.findViewById(R.id.tv_item_maingoodteacher_nickname);
			holder.tv_school=(TextView)convertView.findViewById(R.id.tv_item_maingoodteacher_school);
			holder.tv_intro=(TextView)convertView.findViewById(R.id.tv_item_maingoodteacher_intro);
			
			convertView.setTag(holder);
		} else{
			holder=(MaingoodteacherHolder)convertView.getTag();
		}
		
		// 初始化列表item数据
		// ...

		return convertView;
	}
	
	static class MaingoodteacherHolder{
		ImageView iv_head;
		TextView tv_nickname;
		TextView tv_school;
		TextView tv_intro;
	}

}
