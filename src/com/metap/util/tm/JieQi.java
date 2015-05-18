package com.metap.util.tm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class JieQi {
	public static final String STR_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String jieQi[] = { // ½ÚÆø±í
    	"Á¢´º", "ÓêË®","¾ªÕİ","´º·Ö", "ÇåÃ÷", "¹ÈÓê", "Á¢ÏÄ", "Ğ¡Âú", "Ã¢ÖÖ", "ÏÄÖÁ", "Ğ¡Êî", "´óÊî", "Á¢Çï", "´¦Êî", "°×Â¶",
    			"Çï·Ö", "º®Â¶", "Ëª½µ", "Á¢¶¬", "Ğ¡Ñ©", "´óÑ©", "¶¬ÖÁ", "Ğ¡º®", "´óº®"};
	
	private String name;
	//Time Format:yyyy-MM-dd HH:mm:ss
	private String startTime;
	private String endTime;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public boolean isIn(Calendar c){
		boolean result = false;
		SimpleDateFormat sdf = DateUtil.getChinaDateFormat(STR_TIME_FORMAT);
		try {
			Date st = sdf.parse(startTime);
			Date et = sdf.parse(endTime);
			long ct = c.getTime().getTime();
			long ss = st.getTime();
			long es = et.getTime();
			
			if(ct >= ss && ct < es){
				result = true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Calendar formatCal(String str){
		SimpleDateFormat sdf = DateUtil.getChinaDateFormat(STR_TIME_FORMAT);
		try {
			Date date = sdf.parse(str);
			Calendar c = Calendar.getInstance();
			
			c.setTime(date);
			return c;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
