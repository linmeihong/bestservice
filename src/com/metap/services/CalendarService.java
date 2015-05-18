package com.metap.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.metap.model.YMDH;
import com.metap.util.StringUtil;
import com.metap.util.refrect.UIDesc;
import com.metap.util.refrect.UIHelper;
import com.metap.util.tm.BaZi;
import com.metap.util.tm.ChinaLunar;
import com.metap.util.tm.DateUtil;
import com.metap.util.tm.JieQi;
import com.metap.util.tm.JieQiGroup;
import com.metap.util.tm.Mountain;
import com.metap.util.tm.TMC;
import com.metap.util.tm.TMUtil;
import com.metap.util.tm.TimeGroup;

public class CalendarService {

	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		} else
			return false;
	}
	
	public static int dayCountOfMonth(Calendar c){
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	public static int dayCountOfWeek(int dayOfWeek) {
		int result = 0;
		switch (dayOfWeek) {
		case Calendar.MONDAY:
			result = 0;break;
		case Calendar.TUESDAY:
			result = 1;break;
		case Calendar.WEDNESDAY:
			result = 2;break;
		case Calendar.THURSDAY:
			result = 3;break;
		case Calendar.FRIDAY:
			result = 4;break;
		case Calendar.SATURDAY:
			result = 5;break;
		case Calendar.SUNDAY:
			result = 6;break;
		}

		return result;
	}

	public static List<List<String>> generateDayByMonth(Calendar c)
			 {
		List<List<String>> re = new ArrayList<List<String>>();
		try {
			SimpleDateFormat sdf = DateUtil.getChinaDateFormat("yyyy-MM");
			SimpleDateFormat sdf2 = DateUtil.getChinaDateFormat("yyyy-MM-dd");
			String str = sdf.format(c.getTime());
			str += "-01";
			Date date = sdf2.parse(str);
			Calendar ct = Calendar.getInstance();
			ct.setTime(date);
			int weekDay = ct.get(Calendar.DAY_OF_WEEK);
			int dayCountOfWeek = dayCountOfWeek(weekDay); 
			ChinaLunar lunar = new ChinaLunar(ct);
			int dayCountOfMonth = dayCountOfMonth(ct);
			int rowCount = (dayCountOfMonth+dayCountOfWeek)/7;
			if((dayCountOfMonth+dayCountOfWeek)%7 != 0){
				rowCount ++;
			}
			int listCount = rowCount*7;
			for (int i = 0; i < listCount; i++) {
				ChinaLunar li = lunar.addDay(i-dayCountOfWeek);
				re.add(li.toList());
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return re;
	}
	
	
	public static YMDH Calendar2YMDH(Calendar c){
		YMDH ymdh = new YMDH();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd,HH");
		String str = sdf.format(c.getTime());
		String[] subs = StringUtil.split(str, ",");
		ymdh.setYear(subs[0]);
		ymdh.setMonth(subs[1]);
		ymdh.setDay(subs[2]);
		ymdh.setHour(subs[3]);
		return ymdh;
	}
	
	public static TimeGroup screening(Mountain mt, Calendar now){
		JieQiGroup jqg = JieQiGroup.computeChinaJieQi(now);
		int startIdx = jqg.findMonthIndex(now);
		
		BaZi bz = BaZi.computeBaZi(now);
		String yearZhi = bz.getYear().getZhi();
		TimeGroup tgYear = new TimeGroup(yearZhi);
		for(int idx=startIdx;idx<jqg.getList().size() - 1;idx++){
			int midx = (idx/2+2) % 12;
			String monthZhi = TMC.Zhi[midx];
			TimeGroup tgMonth = tgYear.getSubTimeGroupById(monthZhi);
			if(tgMonth == null){
				tgMonth = new TimeGroup(monthZhi);
				tgYear.getList().add(tgMonth);
			}
			List<String> results = TMUtil.getYearMonthSS(mt,yearZhi,monthZhi);
			if(results.size()>0){
				tgMonth.setMessage(results);				
				continue;
			}
			
			JieQi jqs = jqg.getList().get(idx);
			JieQi jqe = jqg.getList().get(idx + 1);
			Calendar cs = JieQi.formatCal(jqs.getStartTime());
			Calendar ce = JieQi.formatCal(jqe.getStartTime());
			cs.set(Calendar.HOUR_OF_DAY, 0);
			while(DateUtil.compare(cs,ce) < 0){				
				BaZi bzHour = BaZi.computeBaZi(cs);
				ChinaLunar cl = new ChinaLunar(cs);
				String id = String.format("%s%s%sʱ", cl.toSolarStr("yyyyMMdd"),cl.toStringNoYear(),bzHour.getHour().getZhi());
				cs.add(Calendar.HOUR_OF_DAY, 2);
				List<String> msg = getSayNoMessage(mt, bzHour);
				if(msg.size() > 0)continue;
				
				ScoreGroup sg = new ScoreGroup(mt, bzHour,AppService.getInstance().getNianMing());
//				if (sg.checkOption(AppService.getInstance().getOptionMap())) {
//					TimeGroup tgHour = new TimeGroup(bzHour.toString());
//					tgHour.setId(id);
//					tgHour.setBaZi(bzHour);
//					tgMonth.getList().add(tgHour);
//				}
			}
		}
		
		return tgYear;
	}
	
	
	public static List<String> getSayNoMessage(Mountain mt, BaZi bz){
		List<String> re = new ArrayList<String>();
		
		
		return re;
	}

	public static void main(String[] args) {
//		CalendarService.generateDayByMonth(Calendar.getInstance());
//		YMDH tmp = Calendar2YMDH(Calendar.getInstance());
//		List<UIDesc> list = UIHelper.findPropertyDesc(tmp);
//		for(UIDesc desc : list){
//			List<String> dataL = UIHelper.findUIDataList(desc);
//			int idx = UIHelper.getSelectPosition(tmp, desc, dataL);
//			System.out.println(desc.label()+" "+idx);
//		}
		
		SimpleDateFormat sdf = DateUtil.getChinaDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(sdf.format(cal.getTime()));
		for(int i=0;i<24;i++){
			cal.add(Calendar.HOUR_OF_DAY, 1);
			System.out.println(sdf.format(cal.getTime()));
		}
	}
	
}
