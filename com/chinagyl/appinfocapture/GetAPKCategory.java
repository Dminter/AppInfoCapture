package com.chinagyl.appinfocapture;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/**
 * 单独得到APK分类
 * @Description :
 * @author Dminter    
 * @version 1.0  
 * @created Aug 14, 2012 9:39:44 AM
 * @fileName com.chinagyl.appcapture.GetAPKCategory.java
 *
 */
public class GetAPKCategory {

	public static void main(String[] args) {

		String url;
		Document doc;// 12146
		StringBuffer sb = new StringBuffer();
		for (int j = 1; j < 438; j++) {
			url = "http://www.2265.com/game_4/62/android_" + j + ".html";

			try {

				doc = Jsoup.connect(url).timeout(1000).get();

				Elements div2 = doc.select("div.right");
				String category = div2.select("p").get(3).text()
						.replace("类别", "").replace("：", "").trim();

				Random r = new Random();

				int temp = r.nextInt(10);

				do {
					temp = r.nextInt(10);
				} while (temp < 5 || temp > 10);

				FileWriter fw = new FileWriter(
						"d:\\Test\\Log\\apkCategoryInfo.txt");
				sb.append(j).append("|").append(category).append("|")
						.append(temp).append("\n");
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

}
