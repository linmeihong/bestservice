package com.metap.util.tm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BaZi {

	private static Calendar c20140821;
	
	private String timeStr;
	private GanZhi year;
	private GanZhi month;
	private GanZhi day;
	private GanZhi hour;
	private String[] keWX,keDS;
	
	public GanZhi getYear() {
		return year;
	}
	public void setYear(GanZhi year) {
		this.year = year;
	}
	public GanZhi getMonth() {
		return month;
	}
	public void setMonth(GanZhi month) {
		this.month = month;
	}
	public GanZhi getDay() {
		return day;
	}
	public void setDay(GanZhi day) {
		this.day = day;
	}
	public GanZhi getHour() {
		return hour;
	}
	
	public int getHourInt(){
		return TMUtil.findIdx(TMC.Zhi, hour.getZhi()) * 2;
	}
	
	public void setHour(GanZhi hour) {
		this.hour = hour;
	}
	
	public String getTimeStr() {
		return timeStr;
	}
	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}
	public static GanZhi computeGanZhiYear(Calendar c){
		int year = DateUtil.getYear(c);
		JieQiGroup jqg = JieQiGroup.computeChinaJieQi(year);
		while(jqg.compare(c) < 0){
			year--;
			jqg = JieQiGroup.computeChinaJieQi(year);
		}
		
		String result = SixtyCycle.findGanZhiofYear(year);
		GanZhi re = new GanZhi(result);
		return re;
	}
	
	
	public static GanZhi formulaFirstMonthOfYear(GanZhi year){
		int idx = SixtyCycle.findIdx(TMC.Gan, year.getGan());
		if(idx < 0)return null;
		idx = idx % 5;
		String reGan = null;
		switch(idx){
		case 0: reGan = TMC.Gan[2];break;
		case 1: reGan = TMC.Gan[4];break;
		case 2: reGan = TMC.Gan[6];break;
		case 3: reGan = TMC.Gan[8];break;
		case 4: reGan = TMC.Gan[0];break;
		}
		
		return new GanZhi(reGan,TMC.Zhi[2]);
	}
	
	public static GanZhi computeGanZhiMonth(GanZhi year, int idx){
		GanZhi firstMonth = formulaFirstMonthOfYear(year);
		GanZhi re = SixtyCycle.add(firstMonth, idx);
		return re;
	}
	
	public static GanZhi computeGanZhiMonth(Calendar c){
		GanZhi re = null;
		int y = DateUtil.getYear(c);
		JieQiGroup jqg = JieQiGroup.computeChinaJieQi(y);
		while(jqg.compare(c) < 0){
			y--;
			jqg = JieQiGroup.computeChinaJieQi(y);
		}
		
		int idx = jqg.findMonthIndex(c);
		re = computeGanZhiMonth(new GanZhi(SixtyCycle.findGanZhiofYear(y)), idx/2);
		return re;
	}
	
	
	public static GanZhi computeGanZhiDay00(Calendar c){
		if (c20140821 == null) {
			// 字符串转换日期格式  
			DateFormat fmtDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 得到日期格式对象  
			try {
				Date date = fmtDateTime.parse("2014-08-21 00:00:00");
				c20140821 = Calendar.getInstance();
				c20140821.setTime(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				return null;
			}
		}  
		
		long cl = c.getTimeInMillis();
		long cr = c20140821.getTimeInMillis();
		
		long day = (cl - cr)/(1000*3600*24);
		if(cl < cr)day -= 1;
		if(day < 0){
			day += ((Math.abs(day))/((long)60)+1) * 60;
		}
		GanZhi re = new GanZhi (TMC.Gan[(int)(day % 10)] + TMC.Zhi[(int)(day % 12)]);
		return re;
	}
	
	public static GanZhi computeGanZhiDay(Calendar c){
		if (c20140821 == null) {
			// 字符串转换日期格式  
			DateFormat fmtDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 得到日期格式对象  
			try {
				Date date = fmtDateTime.parse("2014-08-20 23:00:00");
				c20140821 = Calendar.getInstance();
				c20140821.setTime(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				return null;
			}
		}  
		
		long cl = c.getTimeInMillis();
		long cr = c20140821.getTimeInMillis();
		
		long day = (cl - cr)/(1000*3600*24);
		if(cl < cr)day -= 1;
		if(day < 0){
			day += ((Math.abs(day))/((long)60)+1) * 60;
		}
		GanZhi re = new GanZhi (TMC.Gan[(int)(day % 10)] + TMC.Zhi[(int)(day % 12)]);
		return re;
	}
	
	public static GanZhi formulaFirstHourOfDay(GanZhi day){
		int idx = SixtyCycle.findIdx(TMC.Gan, day.getGan());
		if(idx < 0)return null;
		idx = idx % 5;
		String reGan = null;
		switch(idx){
		case 0: reGan = TMC.Gan[0];break;
		case 1: reGan = TMC.Gan[2];break;
		case 2: reGan = TMC.Gan[4];break;
		case 3: reGan = TMC.Gan[6];break;
		case 4: reGan = TMC.Gan[8];break;
		}
		
		return new GanZhi(reGan,TMC.Zhi[0]);
	}
	
	private static GanZhi compputeGanZhiHour(Calendar c) {
		GanZhi gz = computeGanZhiDay(c);
		int hour = DateUtil.getHour(c);
		GanZhi re = null;
		if(hour>=23){
			gz = SixtyCycle.add(gz, 1);
			re = formulaFirstHourOfDay(gz);
		}
		else{
			hour = (hour+1)/2;
			GanZhi first = formulaFirstHourOfDay(gz);
			re = SixtyCycle.add(first, hour);
		}
		
		return re;
	}
	
	public static BaZi computeBaZi(String str, String format) throws ParseException{
		SimpleDateFormat sdf = DateUtil.getChinaDateFormat(format);
		Date date = sdf.parse(str);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		return computeBaZi(c);
	}
	
	public static BaZi computeBaZi(Calendar c){		
		BaZi bz = new BaZi();
		bz.setYear(computeGanZhiYear(c));
		bz.setMonth(computeGanZhiMonth(c));
		bz.setDay(computeGanZhiDay(c));
		bz.setHour(compputeGanZhiHour(c));
		String timeStr = DateUtil.formatCal(c);
		bz.setTimeStr(timeStr);
		return bz;
	}
	
	public boolean contains(String s){
		boolean result = false;
		if(year.contains(s)){
			result = true;
		}
		else if(month.contains(s)){
			result = true;
		}
		else if(day.contains(s)){
			result = true;
		}
		else if(hour.contains(s)){
			result = true;
		}
		
		return result;
	}

	public static void main(String[] args) throws ParseException{
//		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = DateUtil.getChinaDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse("2014-08-20 22:00:00");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		BaZi bz = computeBaZi(cal);
		System.out.println(bz.getYear());
		System.out.println(bz.getMonth());
		System.out.println(bz.getDay());
		System.out.println(bz.getHour());
	}
}
