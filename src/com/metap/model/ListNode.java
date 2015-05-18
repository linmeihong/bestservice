package com.metap.model;

import java.util.ArrayList;
import java.util.List;

public class ListNode {

	public String key;
	public Object data;
	public List<ListNode> subList;
	public Class type;
	
	public Class getType() {
		return type;
	}

	public void setType(Class type) {
		this.type = type;
	}

	private static int iteratorIdx;
	
	public ListNode(String key){
		this.key = key;
		subList = new ArrayList<ListNode>();
	}
	
	public ListNode(String key, Class t){
		this.key = key;
		subList = new ArrayList<ListNode>();
		this.type = t;
	}
	
	public ListNode(String key,Object data){
		this.key = key;
		this.data = data;
		subList = new ArrayList<ListNode>();
	}
	
	public int getCount(){
		int count = 0;
		
		if(subList.size() > 0){
			for(ListNode ln : subList){
				count += ln.getCount();
			}
			
			count += 1;
		}
		else{
			count = 1;
		}
		
		return count;
	}
	
	public void add(ListNode ln){
		subList.add(ln);
	}
	
	public void addByParent(String parent, ListNode ln){
		if(key.equals(parent)){
			subList.add(ln);
		}
		else{
			for(ListNode subLn : subList){
				subLn.addByParent(parent, ln);
			}
		}
	}
	
	public ListNode getByKey(String key){
		if(this.key.equals(key)){
			return this;
		}
		else{
			for(ListNode ln : subList){
				ListNode re = ln.getByKey(key);
				if(re != null){
					return re;
				}
			}
		}
		
		return null;
	}
	
	public ListNode getByPosition(int position){
		iteratorIdx = -1;
		return getByPositionImpl(position);
	}
	
	public ListNode getByPositionImpl(int position){
		iteratorIdx++;
		
		if(position == iteratorIdx)
		{
			return this;
		}
		
		for(ListNode ln : subList){
			ListNode re = ln.getByPositionImpl(position);
			if(re != null){
				return re;
			}
		}
			
			return null;
	}
	
	

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if(key != null){
			sb.append(key);
		}
		if(data != null){
			sb.append(" ").append(data.toString());
		}
		
		return sb.toString();
	}

	public List<ListNode> getSubList() {
		return subList;
	}

	public void setSubList(List<ListNode> subList) {
		this.subList = subList;
	}
	
	public boolean isLeaf(){
		return subList.size() == 0;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
