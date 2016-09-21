package com.chinagyl.appinfocapture;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * 得到所有APK的图标
 * 
 * @Description :
 * @author Dminter
 * @version 1.0
 * @created Aug 14, 2012 9:41:23 AM
 * @fileName com.chinagyl.appcapture.GetAPKIcons.java
 * 
 */
public class GetAPKIcons {

	public static void main(String[] args) {

		String url;
		Document doc;
		for (int j = 10000; j <= 10000; j++) {
			url = "http://www.11papa.com/htm/pic9/" + j + ".htm";
			// url = "http://www.2265.com/game_4/62/android_" + j + ".html";

			try {
				doc = Jsoup.connect(url).timeout(5000).get();
				Elements div1 = doc.select("div.n_bd").select("img");
				// System.out.println("img???" + div1);
				for (int i = 0; i < div1.size(); i++) {
					String img = div1.get(i).select("img").attr("src");
					try {
						download(img, "d:\\1\\" + (j + i) + ".jpg");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void download(String urlString, String fileName) throws Exception {
		// 构造URL
		URL url = new URL(urlString);
		// 打开连接
		URLConnection con = url.openConnection();
		// 输入流
		InputStream is = con.getInputStream();
		// 1K的数据缓冲
		byte[] bs = new byte[8096];
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
