package com.tianya.java.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.tianya.java.entity.ClassRoom;
import com.tianya.java.entity.Student;

/**
 * @description
 *	对象与Map互转
 * @author TianwYam
 * @date 2021年6月28日下午5:07:27
 */
public class Object2MapUtils {
	
	public static void main(String[] args) {
		
		ClassRoom classroom = data();
		
//		bean2Map(classroom);
		Map<String, Object> map = fastJson2Map(classroom);
		System.out.println(JSON.toJSONString(map, true));
	}
	
	
	
	public static ClassRoom data() {
		List<Student> students = new ArrayList<>();
		students.add(Student.builder().sid(11).name("张三").age(23).addr("四川").height(175).build());
		students.add(Student.builder().sid(12).name("李四").age(38).addr("四川").height(168).build());
		
		ClassRoom classroom = ClassRoom.builder()
				.roomId(100)
				.roomName("高一一班")
				.students(students)
				.build();
		
		return classroom;
	}
	
	
	/**
	 * @description
	 *	对象转成Map (commons-beanutils 方式)
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
	 * @description
	 *	对象转Map (fastjson 方式)
	 * @author TianwYam
	 * @date 2021年6月28日下午5:27:46
	 * @param bean
	 * @return
	 */
	public static Map<String, Object> fastJson2Map(Object bean) {
		
		return JSON.parseObject(JSON.toJSONString(bean), 
				new TypeReference<Map<String, Object>>(){});
	}
	
	
	
	
	

}
