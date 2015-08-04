package com.example.hometeacher.fragment;

import com.example.hometeacher.R;
import com.example.hometeacher.activity.LoginActivity;
import com.example.hometeacher.activity.MainActivity;

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

public class NavigationDrawerFragment extends Fragment {

	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.fragment_navigation_drawer, container,
				false);

		LinearLayout ll_login = (LinearLayout) view
				.findViewById(R.id.ll_leftmenu_login);
		ll_login.setOnClickListener(onClickListener);

		LinearLayout ll_wallet = (LinearLayout) view
				.findViewById(R.id.ll_leftmenu_wallet);
		ll_wallet.setOnClickListener(onClickListener);

		LinearLayout ll_bill = (LinearLayout) view
				.findViewById(R.id.ll_leftmenu_bill);
		ll_bill.setOnClickListener(onClickListener);

		LinearLayout ll_timetable = (LinearLayout) view
				.findViewById(R.id.ll_leftmenu_timetable);
		ll_timetable.setOnClickListener(onClickListener);

		LinearLayout ll_account = (LinearLayout) view
				.findViewById(R.id.ll_leftmenu_account);
		ll_account.setOnClickListener(onClickListener);

		LinearLayout ll_aboutus = (LinearLayout) view
				.findViewById(R.id.ll_leftmenu_aboutus);
		ll_aboutus.setOnClickListener(onClickListener);

		return view;
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent;
			switch (v.getId()) {
			case R.id.ll_leftmenu_login:
				intent=new Intent(getActivity(),LoginActivity.class);
				startActivity(intent);
				closeDrawer();
				break;
			case R.id.ll_leftmenu_wallet:
				Toast.makeText(getActivity(), "wallet", Toast.LENGTH_SHORT)
						.show();
				closeDrawer();
				break;
			case R.id.ll_leftmenu_bill:
				Toast.makeText(getActivity(), "bill", Toast.LENGTH_SHORT)
						.show();
				closeDrawer();
				break;
			case R.id.ll_leftmenu_timetable:
				Toast.makeText(getActivity(), "timetable", Toast.LENGTH_SHORT)
						.show();
				closeDrawer();
				break;
			case R.id.ll_leftmenu_account:
				Toast.makeText(getActivity(), "account", Toast.LENGTH_SHORT)
						.show();
				closeDrawer();
				break;
			case R.id.ll_leftmenu_aboutus:
				Toast.makeText(getActivity(), "aboutus", Toast.LENGTH_SHORT)
						.show();
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
