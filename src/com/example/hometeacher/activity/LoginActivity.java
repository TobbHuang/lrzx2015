package com.example.hometeacher.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import com.example.hometeacher.R;
import com.example.hometeacher.util.CodeDecompress;
import com.example.hometeacher.util.HttpPost;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);

		new UserLoginTask().execute((Void)null);
		
	}

	public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
		
		String result;

		UserLoginTask() {
		}

		@Override
		protected Boolean doInBackground(Void... params) {
			// TODO: attempt authentication against a network service.

			try {
				String json = "{\"account\":\"18280274169\",\"密码\":\"123456\",\"smsCode\":\"620414\"}";
				String url = "http://192.168.1.108:8080/ZJJ/callServiceAndroid.do";
				String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
						+ "<TransData><BaseInfo><TransType></TransType><TransCode>10001</TransCode>"
						+ "<SubTransCode>02</SubTransCode><UserName></UserName><Password></Password>"
						+ "<ResultCode></ResultCode><ResultMsg></ResultMsg></BaseInfo><InputData>"
						+ json + "</InputData>ss</TransData>";
				System.out.println("xml1:" + xml);
				xml = CodeDecompress.zipCompressBase64Encoding(xml);
				System.out.println("xml2:" + xml);

				result = HttpPost.sendPost(url, xml);
				System.out.println("result1:" + result);

				result = CodeDecompress.zipDecompressBase64Decoding(result);

				System.out.println("result2:" + result);
			} catch (Exception e) {
				e.printStackTrace();
			}

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
