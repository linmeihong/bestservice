package com.metap.util.tm;

public class GanZhi {
	private String gan;
	private String zhi;
	
	public GanZhi(String gan, String zhi){
		this.gan = gan;
		this.zhi = zhi;
	}
	
	public GanZhi(String ganzhi){
		if(ganzhi.length()==2){
			gan = ganzhi.substring(0,1);
			zhi = ganzhi.substring(1);
		}
	}

	public String getGan() {
		return gan;
	}

	public void setGan(String gan) {
		this.gan = gan;
	}

	public String getZhi() {
		return zhi;
	}

	public void setZhi(String zhi) {
		this.zhi = zhi;
	}

	@Override
	public String toString() {
		return gan+zhi;
	}

	public boolean contains(String s) {
		boolean result = false;
		if(gan.contains(s) || zhi.contains(s)){
			result = true;
		}
		
		return result;
	}
	
	
}
