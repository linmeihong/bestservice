package com.metap.util.tm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class JieQiGroup {
	private List<JieQi> list;
	
	public List<JieQi> getList() {
		return list;
	}

	public void setList(List<JieQi> list) {
		this.list = list;
	}

	public JieQiGroup(List<JieQi> list){
		this.list = list;
	}
	
	public int getYear(){
		return Integer.parseInt(list.get(12).getStartTime().substring(0, 4));
	}
	
	public boolean isXiaZhi(Calendar c){
		boolean result = false;
		Calendar xz = DateUtil.parseCal(list.get(8).getStartTime());
		Calendar dz = DateUtil.parseCal(list.get(21).getStartTime());
		if(DateUtil.compare(xz, c) <= 0 && DateUtil.compare(c, dz) < 0){
			result = true;
		}
		
		return result;
	}
	
	public int compare(Calendar c){
		int re = 0;
		SimpleDateFormat sdf = new SimpleDateFormat(JieQi.STR_TIME_FORMAT);
		Calendar st = Calendar.getInstance();
		Calendar et = Calendar.getInstance();
		try {
			st.setTime(sdf.parse(list.get(0).getStartTime()));
			et.setTime(sdf.parse(list.get(list.size()-1).getEndTime()));
			if(c.getTimeInMillis()-st.getTimeInMillis() < 0)
			{
				re = -1;
			}
			else if(c.getTimeInMillis()-et.getTimeInMillis() > 0){
				re = 1;
			}
		} catch (ParseException e) {
			re = -1;
			e.printStackTrace();
		}
		
		return re;
	}

	public int findMonthIndex(Calendar c) {
		int idx = 0;
		
		for(int i=0;i<list.size();i++){
			JieQi jq = list.get(i);
			if(jq.isIn(c)){
				idx = i;
				break;
			}
		}
		
		return idx;
	}
	
	public List<String> toStringList(){
		List<String> re = new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			JieQi jq = list.get(i);
			int idx = i/2;
			re.add(String.format("%sÔÂ:%s:%s", TMC.ChineseNumber[idx],jq.getName(),jq.getStartTime()));
		}
		
		return re;
	}
	
	public static JieQiGroup computeChinaJieQi(Calendar c){
		SimpleDateFormat sdf = DateUtil.getChinaDateFormat("yyyy");
		String year = sdf.format(c.getTime());
		int y = Integer.parseInt(year);
		
		JieQiGroup jqg = computeChinaJieQi(y);
		int re = jqg.compare(c);
		if(re < 0){
			y--;
			jqg = computeChinaJieQi(y);
		}
		else if(re > 1){
			y++;
			jqg = computeChinaJieQi(y);
		}
		
		return jqg;
	}
	
	public static JieQiGroup computeChinaJieQi(int year){
		List<JieQi> list = new ArrayList<JieQi>();
		SolarTerm st = new SolarTerm();
		List<JieQi> listNow = st.computeJieQiByYear(year).getList();
		List<JieQi> listPre = st.computeJieQiByYear(year-1).getList();
		for(int i=24-3;i<24;i++){
			list.add(listPre.get(i));
		}
		
		for(int i=0;i<24-3;i++){
			list.add(listNow.get(i));
		}
		
		for(int i=0;i<23;i++){
			list.get(i).setEndTime(list.get(i+1).getStartTime());
		}
		list.get(23).setEndTime(listNow.get(21).getStartTime());
		
		return new JieQiGroup(list);
	}
}
