package com.metap.util.sc;

import com.metap.util.refrect.UIDesc;
import com.metap.util.refrect.UIType;
import com.metap.util.tm.BaZi;
import com.metap.util.tm.Score;
import com.metap.util.tm.TMUtil;

@UIDesc(label="生化：",name="",type=UIType.Spinner)
public class ShengHua implements IScore{

	public boolean[] gan,zhi,ganZhi,isYinBi;
	private BaZi baZi;
	public ShengHua(BaZi bz){
		this.baZi = bz;
		gan = new boolean[3];
		zhi = new boolean[3];
		ganZhi = new boolean[4];
		isYinBi = new boolean[10];
	}
	
	public Score getScore(){
		Score score = new Score();
		score.setTitle("生化分数：");
		int idx = 0;
		isYinBi[idx++] = gan[0] = TMUtil.isXSTS_He(baZi.getYear().getGan(), baZi.getMonth().getGan());
		isYinBi[idx++] = gan[1] = TMUtil.isXSTS_He(baZi.getMonth().getGan(), baZi.getDay().getGan());
		isYinBi[idx++] = gan[2] = TMUtil.isXSTS_He(baZi.getDay().getGan(), baZi.getHour().getGan());
		
		
		
		isYinBi[idx++] = zhi[0] = TMUtil.isXSTS_He(baZi.getYear().getZhi(), baZi.getMonth().getZhi());
		isYinBi[idx++] = zhi[1] = TMUtil.isXSTS_He(baZi.getMonth().getZhi(), baZi.getDay().getZhi());
		isYinBi[idx++] = zhi[2] = TMUtil.isXSTS_He(baZi.getDay().getZhi(), baZi.getHour().getZhi());
		
		isYinBi[idx++] = ganZhi[0] = TMUtil.isXSTS_He(baZi.getYear().getGan(), baZi.getYear().getZhi());
		isYinBi[idx++] = ganZhi[1] = TMUtil.isXSTS_He(baZi.getMonth().getGan(), baZi.getMonth().getZhi());
		isYinBi[idx++] = ganZhi[2] = TMUtil.isXSTS_He(baZi.getDay().getGan(), baZi.getDay().getZhi());
		isYinBi[idx++] = ganZhi[3] = TMUtil.isXSTS_He(baZi.getHour().getGan(), baZi.getHour().getZhi());
		
		
		int count = 0;
		for(int i=0;i<isYinBi.length;i++){
			if(isYinBi[i]){
				count++;
			}
		}
		
		score.setScore(count*10);
		return score;
	}
}
