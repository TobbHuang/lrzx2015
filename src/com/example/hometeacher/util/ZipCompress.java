package com.example.hometeacher.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.GZIPOutputStream;

import com.example.hometeacher.base64.Base64;

public class ZipCompress {
	/**
	 * 字符串压缩
	 * @param str要压缩的字符串
	 * @return
	 * @throws IOException 
	 */
	public static byte[] zipCompress(String str) throws IOException{
		if (str == null || str.length() == 0){
			return null;
		}
		/*
		ByteArrayOutputStream out = null;
		ZipOutputStream zout = null;
		try {
			out = new ByteArrayOutputStream();
			zout = new ZipOutputStream(out);
			zout.putNextEntry(new ZipEntry("0"));
			zout.setLevel(6);
			zout.setMethod(0);
			zout.write(str.getBytes(Charset.forName("UTF-8")));
			zout.closeEntry();
			return out.toByteArray();
		} catch (IOException e) {
			throw new IOException(e.getCause());
		} finally {
			if (zout != null) {
				zout.close();
			}
			if (out != null) {
				out.close();
			}
		}
		*/
		
		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
		GZIPOutputStream gzip = new GZIPOutputStream(out,2048);
		try {
			gzip.write(str.getBytes(Charset.forName("UTF-8")));
			gzip.finish();
			return out.toByteArray();
		} catch (IOException e) {
			throw e;
		} finally {
			if (gzip != null) {
				gzip.close();
			}
		} 
	}
	/**
	 * 字符串压缩返回Base64编码后的字符串
	 * @param str
	 * @return
	 * @throws IOException
	 */
	public static String zipCompressBase64Encoding(String str) throws IOException{
		byte[] bs = zipCompress(str);
		
//		return Base64.encodeBase64String(bs).substring(41);
		return Base64.encodeBase64String(bs).substring(13);
	}
	
	public static void main(String[] args) throws Exception {
		String str ="";
		FileInputStream stream = new FileInputStream(new File("C:/1.txt"));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1024);
		byte[] b = new byte[1024];
		int count = 0;
		while((count= stream.read(b, 0, 1024))!=-1){
			outputStream.write(b, 0, count);
		}
		str = outputStream.toString("UTF-8");
		str = zipCompressBase64Encoding(str);
		System.out.println(str.length());
		System.out.println(str);
	}
	
	
}
