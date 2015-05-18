package com.metap.util.tm;

public class CycleList<T> {

	public enum CycleType{Positive, Negative}
	
	private T[] list;
	private int currentIdx;
	private CycleType ct;
	
	public CycleList(T[] list, int idx)
	{
		this(list,idx,CycleType.Positive);
	}
	
	public CycleList(T[] list, int idx, CycleType ct){
		this.list = list;
		currentIdx = idx;
		this.ct = ct;
	}
	
	public void next(){
		int step = (ct == CycleType.Positive)? 1 : -1;
		currentIdx+=step;
		if(currentIdx < 0)currentIdx += list.length;
		currentIdx = currentIdx%list.length;
	}
	
	public void goCycle(int count){
		int step = ((ct == CycleType.Positive)? 1 : -1);
		step = step * count;
		currentIdx+=step;
		if(currentIdx < 0){
			currentIdx += (Math.abs(currentIdx/list.length) + 1) * list.length;
		}
		
		currentIdx = currentIdx%list.length;
	}
	
	public T getCurrent(){
		return list[currentIdx];
	}
}
