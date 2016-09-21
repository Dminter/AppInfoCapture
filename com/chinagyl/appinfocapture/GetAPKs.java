package com.chinagyl.appinfocapture;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 得到APK
 * 
 * @Description :
 * @author Dminter
 * @version 1.0
 * @created Aug 14, 2012 9:43:19 AM
 * @fileName com.chinagyl.appcapture.GetAPKs.java
 * 
 */
public class GetAPKs {

	public static void main(String[] args) {

		// int ApkId = 12146; 1811 2811 3811 5811 13435 13511 //13511 12146
		// 12871 7503 4875 5811 7628 8503 8503
		String down_url = "http://www.2265.com/down.jsp?flg=dianxin&appid=";

		try {
			try {
				for (int i = 8000; i < 8503; i++) {
					download(down_url + i, "D:\\Test\\APPs\\" + i + ".apk");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void download(String urlString, String fileName)
			throws Exception {
		// 构造URL
		URL url = new URL(urlString);
		// 打开连接
		URLConnection con = url.openConnection();
		con.setConnectTimeout(5000);
		// 输入流
		InputStream is = con.getInputStream();
		// 1K的数据缓冲
		byte[] bs = new byte[1024];
		// 读取到的数据长度
		int len;
		// 输出的文件流
		OutputStream os = new FileOutputStream(fileName);
		// 开始读取
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		// 完毕，关闭所有链接
		os.close();
		is.close();
	}

}
