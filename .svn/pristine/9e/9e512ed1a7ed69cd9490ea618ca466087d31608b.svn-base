package com.example.hometeacher.activity;

import org.json.JSONObject;

import com.example.hometeacher.R;
import com.example.hometeacher.data.Data;
import com.example.hometeacher.util.Encrypt;
import com.example.hometeacher.util.HttpPost;
import com.example.hometeacher.util.ParseXML;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {

	ProgressDialog progressDialog;

	ImageView iv_leftarrow;
	Button btn_register;
	Button btn_sendkey;

	EditText et_phone, et_password, et_key;

	int i = 60;// 用于计时

	TimeHandler timeHandler;
	KeyHandler keyHandler;
	CheckcodeHandler checkcodeHandler;
	SetpswHandler setpswHandler = new SetpswHandler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_register);

		progressDialog = new ProgressDialog(this);
		progressDialog.setMessage("正在加载中...");
		progressDialog.setCancelable(true);

		iv_leftarrow = (ImageView) findViewById(R.id.iv_register_leftarrow);
		iv_leftarrow.setOnClickListener(onClickListener);

		et_phone = (EditText) findViewById(R.id.et_register_phone);

		et_password = (EditText) findViewById(R.id.et_register_password);

		et_key = (EditText) findViewById(R.id.et_register_key);

		btn_register = (Button) findViewById(R.id.btn_register_register);
		btn_register.setOnClickListener(onClickListener);

		btn_sendkey = (Button) findViewById(R.id.btn_register_sendkey);
		btn_sendkey.setOnClickListener(onClickListener);

		TextView tv_law = (TextView) findViewById(R.id.tv_register_law);
		tv_law.setOnClickListener(onClickListener);

		timeHandler = new TimeHandler();
		keyHandler = new KeyHandler();
		checkcodeHandler = new CheckcodeHandler();

	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.iv_register_leftarrow:
				finish();
				break;
			case R.id.btn_register_sendkey:
				String phone = et_phone.getText().toString();
				if (phone.length() != 11) {
					Toast.makeText(RegisterActivity.this, "请输入正确的手机号",
							Toast.LENGTH_SHORT).show();
				} else {
					i = 60;
					btn_sendkey.setClickable(false);
					new Thread(r_sendkey).start();
				}
				break;
			case R.id.btn_register_register:
				String key = et_key.getText().toString();
				if (key.length() != 6) {
					Toast.makeText(RegisterActivity.this, "请输入正确的验证码",
							Toast.LENGTH_SHORT).show();
				} else if (et_phone.getText().toString().length() != 11) {
					Toast.makeText(RegisterActivity.this, "请输入正确的手机号",
							Toast.LENGTH_SHORT).show();
				} else if (et_password.getText().toString().length() < 6) {
					Toast.makeText(RegisterActivity.this, "密码不能少于6位",
							Toast.LENGTH_SHORT).show();
				} else {
					progressDialog.show();
					new Thread(r_checkcode).start();
				}
				break;
			case R.id.tv_register_law:
				break;
			}
		}
	};

	Runnable r_time = new Runnable() {

		@SuppressLint("HandlerLeak")
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				if (i > 0) {
					i--;
					Bundle b = new Bundle();
					Message msg = new Message();
					msg.setData(b);
					timeHandler.sendMessage(msg);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					Bundle b = new Bundle();
					Message msg = new Message();
					msg.setData(b);
					timeHandler.sendMessage(msg);
					break;
				}
			}
		}
	};

	Runnable r_sendkey = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				JSONObject jsn = new JSONObject();
				jsn.put("account", et_phone.getText().toString());
				jsn.put("templateId", "10849");

				String result = HttpPost.sendPost(Data.URL, jsn.toString(),
						"10001");

				result = ParseXML.parseXml(result);

				Message msg = new Message();
				Bundle b = new Bundle();
				b.putString("result", result);
				msg.setData(b);
				keyHandler.sendMessage(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	};

	Runnable r_checkcode = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				JSONObject jsn = new JSONObject();
				jsn.put("account", et_phone.getText().toString());
				jsn.put("smsCode", et_key.getText().toString());

				String result = HttpPost.sendPost(Data.URL, jsn.toString(),
						"10002");

				result = ParseXML.parseXml(result);

				Message msg = new Message();
				Bundle b = new Bundle();
				b.putString("result", result);
				msg.setData(b);
				checkcodeHandler.sendMessage(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	};

	Runnable r_setPsw = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				JSONObject jsn = new JSONObject();
				jsn.put("account", et_phone.getText().toString());
				jsn.put("password",
						Encrypt.MD5(et_password.getText().toString()));

				String result = HttpPost.sendPost(Data.URL, jsn.toString(),
						"10003");

				result = ParseXML.parseXml(result);

				Message msg = new Message();
				Bundle b = new Bundle();
				b.putString("result", result);
				msg.setData(b);
				setpswHandler.sendMessage(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	@SuppressLint("HandlerLeak")
	class TimeHandler extends Handler {
		@SuppressWarnings("deprecation")
		@SuppressLint("NewApi")
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);

			if (i > 0) {
				btn_sendkey.setBackgroundResource(R.drawable.shape_registerkey);
				btn_sendkey
						.setTextColor(getResources().getColor(R.color.white));
				btn_sendkey.setText(i + "s");
			} else {
				btn_sendkey.setBackgroundResource(R.drawable.shape_registerkey);
				btn_sendkey
						.setTextColor(getResources().getColor(R.color.white));
				btn_sendkey.setClickable(true);
				btn_sendkey.setText("发送验证码");
			}

		}
	}

	class KeyHandler extends Handler {
		@SuppressLint("HandlerLeak")
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			try {
				if (msg.getData().getString("result").equals("error")) {
					Toast.makeText(RegisterActivity.this, "网络出现问题了",
							Toast.LENGTH_SHORT).show();
					return;
				}

				JSONObject json = new JSONObject(msg.getData().getString(
						"result"));
				JSONObject resultJsn = json.getJSONObject("result");

				if (resultJsn.getString("flag").equals("0")) {
					new Thread(r_time).start();
				} else {
					Toast.makeText(RegisterActivity.this,
							resultJsn.getString("msg"), Toast.LENGTH_SHORT)
							.show();
					btn_sendkey.setClickable(true);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@SuppressLint("HandlerLeak")
	class CheckcodeHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);

			// progressDialog.dismiss();

			try {
				if (msg.getData().getString("result").equals("error")) {
					Toast.makeText(RegisterActivity.this, "网络出现问题了",
							Toast.LENGTH_SHORT).show();
					progressDialog.dismiss();
					return;
				}

				JSONObject json = new JSONObject(msg.getData().getString(
						"result"));
				JSONObject resultJsn = json.getJSONObject("result");

				if (resultJsn.getString("flag").equals("0")) {
					new Thread(r_setPsw).start();
				} else {
					Toast.makeText(RegisterActivity.this,
							resultJsn.getString("msg"), Toast.LENGTH_SHORT)
							.show();
					progressDialog.dismiss();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	class SetpswHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);

			progressDialog.dismiss();

			try {
				if (msg.getData().getString("result").equals("error")) {
					Toast.makeText(RegisterActivity.this, "网络出现问题了",
							Toast.LENGTH_SHORT).show();
					return;
				}

				JSONObject json = new JSONObject(msg.getData().getString(
						"result"));
				JSONObject resultJsn = json.getJSONObject("result");

				if (resultJsn.getString("flag").equals("0")) {
					Toast.makeText(RegisterActivity.this, "注册成功",
							Toast.LENGTH_SHORT).show();
					finish();
				} else {
					Toast.makeText(RegisterActivity.this,
							resultJsn.getString("msg"), Toast.LENGTH_SHORT)
							.show();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

}
