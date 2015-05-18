package com.metap.util.tm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import android.graphics.Color;

public class FormatUtil {

	public static final Map<String,Integer> colorMap = new HashMap<String, Integer>(){{
//		put("0004", Color.BLUE);put("0104", Color.BLUE);put("0203", Color.BLUE);put("0206", Color.BLUE);
//		put("0606", Color.BLUE);
//		put("0401", Color.BLUE);put("0402", Color.BLUE);put("0403", Color.BLUE);put("0404", Color.BLUE);
//    	put("0501", Color.BLUE);put("0502", Color.BLUE);put("0503", Color.BLUE);put("0504", Color.BLUE);
//    	put("0601", Color.RED);put("0602", Color.RED);put("0603", Color.RED);put("0604", Color.RED);
//    	put("0701", Color.RED);put("0702", Color.RED);put("0703", Color.RED);put("0704", Color.RED);
		}};
	
	public static List<String> formatBaZi(BaZi data){
		List<String> list = new ArrayList<String>();
		list.add("���");
		list.add(data.getYear().getGan());
		list.add(data.getMonth().getGan());
		list.add(data.getDay().getGan());
		list.add(data.getHour().getGan());
		list.add("ENTER");
		list.add("��֧");
		list.add(data.getYear().getZhi());
		list.add(data.getMonth().getZhi());
		list.add(data.getDay().getZhi());
		list.add(data.getHour().getZhi());
		list.add("ENTER");
		
		return list;
	}
	
	public static List<String> formatWX(Mountain mt, BaZi bz){
		List<String> list = new ArrayList<String>();
		list.add(TMUtil.getWuShenWX(mt.getShan(), bz.getYear().getGan()));
		list.add(TMUtil.getWuShenWX(mt.getShan(), bz.getMonth().getGan()));
		list.add(TMUtil.getWuShenWX(mt.getShan(), bz.getDay().getGan()));
		list.add(TMUtil.getWuShenWX(mt.getShan(), bz.getHour().getGan()));
		return list;
	}
	
	public static List<String> formatDS(Mountain mt, BaZi bz){
		List<String> list = new ArrayList<String>();
		list.add(TMUtil.getWuShenDS(mt.getShan(), bz.getYear().getGan()));
		list.add(TMUtil.getWuShenDS(mt.getShan(), bz.getMonth().getGan()));
		list.add(TMUtil.getWuShenDS(mt.getShan(), bz.getDay().getGan()));
		list.add(TMUtil.getWuShenDS(mt.getShan(), bz.getHour().getGan()));
		return list;
	}
	
	public static List<String> formatWXDS(Mountain mt, BaZi bz){
		List<String> list = new ArrayList<String>();
		list.add("����");list.add("��");list.add("��");list.add("��");list.add("ʱ");list.add("ENTER");
		list.add("����");
		list.add(TMUtil.getWuShenWX(mt.getShan(), bz.getYear().getGan()));
		list.add(TMUtil.getWuShenWX(mt.getShan(), bz.getMonth().getGan()));
		list.add(TMUtil.getWuShenWX(mt.getShan(), bz.getDay().getGan()));
		list.add(TMUtil.getWuShenWX(mt.getShan(), bz.getHour().getGan()));
		list.add("ENTER");
		list.add("����");
		list.add(TMUtil.getWuShenDS(mt.getShan(), bz.getYear().getGan()));
		list.add(TMUtil.getWuShenDS(mt.getShan(), bz.getMonth().getGan()));
		list.add(TMUtil.getWuShenDS(mt.getShan(), bz.getDay().getGan()));
		list.add(TMUtil.getWuShenDS(mt.getShan(), bz.getHour().getGan()));
		list.add("ENTER");
		return list;
	}
}
