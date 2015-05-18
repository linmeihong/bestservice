package com.best.util;

import java.util.ArrayList;
import java.util.List;

import com.best.domain.ReceiveXmlEntity;

public class AppLogger {

	private static List<ReceiveXmlEntity> msgList = new ArrayList<ReceiveXmlEntity>();
	
	private static List<String> msgSourceList = new ArrayList<String>();
	
	private static List<String> msgResultList = new ArrayList<String>();
	static{
		ReceiveXmlEntity rxe = new ReceiveXmlEntity();
		rxe.setContent("here is message:");
		msgList.add(rxe);
	}
	
	public static void logStr(String str){
		if(msgSourceList.size()>100){
			msgSourceList.clear();
		}
		
		msgSourceList.add(str);
	}
	
	public static void logRxe(ReceiveXmlEntity rxe){
		if(msgList.size()>100){
			msgList.clear();
		}
		
		msgList.add(rxe);
	}
	
	public static void logResult(String str){
		if(msgResultList.size()>100){
			msgResultList.clear();
		}
		
		msgResultList.add(str);
	}

	public static List<ReceiveXmlEntity> getMsgList() {
		return msgList;
	}

	public static void setMsgList(List<ReceiveXmlEntity> msgList) {
		AppLogger.msgList = msgList;
	}

	public static List<String> getMsgSourceList() {
		return msgSourceList;
	}

	public static void setMsgSourceList(List<String> msgSourceList) {
		AppLogger.msgSourceList = msgSourceList;
	}

	public static List<String> getMsgResultList() {
		return msgResultList;
	}

	public static void setMsgResultList(List<String> msgResultList) {
		AppLogger.msgResultList = msgResultList;
	}
	
	
}
