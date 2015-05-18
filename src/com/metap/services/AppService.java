package com.metap.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.metap.model.ListNode;
import com.metap.model.Setting;
import com.metap.model.YMDH;
import com.metap.model.Year;
//import com.metap.ui.Binder;
import com.metap.util.sc.Chong;
import com.metap.util.sc.DouShouKe;
import com.metap.util.sc.NianMing;
import com.metap.util.sc.ShengHua;
import com.metap.util.sc.TianYueDe;
import com.metap.util.sc.WangShan;
import com.metap.util.sc.WuXingKe;
import com.metap.util.tm.Mountain;
import com.metap.util.tm.Option;
import com.metap.util.tm.TimeGroup;

public class AppService {

	private static AppService service;
	
	private Setting setting;
	private ListNode listNode;
	
	private YMDH ymdh;
	private Calendar currentSelectCal;
	private com.metap.util.tm.Mountain mountain;
	private TimeGroup timeGroup;
	
//	Map<String, Binder> optionMap;
	
	private AppService(){
		setting = new Setting();
		setting.setNormalTextSize(16);
		listNode = new ListNode("Root");
		currentSelectCal = Calendar.getInstance();
		ymdh = CalendarService.Calendar2YMDH(currentSelectCal);
		mountain = new Mountain(7);
	}
	
	public static AppService getInstance(){
		if(service == null){
			service = new AppService();
			service.init();
		}
		
		return service;
	}
	
	public void init(){
		listNode.add(new ListNode("ɽ��"));
		listNode.addByParent("ɽ��",new ListNode("ɽ��:",mountain));
		listNode.add(new ListNode("ʱ��ѡ��"));
		listNode.addByParent("ʱ��ѡ��",new ListNode("ʱ��:",ymdh));
		listNode.add(new ListNode("����",Year.class));
		listNode.addByParent("����",new ListNode("����",new Year("2015")));
		
//		optionMap = new HashMap<String, Binder>();
//		optionMap.put("��ɽ", new Binder(WangShan.class, new Option()));
//		optionMap.put("����", new Binder(ShengHua.class, new Option()));
//		optionMap.put("��ɵ�֧��", new Binder(Chong.class, new Option()));
//		optionMap.put("���µ�", new Binder(TianYueDe.class, new Option()));
//		optionMap.put("����", new Binder(DouShouKe.class, new Option()));
//		optionMap.put("����", new Binder(WuXingKe.class, new Option()));
//		optionMap.put("����", new Binder(NianMing.class, new Option()));
	}
	
	public List<Year> getNianMing(){
		List<Year> re = new ArrayList<Year>();
		ListNode ln = listNode.getByKey("����");
		
		for(ListNode node : ln.getSubList()){
			if(node != null && node.getData() instanceof Year){
				Year y = (Year)node.getData();
				re.add(y);
			}
		}
		
		return re;
	}
	
	public static Setting getAppSetting(){
		return getInstance().setting;
	}
	
	public static ListNode getListNode(){
		return getInstance().listNode;
	}

	public static Calendar getCurrentSelectCal() {
		return getInstance().currentSelectCal;
	}

	public static void setCurrentSelectCal(Calendar currentSelectCal) {
		 getInstance().currentSelectCal = currentSelectCal;
	}
	
	public com.metap.util.tm.Mountain getMountain() {
		return mountain;
	}

	public void setMountain(com.metap.util.tm.Mountain mountain) {
		this.mountain = mountain;
	}

	public TimeGroup getTimeGroup() {
		return timeGroup;
	}

	public void setTimeGroup(TimeGroup timeGroup) {
		this.timeGroup = timeGroup;
	}

	public YMDH getYmdh() {
		return ymdh;
	}

	public void setYmdh(YMDH ymdh) {
		this.ymdh = ymdh;
	}

//	public Map<String, Binder> getOptionMap() {
//		return optionMap;
//	}
//
//	public void setOptionMap(Map<String, Binder> optionMap) {
//		this.optionMap = optionMap;
//	}

	public static void main(String[] args){
		AppService as = new AppService();
		int count = as.getListNode().getCount();
		
		for(int i=0;i<count;i++){
			ListNode ln = AppService.getListNode().getByPosition(i);
			String key = ln.getKey();
			System.out.println(i+ "\t"+key);
		}
	}

}
