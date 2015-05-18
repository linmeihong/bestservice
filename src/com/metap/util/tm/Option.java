package com.metap.util.tm;

import com.metap.util.refrect.UIDesc;
import com.metap.util.refrect.UIParam;
import com.metap.util.refrect.UIType;

public class Option {

	@UIDesc(label="±È·Ö£º",name="score",type=UIType.Spinner,data=UIParam.KEY_SCORE)
	private String score;
	@UIDesc(label="¿¼ÂÇ£º",name="search",type=UIType.CheckBox)
	private Boolean search;
	
	public Option(){
		score = "50";
		search = true;
	}
	
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Boolean getSearch() {
		return search;
	}
	public void setSearch(Boolean search) {
		this.search = search;
	}	
	
}
