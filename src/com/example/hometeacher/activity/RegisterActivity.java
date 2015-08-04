package com.example.hometeacher.activity;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.hometeacher.R;
import com.example.hometeacher.data.Data;
import com.example.hometeacher.util.HttpPost;
import com.example.hometeacher.util.ParseXML;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
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
	RegisterHandler registerHandler;

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
		registerHandler = new RegisterHandler();

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
				String password = et_password.getText().toString();
				String key = et_key.getText().toString();
				if (password.length() < 6) {
					Toast.makeText(RegisterActivity.this, "密码不能少于6位",
							Toast.LENGTH_SHORT).show();
				} else if (key.length() != 6) {
					Toast.makeText(RegisterActivity.this, "请输入正确的验证码",
							Toast.LENGTH_SHORT).show();
				} else {
					progressDialog.show();
					new Thread(r_register).start();
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

				String result = HttpPost.sendPost(Data.URL, jsn.toString(), "10001");

				System.out.println("result:" + result);
				ParseXML.parseXml(result);

//				Message msg = new Message();
//				Bundle b = new Bundle();
//				b.putString("result", result);
//				msg.setData(b);
//				keyHandler.sendMessage(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	};

	Runnable r_register = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
//			List<NameValuePair> params = new ArrayList<NameValuePair>();
//			params.add(new BasicNameValuePair("Request", "SignUp"));
//			params.add(new BasicNameValuePair("Phone", et_phone.getText()
//					.toString()));
//			// �ֻ���+���� MD5��ϼ���
//			params.add(new BasicNameValuePair("Password", Encrypt.MD5(et_phone
//					.getText().toString() + et_password.getText().toString())));
//			params.add(new BasicNameValuePair("Code", et_key.getText()
//					.toString()));
//
//			String result = new HttpPostConnection("SignServer", params)
//					.httpConnection();
//
//			if (result.equals("timeout")) {
//				JSONObject json = new JSONObject();
//				try {
//					json.put("Result", "timeout");
//					result = json.toString();
//				} catch (JSONException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//
//			Message msg = new Message();
//			Bundle b = new Bundle();
//			b.putString("result", result);
//			msg.setData(b);
//			registerHandler.sendMessage(msg);

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
				// btn_sendkey.setBackgroundColor(getResources().getColor(
				// R.color.grey));
				// btn_sendkey.setTextColor(getResources().getColor(
				// R.color.darkGrey));
				btn_sendkey.setText("重新发送(" + i + "s)");
			} else {
				// btn_sendkey.setBackgroundDrawable(getResources().getDrawable(
				// R.drawable.selector_drawable_register_sendkey));
				btn_sendkey.setClickable(true);
				btn_sendkey.setText("重新发送");
				// btn_sendkey.setTextColor(getResources().getColor(R.color.blue));
			}

		}
	}

	class KeyHandler extends Handler {
		@SuppressLint("HandlerLeak")
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);

			Bundle b = msg.getData();
			JSONObject json;
			String result = null;
			try {
				json = new JSONObject(b.getString("result"));
				result = json.getString("Result");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (result.equals("��֤���ѷ���")) {
				Toast.makeText(RegisterActivity.this, result,
						Toast.LENGTH_SHORT).show();
				new Thread(r_time).start();
			} else if (result.equals("��֤�뷢��ʧ��")) {
				Toast.makeText(RegisterActivity.this, result,
						Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(RegisterActivity.this,
						"��֤���ŷ���ʧ�ܣ�����������������", Toast.LENGTH_SHORT)
						.show();
			}

		}
	}

	@SuppressLint("HandlerLeak")
	class RegisterHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);

			progressDialog.dismiss();

			Bundle b = msg.getData();
			JSONObject json;
			String result = null;
			try {
				json = new JSONObject(b.getString("result"));
				result = json.getString("Result");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Toast.makeText(RegisterActivity.this, result, Toast.LENGTH_SHORT)
					.show();

			if (result.equals("ע��ɹ�")) {
				Toast.makeText(RegisterActivity.this, result,
						Toast.LENGTH_SHORT).show();
				finish();
			} else if (result.equals("timeout")) {
				Toast.makeText(RegisterActivity.this,
						"��֤���ŷ���ʧ�ܣ�����������������", Toast.LENGTH_SHORT)
						.show();
			} else {
				Toast.makeText(RegisterActivity.this, result,
						Toast.LENGTH_SHORT).show();
			}

		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

}
