package com.jyx.edu.NewMapper180831.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static final String yyyyMMdd = "yyyyMMdd";
    public static final String yyyyMMddHHmm = "yyyyMMddHHmm";
    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
     
    public static final String _yyyyMMdd = "yyyy-MM-dd";
    public static final String _yyyyMMddHHmm = "yyyy-MM-dd HH:mm";
    public static final String _yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
    public static final String _yyyyMMddHHmmssSSS = "yyyy-MM-dd HH:mm:ss.SSS";
    
    public static final String __yyyyMMdd = "yyyy/MM/dd";
    public static final String __yyyyMMddHHmm = "yyyy/MM/dd HH:mm";
    public static final String __yyyyMMddHHmmss = "yyyy/MM/dd HH:mm:ss";
    
    /**
     * 获取当前月的第一天
     */
    public static Date getFastDateFromMonth(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date date = calendar.getTime();
		return date;
    }
    /**
     * 获取上个月的最后一天
     */
    public static Date getLastDateFromLastMonth(){
    	Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1); 
		calendar.add(Calendar.DATE, -1);
		Date date = calendar.getTime();
		return date;
    }
    /**
     * 获取这个月最后一天
     * @return
     */
    public static Date getLastDateFromMonth(){
    	Calendar calendar = Calendar.getInstance();    
    	calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
        Date date = calendar.getTime();
		return date;
    }
}
