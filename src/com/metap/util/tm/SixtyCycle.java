package com.metap.util.tm;

import java.util.Calendar;

public class SixtyCycle {
	
	//====== 传入 月日的offset 传回干支, 0=甲子
    public static String findGanZhiofYear(int year) {
    	int num = year - 1900 + 36;
        return (TMC.Gan[num % 10] + TMC.Zhi[num % 12]);
    }
    
    public static int sub(GanZhi gz1, GanZhi gz2){
    	int gi1 = findIdx(TMC.Gan,gz1.getGan());
    	int gi2 = findIdx(TMC.Gan,gz2.getGan());
    	int zi1 = findIdx(TMC.Zhi,gz1.getZhi());
    	int zi2 = findIdx(TMC.Zhi,gz2.getZhi());
    	
    	int gsub = gi1 - gi2;
    	int zsub = zi1 - zi2;
    	//a + x*10 = b + y*12
    	int x = 0;
    	for(int i=0;i<100;i++){
    		int sum = zsub - gsub + i*12;
    		if(sum >= 0 && sum%10 == 0){
    			x = sum/10;
    			break;
    		}
    	}
    	
    	int re = gsub + x * 10;
    	if(re < 0){
    		re = (re+60) % 60;
    	}
    	return re;
    }
    
    public static GanZhi add(GanZhi gz,int count){
    	int rc = mode(count, 60);
    	
    	int gi = findIdx(TMC.Gan, gz.getGan());
    	int zi = findIdx(TMC.Zhi, gz.getZhi());
    	gi = mode(gi + rc,10);
    	zi = mode(zi + rc,12);
 
    	gi = gi % 10;
    	zi = zi % 12;
    	
    	return new GanZhi(TMC.Gan[gi],TMC.Zhi[zi]);
    }
    
    public static int mode(int i, int m){
    	int re = i;
    	if(re < 0){
    		re += (Math.abs(re)/m+1)*m;
    	}
    	
    	return re % m;
    }
    
    public static int findIdx(String[] strs, String str){
    	int re = -1;
    	for(int i=0;i<strs.length;i++){
    		if(strs[i].equals(str)){
    			re = i;
    			break;
    		}
    	}
    	
    	return re;
    }
    
    public static void main(String[] args){
//    	GanZhi gz = new GanZhi(TMC.Gan[3],TMC.Zhi[5]);
//    	System.out.println(gz);
//    	System.out.println(add(gz, -2));
//    	System.out.println(add(gz,122));
//    	GanZhi gz1 = new GanZhi("甲","子");
//    	GanZhi gz2 = new GanZhi("辛","巳");
//    	int sub = sub(gz1,gz2);
//    	System.out.println(sub);
//    	System.out.println(add(gz2, sub));
    	
    	Calendar cal = Calendar.getInstance();
    	System.out.println(DateUtil.formatCal(cal));
    	cal.add(Calendar.DAY_OF_WEEK, 365);
    	System.out.println(DateUtil.formatCal(cal));
    }
}
