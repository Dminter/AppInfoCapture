package com.chinagyl.appinfocapture;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * 得到所有APK的小图标相关联的APK信息(APKID-->图标名称)
 * 
 * @Description :
 * @author Dminter
 * @version 1.0
 * @created Aug 14, 2012 9:40:08 AM
 * @fileName com.chinagyl.appcapture.GetAPKIconInfo.java
 * 
 */
public class GetAPKIconInfo {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		String url;
		Document doc;

		for (int j = 1; j < 438; j++) {
			url = "http://www.2265.com/game_4/62/android_" + j + ".html";

			try {
				doc = Jsoup.connect(url).timeout(5000).get();
				Elements div1 = doc.select("div.ProInfo");
				String img = div1.select("img").attr("src");
				FileWriter fw = new FileWriter(
						"d:\\Test\\Log\\apkIconsInfo.txt");
				sb.append(j).append("|").append(j).append("_icon.png")
						.append("\n");
				System.out.println(sb.toString());
				fw.write(sb.toString(), 0, sb.toString().length());
				fw.flush();
				fw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
