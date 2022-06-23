package com.crm.comcast.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * it's contains External File specific libraries
 * @author Admin
 *
 */

public class FileUtility {
	/**
	 * its used return the value from the property file based on key
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	
	public String getPropertyKeyValue(String key) throws Throwable
	
	{
		FileInputStream fileinputstream = new FileInputStream(".\\src\\test\\resources\\assignment attachments\\weekend1assignment\\data.properties.txt");
		
		Properties pres = new Properties();
		
		pres.load(fileinputstream);
		
		String value = pres.getProperty(key);
		
		return value;	
		
	}
	

}
