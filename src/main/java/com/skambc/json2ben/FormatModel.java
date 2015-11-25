package com.skambc.json2ben;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/***
 * 遍历实体类的属性和数据类型以及属性值
 * @author LiBaozhen
 * @date 2013-1-4 上午10:25:02
 * @company
 * @version v1.3
 * @see 相关类
 * @since 相关/版本
 */
public class FormatModel {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        Usr user = new Usr();
        // user.setId();
        user.setName("jinhd");
        setDefaultValue(user);
        System.out.println(user.getAge());

    }

    public static void setDefaultValue(Object model) throws NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // 获取实体类的所有属性，返回Field数组
        Field[] field = model.getClass().getDeclaredFields();
        Method [] methods=model.getClass().getDeclaredMethods();
        // 遍历所有属性
        for (int j = 0; j < field.length; j++) {
            // 获取属性的名字
            String name = field[j].getName();
            // 获取属性的类型
            Class type = field[j].getType();
            if ("java.lang.String".equals(type.getName())) {
//                Method setMethod = model.getClass().getMethod("set" + StringUtil.firstCharUpperCase(name), type);
//                Method getMethod = model.getClass().getMethod("get" + StringUtil.firstCharUpperCase(name));
                Method setMethod = null;
                Method getMethod = null;
                for(Method m:methods){
                	if(m.getName().equalsIgnoreCase("set" + name)){
                		setMethod=m;
                		break;
                	}
                }
                for(Method m:methods){
                	if(m.getName().equalsIgnoreCase("get" + name)){
                		getMethod=m;
                		break;
                	}
                }
                if(setMethod==null||getMethod==null){
                	continue;
                }
                String value = (String) getMethod.invoke(model);
                if (value == null || "".equals(value)) {
                    setMethod.invoke(model, "");
                }
            } else if ("java.lang.Double".equals(type.getName())) {
                Method setMethod = model.getClass().getMethod("set" + StringUtil.firstCharUpperCase(name), type);
                Method getMethod = model.getClass().getMethod("get" + StringUtil.firstCharUpperCase(name));
                Double value = (Double) getMethod.invoke(model);
                if (value == null) {
                    setMethod.invoke(model, 0.0);
                }

            }
            /*
             * else if ("int".equals(type.getName())) {
             * int value = (Integer) getMethod.invoke(model);
             * System.out.println(value);
             * if (value == null) {
             * setMethod.invoke(model, "");
             * }
             * setMethod.invoke(model, "");
             * } else if ("short".equals(type.getName())) {
             * setMethod.invoke(model, "");
             * } else if ("float".equals(type.getName())) {
             * setMethod.invoke(model, "");
             * } else if ("double".equals(type.getName())) {
             * setMethod.invoke(model, "");
             * } else if ("long".equals(type.getName())) {
             * setMethod.invoke(model, "");
             * } else if ("java.util.Date".equals(type.getName())) {
             * setMethod.invoke(model, "");
             * }
             */
        }
    }
}

class Usr {
    String id;
    String name;
    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
