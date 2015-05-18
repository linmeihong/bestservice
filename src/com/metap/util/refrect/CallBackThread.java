package com.metap.util.refrect;


public class CallBackThread extends Thread {

	private CallBack callBack;
	public CallBackThread(CallBack cb){
		this.callBack = cb;
	}

	@Override
	public void run() {
		ObjectInvoker.invoke(callBack);
	}
	
	
}
