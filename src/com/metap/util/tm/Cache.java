package com.metap.util.tm;

import java.util.HashMap;
import java.util.Map;

public class Cache {

	public static Map<String, Object> cache = new HashMap<String, Object>();
	
	public static JieQiGroup getJieQiGroupByYear(int year){
		JieQiGroup result = null;
		String key = "JieQiGroup"+year;
		if(!cache.containsKey(key)){
			result = JieQiGroup.computeChinaJieQi(year);
			cache.put(key, result);
		}
		else{
			result = (JieQiGroup)cache.get(key);
		}
		
		return result;
	}
}
