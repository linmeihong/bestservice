package com.metap.util.tm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.metap.util.tm.CycleList.CycleType;

public class TMUtil {
	public static int toPosivite(int target, int mode){
		int result = target;
		if(target < 0){
			result = target + ((-target)/mode + 1)*mode;
		}
		
		result = result % mode;
		return result;
	}
	
    public static String getChangSheng4(String jinmushuihuotu){
    	String re = null;
//    	System.out.println(jinmushuihuotu);
    	if(TMC.ChangSheng4.containsKey(jinmushuihuotu)){
    		re = TMC.ChangSheng4.get(jinmushuihuotu);
    	}
    	
    	return re;
    }
    
    public static String getTianGuanFu(String year, String month){
    	int idx = findIdx(TMC.Zhi,year);
    	String cs4 = getChangSheng4(TMC.ZhiWuXing3[idx]);
//    	System.out.println(cs4);
    	CycleList<String> clJGZ = new CycleList<String>(TMC.JiuGongZhang, 4);
    	int count = findIdx(TMC.Zhi,cs4) + 3 - findIdx(TMC.Zhi,month);//临官位+3
    	if(count < 0)count += TMC.Zhi.length;
    	count = count % TMC.Zhi.length;
    	clJGZ.goCycle(count);
    	
    	String result = clJGZ.getCurrent();
    	return result;
    }
    
    public static String get3Shan(String bagua){
    	return null;
    }
    
    public static String getDiGuanFu(String year, String month){
    	int idx = findIdx(TMC.Zhi,year);
    	CycleList<String> cl = new CycleList<String>(TMC.Zhi, idx);
    	cl.goCycle(4);//建+4->定
    	String target = cl.getCurrent();
    	idx = findIdx(TMC.Zhi,target);
    	
    	CycleList<String> clJGZ = new CycleList<String>(TMC.JiuGongZhang, 4);
    	int count = idx - findIdx(TMC.Zhi,month);
    	if(count < 0)count += TMC.Zhi.length;
    	count = count % TMC.Zhi.length;
    	clJGZ.goCycle(count);
    	
    	String result = clJGZ.getCurrent();
    	return result;
    }
    
    public static String getWuHuangSha(String year, String month){
    	int idx = findIdx(TMC.Zhi,year);
    	idx = idx % 3;
    	int start = 8;
    	switch(idx){
    	case 0:
    		start = 7;break;
    	case 1:
    		start = 4;break;
    	case 2:
    		start = 1;break;
    	}
    	
    	idx = findIdx(TMC.Zhi,month);
    	int count = idx - 2;
    	if(count < 0) count = count + 12;
    	start = start - count;
    	if(start < 0){
    		start += 9;
    		if(start < 0) start += 9;
    	}
    	
    	count = 4 - start;
    	if(count < 0){
    		count += 9;
    	}
    	
    	CycleList<String> clJGZ = new CycleList<String>(TMC.JiuGongZhang, 4);
    	clJGZ.goCycle(count);
    	String result = clJGZ.getCurrent();
    	return result;
    }
    
    public static String getDaYueJian(String year, String month)
    {
    	int idx = findIdx(TMC.Zhi,year);
    	idx = idx % 3;
    	int start = 8;
    	switch(idx){
    	case 0:
    		start = 7;break;
    	case 1:
    		start = 4;break;
    	case 2:
    		start = 1;break;
    	}
    	
    	CycleList<String> clJGZ = new CycleList<String>(TMC.JiuGongZhang, start,CycleType.Negative);
    	idx = findIdx(TMC.Zhi,month);
    	int count = idx - 2;
    	if(count < 0) count = count + 12;
    	clJGZ.goCycle(count);
    	String result = clJGZ.getCurrent();
    	return result;
    }
    
    public static String getXiaoYueJian(String year, String month)
    {
    	int idx = findIdx(TMC.Zhi,year);
    	int start = 8;
    	if(idx%2 == 0){
    		start = 4;
    	}
    	
    	idx = findIdx(TMC.Zhi,month);
    	int count = idx - 2;
    	if(count < 0) count = count + 12;
    	CycleList<String> clJGZ = new CycleList<String>(TMC.JiuGongZhang, start);
    	clJGZ.goCycle(count);
    	String result = clJGZ.getCurrent();
    	return result;
    }
    
    public static boolean isSanSHa(String zhi, String shanXiang){
    	String sanShan = getSanSha(zhi);
    	return sanShan.contains(shanXiang);
    }
    
    public static String getSanSha(String zhi){
    	int idx = findIdx(TMC.Zhi,zhi);
    	String wx3 = TMC.ZhiWuXing3[idx];
    	String result = TMC.SanSha.get(wx3);
    	
    	return result;
    }
    
    
    public static int findIdx(String[] data, String in){
    	for(int i=0;i<data.length;i++){
    		if(data[i].equals(in)){
    			return i;
    		}
    	}
    	
    	return -1;
    }
    
    public static boolean isGanChong(String s1, String s2){
    	boolean result = false;
    	
    	int i1 = findIdx(TMC.Gan, s1);
    	int i2 = findIdx(TMC.Zhi, s2);
    	int sub = Math.abs(i1 - i2);
    	if(sub == 6){
    		result = true;
    	}
    	
    	return result;
    }
    
    public static boolean isZhiChong(String s1, String s2){
    	boolean result = false;
    	
    	int i1 = findIdx(TMC.Zhi, s1);
    	int i2 = findIdx(TMC.Zhi, s2);
    	int sub = Math.abs(i1 - i2);
    	if(sub == 6){
    		result = true;
    	}
    	
    	return result;
    }
    
    public static boolean isYinBi(String zhu, String ke){
    	boolean result = false;
    	
    	if(TMC.WuXing.containsKey(zhu) && TMC.WuXing.containsKey(ke)){
    		String z = TMC.WuXing.get(zhu);
        	String k = TMC.WuXing.get(ke);
        	
        	int iz = findIdx(TMC.WX, z);
        	int ik = findIdx(TMC.WX, k);
        	int sub = ik - iz;
        	if(sub == 0 || sub == -1 || sub == 3){
        		result = true;
        	}
    	}
    	
    	return result;
    }
    
    public static boolean isXSTS_He(String zhu, String ke){
    	boolean result = isXiangShengTongShu(zhu, ke);
    	if(!result){
    		result = isGanHe(zhu, ke);
    	}
    	if(!result){
    		result = isZhiHe(zhu,ke);
    	}
    	
    	return result;
    }
    
    public static boolean isXiangShengTongShu(String zhu, String ke){
    	boolean result = false;
    	
    	if(TMC.WuXing.containsKey(zhu) && TMC.WuXing.containsKey(ke)){
    		String z = TMC.WuXing.get(zhu);
        	String k = TMC.WuXing.get(ke);
        	
        	int iz = findIdx(TMC.WX, z);
        	int ik = findIdx(TMC.WX, k);
        	int sub = Math.abs(ik - iz);
        	if(sub != 2 && sub != 3){
        		result = true;
        	}
    	}
    	
    	return result;
    }
    
    public static String getWuShen(String zhu, String ke){
    	String result = null;
    	String[] strs = new String[]{"金","水","木","火","土"};
    	String[] data = new String[]{"孙","才","官","印","兄","孙","才","官","印"};
    	
    	int iz = findIdx(strs, zhu);
    	int ik = findIdx(strs, ke);
    	
    	int sub = ik - iz;
    	result = data[sub + 4];
    	return result;
    }
    
    /**
     * 甲己合
     * @param g1
     * @param g2
     * @return
     */
    public static boolean isGanHe(String g1, String g2){
    	boolean result = false;
    	int idx1 = findIdx(TMC.Gan,g1);
    	if(idx1<0)return result;
    	int idx2 = findIdx(TMC.Gan,g2);
    	if(idx2<0)return result;
    	int sub = idx1 - idx2;
    	sub += 10;
    	if(sub % 5 == 0){
    		result = true;
    	}
    	
    	return result;
    }
    
    /**
     * 
     * @param z1
     * @param z2
     * @return
     */
    public static boolean isZhiHe(String z1, String z2){
    	boolean result = false;
    	int idx1 = findIdx(TMC.Zhi,z1);
    	if(idx1<0)return result;
    	int idx2 = findIdx(TMC.Zhi,z2);
    	if(idx2<0)return result;
    	
    	int add = idx1 + idx2;
    	if(add == 1 || add == 13){
    		result = true;
    	}    	
    	
    	return result;
    }
    
    public static String getWuShenWX(String zhu, String ke)
    {
    	if(!TMC.WuXing.containsKey(zhu) || !TMC.WuXing.containsKey(ke)){
    		return null;
    	}
    	String z = TMC.WuXing.get(zhu);
    	String k = TMC.WuXing.get(ke);
    	
    	return getWuShen(z, k);
    }
    
    public static String getWX(String zhu){
    	return TMC.WuXing.get(zhu);
    }
    
    public static String getDS(String zhu){
    	int idx = findIdx(TMC.Mountains, zhu);
    	String z = TMC.MountainsDS[idx];
    	return z;
    }
    
    public static String getWuShenDS(String zhu, String ke)
    {
    	int idx = findIdx(TMC.Mountains, zhu);
    	String z = TMC.MountainsDS[idx];
    	idx = findIdx(TMC.Gan, ke);
    	if(idx<0)return null;
    	String k = TMC.GanDouShou[idx];
    	
    	return getWuShen(z, k);
    }
    
    public static String getShenShaStr(String year, String month){
    	StringBuffer sb = new StringBuffer();
    	sb.append(String.format("<天官符:%s>", getTianGuanFu(year, month)));
    	sb.append(String.format("<地官符:%s>", getDiGuanFu(year, month)));
    	sb.append(String.format("<大月建:%s>", getDaYueJian(year, month)));
    	sb.append(String.format("<小月建:%s>", getXiaoYueJian(year, month)));
    	sb.append(String.format("<五黄煞:%s>", getWuHuangSha(year, month)));
    	
    	return sb.toString();
    }
    
    public static List<String> getShenShaList(String year, String month){
    	List<String> list = new ArrayList<String>();
    	list.add(String.format("天官符:%s", getTianGuanFu(year, month)));
    	list.add(String.format("地官符:%s", getDiGuanFu(year, month)));
    	list.add(String.format("大月建:%s", getDaYueJian(year, month)));
    	list.add(String.format("小月建:%s", getXiaoYueJian(year, month)));
    	list.add(String.format("五黄煞:%s", getWuHuangSha(year, month)));
    	
    	return list;
    }
    
    public static boolean isIn(String bagua, String mt){
    	if(!TMC.BaGuaMap.containsKey(bagua)){
    		return false;
    	}
    	
    	String bgstr = TMC.BaGuaMap.get(bagua);
    	if(bgstr.contains(mt)){
    		return true;
    	}
    	
    	return false;
    }
    
    public static String getGanChong(String str){
    	int count = 0;
    	StringBuffer sb = new StringBuffer();
    	for(int i=0;i<str.length()-1;i++){
    		for(int j=i+1;j<str.length();j++){
    			String s1 = ""+str.charAt(i);
    			String s2 = ""+str.charAt(j);
    			if(isGanChong(s1, s2)){
    				sb.append(s1).append(s2);
    			}
    		}
    	}
    	
    	return sb.toString();
    }
    
    public static String getZhiChong(String str){
    	int count = 0;
    	StringBuffer sb = new StringBuffer();
    	for(int i=0;i<str.length()-1;i++){
    		for(int j=i+1;j<str.length();j++){
    			String s1 = ""+str.charAt(i);
    			String s2 = ""+str.charAt(j);
    			if(isZhiChong(s1, s2)){
    				sb.append(s1).append(s2);
    			}
    		}
    	}
    	
    	return sb.toString();
    }

	public static List<String> getYearMonthSS(Mountain mt, String year,
			String month) {
		List<String> result = new ArrayList<String>();
		String bagua = getTianGuanFu(year, month);
		if(isIn(bagua, mt.getShan())){
			result.add(String.format("天官符占山：%s", bagua));
		}
		bagua = getDiGuanFu(year, month);
		if(isIn(bagua, mt.getShan())){
			result.add(String.format("地官符占山：%s", bagua));
		}
		bagua = getDaYueJian(year, month);
		if(isIn(bagua, mt.getShan())){
			result.add(String.format("大月建占山：%s", bagua));
		}
		bagua = getXiaoYueJian(year, month);
		if(isIn(bagua, mt.getShan())){
			result.add(String.format("小月建占山：%s", bagua));
		}
		bagua = getWuHuangSha(year, month);
		if(isIn(bagua, mt.getShan())){
			result.add(String.format("五黄煞占山：%s", bagua));
		}
		return result;
	}
	
	public static JieQiGroup getJieQiGroup(BaZi bz){
		GanZhi gz0 = new GanZhi("甲","子");
		GanZhi gz1 = bz.getYear();
		int sub1 = SixtyCycle.sub(gz1, gz0);
		int sub2 = SixtyCycle.sub(gz0, gz1);
		int year = 1984 + sub1;
//		if(Math.abs(sub2) < Math.abs(sub1)){
//			year = 1984 - sub2;
//		}
		
		return Cache.getJieQiGroupByYear(year);
	}
	
	public static List<String> getJianChuChs(BaZi bz){
		List<String> list = new ArrayList<String>();
		list.add("建除");list.add("-");list.add(">");list.add(getJianChu(bz));list.add("日");list.add("ENTER");
		return list;
	}
	
	public static String getJianChu(BaZi bz){
		String re = null;
		JieQiGroup jqg = getJieQiGroup(bz);
		int idx0 = findIdx(TMC.Zhi,bz.getMonth().getZhi());
		int idx = (idx0 - 2 + 12) % 12;
		int idxJQ = idx * 2;
		
		JieQi jq = jqg.getList().get(idxJQ);
		Calendar cal = JieQi.formatCal(jq.getStartTime());
		GanZhi gzRi = BaZi.computeGanZhiDay(cal);
		
		int zi = findIdx(TMC.Zhi, gzRi.getZhi());
		int sub = idx0 - zi;
		if(sub < 0){
			sub += 12;
		}
		
		int count = SixtyCycle.sub(bz.getDay(), gzRi);
		int ci = 12 - sub;
		int ti = (ci + count) % 12;
		return TMC.JianChu[ti];
	}
	
	public static List<Calendar> findJiaZi(int year){
		JieQiGroup jqg = Cache.getJieQiGroupByYear(year);
		JieQiGroup jqgPre = Cache.getJieQiGroupByYear(year-1);
		List<Calendar> list = new ArrayList<Calendar>();
		String str = jqgPre.getList().get(21).getStartTime();
		list.add(findJiaZi(str));
		str = jqg.getList().get(1).getStartTime();
		list.add(findJiaZi(str));
		str = jqg.getList().get(5).getStartTime();
		list.add(findJiaZi(str));
		str = jqg.getList().get(9).getStartTime();
		list.add(findJiaZi(str));
		str = jqg.getList().get(13).getStartTime();
		list.add(findJiaZi(str));
		str = jqg.getList().get(17).getStartTime();
		list.add(findJiaZi(str));
		str = jqg.getList().get(21).getStartTime();
		list.add(findJiaZi(str));
		
		return list;
	}
	
	public static Calendar findJiaZi(String strTime){
//		System.out.println("###"+str);
		String str = strTime.trim().substring(0,11)+"00:00:00";
		Calendar cal = JieQi.formatCal(str);
		GanZhi gzYS = BaZi.computeGanZhiDay(cal);
		GanZhi gzJiaZi = new GanZhi("甲","子");
		int count = SixtyCycle.sub(gzJiaZi, gzYS);
		int countPre = SixtyCycle.sub(gzYS, gzJiaZi);
		if(count < countPre){
			cal.add(Calendar.DAY_OF_YEAR, count);
		}
		else{
			cal.add(Calendar.DAY_OF_YEAR, -countPre);
		}
		
		//DateUtil.resetHHmmss(cal);
//		System.out.println(DateUtil.formatCal(cal));
		return cal;
	}
	
	public static void main(String[] args){
//		System.out.println(isYinBi("甲", "甲"));
//		System.out.println(isYinBi("甲", "丙"));
//		System.out.println(isYinBi("甲", "庚"));
//		System.out.println(isYinBi("甲", "卯"));
//		
//		String datestr = "2015-03-06 00:00:00";
//		Calendar cal = JieQi.formatCal(datestr);
//		BaZi bz = BaZi.computeBaZi(cal);
//		System.out.println(getJianChu(bz));
//		List<Calendar> list = findJiaZi(2015);
		System.out.println(toPosivite(10, 9));
		System.out.println(toPosivite(-10, 9));
	}
}
