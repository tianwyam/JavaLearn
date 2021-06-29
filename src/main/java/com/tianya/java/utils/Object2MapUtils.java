package com.tianya.java.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.cglib.beans.BeanMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.tianya.java.entity.ClassRoom;
import com.tianya.java.entity.Student;

/**
 * @description 对象与Map互转
 * @author TianwYam
 * @date 2021年6月28日下午5:07:27
 */
public class Object2MapUtils {

	public static void main(String[] args) {

		ClassRoom classroom = data();

//		Map<String, String> map = bean2Map(classroom);
//		Map<String, Object> map = fastJsonBean2Map(classroom);
//		Map<String, Object> map = javaBean2Map(classroom);
		Map<String, Object> map = springBean2Map(classroom);
		System.out.println(JSON.toJSONString(map, true));
	}

	public static ClassRoom data() {
		List<Student> students = new ArrayList<>();
		students.add(Student.builder().sid(11).name("张三").age(23).addr("四川").height(175).build());
		students.add(Student.builder().sid(12).name("李四").age(38).addr("四川").height(168).build());

		ClassRoom classroom = ClassRoom.builder().roomId(100).roomName("高一一班").students(students).build();

		return classroom;
	}

	/**
	 * @description 对象转成Map (apache commons-beanutils 方式)
	 * @author TianwYam
	 * @date 2021年6月28日下午5:25:42
	 * @param bean 实例对象
	 * @return Map<String, String>
	 */
	public static Map<String, String> bean2Map(Object bean) {

		try {
			return BeanUtils.describe(bean);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}

		return new HashMap<>();
	}

	/**
	 * @description 对象转Map (fastjson 方式)
	 * @author TianwYam
	 * @date 2021年6月28日下午5:27:46
	 * @param bean
	 * @return
	 */
	public static Map<String, Object> fastJsonBean2Map(Object bean) {

		return JSON.parseObject(JSON.toJSONString(bean), 
				new TypeReference<Map<String, Object>>() {
		});
	}

	/**
	 * @description 对象转Map (spring cglib 方式)
	 * @author TianwYam
	 * @date 2021年6月29日上午10:52:02
	 * @param bean
	 * @return
	 */
	@SuppressWarnings("all")
	public static Map<String, Object> springBean2Map(Object bean) {

		Map<String, Object> map = new HashMap<>();
		BeanMap beanMap = BeanMap.create(bean);
		for (Object object : beanMap.entrySet()) {
			if (object instanceof Map.Entry) {
				Entry<String , Object> entry = (Entry<String, Object>)object ;
				String key = entry.getKey();
				map.put(key, beanMap.get(key));
			}
		}

		return map;
	}



	/**
	 * @description
	 *	对象转Map (java 内省机制 的 方式)
	 * @author TianwYam
	 * @date 2021年6月29日上午10:59:20
	 * @param bean
	 * @return
	 */
	public static Map<String, Object> javaBean2Map(Object bean)  {
		
		Map<String, Object> map = new HashMap<>();
		
		try {
			
			// 获取JavaBean的描述器
			BeanInfo b = Introspector.getBeanInfo(bean.getClass(), Object.class);
			
			// 获取属性描述器
			PropertyDescriptor[] pds = b.getPropertyDescriptors();
			
			// 对属性迭代
			for (PropertyDescriptor pd : pds) {
				
				// 属性名称
				String propertyName = pd.getName();
				
				// 属性值,用getter方法获取
				Method m = pd.getReadMethod();
				
				// 用对象执行getter方法获得属性值
				Object properValue = m.invoke(bean);
				
				// 把属性名-属性值 存到Map中
				map.put(propertyName, properValue);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}

}
