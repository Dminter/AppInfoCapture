package com.chinagyl.appinfocapture;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * 所有APK相关信息,除了版本号版本名称和APK本身
 * 
 * @Description :
 * @author Dminter
 * @version 1.0
 * @created Aug 14, 2012 9:37:08 AM
 * @fileName com.chinagyl.appcapture.GetAllAPKInfos.java
 * 
 */
public class GetAllAPKInfos {

	public static void main(String[] args) {

		String url;
		Document doc;// 12146 438 13511
		StringBuffer sb = new StringBuffer();
		for (int j = 11567; j < 13511; j++) {
			url = "http://www.2265.com/game_4/62/android_" + j + ".html";

			try {

				doc = Jsoup.connect(url).timeout(5000).get();
				Elements div1 = doc.select("div.proinfo");
				String version = div1.select("h1").select("span").text();
				String name = div1.select("h1").text().replace(version, "");
				Elements div2 = doc.select("div.left");
				String down_times = div2.select("p").get(0).text()
						.replace("下载", "").replace("次", "").replace("：", "")
						.trim();
				String apk_size = div2.select("p").get(1).text()
						.replace("大小", "").replace("KB", "").replace("：", "")
						.trim();
				double xz2 = Float.parseFloat(apk_size) / 1024.0;
				DecimalFormat df = new DecimalFormat("#0.00");
				String apk_size_MB = df.format(xz2);
				String time = div2.select("p").get(2).text().replace("时间", "")
						.replace("：", "").trim();
				Elements div3 = doc.select("div.vb_r_pi_box4");
				String apk_desc = "";
				if (div3.select("p").size() <= 2) {
					apk_desc = "暂无简介";
				} else {
					apk_desc = div3.select("p").get(2).text();
				}

				Elements div00 = doc.select("div.right");
				String category = div00.select("p").get(3).text()
						.replace("类别", "").replace("：", "").trim();

				Random r = new Random();

				int temp = r.nextInt(10);

				do {
					temp = r.nextInt(10);
				} while (temp < 5 || temp > 10);

				FileWriter fw = new FileWriter("d:\\Test\\Log\\allApkInfo2.txt");
				sb.append(j).append("|").append(j).append(".apk").append("|")
						.append(name).append("|").append(apk_size_MB)
						.append("|").append(version).append("|")
						.append(apk_desc).append("|").append(time).append("|")
						.append(down_times).append("|").append(j)
						.append("_1.jpg").append("|").append(j)
						.append("_2.jpg").append("|").append(j)
						.append("_3.jpg").append("|").append(j)
						.append("_4.jpg").append("|").append(j)
						.append("_5.jpg").append("|").append(category)
						.append("|").append(j).append("_icon.png").append("\n");
				fw.write(sb.toString(), 0, sb.toString().length());
				fw.flush();
				fw.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
