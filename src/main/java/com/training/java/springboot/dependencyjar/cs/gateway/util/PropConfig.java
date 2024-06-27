/*
 * Created on Jul 13, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.training.java.springboot.dependencyjar.cs.gateway.util;

import java.io.FileInputStream;
import java.util.Properties;

public class PropConfig {
	//Constant
	private static final String DEFAULT_PATH = "/wasapp/config/cspaygw/backendgateway.properties";
	private static final String DEFAULT_PATH_LOCAL = "D:\\code_workspaces\\workspace_cs_refactor\\EXAMPLE\\springboot-cs-case-study-02\\CS-CONFIG\\case-study.properties";
	private static PropConfig instance = null;
	private static String ConfigDir = null;
	private static Properties props = null;
	/*	Environment	*/
	public final String Tag = "Environment.java Copyright (c) 2001 CP Seven Eleven";
	public static final String OS_ARCH = System.getProperty("os.arch");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String PATH_SEP = System.getProperty("file.separator");
	
	private PropConfig() {
		if(ConfigDir == null){
			ConfigDir = DEFAULT_PATH;
		}
		loadPros();
	}
	
	static synchronized public PropConfig getInstance() {
		if (instance == null) {
			instance = new PropConfig();
		}
		return instance;
	}
	
	public static void reset(){
		System.out.println("Reset Properties");
		props = null;
		instance = null;
	}
	
	private void loadPros() {
		try {
			System.out.println("Load Properties : " + ConfigDir);
			props = new Properties();
			props.load(new FileInputStream(ConfigDir));
		} catch (Exception ex) {
			System.err.println("Error loadPros : " + ConfigDir);
			try {
				ConfigDir = DEFAULT_PATH_LOCAL;
				props = new Properties();
				props.load(new FileInputStream(ConfigDir));
			} catch (Exception ex2) {
				System.err.println("Error loadPros : " + ConfigDir);
				ex2.printStackTrace();
			}
		}
	}
	
	//Properties key not found : return null
	public static String getProperty(String key) {
		if(props==null){
			getInstance();
		}
		return props.getProperty(key);
	}
	
	public static String getProperty(String key, String defaultValue) {
		if(props==null){
			getInstance();
		}
		String result = props.getProperty(key);
		if(result==null){
			result = defaultValue;
		}
		return result;
	}
	
	public static void setConfigDir(String string) {
		ConfigDir = string;
	}
	
}