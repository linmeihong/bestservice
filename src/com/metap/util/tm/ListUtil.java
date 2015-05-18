package com.metap.util.tm;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

	public static List<String> merge(List<String>l1, List<String> l2){
		List<String> list = new ArrayList<String>();
		int idx = 0;
		for(String str : l1){
			if(!"ENTER".equals(str)){
				list.add(str);
			}
			else{
				if(idx < l2.size()){
					String s2 = l2.get(idx);
					while(!"ENTER".equals(s2)){
						list.add(s2);
						idx++;
						s2 = l2.get(idx);
					}
					
					if("ENTER".equals(s2)){
						idx++;
					}
				}
				
				list.add(str);
			}
		
		}
		
		while(idx < l2.size()){
			list.add(l2.get(idx));
			idx ++;
		}
		
		return list;
	}
	
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
		list.add("11");list.add("ENTER");list.add("21");//list.add("ENTER");
		List<String> l2 = new ArrayList<String>();
		l2.add("12");l2.add("ENTER");l2.add("22");l2.add("ENTER");
		l2.add("31");
		
		List<String> l3 = merge(list, l2);
		for(String str : l3){
			if("ENTER".equals(str)){
				System.out.println();
			}
			else{
				System.out.print(str);
				System.out.print("\t");
			}
		}
	}
}
