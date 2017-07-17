package com.shik.dao;


import com.shik.support.generator.MybatisGeneratorXml;
import com.shik.support.reader.PropertiesFileUtil;

/**
 * 代码生成类
 * Created by ZhangShuzheng on 2017/1/10.
 */
public class Generator {

	// 根据命名规范，只修改此常量值即可
	private static String MODULE_PREFIX_NAME = "";
	private static String JDBC_DRIVER = PropertiesFileUtil.getInstance("config/jdbc").get("primary.driver-class-name");
	private static String JDBC_URL = PropertiesFileUtil.getInstance("config/jdbc").get("primary.url");
	private static String JDBC_USERNAME = PropertiesFileUtil.getInstance("config/jdbc").get("primary.username");
	private static String JDBC_PASSWORD = PropertiesFileUtil.getInstance("config/jdbc").get("primary.password");

	/**
	 * 自动代码生成
	 * @param args
	 */
	public static void main(String[] args) {
		MybatisGeneratorXml.generator(JDBC_DRIVER, JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD, MODULE_PREFIX_NAME);
	}

}
