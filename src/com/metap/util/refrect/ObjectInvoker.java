package com.metap.util.refrect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ObjectInvoker {
	
	public static Object invoke(CallBack callBack){
		return ObjectInvoker.invoke(callBack.getObject(), callBack.getMethod(), callBack.getParam());
	}
	public static Object invoke(Object object, String methodName,Object... params){
		Class[] paramsType = null;
		if (params != null) {
			paramsType = new Class[params.length];
			int idx = 0;
			for (Object param : params) {
				paramsType[idx++] = param.getClass();
			}
		}
		try {
			Method method = object.getClass().getMethod(methodName, paramsType);
			return method.invoke(object, params);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
//	public static Method getMethod(Class c, String methodName, Class[] paramsType){
//		Method method = c.getMethod(methodName, paramsType);
//		
//		while(method == null && paramsType != null){
//			for(int i=0;i<paramsType.length; i++){
//				if(!paramsType[i].getSuperclass().equals(Object.class)){
//					paramsType[i] = paramsType[i].getSuperclass();
//				}
//			}
//		}
//		
//		return method;
//	}
}
