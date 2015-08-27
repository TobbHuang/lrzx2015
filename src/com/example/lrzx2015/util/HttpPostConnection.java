package com.example.lrzx2015.util;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import com.example.lrzx2015.data.Data;

/**
 * http连接方法
 * 
 * @author Tobb
 * @Time 2015-08-26
 * 
 */
public class HttpPostConnection {
	String url;
	List<NameValuePair> params;

	public HttpPostConnection(String url, List<NameValuePair> params) {
		this.url = url;
		this.params = params;
	}

	public String httpConnection() {

		String result = null;
		try {
			HttpClient httpClient = new DefaultHttpClient();
			httpClient.getParams().setIntParameter(
					CoreConnectionPNames.SO_TIMEOUT, 15000);
			httpClient.getParams().setIntParameter(
					CoreConnectionPNames.CONNECTION_TIMEOUT, 15000);

			HttpPost httpPost = new HttpPost(Data.URL + url);

			httpPost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));

			HttpResponse httpResponse = httpClient.execute(httpPost);
			result = EntityUtils.toString(httpResponse.getEntity());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "timeout";
		}

		return result;

	}

}
