package com.crm.comcast.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * it's contains java specific libraries  like getRandomdata & getsystem date etc...
 * @author Lohith
 *
 */

public class JavaUtility {
	/**
	 * its used to generate the Random number with in the range of 1000.
	 * 
	 * @return
	 */
	

	public int getRandomNumber()
	{
		Random random = new Random();
		
		int randNum = random.nextInt(1000);
		
		return randNum;
	}
	
	/**
	 * its used to get the system date and time in IST format
	 * @return
	 */
	
	public String getSystemDateAndTimeInISTFormat()
	{
		Date date = new Date();
		
		return date.toString();
	}
	
	/**
	 * its used to get the current system date based on YYYY-MM-DD format
	 * @return
	 */
	
	public String getSystemDateAndTimeInStandardFormat()
	{
		Date date = new Date();
		
		String  dateAndtime= date.toString();
		
		String YYYY = dateAndtime.split(" ")[5];
		String DD = dateAndtime.split(" ")[2];
		int MM = date.getMonth()+1;
		
		String standardFormat;
		return standardFormat=YYYY+" "+DD+" "+MM;
		
	}

}
