package com.metap.util.refrect;

public class CallBack {

	private Object object;
	private String method;
	private Object[] param;
	
	public CallBack(Object o, String method)
	{
		this.object = o;
		this.method = method;
	}
	
	public CallBack(Object o, String method,Object[] param){
		this.object = o;
		this.method = method;
		this.param = param;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Object[] getParam() {
		return param;
	}

	public void setParam(Object[] param) {
		this.param = param;
	}
	
}
