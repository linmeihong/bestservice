package com.metap.util.sc;

import java.util.List;

import com.metap.model.Year;
import com.metap.util.refrect.UIDesc;
import com.metap.util.refrect.UIType;
import com.metap.util.tm.BaZi;
import com.metap.util.tm.Score;
import com.metap.util.tm.SixtyCycle;
import com.metap.util.tm.TMUtil;
@UIDesc(label="������",name="",type=UIType.Spinner)
public class NianMing implements IScore{
	private List<Year> list;
	private BaZi bz;
	
	public NianMing(List<Year> list, BaZi bz){
		this.list = list;
		this.bz = bz;
	}

	public Score getScore() {
		// TODO Auto-generated method stub
		Score s = new Score();
		s.setTitle("�����壺");
		StringBuffer sbgan = new StringBuffer();
		sbgan.append(bz.getYear().getGan()).append(bz.getMonth().getGan()).append(bz.getDay().getGan()).append(bz.getHour().getGan());
		StringBuffer sbzhi = new StringBuffer();
		sbzhi.append(bz.getYear().getZhi()).append(bz.getMonth().getZhi()).append(bz.getDay().getZhi()).append(bz.getHour().getZhi());
		
		int sc = 100;
		
		for(Year year : list){
			String ganzhi = SixtyCycle.findGanZhiofYear(year.getYearInt());
			if(TMUtil.isGanChong(""+ganzhi.charAt(0), sbgan.toString())){
				sc = 0;
			}
			
			if(TMUtil.isZhiChong(""+ganzhi.charAt(1), sbzhi.toString())){
				sc = 0;
			}
		}
		
		s.setScore(sc);
		return s;
	}
}
