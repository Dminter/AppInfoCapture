package com.chinagyl.appinfocapture;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 得到所有APK包信息,包含包名,版本名称,版本号等信息
 * 
 * @Description :
 * @author Dminter
 * @version 1.0
 * @created Aug 14, 2012 9:42:45 AM
 * @fileName com.chinagyl.appcapture.GetApkPackageInfos.java
 * 
 */
public class GetApkPackageInfos {
	/**
	 * apk 解析命令
	 */
	private String apkOrder = "aapt.exe d badging ";

	public ApkPackageInfo getApkPackageInfo(File apkFile) {
		ApkPackageInfo apkPackageInfo = null;
		InputStream stderr = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			Runtime rt = Runtime.getRuntime();
			String order = apkOrder + "\"" + apkFile.getPath() + "\"";
			System.out.println(order);
			Process proc = rt.exec(order);
			stderr = proc.getInputStream();
			isr = new InputStreamReader(stderr);
			br = new BufferedReader(isr);
			String line = null;
			apkPackageInfo = new ApkPackageInfo();
			apkPackageInfo.setSavePath(apkFile.getPath());
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				if (line.startsWith("package:")) {
					int index = line.indexOf("name='") + 6;
					String packageName = line.substring(index,
							line.indexOf("'", index));
					index = line.indexOf("versionCode='") + 13;
					String versionCode = line.substring(index,
							line.indexOf("'", index));
					index = line.indexOf("versionName='") + 13;
					String versionName = line.substring(index,
							line.indexOf("'", index));

					apkPackageInfo.setPackageName(packageName);
					apkPackageInfo.setVersionCode(versionCode);
					apkPackageInfo.setVersionName(versionName);
				} else if (line.startsWith("sdkVersion:")) {
					int index = line.indexOf("sdkVersion:'") + 12;
					String sdkVersion = line.substring(index,
							line.indexOf("'", index));

					apkPackageInfo.setSdkVersion(sdkVersion);
				} else if (line.startsWith("application:")) {
					int index = line.indexOf("label='") + 7;
					String label = line.substring(index,
							line.indexOf("'", index));
					index = line.indexOf("icon='") + 6;
					String icon = line.substring(index,
							line.indexOf("'", index));

					apkPackageInfo.setLabel(label);
					apkPackageInfo.setIcon_name(icon.substring(icon
							.lastIndexOf("/") + 1));
					apkPackageInfo.setIcon_m_path(icon);
					apkPackageInfo.setIcon_h_path(icon.replace("mdpi", "hdpi"));
					apkPackageInfo.setIcon_l_path(icon.replace("mdpi", "ldpi"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != br)
					br.close();
				if (null != isr)
					isr.close();
				if (null != stderr)
					stderr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return apkPackageInfo;
	}

	public static void main(String args[]) {
		StringBuffer sb = new StringBuffer();
		GetApkPackageInfos getApkPackageInfos = new GetApkPackageInfos();

		FileWriter fw;
		try {

			for (int i = 7743; i < 13511; i++) {
				File file = new File("d:\\Test\\APPs\\" + i + ".apk");
				if (file.exists()) {

					ApkPackageInfo info = getApkPackageInfos
							.getApkPackageInfo(file);
					fw = new FileWriter("d:\\Test\\Log\\allApkPackageInfo2.txt");
					sb.append(i).append("|").append(info.getPackageName())
							.append("|").append(info.getVersionName())
							.append("|").append(info.getVersionCode())
							.append("|").append(info.getSdkVersion())
							.append("\n");
					System.out.println(sb.toString());
					fw.write(sb.toString(), 0, sb.toString().length());
					fw.flush();
					fw.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
