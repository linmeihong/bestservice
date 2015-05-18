package com.metap.util.tm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.metap.util.tm.CycleList.CycleType;

//import android.text.GetChars;

public class TMC {

	public static final String[] WX = {"��","ˮ","ľ","��","��"};
	public static final String[] wuXingWuShen = {"��","��","��","ӡ","��","��","��","��","ӡ"};
	
	public final static String ChineseNumber[] = {"һ", "��", "��", "��", "��", "��", "��", "��", "��", "ʮ", "ʮһ", "ʮ��"};
    public static final String[] Gan = new String[]{"��", "��", "��", "��", "��", "��", "��", "��", "��", "��"};
    public static final String[] GanWuXing = new String[]{"ľ", "ľ", "��", "��", "��", "��", "��", "��", "ˮ", "ˮ"};
    public static final String[] GanDouShou = new String[]{"��", "��", "ˮ", "ľ", "��", "��", "��", "ˮ", "ľ", "��"};
    public static final String[] Zhi = new String[]{"��", "��", "��", "î", "��", "��", "��", "δ", "��", "��", "��", "��"};
    public static final String[] ZhiWuXing = new String[]{"ˮ", "��", "ľ", "ľ", "��", "��", "��", "��", "��", "��", "��", "ˮ"};
    public static final String[] ZhiWuXing3 = new String[]{"ˮ", "��", "��", "ľ", "ˮ", "��", "��", "ľ", "ˮ", "��", "��", "ľ"};
    public static final String[] TianDe = new String[]{"��","��","��","��","��","��","��","��","��","��","��","��"};
    
    public static final Map<String,String> ChangSheng4 = new HashMap<String, String>(){{
    	put("��", "��");put("ľ", "��");put("ˮ", "��");put("��", "��");}};
    	public static final Map<String,String> SanSha = new HashMap<String, String>(){{
    		put("��","�����ӹ��");put("ˮ", "�ȱ��綡δ");put("ľ", "���������");put("��", "����î�ҳ�");
    	}};
    
    	public static final Map<String,String> ShanHe = new HashMap<String, String>(){{
        	put("��", "���ϳ�");put("ľ", "��îδ");put("ˮ", "���ӳ�");put("��", "������");}};
    public static final String[] ChangSheng = new String[]{
		"����","��ԡ��","�ڴ�","�ٹ�","����","˥","��","��","Ĺ","��","̥","��"
		
	};
    
    public static final String[] Mountains = new String[]{
		"��","��","��","��","��","��","î","��","��","��","��","��","��","��","δ","��","��","��","��","��","��","Ǭ","��","��"
	};
 
    public static final String[] MountainsDS = new String[]{
		"��","��","��","ľ","ľ","ˮ","ˮ","��","��","��","��","��","��","ľ","ľ","ˮ","ˮ","��","��","��","��","��","��","��"
	};
    
    public static final String[] JiuGongZhang = new String[]{
		"��","��","��","��","��","Ǭ","��","��","��"
	};
    
    public static String jiuGongZhongChs(int idx){
    	return ChineseNumber[idx]+JiuGongZhang[idx];
    }
    
	public static String jiuXingChs(int idx){
		return TMC.ChineseNumber[idx]+TMC.JiuXing[idx];
	}
    
    public static Map<String, String> BaGuaMap = new HashMap<String, String>(){{
    	put("��", "���ӹ�");put("��", "������");
    	put("��", "��î��");put("��", "������");
    	put("��", "���綡");put("��", "δ����");
    	put("��", "������");put("Ǭ", "��Ǭ��");
    	put("��", "    ");
    }};
    
    public static final String[] JiuGongZhangWX = new String[]{
		"ˮ","��","ľ","ľ","��","��","��","��","��"
	};
    
    public static final String[] JianChu = new String[]{
		"��","��","��","ƽ","��","ִ","��","Σ","��","��","��","��"
	};
    
    public static final String[] JiuXing = new String[]{
    	"��","��","��","��","��","��","��","��","��"
    };
    
    public static Map<String,String> WuXing = new HashMap<String, String>(){{
    	for(int i=0;i<Gan.length;i++){
    		put(Gan[i], GanWuXing[i]);
    	}
    	for(int i=0;i<Zhi.length;i++){
    		put(Zhi[i], ZhiWuXing[i]);
    	}
    	for(int i=0;i<JiuGongZhang.length;i++){
    		put(JiuGongZhang[i], JiuGongZhangWX[i]);
    	}
    }};
    

    
    public static void main(String[] args){
//    	System.out.print(getDaYueJian(Zhi[0], Zhi[0]));
//    	for(int i=0;i<Zhi.length;i++){
//    		System.out.print(Zhi[i]+" ");
//    		for(int j=0;j<Zhi.length;j++){
//    			System.out.print(getXiaoYueJian(Zhi[i], Zhi[j]));
//    		}
//    		System.out.println();
//    	}
    	
//    	System.out.println(getTianGuanFu("δ", "��"));
//    	System.out.println(getDiGuanFu("δ", "��"));
//    	System.out.println(getDaYueJian("δ", "��"));
//    	System.out.println(getXiaoYueJian("δ", "��"));
//    	System.out.println(getWuHuangSha("δ", "��"));
    	
//    	System.out.println(getWuShenWX("��", "��"));
    }
}
