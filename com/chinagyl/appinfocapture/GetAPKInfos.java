package com.chinagyl.appinfocapture;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GetAPKInfos {
	/**
	 * 得到部分APK基本信息
	 * 
	 * @Description
	 * @param args
	 * @return
	 */
	public static void main(String[] args) {

		String url;
		Document doc;// 12146
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < 438; j++) {
			url = "http://www.2265.com/game_4/62/android_" + j + ".html";

			try {

				doc = Jsoup.connect(url).timeout(1000).get();
				Elements div1 = doc.select("div.proinfo");
				String version = div1.select("h1").select("span").text();
				String name = div1.select("h1").text().replace(version, "");
				// System.out.println("->" + name);
				// System.out.println("->" + version);

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
				// System.out.println(apk_size_MB);

				String time = div2.select("p").get(2).text().replace("时间", "")
						.replace("：", "").trim();
				// System.out.println(time);

				Elements div3 = doc.select("div.vb_r_pi_box4");
				String apk_desc = div3.select("p").get(2).text();
				// System.out.println(apk_desc);

				FileWriter fw = new FileWriter("d:\\Test\\Log\\apkInfo.log");

				sb.append(j).append("|").append(j).append(".apk").append("|")
						.append(name).append("|").append(apk_size_MB)
						.append("|").append(version).append("|")
						.append(apk_desc).append("|").append(time).append("|")
						.append(down_times).append("|").append(j)
						.append("_1.jpg").append("|").append(j)
						.append("_2.jpg").append("|").append(j)
						.append("_3.jpg").append("|").append(j)
						.append("_4.jpg").append("|").append(j)
						.append("_5.jpg").append("\n");
				// System.out.println(sb.toString());
				fw.write(sb.toString(), 0, sb.toString().length());
				fw.flush();
				fw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
