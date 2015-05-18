package com.metap.util.sc;

import com.metap.util.refrect.UIDesc;
import com.metap.util.refrect.UIType;
import com.metap.util.tm.BaZi;
import com.metap.util.tm.Mountain;
import com.metap.util.tm.Score;
import com.metap.util.tm.TMC;
import com.metap.util.tm.TMUtil;

@UIDesc(label="���µ£�",name="",type=UIType.Spinner)
public class TianYueDe implements IScore{

	private Mountain mt;
	private BaZi bz;
	
	public TianYueDe(Mountain mt, BaZi bz){
		this.mt = mt;
		this.bz = bz;
	}
	public Score getScore() {
		Score score = new Score();
		score.setTitle("���µµ÷֣�");
		int idx = TMUtil.findIdx(TMC.Zhi, bz.getMonth().getZhi());
		String td = TMC.TianDe[idx];
		String[] yuede = {"��","��","��","��"};
		String yd = yuede[idx%4];
		
		if(mt.contains(td) || bz.contains(td)){
			score.setScore(100);
			if(score.getScore() > 0){
				score.getInfo().add("���"+td);
			}
		}
		else if(mt.contains(yd) || mt.contains(yd)){
			score.setScore(score.getScore()+100);
			if(score.getScore() > 0){
				score.getInfo().add("�µ�"+td);
			}
		}
		
		return score;
	}

}
