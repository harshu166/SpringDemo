package com.fico.data.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfig {
	
	public static Properties getConfigProp() throws IOException {
		Properties prop = new Properties();
    	InputStream input = null;
    	
    	String filename = "config.properties";
		 
    	input = LoadConfig.class.getClassLoader().getResourceAsStream(filename);
		prop.load(input);
		
    	return prop;
	}
}
