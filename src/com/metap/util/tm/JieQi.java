package com.metap.util.tm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class JieQi {
	public static final String STR_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String jieQi[] = { // 节气表
    	"立春", "雨水","惊蛰","春分", "清明", "谷雨", "立夏", "小满", "芒种", "夏至", "小暑", "大暑", "立秋", "处暑", "白露",
    			"秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至", "小寒", "大寒"};
	
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
