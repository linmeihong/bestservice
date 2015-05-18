package com.metap.util.sc;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.metap.util.tm.BaZi;
import com.metap.util.tm.DateUtil;
import com.metap.util.tm.JieQiGroup;
import com.metap.util.tm.Mountain;
import com.metap.util.tm.TMC;
import com.metap.util.tm.TMUtil;

public class ZiBaiShi {

	private static int[] TYPE= {0,3,6,8,5,2};
	private Mountain mt;
	private BaZi bz;
	private JieQiGroup jqg;
	public ZiBaiShi(Mountain mt, BaZi bz){
		this.mt = mt;
		this.bz = bz;
	}
	
	public static List<String> getZiBaiShi(BaZi bz){
		List<String> result = new ArrayList<String>();
		JieQiGroup jqg = TMUtil.getJieQiGroup(bz);
		Calendar cal = DateUtil.parseCal(bz.getTimeStr());
		
		int type = TMUtil.findIdx(TMC.Zhi, bz.getDay().getZhi()) % 3;
		int step = 1;
		if(jqg.isXiaZhi(cal)){
			type += 3;
			step = -1;
		}
		
		int si = TMUtil.findIdx(TMC.Zhi, bz.getHour().getZhi());
		int total = type + si * step;
		
		total = TMUtil.toPosivite(total, 9);
		
		int[] zibai = new int[9];
		
		for(int i=0;i<9;i++){
			int tsi = i + 4;
			zibai[(tsi)%9] = total;
			total = (total + step) % 9;
			total = TMUtil.toPosivite(total, 9);
		}		
		
		result.add("×Ï°×");result.add("Ê±");result.add("¼Ò");result.add("ENTER");
		result.add(TMC.JiuGongZhang[3]+TMC.ChineseNumber[zibai[3]]);
		result.add(TMC.JiuGongZhang[8]+TMC.ChineseNumber[zibai[8]]);
		result.add(TMC.JiuGongZhang[1]+TMC.ChineseNumber[zibai[1]]);result.add("ENTER");
		result.add(TMC.JiuGongZhang[2]+TMC.ChineseNumber[zibai[2]]);
		result.add(TMC.JiuGongZhang[4]+TMC.ChineseNumber[zibai[4]]);
		result.add(TMC.JiuGongZhang[6]+TMC.ChineseNumber[zibai[6]]);result.add("ENTER");
		result.add(TMC.JiuGongZhang[7]+TMC.ChineseNumber[zibai[7]]);
		result.add(TMC.JiuGongZhang[0]+TMC.ChineseNumber[zibai[0]]);
		result.add(TMC.JiuGongZhang[5]+TMC.ChineseNumber[zibai[5]]);result.add("ENTER");
		return result;
	}
}
