package com.metap.util.sc;

import com.metap.util.StringUtil;
import com.metap.util.refrect.UIDesc;
import com.metap.util.refrect.UIType;
import com.metap.util.tm.BaZi;
import com.metap.util.tm.Score;
import com.metap.util.tm.TMUtil;

@UIDesc(label="��ɵ�֧�壺",name="",type=UIType.Spinner)
public class Chong implements IScore{

	private BaZi bz;
	public Chong(BaZi bz){
		this.bz = bz;
	}
	public Score getScore() {
		Score score = new Score();
		score.setScore(0);
		score.setTitle("��ɵ�֧��÷�:");
		int count = 0;
		
		StringBuffer sbgan = new StringBuffer();
		sbgan.append(bz.getYear().getGan()).append(bz.getMonth().getGan()).append(bz.getDay().getGan()).append(bz.getHour().getGan());
		StringBuffer sbzhi = new StringBuffer();
		sbzhi.append(bz.getYear().getZhi()).append(bz.getMonth().getZhi()).append(bz.getDay().getZhi()).append(bz.getHour().getZhi());
		
		String s1 = TMUtil.getGanChong(sbgan.toString());
		String s2 = TMUtil.getZhiChong(sbzhi.toString());
		if(StringUtil.isBlank(s1) && StringUtil.isBlank(s2) ){
			score.setScore(100);
		}
		else{
			score.getInfo().add(s1);
			score.getInfo().add(s2);
		}
		
		return score;
	}
	
	
}
