package com.tianya.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tianya.java.entity.Student;

/**
 * @Description: 
 * 	学习Java中的 lambda表达式
 * @author: TianwYam
 * @date 2021年3月28日 下午12:57:22
 */
public class Java8Lambda {
	
	
	
	
	@Test
	public void filter() {
		
		List<Student> students = initDatas();
		
		System.out.println("学生基本信息：");
		students.forEach(System.out::println);
		
		
		// 查询大于 25岁的 学生
		System.out.println("查询大于 25岁的 学生：");
		List<Student> collect = students.stream()
				.filter(student->student.getAge() > 25)
				.collect(Collectors.toList());
		collect.forEach(System.out::println);
		
		
		System.out.println("按照年龄排序(从小到大)：");
		List<Student> sortList = students.stream()
				.sorted( (a,b)-> a.getAge() - b.getAge())
				.collect(Collectors.toList());
		sortList.forEach(System.out::println);
		
		
		// 获取最高的学生
		System.out.println("获取最高的学生：");
		Student maxHeightStudent = students.stream()
				.max((a,b)->a.getHeight() - b.getHeight())
				.get();
		System.out.println(maxHeightStudent);
		
		
		
		// 获取所有学生的年龄和
		Integer ageSum = students.stream()
			.reduce(0, 
					(a,b)-> a + b.getAge(), 
					(a,b)-> a + b);
		System.out.println("所有学生的年龄总和：" + ageSum);
		
		
		
		// 还可以：
		Integer allStudentAge = students.stream()
				.map(Student::getAge)
				.reduce(0, Integer::sum);
		System.out.println("获取所有人年龄之和：" + allStudentAge);
		
		
		
		// 转换成MAP
		Map<Integer, String> mapList = students.stream()
				.collect(
						Collectors.toMap(Student::getSid, 
								Student::getName));
		mapList.forEach((k,v)->System.out.println(k + ": " + v));
		
		
		System.out.println("同一个地方的人：");
		Map<String, List<Student>> addrMap = students.stream()
				.collect(Collectors.groupingBy(Student::getAddr));
		System.out.println(JSON.toJSONString(addrMap, 
				SerializerFeature.PrettyFormat));
		
		
		
		
		// 根据 地方分组，求出 每个 地方最高的 身高
		Map<String, Optional<Integer>> groupByList = students.stream()
				.collect(Collectors.groupingBy(Student::getAddr, 
						Collectors.mapping(Student::getHeight, 
						Collectors.maxBy((a,b)->a-b))));
		
		groupByList.forEach((k,v)->System.out.println(k + " : " + v.get()));
		
		
		// 先分组，然后 求身高最大的 学生
		System.out.println("求各个地方最高的人：");
		Map<String, Optional<Student>> groupMaxHeightStudentMap = students.stream()
				.collect(Collectors.groupingBy(Student::getAddr, 
				Collectors.mapping(a->a, 
						Collectors.maxBy((a,b)->a.getHeight() - b.getHeight()))));
		
		
		groupMaxHeightStudentMap.forEach((k,v)->System.out.println(k + " : " + v.get()));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * @Description: 
	 * 模拟数据，可以用数据库
	 * @author: TianwYam
	 * @date 2021年3月28日 下午1:15:05
	 * @return
	 */
	public static List<Student> initDatas() {
		
		List<Student> students = new ArrayList<>();
		
		students.add(Student.builder().sid(11).name("张三").age(23).addr("四川").height(175).build());
		students.add(Student.builder().sid(12).name("李四").age(38).addr("四川").height(168).build());
		students.add(Student.builder().sid(13).name("嬴政").age(26).addr("北京").height(185).build());
		students.add(Student.builder().sid(14).name("荆轲").age(17).addr("湖南").height(164).build());
		students.add(Student.builder().sid(15).name("曹操").age(26).addr("陕西").height(194).build());
		students.add(Student.builder().sid(16).name("盖聂").age(17).addr("云南").height(184).build());
		students.add(Student.builder().sid(17).name("刘邦").age(23).addr("北京").height(165).build());
		students.add(Student.builder().sid(18).name("王五").age(38).addr("四川").height(165).build());
		students.add(Student.builder().sid(19).name("刘备").age(50).addr("四川").height(174).build());
		
		return students;
	}
	
	
	

}
