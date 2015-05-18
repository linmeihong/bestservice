package com.metap.util.tm;

import java.util.ArrayList;
import java.util.List;

public class TimeGroup {

	private String id;
	private BaZi baZi;
	private List<String> message;
	
	private List<TimeGroup> list;
	
	public TimeGroup(String id){
		this.id = id;
		list = new ArrayList<TimeGroup>();
	}
	
	public TimeGroup getSubTimeGroupById(String id){
		for(TimeGroup tg : list){
			if(tg.getId().equals(id)){
				return tg;
			}
		}
		
		return null;
	}

	public BaZi getBaZi() {
		return baZi;
	}

	public void setBaZi(BaZi baZi) {
		this.baZi = baZi;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

	public List<TimeGroup> getList() {
		return list;
	}

	public void setList(List<TimeGroup> list) {
		this.list = list;
	}
	
}
