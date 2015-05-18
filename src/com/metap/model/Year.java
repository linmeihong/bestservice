package com.metap.model;

import com.metap.util.refrect.UIDesc;
import com.metap.util.refrect.UIParam;
import com.metap.util.refrect.UIType;
import com.metap.util.tm.SixtyCycle;

public class Year {

	@UIDesc(label="Äê·Ý£º",name="year",type=UIType.Spinner,data=UIParam.KEY_YEAR)
	private String year;
	
	public Year(){
		this.year = "2015";
	}
	
	public Year(String year){
		this.year = year;
	}

	public String toString() {
		return year + SixtyCycle.findGanZhiofYear(Integer.parseInt(year));
	}

	public String getYear() {
		return year;
	}
	
	public int getYearInt(){
		return Integer.parseInt(year);
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	
}
