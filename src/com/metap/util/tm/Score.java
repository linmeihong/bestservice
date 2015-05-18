package com.metap.util.tm;

import java.util.ArrayList;
import java.util.List;

public class Score {

	private String title;
	private int score;
	private List<String> info = new ArrayList<String>();
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	public List<String> getInfo() {
		return info;
	}

	public void setInfo(List<String> info) {
		this.info = info;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(title).append(score).append(";");
		for(String str : info){
			sb.append(str).append(" ");
		}
		
		return sb.toString();
	}	
	
	
}
