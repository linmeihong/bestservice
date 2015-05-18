package com.metap.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.metap.model.Year;
//import com.metap.ui.Binder;
import com.metap.util.sc.Chong;
import com.metap.util.sc.DouShouKe;
import com.metap.util.sc.IScore;
import com.metap.util.sc.NianMing;
import com.metap.util.sc.ShengHua;
import com.metap.util.sc.TianYueDe;
import com.metap.util.sc.WangShan;
import com.metap.util.sc.WuXingKe;
import com.metap.util.tm.BaZi;
import com.metap.util.tm.Mountain;
import com.metap.util.tm.Option;
import com.metap.util.tm.Score;

public class ScoreGroup {

	private Mountain mt;
	private BaZi bz;
	private List<Year> nianMing;
	private Map<String, IScore> scoreMap = new HashMap<String, IScore>();
	public ScoreGroup(Mountain mt, BaZi bz,List<Year> nm){
		this.mt = mt;
		this.bz = bz;
		this.nianMing = nm;
		init();
	}
	
	public void init(){		
		scoreMap.put(ShengHua.class.toString(), new ShengHua(bz));
		scoreMap.put(WangShan.class.toString(), new WangShan(mt,bz));
		scoreMap.put(Chong.class.toString(),new Chong(bz));
		scoreMap.put(TianYueDe.class.toString(), (new TianYueDe(mt, bz)));
		scoreMap.put(DouShouKe.class.toString(), new DouShouKe(mt, bz));
		scoreMap.put(WuXingKe.class.toString(), new WuXingKe(mt, bz));
		scoreMap.put(NianMing.class.toString(), new NianMing(nianMing, bz));
	}
	
//	public boolean checkOption(Map<String, Binder> map){
//		boolean result = true;
//		for(Binder binder : map.values()){
//			if(binder.getData() instanceof Option){
//				Option option = (Option)binder.getData();
//				if(option.getSearch()){
//					String key = binder.getType().toString();
//					IScore score = scoreMap.get(key);
//					Score s = score.getScore();
//					if(s.getScore() < Integer.parseInt(option.getScore())){
//						result = false;
//						break;
//					}
//				}
//			}
//			
//		}
//		
//		return result;
//	}
	
	public List<String> getScoreInfo(){
		List<String> result = new ArrayList<String>();
		for(IScore score : scoreMap.values()){
			Score s = score.getScore();
			result.add(s.toString());
		}
		
		return result;
	}
}
