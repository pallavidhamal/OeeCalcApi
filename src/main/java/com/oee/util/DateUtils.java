package com.oee.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	
	 private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 
	 private static final SimpleDateFormat ddMMYYSDF = new SimpleDateFormat("dd-MM-yyyy");
	    
	    private static SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");

	    private static final DateTimeFormatter myInvoiceDateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
				.withLocale(Locale.UK)
				.withZone(ZoneId.systemDefault());
	    
	    /**
	     * Returns today's date as java.util.Date object
	     *
	     * @return today's date as java.util.Date object
	     */
	    public static Date today() {
	        return new Date();
	    }

	    /**
	     * Returns today's date as yyyy-MM-dd format
	     *
	     * @return today's date as yyyy-MM-dd format
	     */
	    public static String todayStr() {
	        return sdf.format(today());
	    }
	    
	    
	    public static String todayStrSimpleDateTimeFormat() {
	        return simpleDateTimeFormat.format(today());
	    }
	    

	    /**
	     * Returns the formatted String date for the passed java.util.Date object
	     *
	     * @param date
	     * @return
	     */
	    public static String formattedDate(Date date) {
	        return date != null ? sdf.format(date) : todayStr();
	    }
	   // String myInvoiceRoundOffDateAndTime = myInvoiceDateTimeFormatter.format(myInvoiceDate);
	    
	    public static String formattedInstantToDateTimeString(Instant date) {
	        return date != null ? myInvoiceDateTimeFormatter.format(date) : todayStr();
	    }
	    
	    
	    // To Check if a String is a valid date format or not
	    public static boolean isValidDate(String date) {
	    	
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        
	        dateFormat.setLenient(false);
	        
	        try {
	        	
	          dateFormat.parse(date.trim());
	          
	        } 
	        catch (Exception pe) {
	        	
	          return false;
	          
	        }
	        
	        return true;
	      }
	    
	    public static String formattedInstantToSimpleDateTimeFormat(Instant date) {
	    	
//	        return date != null ? simpleDateTimeFormat.format(Date.from(date)) : todayStr();
	    	return date != null ? simpleDateTimeFormat.format(Date.from(date)) : "";
	        
	    }
	    
	    public static String formatDateToDDMMYYYY(String inputDate) {
	    	
	    	Date date = new Date();
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        System.out.println(inputDate+"\t"+date);  
	    	
	        return ddMMYYSDF.format(date);
	    }

}
