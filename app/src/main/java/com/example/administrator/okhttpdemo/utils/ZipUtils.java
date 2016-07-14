package com.example.administrator.okhttpdemo.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

/**
 * Zip���ѹ��
 * 
 * @author Administrator
 * 
 */
public class ZipUtils {

	/**
	 * zip��ѹ�㷨
	 * 
	 * @param bContent
	 * @return
	 */
	public static byte[] unZip(byte[] bContent) {
		byte[] b = null;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(bContent);
			ZipInputStream zip = new ZipInputStream(bis);
			while (zip.getNextEntry() != null) {
				byte[] buf = new byte[1024];
				int num = -1;
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				while ((num = zip.read(buf, 0, buf.length)) != -1) {
					baos.write(buf, 0, num);
				}
				b = baos.toByteArray();
				baos.flush();
				baos.close();
			}
			zip.close();
			bis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return b;
	}

	/**
	 * gzip��ѹ
	 * 
	 * @param bContent
	 * @return
	 */
	public static byte[] unGZip(byte[] bContent) {

		byte[] data = new byte[1024];
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(bContent);
			GZIPInputStream pIn = new GZIPInputStream(in);
			DataInputStream objIn = new DataInputStream(pIn);

			int len = 0;
			int count = 0;
			while ((count = objIn.read(data, len, len + 0)) != -1) {
				len = len + count;
			}

			byte[] trueData = new byte[len];
			System.arraycopy(data, 0, trueData, 0, len);

			objIn.close();
			pIn.close();
			in.close();

			return trueData;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
