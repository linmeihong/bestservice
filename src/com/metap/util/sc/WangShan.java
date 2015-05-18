package com.metap.util.sc;

import com.metap.util.refrect.UIDesc;
import com.metap.util.refrect.UIType;
import com.metap.util.tm.BaZi;
import com.metap.util.tm.Mountain;
import com.metap.util.tm.Score;
import com.metap.util.tm.TMC;
import com.metap.util.tm.TMUtil;

@UIDesc(label="旺山：",name="WangShan",type=UIType.Spinner)
public class WangShan implements IScore{

	private Mountain mt;
	private BaZi bz;
	private boolean[] isWang;
	public WangShan(Mountain m, BaZi bz){
		this.mt = m;
		this.bz = bz;
		isWang = new boolean[8];
	}
	
	public Score getScore(){
		Score score = new Score();
		score.setTitle("旺山分数：");
		int idx = 0;
		isWang[idx++] = TMUtil.isYinBi(mt.getShan(), bz.getYear().getGan());
		isWang[idx++] = TMUtil.isYinBi(mt.getShan(), bz.getMonth().getGan());
		isWang[idx++] = TMUtil.isYinBi(mt.getShan(), bz.getDay().getGan());
		isWang[idx++] = TMUtil.isYinBi(mt.getShan(), bz.getHour().getGan());
		isWang[idx++] = TMUtil.isYinBi(mt.getShan(), bz.getYear().getZhi());
		isWang[idx++] = TMUtil.isYinBi(mt.getShan(), bz.getMonth().getZhi());
		isWang[idx++] = TMUtil.isYinBi(mt.getShan(), bz.getDay().getZhi());
		isWang[idx++] = TMUtil.isYinBi(mt.getShan(), bz.getHour().getZhi());
		
		int totalCount = 0;
		for(int i=0;i<isWang.length;i++){
			if(isWang[i]){
				totalCount++;
			}
		}
		if(TMC.WuXing.containsKey(mt.getShan())){
			String s = TMC.WuXing.get(mt.getShan());
			if(TMC.ShanHe.containsKey(s)){
				String sh = TMC.ShanHe.get(s);
				int count=0;
				String str = bz.getYear().getZhi()+bz.getMonth().getZhi()+bz.getDay().getZhi()+bz.getHour().getZhi();
				for(int i=0;i<sh.length();i++){
					if(str.contains(""+sh.charAt(i))){
						count++;
					}
				}
				
				if(count > 1){
					score.getInfo().add(sh+"增加比分"+(count*10));
				}
				
				totalCount += count;
			}
		}
		
		if(TMUtil.isYinBi(mt.getShan(), bz.getMonth().getZhi())){
			totalCount += 5;
			score.getInfo().add("月令增加比分50");
		}
		
		score.setScore(totalCount * 10);
		return score;
	}
	
	public static void main(String[] args){
		String str = "aaa中国人";
		for(int i=0;i<str.length();i++){
			System.out.println(str.charAt(i));
		}
	}
}
