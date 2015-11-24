package com.skambc.json2ben;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String json = "{\"address\":\"\",\"id\":\"2\",\"orgid\":null}";
//		JSONObject jo = null;
//		Map map=new HashMap<String,Object>();
//		map.put("pp", new People());
//		People p = (People) JSONObject.toBean(jo, null,map);
//		//People p = (People) JsonUtil.toJava(jo,People.class);
//		People pp=(People)map.get("pp");
//		System.out.println(pp.getId());
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String>  map=null;
		map=new HashMap<String,String>();
		map.put("hostId", "1");
		list.add(map);
		map=new HashMap<String,String>();
		map.put("hostId", "2");
		list.add(map);
		map=new HashMap<String,String>();
		map.put("hostId", "3");
		list.add(map);
		map=new HashMap<String,String>();
		map.put("hostId", "4");
		list.add(map);
		map=new HashMap<String,String>();
		map.put("hostId", "5");
		list.add(map);
		System.out.println(JSONArray.fromObject(list));
	}

}
