package com.example.hometeacher.activity;

import java.util.List;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.baidu.location.Poi;
import com.example.hometeacher.R;
import com.example.hometeacher.R.layout;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class LocationActivity extends Activity {

	ProgressDialog pd;

	public LocationClient mLocationClient = null;
	public BDLocationListener myListener = new MyLocationListener();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_location);

		pd = new ProgressDialog(this);
		pd.setMessage("正在定位，请稍后");
		pd.setCancelable(true);

		initLocation();
		initView();

	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.rl_location_location:
				pd.show();
				mLocationClient.start();
				break;
			}
		}
	};

	private void initView() {
		RelativeLayout rl_location = (RelativeLayout) findViewById(R.id.rl_location_location);
		rl_location.setOnClickListener(onClickListener);
	}

	private void initLocation() {
		// TODO Auto-generated method stub
		mLocationClient = new LocationClient(getApplicationContext()); // 声明LocationClient类
		mLocationClient.registerLocationListener(myListener); // 注册监听函数

		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationMode.Hight_Accuracy);// 可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
		option.setCoorType("bd09ll");// 可选，默认gcj02，设置返回的定位结果坐标系
		int span = 0;
		option.setScanSpan(span);// 可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
		option.setIsNeedAddress(true);// 可选，设置是否需要地址信息，默认不需要
		option.setOpenGps(true);// 可选，默认false,设置是否使用gps
		// option.setLocationNotify(true);//
		// 可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
		option.setIsNeedLocationDescribe(true);// 可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
		option.setIsNeedLocationPoiList(true);// 可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
		option.setIgnoreKillProcess(false);// 可选，默认false，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认杀死
		option.SetIgnoreCacheException(false);// 可选，默认false，设置是否收集CRASH信息，默认收集
		option.setEnableSimulateGps(false);// 可选，默认false，设置是否需要过滤gps仿真结果，默认需要
		mLocationClient.setLocOption(option);

	}

	public class MyLocationListener implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation location) {
			// Receive Location
			pd.dismiss();
			StringBuffer sb = new StringBuffer(256);
			if (location.getLocType() == BDLocation.TypeGpsLocation
					|| location.getLocType() == BDLocation.TypeNetWorkLocation) {// GPS定位结果||网络定位结果
				sb.append(location.getCity());
				sb.append(location.getDistrict());
				sb.append(location.getStreet());
				sb.append(" " + location.getLocationDescribe());// 位置语义化信息

				Intent intent = new Intent("RefreshMatch");
				intent.putExtra("type", 0);
				intent.putExtra("data", sb.toString());
				sendBroadcast(intent);
				finish();
			} else {// 定位失败
				Toast.makeText(LocationActivity.this, "定位失败",
						Toast.LENGTH_SHORT).show();
			}
			System.out.println(sb.toString());
		}
	}
}
