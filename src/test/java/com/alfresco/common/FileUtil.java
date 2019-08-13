package com.alfresco.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileUtil {

    static Properties odigoProps = null;
    static {
		try {
			Properties tempProps = null;
			tempProps=readPropertiesFile("serenity");
			if (tempProps.getProperty("chrome_preferences.intl.accept_languages")=="fr")
			odigoProps = readPropertiesFile("Fr");
			else
				odigoProps = readPropertiesFile("en");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static String getLocalizeText(String propName) {
    	return odigoProps.getProperty(propName);
    }
    
	private static File getJDBCPropFile() {
		File filePath = new File(System.getProperty("user.dir")+"/src/test/resources/config/jdbc.properties");
		return filePath;
    }
	
	private static File getSerenityPropFile() {
		File filePath = new File(System.getProperty("user.dir")+"/src/test/resources/serenity.properties");
		return filePath;
    }
	
	private static File getFrFile() {
		File filePath = new File(System.getProperty("user.dir")+"/src/test/resources/config/fr.properties");
		return filePath;
    }
	
	private static File getEnFile() {
		File filePath = new File(System.getProperty("user.dir")+"/src/test/resources/config/en.properties");
		return filePath;
    }
	
	public static Properties readPropertiesFile(String propFile) throws Exception {
        Properties props = new Properties();
        InputStream in = null;
        if (propFile =="JDBC")
		in = new FileInputStream(getJDBCPropFile());
        else if (propFile =="serenity")
        	in = new FileInputStream(getSerenityPropFile());
        else if (propFile =="Fr")
        	in= new FileInputStream(getFrFile());
        else
        	in= new FileInputStream(getEnFile());
		props.load(in);
		in.close();
        return props;
    }
	
	public static String getKeyValue(String propName) throws Exception {
		return readPropertiesFile("en").getProperty(propName);
	}
}
