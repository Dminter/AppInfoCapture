package com.chinagyl.appinfocapture;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 得到单个APK信息,测试用
 * 
 * @Description :
 * @author Dminter
 * @version 1.0
 * @created Aug 14, 2012 9:42:31 AM
 * @fileName com.chinagyl.appcapture.GetAPKOnes.java
 * 
 */
public class GetAPKOnes {

	public static void main(String[] args) {

		int ApkId = 37;
		String down_url = "http://www.2265.com/down.jsp?flg=dianxin&appid=";

		try {
			try {
				download(down_url + ApkId, "D:\\Test\\APPs2\\" + ApkId + ".apk");

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
