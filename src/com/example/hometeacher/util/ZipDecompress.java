package com.example.hometeacher.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;

import com.example.hometeacher.base64.Base64;

public class ZipDecompress {
	
	/**
	 * 解压压缩的字符串
	 * @param bs 
	 * @return
	 * @throws IOException
	 */
	public static String zipDecompress(byte[] bs) throws IOException {
		if (bs == null) {
			return null;
		}
		/*
		ByteArrayOutputStream out = null;
		ByteArrayInputStream in = null;
		ZipInputStream zin = null;
		try {
			out = new ByteArrayOutputStream();
			in = new ByteArrayInputStream(bs);
			zin = new ZipInputStream(in);
			zin.getNextEntry();
			byte[] buffer = new byte[1024];
			int offset = -1;
			while ((offset = zin.read(buffer)) != -1) {
				out.write(buffer, 0, offset);
			}
			return out.toString("UTF-8");
		} catch (IOException e) {
			throw new IOException(e.getCause());
		} finally {
			if (zin != null) {
				try {
					zin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}*/

		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
		ByteArrayInputStream in = new ByteArrayInputStream(bs, 0, bs.length);
		GZIPInputStream gunzip = new GZIPInputStream(in);
		try {
			byte[] buffer = new byte[1024];
			int n = 0;
			while ((n = gunzip.read(buffer, 0, 1024)) != -1) {
				out.write(buffer, 0, n);
			}
			out.flush();
			return out.toString("UTF-8");
		} catch (IOException e) {
			throw e;
		} finally {
			in.close();
			gunzip.close();
			out.close();
		}
	}
	
	/**
	 * 字符串压缩解压
	 * @param str base64编码的字符串
	 * @return
	 * @throws IOException
	 */
	public static String zipDecompressBase64Decoding(String str) throws IOException{
		if(str == null || str.length()==0){
			return null;
		}
		
//		byte[] bs = Base64.decodeBase64(String.format("UEsDBBQACAAIAPJ6J0YAAAAAAAAAAAAAAAABAAAAM%s", str));
		byte[] bs = Base64.decodeBase64(String.format("H4sIAAAAAAAAA%s", str));
		return zipDecompress(bs);
	}
}
