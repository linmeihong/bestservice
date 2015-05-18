package com.metap.util.refrect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.metap.model.YMDH;

public class UIHelper {
	
	

	private static UIHelper helper;
	
	private Map<String, Object> data;
	private UIHelper(){
		
	}
	
	public static UIHelper getInstance(){
		if(helper == null){
			helper = new UIHelper();
		}
		
		return helper;
	}
	
	public static List<String> findUIDataList(UIDesc desc){
		Object re = UIParam.get(desc.data());
		if(re instanceof List<?>){
			return (List<String>)re;
		}
		
		return null;
	}
	
	
	public UIDesc findClassDesc(Object object) {
		if (object == null)
			return null;
		UIDesc classDesc = object.getClass().getAnnotation(
				UIDesc.class);

		return classDesc;
	}
	
	public static List<UIDesc> findPropertyDesc(Object object) {
		List<UIDesc> list = new ArrayList<UIDesc>();
		Field[] fields = object.getClass().getDeclaredFields();

		for (Field field : fields) {
			UIDesc desc = field.getAnnotation(UIDesc.class);

			if (desc != null) {
				// TODO 这里要修改避免重复
				list.add(desc);
			}
		}

		return list;
	}
	
	public static int getSelectPosition(Object o, UIDesc desc, List<String> data){
		int position = 0;
		
		Object value = getPropertyValue(o, desc);
		if(value != null && value instanceof String){
			String v = (String)value;
			for(int i=0;i<data.size();i++){
				if(v.equals(data.get(i))){
					position = i;
					break;
				}
			}
		}
		
		return position;
	}
	
	public static void setPropertyValue(Object object, Object value, UIDesc desc){
		try {
			String fieldName = desc.name();
			String methodName = "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
			Method method = object.getClass().getMethod(methodName, value.getClass());
			method.invoke(object, value);
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
		
	}
	
	public static Object getPropertyValue(Object object, UIDesc desc){
		Object re = null;
		try {
			String fieldName = desc.name();
			String methodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
			Method method = object.getClass().getMethod(methodName, null);
			re = method.invoke(object, null);
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
		
		return re;
	}
	
	public static void main(String[] args){
		List<UIDesc> list = UIHelper.findPropertyDesc(new YMDH());
		
		for(UIDesc desc : list){
			System.out.println(desc.name());
		}
	}
}
