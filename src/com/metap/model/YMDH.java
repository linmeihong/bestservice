package com.metap.model;

import com.metap.util.refrect.UIDesc;
import com.metap.util.refrect.UIParam;
import com.metap.util.refrect.UIType;

public class YMDH {

	@UIDesc(label="年份：",name="year",type=UIType.Spinner,data=UIParam.KEY_YEAR)
	private String year;
	@UIDesc(label="月份：",name="month",type=UIType.Spinner,data=UIParam.KEY_MONTH)
	private String month;
	@UIDesc(label="日  ：",name="day",type=UIType.Spinner,data=UIParam.KEY_DAY)
	private String day;
	@UIDesc(label="时辰：",name="hour",type=UIType.Spinner,data=UIParam.KEY_HOUR)
	private String hour;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(year).append("-").append(month).append("-").append(day).append(" ").append(hour);
		return sb.toString();
	}
	
	
}
