package com.metap.util.refrect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.metap.util.tm.Mountain;

public class UIParam {
	public static final String KEY_YEAR = "KEY_YEAR";
	public static final String KEY_MONTH = "KEY_MONTH";
	public static final String KEY_DAY = "KEY_DAY";
	public static final String KEY_HOUR = "KEY_HOUR";
	public static final String KEY_MOUNTAIN = "KEY_MOUNTAIN";
	public static final String KEY_SCORE = "KEY_SCORE";
	
	private static Map<String, Object> data;
	static{
		init();
	}
	
	private static void init(){
		data = new HashMap<String, Object>();
		List<String> year = new ArrayList<String>();		
		for(int i=1901;i<2099;i++){
			year.add(""+i);
		}
		data.put(KEY_YEAR, year);
		
		List<String> month = new ArrayList<String>();
		for(int i=1;i<=12;i++){
			month.add(String.format("%02d", i));
		}
		data.put(KEY_MONTH, month);
		
		List<String> day = new ArrayList<String>();
		for(int i=1;i<=31;i++){
			day.add(String.format("%02d", i));
		}
		data.put(KEY_DAY, day);
		
		List<String> hour = new ArrayList<String>();
		for (int i = 0; i < 12; i++) {
			int start = i * 2 - 1, end = i * 2 + 1;
			if (start < 0)
				start += 24;
//			hour.add(start + ":00~" + end + ":00");
			hour.add(String.format("%02d", i*2));
		}
		data.put(KEY_HOUR, hour);
		
		List<String> mtList = new ArrayList<String>();
		for(int i=0;i<Mountain.Mountains.length;i++){
			mtList.add(Mountain.Mountains[i]);
		}
		data.put(KEY_MOUNTAIN, mtList);
		
		List<String> scList = new ArrayList<String>();
		for(int i=0;i<10;i++){
			scList.add(""+((i+1)*10));
		}
		data.put(KEY_SCORE, scList);
	}

	public static Object get(String key){
		if(data.containsKey(key)){
			return data.get(key);
		}
		else{
			return null;
		}
	}
}
