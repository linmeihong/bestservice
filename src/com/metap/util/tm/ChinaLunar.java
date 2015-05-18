package com.metap.util.tm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.metap.util.sc.ZiBaiRi;



public class ChinaLunar extends Lunar {
	public static final String[] WeekStr = new String[]{"��һ","�ܶ�","����","����","����","����","����"};
    
    
	private Calendar cal;
	public ChinaLunar(Calendar cal) {
		super(cal);
		this.cal = cal;
	}

	public ChinaLunar addDay(int day){
		Calendar c = (Calendar)cal.clone();
		c.add(Calendar.DATE, day);
		
		return new ChinaLunar(c);
	}
	
	public String toSolarStr(String format){
		SimpleDateFormat sdf = DateUtil.getChinaDateFormat(format);
		return sdf.format(cal.getTime());
	}
	
	public List<String> toList(){
		List<String> list = new ArrayList<String>();
		BaZi bz = BaZi.computeBaZi(cal);
		list.add(""+cal.get(Calendar.DAY_OF_MONTH));
		list.add(""+ getChinaDayString());
		list.add(BaZi.computeGanZhiDay00(cal).toString());
		list.add(TMUtil.getJianChu(bz));
//		list.add(ZiBaiRi.getZiBai(bz));
		list.addAll(ZiBaiRi.getZiBaiList(bz));
		return list;
	}
	
	public static void main(String[] args) throws ParseException{
//		ChinaLunar cl = new ChinaLunar(Calendar.getInstance());
//		System.out.println(cl.toString());
//		System.out.println(cl.addDay(-1));
		
//		DateFormat fmtDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = fmtDateTime.parse("2014-08-19 00:00:00");
//		Calendar c = Calendar.getInstance();
//		c.setTime(date);
//		System.out.println(computeGanZhi(c));
		
		List<JieQi> list = JieQiGroup.computeChinaJieQi(2014).getList();
		for(JieQi jq: list){
			System.out.println(jq.getName()+":"+jq.getStartTime());
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse("2015-03-01 05:05:05");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		JieQiGroup jqg = new JieQiGroup(list);
		int re = jqg.compare(c);
		System.out.println(re);
	}
}
