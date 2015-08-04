package com.example.hometeacher.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class HttpPost {
	public static String sendPost(String url, String json, String transCode) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result="";
		try {

			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+ "<TransData><BaseInfo><TransType></TransType><TransCode>"
					+ transCode
					+ "</TransCode>"
					+ "<SubTransCode>02</SubTransCode><UserName></UserName><Password></Password>"
					+ "<ResultCode></ResultCode><ResultMsg></ResultMsg></BaseInfo><InputData>"
					+ json + "</InputData>ss</TransData>";
			String param = null;
			param = ZipCompress.zipCompressBase64Encoding(xml);
			
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();

			conn.setRequestProperty("charset", "UTF-8");
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setConnectTimeout(5000);

			conn.setDoOutput(true);
			conn.setDoInput(true);

			out = new PrintWriter(conn.getOutputStream());
			out.print(param);
			out.flush();
			in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			result = ZipDecompress.zipDecompressBase64Decoding(result);
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			result="error";
			out.close();
			try {
				in.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		

		return result;
	}
}
