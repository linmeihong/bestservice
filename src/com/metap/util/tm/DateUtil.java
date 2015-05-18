package com.metap.util.tm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	public static final String STR_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
	public static SimpleDateFormat getChinaDateFormat(String template){
		return new SimpleDateFormat(template,Locale.CHINA);
	}
	
	public static int getYear(Calendar c){
		int year = 1900;
		SimpleDateFormat sdf = getChinaDateFormat("yyyy");
		String str = sdf.format(c.getTime());
		year = Integer.parseInt(str);
		return year;
	}
	
	public static int getHour(Calendar c){
		int hour = 1900;
		SimpleDateFormat sdf = getChinaDateFormat("HH");
		String str = sdf.format(c.getTime());
		hour = Integer.parseInt(str);
		return hour;
	}

	public static long compare(Calendar cs, Calendar ce) {
		return (cs.getTimeInMillis() - ce.getTimeInMillis());
	}

	public static String formatCal(Calendar cal) {
		SimpleDateFormat sdf = getChinaDateFormat(STR_TIME_FORMAT);
		return sdf.format(cal.getTime());
	}
	
	public static Calendar parseCal(String str){
		Calendar re = Calendar.getInstance();
		SimpleDateFormat sdf = getChinaDateFormat(STR_TIME_FORMAT);
		try {
			Date date = sdf.parse(str);		
			re.setTime(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	public static void resetHHmmss(Calendar cal) {
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
	}
}
