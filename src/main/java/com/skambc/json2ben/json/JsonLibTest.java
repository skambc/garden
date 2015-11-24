package com.skambc.json2ben.json;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sf.ezmorph.Morpher;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.bean.BeanMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;


public class JsonLibTest {

	/*
	 * ��ͨ���͡�List��Collection�ȶ�����JSONArray����
	 * 
	 * Map���Զ�����������JSONObject���� ���Խ�Map����һ�����������key/value�Կ������ɶ��������/����ֵ
	 * ��{key1:value1,key2,value2......}
	 * 
	 * 1.JSONObject��һ��name:values���ϣ�ͨ������get(key)����ȡ�õ���key���Ӧ��value����(�ַ���)
	 * ͨ������getJSONObject(key)����ȡ��һ��JSONObject��--> ת����map, ͨ������getJSONArray(key)
	 * ����ȡ��һ��JSONArray ��
	 */

	// һ������ת����JSON
	@Test
	public void testArrayToJSON() {
		boolean[] boolArray = new boolean[] { true, false, true };
		JSONArray jsonArray = JSONArray.fromObject(boolArray);
		System.out.println(jsonArray);
		// prints [true,false,true]
	}

	// Collection����ת����JSON
	@Test
	public void testListToJSON() {
		List list = new ArrayList();
		list.add("first");
		list.add("second");
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println(jsonArray);
		// prints ["first","second"]
	}

	// �ַ���jsonת����json�� �����������JSONArray��JSONObject
	@Test
	public void testJsonStrToJSON() {
		JSONArray jsonArray = JSONArray.fromObject("['json','is','easy']");
		System.out.println(jsonArray);
		// prints ["json","is","easy"]
	}

	// Mapת����json�� ����jsonObject
	@Test
	public void testMapToJSON() {
		Map map = new HashMap();
		map.put("name", "json");
		map.put("bool", Boolean.TRUE);
		map.put("int", new Integer(1));
		map.put("arr", new String[] { "a", "b" });
		map.put("func", "function(i){ return this.arr[i]; }");

		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject);
	}

	// ��������beanת�ɳ�json
	@Test
	public void testBeadToJSON() {
		MyBean bean = new MyBean();
		bean.setId("001");
		bean.setName("���п�");
		bean.setDate(new Date());

		List cardNum = new ArrayList();
		cardNum.add("ũ��");
		cardNum.add("����");
		cardNum.add("����");
		cardNum.add(new Person("test"));

		bean.setCardNum(cardNum);

		JSONObject jsonObject = JSONObject.fromObject(bean);
		System.out.println(jsonObject);

	}

	// ��ͨ���͵�jsonת���ɶ���
	@Test
	public void testJSONToObject() throws Exception {
		String json = "{name=\"json\",bool:true,int:1,double:2.2,func:function(a){ return a; },array:[1,2]}";
		JSONObject jsonObject = JSONObject.fromObject(json);
		System.out.println(jsonObject);
		Object bean = JSONObject.toBean(jsonObject);
		assertEquals(jsonObject.get("name"),
				PropertyUtils.getProperty(bean, "name"));
		assertEquals(jsonObject.get("bool"),
				PropertyUtils.getProperty(bean, "bool"));
		assertEquals(jsonObject.get("int"),
				PropertyUtils.getProperty(bean, "int"));
		assertEquals(jsonObject.get("double"),
				PropertyUtils.getProperty(bean, "double"));
		assertEquals(jsonObject.get("func"),
				PropertyUtils.getProperty(bean, "func"));
		System.out.println(PropertyUtils.getProperty(bean, "name"));
		System.out.println(PropertyUtils.getProperty(bean, "bool"));
		System.out.println(PropertyUtils.getProperty(bean, "int"));
		System.out.println(PropertyUtils.getProperty(bean, "double"));
		System.out.println(PropertyUtils.getProperty(bean, "func"));
		System.out.println(PropertyUtils.getProperty(bean, "array"));

		List arrayList = (List) JSONArray.toCollection(jsonObject
				.getJSONArray("array"));
		for (Object object : arrayList) {
			System.out.println(object);
		}

	}

	// ��json�����ɸ������Ͷ���, ����List
	@Test
	public void testJSONToBeanHavaList() {
		String json = "{list:[{name:'test1'},{name:'test2'}],map:{test1:{name:'test1'},test2:{name:'test2'}}}";
		// String json = "{list:[{name:'test1'},{name:'test2'}]}";
		Map classMap = new HashMap();
		classMap.put("list", Person.class);
		MyBeanWithPerson diyBean = (MyBeanWithPerson) JSONObject.toBean(
				JSONObject.fromObject(json), MyBeanWithPerson.class, classMap);
		
		
		
		
		
		System.out.println(diyBean);

		List list = diyBean.getList();
		for (Object o : list) {
			if (o instanceof Person) {
				Person p = (Person) o;
				System.out.println(p.getName());
			}
		}
	}

	// ��json�����ɸ������Ͷ���, ����Map
	@Test
	public void testJSONToBeanHavaMap() {
		// ��Map����һ������
		String json = "{list:[{name:'test1'},{name:'test2'}],map:{test1:{name:'test1'},test2:{name:'test2'}}}";
		Map classMap = new HashMap();
		classMap.put("list", Person.class);
		classMap.put("map", Map.class);
		// ʹ�ð�ʾ��ֱ�ӽ�json����Ϊָ���Զ����������List��ȫ����,Mapû����ȫ����
		MyBeanWithPerson diyBean = (MyBeanWithPerson) JSONObject.toBean(
				JSONObject.fromObject(json), MyBeanWithPerson.class, classMap);
		System.out.println(diyBean);

		System.out.println("do the list release");
		List<Person> list = diyBean.getList();
		for (Person o : list) {
			Person p = (Person) o;
			System.out.println(p.getName());
		}

		System.out.println("do the map release");

		// ����ע������ע��任������Ҫ�õ�ezmorph���е���
		MorpherRegistry morpherRegistry = JSONUtils.getMorpherRegistry();
		Morpher dynaMorpher = new BeanMorpher(Person.class, morpherRegistry);
		morpherRegistry.registerMorpher(dynaMorpher);

		Map map = diyBean.getMap();
		/* �����mapû�������Ͱ�ʾ���ʰ�Ĭ�ϵģ�������Ϊnet.sf.ezmorph.bean.MorphDynaBean���͵Ķ��� */
		System.out.println(map);
		List<Person> output = new ArrayList();
		for (Iterator i = map.values().iterator(); i.hasNext();) {
			// ʹ��ע������ָ��DynaBean���ж���任
			output.add((Person) morpherRegistry.morph(Person.class, i.next()));
		}

		for (Person p : output) {
			System.out.println(p.getName());
		}

	}
	@Test
	public void testBeanToJson(){
		Person p1=new Person();
		p1.setName("jinhd");
		Person p2=new Person();
		p2.setName("test2");
		MyBeanWithPerson mybean=new MyBeanWithPerson();
		List<Person> list=new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		mybean.setList(list);
		Map<String,Person> map=new HashMap<String,Person>();
		map.put("test1", p1);
		map.put("test2", p2);
		mybean.setMap(map);
		JSONObject per=JSONObject.fromObject(mybean);
		System.out.println(per.toString());
	}

}
