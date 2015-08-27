package com.example.hometeacher.activity;

import java.util.ArrayList;

import com.example.hometeacher.R;
import com.example.hometeacher.R.layout;
import com.example.hometeacher.adapter.BillFragmentAdapter;
import com.example.hometeacher.data.Data;
import com.example.hometeacher.fragment.Bill1Fragment;
import com.example.hometeacher.fragment.Bill2Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BillActivity extends FragmentActivity {

	private ViewPager mPager;
	private ArrayList<Fragment> fragmentList;

	TextView tv_cursor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_bill);

		initView();

	}

	private void initView() {
		// TODO Auto-generated method stub

		ImageView iv_back = (ImageView) findViewById(R.id.iv_bill_leftarrow);
		iv_back.setOnClickListener(onClickListener);

		tv_cursor = (TextView) findViewById(R.id.tv_bill_cursor);

		TextView tv_btn1 = (TextView) findViewById(R.id.tv_bill_btn1);
		tv_btn1.setOnClickListener(onClickListener);

		TextView tv_btn2 = (TextView) findViewById(R.id.tv_bill_btn2);
		tv_btn2.setOnClickListener(onClickListener);

		initCursor();
		initViewpager();
	}

	private void initCursor() {
		// TODO Auto-generated method stub
		tv_cursor.getLayoutParams().width = (int) (Data.SCREENWIDTH * 0.5);
	}

	private void initViewpager() {
		// TODO Auto-generated method stub
		mPager = (ViewPager) findViewById(R.id.vp_bill_list);
		fragmentList = new ArrayList<Fragment>();
		fragmentList.add(new Bill1Fragment());
		fragmentList.add(new Bill2Fragment());
		mPager.setAdapter(new BillFragmentAdapter(getSupportFragmentManager(),
				fragmentList));
		mPager.setCurrentItem(0);// 设置当前显示标签页为第一页
		mPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}

	public class MyOnPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int position) {
			// TODO Auto-generated method stub
			Animation animation = null;

			if (position == 0) {
				animation = new TranslateAnimation(
						(int) (Data.SCREENWIDTH * 0.5), 0, 0, 0);
			} else {
				animation = new TranslateAnimation(0,
						(int) (Data.SCREENWIDTH * 0.5), 0, 0);
			}

			animation.setFillAfter(true);// True:图片停在动画结束位置
			animation.setDuration(300);
			tv_cursor.startAnimation(animation);
		}
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.iv_bill_leftarrow:
				finish();
				break;
			case R.id.tv_bill_btn1:
				if (mPager.getCurrentItem() == 1) {
					mPager.setCurrentItem(0);
				}
				break;
			case R.id.tv_bill_btn2:
				if (mPager.getCurrentItem() == 0) {
					mPager.setCurrentItem(1);
				}
				break;
			}
		}
	};

}
