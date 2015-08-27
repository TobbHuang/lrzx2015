package com.example.lrzx2015.fragment;

import com.example.lrzx2015.R;
import com.example.lrzx2015.activity.IntroductionActivity;
import com.example.lrzx2015.activity.MainActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * 侧拉fragment
 * 
 * @author Tobb
 * @Time 2015-08-26
 * 
 */
public class NavigationDrawerFragment extends Fragment {

	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.fragment_navigation_drawer, container,
				false);

		LinearLayout ll_0 = (LinearLayout) view
				.findViewById(R.id.ll_leftmenu_0);
		ll_0.setOnClickListener(onClickListener);

		LinearLayout ll_1 = (LinearLayout) view
				.findViewById(R.id.ll_leftmenu_1);
		ll_1.setOnClickListener(onClickListener);

		LinearLayout ll_2 = (LinearLayout) view
				.findViewById(R.id.ll_leftmenu_2);
		ll_2.setOnClickListener(onClickListener);

		LinearLayout ll_3 = (LinearLayout) view
				.findViewById(R.id.ll_leftmenu_3);
		ll_3.setOnClickListener(onClickListener);

		LinearLayout ll_4 = (LinearLayout) view
				.findViewById(R.id.ll_leftmenu_4);
		ll_4.setOnClickListener(onClickListener);

		LinearLayout ll_5 = (LinearLayout) view
				.findViewById(R.id.ll_leftmenu_5);
		ll_5.setOnClickListener(onClickListener);

		LinearLayout ll_6 = (LinearLayout) view
				.findViewById(R.id.ll_leftmenu_6);
		ll_6.setOnClickListener(onClickListener);

		LinearLayout ll_7 = (LinearLayout) view
				.findViewById(R.id.ll_leftmenu_7);
		ll_7.setOnClickListener(onClickListener);

		return view;
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent;
			switch (v.getId()) {
			case R.id.ll_leftmenu_0:
				closeDrawer();
				break;
			case R.id.ll_leftmenu_1:
				intent=new Intent(getActivity(),IntroductionActivity.class);
				startActivity(intent);
				closeDrawer();
				break;
			case R.id.ll_leftmenu_2:
				closeDrawer();
				break;
			case R.id.ll_leftmenu_3:
				closeDrawer();
				break;
			case R.id.ll_leftmenu_4:
				closeDrawer();
				break;
			case R.id.ll_leftmenu_5:
				closeDrawer();
				break;
			case R.id.ll_leftmenu_6:
				closeDrawer();
				break;
			case R.id.ll_leftmenu_7:
				closeDrawer();
				break;
			}
		}
	};

	public void openDrawer() {
		if (MainActivity.mDrawerLayout != null) {
			MainActivity.mDrawerLayout.openDrawer(Gravity.LEFT);
		}
	}

	public void closeDrawer() {
		if (MainActivity.mDrawerLayout != null) {
			MainActivity.mDrawerLayout.closeDrawer(Gravity.LEFT);
		}
	}
}
