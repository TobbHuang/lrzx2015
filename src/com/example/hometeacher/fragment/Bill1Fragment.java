package com.example.hometeacher.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.hometeacher.R;
import com.example.hometeacher.adapter.BillAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Bill1Fragment extends Fragment {
	
	ArrayList<HashMap<String,Object>> list;
	BillAdapter adapter;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fragment_bill, container, false);
		
		list=new ArrayList<HashMap<String,Object>>();
		adapter=new BillAdapter(getActivity(), list);
		list.add(new HashMap<String, Object>());
		list.add(new HashMap<String, Object>());
		list.add(new HashMap<String, Object>());
		list.add(new HashMap<String, Object>());
		list.add(new HashMap<String, Object>());
		
		ListView lv=(ListView)v.findViewById(R.id.lv_billfragment);
		lv.setDivider(null);
		lv.setAdapter(adapter);
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
			}
		});
		
		return v;
	}

}
