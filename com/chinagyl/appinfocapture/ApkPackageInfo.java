package com.chinagyl.appinfocapture;

import org.jsoup.helper.StringUtil;

/**
 * 根据APK得到包名,版本号,版本名称等相关信息的实体类
 */

/**
 * apk 包信息
 * 
 * @author king
 * 
 */
public class ApkPackageInfo {

	private String savePath;
	/**
	 * 包名
	 */
	private String packageName;
	/**
	 * 版本CODE
	 */
	private String versionCode;
	/**
	 * 版本号
	 */
	private String versionName;
	/**
	 * android版本号
	 */
	private String sdkVersion;
	/**
	 * 标题
	 */
	private String label;

	/**
	 * 图标名称
	 */
	private String icon_name;

	/**
	 * 大图标
	 */
	private String icon_h_path;

	/**
	 * 中图标
	 */
	private String icon_m_path;

	/**
	 * 小图标
	 */
	private String icon_l_path;

	/**
	 * 大图标
	 */
	private String icon_h_url;

	/**
	 * 中图标
	 */
	private String icon_m_url;

	/**
	 * 小图标
	 */
	private String icon_l_url;

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getSdkVersion() {
		return sdkVersion;
	}

	public void setSdkVersion(String sdkVersion) {
		this.sdkVersion = sdkVersion;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getIcon_h_path() {
		return icon_h_path;
	}

	public void setIcon_h_path(String icon_h_path) {
		this.icon_h_path = icon_h_path;
	}

	public String getIcon_m_path() {
		return icon_m_path;
	}

	public void setIcon_m_path(String icon_m_path) {
		this.icon_m_path = icon_m_path;
	}

	public String getIcon_l_path() {
		return icon_l_path;
	}

	public void setIcon_l_path(String icon_l_path) {
		this.icon_l_path = icon_l_path;
	}

	public String getIcon_h_url() {
		return icon_h_url;
	}

	public void setIcon_h_url(String icon_h_url) {
		this.icon_h_url = icon_h_url;
	}

	public String getIcon_m_url() {
		return icon_m_url;
	}

	public void setIcon_m_url(String icon_m_url) {
		this.icon_m_url = icon_m_url;
	}

	public String getIcon_l_url() {
		return icon_l_url;
	}

	public void setIcon_l_url(String icon_l_url) {
		this.icon_l_url = icon_l_url;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getIcon_name() {
		return icon_name;
	}

	public void setIcon_name(String icon_name) {
		this.icon_name = icon_name;
	}

	public String getIcon_h_name() {
		if (!StringUtil.isBlank(icon_name)) {
			StringBuilder icon_name = new StringBuilder(this.icon_name);
			return icon_name.insert(icon_name.lastIndexOf("."), "_h")
					.toString();
		}
		return null;
	}

	public String getIcon_m_name() {
		if (!StringUtil.isBlank(icon_name)) {
			StringBuilder icon_name = new StringBuilder(this.icon_name);
			return icon_name.insert(icon_name.lastIndexOf("."), "_m")
					.toString();
		}
		return null;
	}

	public String getIcon_l_name() {
		if (!StringUtil.isBlank(icon_name)) {
			StringBuilder icon_name = new StringBuilder(this.icon_name);
			return icon_name.insert(icon_name.lastIndexOf("."), "_l")
					.toString();
		}
		return null;
	}

	@Override
	public String toString() {
		return "ApkPackageInfo [savePath=" + savePath + ", packageName="
				+ packageName + ", versionCode=" + versionCode
				+ ", versionName=" + versionName + ", sdkVersion=" + sdkVersion
				+ ", label=" + label + ", icon_name=" + icon_name
				+ ", icon_h_path=" + icon_h_path + ", icon_m_path="
				+ icon_m_path + ", icon_l_path=" + icon_l_path
				+ ", icon_h_url=" + icon_h_url + ", icon_m_url=" + icon_m_url
				+ ", icon_l_url=" + icon_l_url + "]";
	}

}
