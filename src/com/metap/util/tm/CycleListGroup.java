package com.metap.util.tm;

import java.util.ArrayList;
import java.util.List;

public class CycleListGroup<T> {
	private List<CycleList<T>> list = new ArrayList<CycleList<T>>();
	
	public CycleListGroup(){
		
	}
	
	public void add(CycleList<T> cl){
		list.add(cl);
	}
	
	public void goAll(int count){
		for(CycleList<T> cl : list){
			cl.goCycle(count);
		}
	}
}
