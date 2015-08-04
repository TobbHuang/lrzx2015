/**
 * <p>Title: CodeDecompress.java</p>
 * <p>Description: </p>
 * @author YLinHu
 * @date 2015年4月1日
 * @version 1.0
 */
package com.example.hometeacher.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import sun.misc.*;

import com.example.hometeacher.base64.Base64;

/**
 * <p>
 * Title: CodeDecompress
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author YLinHu
 * @date 2015年4月1日
 */
public class CodeDecompress {

	/**
	 * 
	 * 使用gzip进行压缩
	 */
	public static byte[] gzip(String primStr) {
		if (primStr == null || primStr.length() == 0) {
			return null;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		GZIPOutputStream gzip = null;
		try {
			gzip = new GZIPOutputStream(out);
			gzip.write(primStr.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (gzip != null) {
				try {
					gzip.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return out.toByteArray();
	}

	/**
	 * 
	 * <p>
	 * Description:使用gzip进行解压缩
	 * </p>
	 * 
	 * @param compressedStr
	 * @return
	 */
	public static String gunzip(byte[] bs) {

		if (bs == null) {
			System.out.println("bs==0");
			return null;
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = null;
		GZIPInputStream ginzip = null;
		byte[] compressed = null;
		String decompressed = null;
		try {
			compressed = bs;
			in = new ByteArrayInputStream(compressed);
			ginzip = new GZIPInputStream(in);

			byte[] buffer = new byte[1024];
			int offset = -1;

			while ((offset = ginzip.read(buffer)) != -1) {
				out.write(buffer, 0, offset);
			}
			decompressed = out.toString("UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ginzip != null) {
				try {
					ginzip.close();
				} catch (IOException e) {
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
		return decompressed;
	}

	/**
	 * 字符串压缩解压
	 * 
	 * @param str
	 *            base64编码的字符串
	 * @return
	 * @throws IOException
	 */
	public static String zipDecompressBase64Decoding(String str)
			throws IOException {
		if (str == null || str.length() == 0) {
			return null;
		}

		byte[] bs = Base64.decodeBase64(String.format("H4sIAAAAAA%s", str));
		return gunzip(bs);
	}

	/**
	 * 使用zip进行压缩
	 * 
	 * @param str
	 *            压缩前的文本
	 * @return 返回压缩后的文本
	 */
	public static final String zip(String str) {
		if (str == null)
			return null;
		byte[] compressed;
		ByteArrayOutputStream out = null;
		ZipOutputStream zout = null;
		String compressedStr = null;
		try {
			out = new ByteArrayOutputStream();
			zout = new ZipOutputStream(out);
			zout.putNextEntry(new ZipEntry("0"));
			zout.write(str.getBytes());
			zout.closeEntry();
			compressed = out.toByteArray();
			compressedStr = new BASE64Encoder()
					.encodeBuffer(compressed);
		} catch (IOException e) {
			compressed = null;
		} finally {
			if (zout != null) {
				try {
					zout.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
		return compressedStr;
	}

	/**
	 * 使用zip进行解压缩
	 * 
	 * @param compressed
	 *            压缩后的文本
	 * @return 解压后的字符串
	 */
	public static final String unzip(String compressedStr) {
		if (compressedStr == null) {
			return null;
		}

		ByteArrayOutputStream out = null;
		ByteArrayInputStream in = null;
		ZipInputStream zin = null;
		String decompressed = null;
		try {
			byte[] compressed = new BASE64Decoder()
					.decodeBuffer(compressedStr);
			out = new ByteArrayOutputStream();
			in = new ByteArrayInputStream(compressed);
			zin = new ZipInputStream(in);
			zin.getNextEntry();
			byte[] buffer = new byte[1024];
			int offset = -1;
			while ((offset = zin.read(buffer)) != -1) {
				out.write(buffer, 0, offset);
			}
			decompressed = out.toString();
		} catch (IOException e) {
			decompressed = null;
		} finally {
			if (zin != null) {
				try {
					zin.close();
				} catch (IOException e) {
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
		return decompressed;
	}

	/**
	 * 字符串压缩返回Base64编码后的字符串
	 * 
	 * @param str
	 * @return
	 * @throws IOException
	 */
	public static String zipCompressBase64Encoding(String str)
			throws IOException {
		byte[] bs = gzip(str);
		return Base64.encodeBase64String(bs).substring(10);
	}

	/*
	 * 使用Base64加密
	 */
	public static String getBase64(String str) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}

	/*
	 * 使用Base64解密
	 */
	public static String getFromBase64(String s) {
		byte[] b = null;
		String result = null;
		if (s != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				b = decoder.decodeBuffer(s);
				result = new String(b, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
