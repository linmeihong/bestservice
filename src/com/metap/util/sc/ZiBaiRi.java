package com.metap.util.sc;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.metap.util.tm.BaZi;
import com.metap.util.tm.DateUtil;
import com.metap.util.tm.GanZhi;
import com.metap.util.tm.JieQi;
import com.metap.util.tm.JieQiGroup;
import com.metap.util.tm.Mountain;
import com.metap.util.tm.SixtyCycle;
import com.metap.util.tm.TMC;
import com.metap.util.tm.TMUtil;

public class ZiBaiRi {
	public static final int[] ZiBaiRi_START = {0,6,3,8,2,5,0}; //{1,7,4,9,3,6,1}; 
	public static final int[] ZiBaiRi_STEP = {1,1,1,-1,-1,-1,1};
	private Mountain mt;
	private BaZi bz;
	private JieQiGroup jqg;
	public ZiBaiRi(Mountain mt, BaZi bz){
		this.mt = mt;
		this.bz = bz;
		jqg = TMUtil.getJieQiGroup(bz);
	}
	
	public static String getZiBai(BaZi bz){		
		int idx0 = TMUtil.findIdx(TMC.Zhi, bz.getMonth().getZhi());
		int idx = (idx0 - 2 + 12) % 12;
		int idxJQ = idx * 2;
		JieQiGroup jqg = TMUtil.getJieQiGroup(bz);
		JieQi jq = jqg.getList().get(idxJQ);
		Calendar cal = JieQi.formatCal(jq.getStartTime());
		DateUtil.resetHHmmss(cal);
		System.out.println(DateUtil.formatCal(cal));
		GanZhi gz = BaZi.computeGanZhiDay(cal);
		int count = SixtyCycle.sub(bz.getDay(), gz);
		cal.add(Calendar.DAY_OF_YEAR, count);
		
		int year = DateUtil.getYear(cal);
		List<Calendar> list = TMUtil.findJiaZi(year);
		int ti=0;
		for(int i=0;i<list.size();i++){
			if(DateUtil.compare(list.get(i), cal) > 0){
				System.out.println(DateUtil.formatCal(list.get(i))+" "+DateUtil.formatCal(cal));
				ti = i - 1;
				break;
			}
		}
		
		if(ti < 0){
			return "";
		}		
		
		int tc = SixtyCycle.sub(bz.getDay(), new GanZhi("甲","子"));
		int total = ZiBaiRi_START[ti] + ZiBaiRi_STEP[ti] * tc;
		
		if(total < 0){
			total += (Math.abs(total)/9+1) * 9;
		}
		
		total = total % 9;
		
		return TMC.ChineseNumber[total]+TMC.JiuXing[total];
	}	
	
	public static List<String> getZiBaiList(BaZi bz){
		List<String> result = new ArrayList<String>();
		int idx0 = TMUtil.findIdx(TMC.Zhi, bz.getMonth().getZhi());
		int idx = (idx0 - 2 + 12) % 12;
		int idxJQ = idx * 2;
		JieQiGroup jqg = TMUtil.getJieQiGroup(bz);
		JieQi jq = jqg.getList().get(idxJQ);
		Calendar cal = JieQi.formatCal(jq.getStartTime());
		DateUtil.resetHHmmss(cal);
		System.out.println(DateUtil.formatCal(cal));
		GanZhi gz = BaZi.computeGanZhiDay(cal);
		int count = SixtyCycle.sub(bz.getDay(), gz);
		cal.add(Calendar.DAY_OF_YEAR, count);
		
		int year = DateUtil.getYear(cal);
		List<Calendar> list = TMUtil.findJiaZi(year);
		int ti=0;
		for(int i=0;i<list.size();i++){
			if(DateUtil.compare(list.get(i), cal) > 0){
				System.out.println(DateUtil.formatCal(list.get(i))+" "+DateUtil.formatCal(cal));
				ti = i - 1;
				break;
			}
		}
		
		if(ti < 0){
			return result;
		}		
		
		int tc = SixtyCycle.sub(bz.getDay(), new GanZhi("甲","子"));
		int total = ZiBaiRi_START[ti] + ZiBaiRi_STEP[ti] * tc;
		
		if(total < 0){
			total += (Math.abs(total)/9+1) * 9;
		}
		
		total = total % 9;
		
		result.add(TMC.ChineseNumber[total]+TMC.JiuXing[total]);
		int[] zibai = new int[9];
		
		for(int i=0;i<9;i++){
			int si = i + 4;
			zibai[(si)%9] = total + 1;
			total = (total + ZiBaiRi_STEP[ti]) % 9;
			if(total < 0){
				total += 9;
			}
		}		
		
		result.add(""+zibai[3]+""+zibai[8]+""+zibai[1]);//492
		result.add(""+zibai[2]+""+zibai[4]+""+zibai[6]);//357
		result.add(""+zibai[7]+""+zibai[0]+""+zibai[5]);//816
		return result;
	}	
	
	
	public static List<String> getZiBaiListShort(BaZi bz){
		List<String> result = new ArrayList<String>();
		int idx0 = TMUtil.findIdx(TMC.Zhi, bz.getMonth().getZhi());
		int idx = (idx0 - 2 + 12) % 12;
		int idxJQ = idx * 2;
		JieQiGroup jqg = TMUtil.getJieQiGroup(bz);
		JieQi jq = jqg.getList().get(idxJQ);
		Calendar cal = JieQi.formatCal(jq.getStartTime());
		DateUtil.resetHHmmss(cal);
		System.out.println(DateUtil.formatCal(cal));
		GanZhi gz = BaZi.computeGanZhiDay(cal);
		int count = SixtyCycle.sub(bz.getDay(), gz);
		cal.add(Calendar.DAY_OF_YEAR, count);
		
		int year = DateUtil.getYear(cal);
		List<Calendar> list = TMUtil.findJiaZi(year);
		int ti=0;
		for(int i=0;i<list.size();i++){
			if(DateUtil.compare(list.get(i), cal) > 0){
				System.out.println(DateUtil.formatCal(list.get(i))+" "+DateUtil.formatCal(cal));
				ti = i - 1;
				break;
			}
		}
		
		if(ti < 0){
			return result;
		}		
		
		int tc = SixtyCycle.sub(bz.getDay(), new GanZhi("甲","子"));
		int total = ZiBaiRi_START[ti] + ZiBaiRi_STEP[ti] * tc;
		
		if(total < 0){
			total += (Math.abs(total)/9+1) * 9;
		}
		
		total = total % 9;
		
//		result.add(TMC.ChineseNumber[total]+TMC.JiuXing[total]);
		int[] zibai = new int[9];
		
		for(int i=0;i<9;i++){
			int si = i + 4;
			zibai[(si)%9] = total;
			total = (total + ZiBaiRi_STEP[ti]) % 9;
			total = TMUtil.toPosivite(total, 9);
		}		
		
		result.add("紫白");result.add("日");result.add("家");result.add("ENTER");
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
	
	public static List<String> getZiBaiListAll(BaZi bz){
		List<String> result = new ArrayList<String>();
		int idx0 = TMUtil.findIdx(TMC.Zhi, bz.getMonth().getZhi());
		int idx = (idx0 - 2 + 12) % 12;
		int idxJQ = idx * 2;
		JieQiGroup jqg = TMUtil.getJieQiGroup(bz);
		JieQi jq = jqg.getList().get(idxJQ);
		Calendar cal = JieQi.formatCal(jq.getStartTime());
		DateUtil.resetHHmmss(cal);
		System.out.println(DateUtil.formatCal(cal));
		GanZhi gz = BaZi.computeGanZhiDay(cal);
		int count = SixtyCycle.sub(bz.getDay(), gz);
		cal.add(Calendar.DAY_OF_YEAR, count);
		
		int year = DateUtil.getYear(cal);
		List<Calendar> list = TMUtil.findJiaZi(year);
		int ti=0;
		for(int i=0;i<list.size();i++){
			if(DateUtil.compare(list.get(i), cal) > 0){
				System.out.println(DateUtil.formatCal(list.get(i))+" "+DateUtil.formatCal(cal));
				ti = i - 1;
				break;
			}
		}
		
		if(ti < 0){
			return result;
		}		
		
		int tc = SixtyCycle.sub(bz.getDay(), new GanZhi("甲","子"));
		int total = ZiBaiRi_START[ti] + ZiBaiRi_STEP[ti] * tc;
		
		if(total < 0){
			total += (Math.abs(total)/9+1) * 9;
		}
		
		total = total % 9;
		
//		result.add(TMC.ChineseNumber[total]+TMC.JiuXing[total]);
		int[] zibai = new int[9];
		
		for(int i=0;i<9;i++){
			int si = i + 4;
			zibai[(si)%9] = total;
			total = (total + ZiBaiRi_STEP[ti]) % 9;
			if(total < 0){
				total += 9;
			}
		}		
		
		result.add(TMC.jiuGongZhongChs(3)+TMC.jiuXingChs(zibai[3]));
		result.add(TMC.jiuGongZhongChs(8)+TMC.jiuXingChs(zibai[8]));
		result.add(TMC.jiuGongZhongChs(1)+TMC.jiuXingChs(zibai[1]));result.add("ENTER");
		result.add(TMC.jiuGongZhongChs(2)+TMC.jiuXingChs(zibai[2]));
		result.add(TMC.jiuGongZhongChs(4)+TMC.jiuXingChs(zibai[4]));
		result.add(TMC.jiuGongZhongChs(6)+TMC.jiuXingChs(zibai[6]));result.add("ENTER");
		result.add(TMC.jiuGongZhongChs(7)+TMC.jiuXingChs(zibai[7]));
		result.add(TMC.jiuGongZhongChs(0)+TMC.jiuXingChs(zibai[0]));
		result.add(TMC.jiuGongZhongChs(5)+TMC.jiuXingChs(zibai[5]));result.add("ENTER");
		return result;
	}	
	

	
	public static void main(String[] args){
		String str = "2015-04-18 00:00:00";
		Calendar cal = JieQi.formatCal(str);
		System.out.println(DateUtil.getYear(cal));
		List<String> list = getZiBaiList(BaZi.computeBaZi(cal));
		for(String s : list){
			System.out.println(s);
		}
	}
}
