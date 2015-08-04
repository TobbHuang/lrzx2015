package com.example.hometeacher.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

import com.example.hometeacher.R;
import com.example.hometeacher.data.Data;
import com.example.hometeacher.util.HttpPost;
import com.example.hometeacher.util.ZipCompress;
import com.example.hometeacher.util.ZipDecompress;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		
		initView();

		//new UserLoginTask().execute((Void)null);
		
	}
	
	private void initView() {
		// TODO Auto-generated method stub
		RelativeLayout rl_register=(RelativeLayout)findViewById(R.id.rl_login_register);
		rl_register.setOnClickListener(onClickListener);
	}

	OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent;
			switch(v.getId()){
			case R.id.rl_login_register:
				intent=new Intent(LoginActivity.this,RegisterActivity.class);
				startActivity(intent);
				break;
			}
		}
	};

	public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
		
		String result;

		UserLoginTask() {
		}

		@Override
		protected Boolean doInBackground(Void... params) {
			// TODO: attempt authentication against a network service.

			

			// TODO: register the new account here.
			return true;
		}

		@Override
		protected void onPostExecute(final Boolean success) {
		}

		@Override
		protected void onCancelled() {
		}
	}
}
