package com.chinagyl.appinfocapture;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetAPKImages {
	/**
	 * 得到所有APK详情图片信息
	 * 
	 * @Description
	 * @param args
	 * @return
	 */
	public static void main(String[] args) {

		String url;
		Document doc;
		// 13511 12146 13435
		for (int j = 12146; j < 13511; j++) {
			url = "http://www.2265.com/game_4/62/android_" + j + ".html";

			try {

				doc = Jsoup.connect(url).timeout(5000).get();
				Elements links = doc.select("a[href]");

				for (int i = 0; i < links.size(); i++) {
					if (links.get(i).attr("abs:href").contains(".jpg")) {
						try {

							if (i - 36 > 5) {

							} else if (i - 36 == 0) {

							} else {
								download(links.get(i).attr("abs:href")
										.toString(), "d:\\Test\\Imgs3\\" + j
										+ "_" + (i - 36) + ".jpg");
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}

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
