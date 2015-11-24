package com.skambc.json2ben;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public class JsonUtil {
	public static Object toJava(JSON json, Class clazz) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setRootClass(clazz);
		jsonConfig.setJavaPropertyFilter(new PropertyFilter() {

			public boolean apply(Object source, String name, Object value) {
				// TODO Auto-generated method stub
				try {
					source.getClass().getDeclaredField(name);
					return false;
				} catch (NoSuchFieldException e) {

					// TODO Auto-generated catch block
					// e.printStackTrace();
					return true;
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					return true;
				}
			}
		});
		return JSONSerializer.toJava(json, jsonConfig);
	}

}
