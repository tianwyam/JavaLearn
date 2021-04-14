package com.tianya.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.tianya.java.entity.ClassRoom;
import com.tianya.java.entity.Student;
import com.tianya.java.entity.Teacher;

/**
 * @Description: 
 * Java 8 新语法 Optional
 * @author: TianwYam
 * @date 2021年4月14日 下午8:45:41
 */
public class Java8Optional {

	
	public static void main(String[] args) {
		
		
		ClassRoom room = null ;
		

		List<Student> students = new ArrayList<>();
		students.add(Student.builder().sid(11).name("张三").age(23).addr("四川").height(175).build());
		students.add(Student.builder().sid(12).name("李四").age(38).addr("四川").height(168).build());
		
		ClassRoom classroom = ClassRoom.builder()
				.roomId(100)
				.roomName("高一一班")
				.students(students)
				.build();
		
		System.out.println(Optional.of(classroom));
		
		Optional<ClassRoom> classroomOptional = Optional.ofNullable(classroom);
		
		
		// NullPointerException
//		Optional<ClassRoom> nullOptional = Optional.of(room);
//		System.out.println(nullOptional);
//		
		System.out.println("输出一个带空的对象：");
		Optional<ClassRoom> roomOptional = Optional.ofNullable(room);
		// Optional.empty
		System.out.println(roomOptional);
		
		System.out.println(roomOptional.isPresent());
		System.out.println(classroomOptional.isPresent());
		
		// 一定程度上可以避免空指针异常
		// 如果存在，则输出，如果不存在，则输出 null
		System.out.println(roomOptional.orElse(null));
		
		// 如果存在，则执行 
		roomOptional.ifPresent(System.out::println);
		
	
		
	
		// 存在，则输出 教室
		classroomOptional.ifPresent(System.out::println);
		
		// 获取教室名称
		String roomName = classroomOptional.map(ClassRoom::getRoomName)
				.orElse("教室名称");
		System.out.println(roomName);
		 
		// map -> orElse 类似如下操作
		if (classroom != null) {
			String name = classroom.getRoomName();
			if(StringUtils.isNotBlank(name)) {
				System.out.println(name);
			}else {
				System.out.println("教室名称");
			}
		}
//		
//		
//		
		Optional<ClassRoom> filter = classroomOptional.filter(room2 -> CollectionUtils.isEmpty(room2.getStudents()));
		System.out.println(filter.isPresent());
		
		classroomOptional.flatMap(a->Optional.ofNullable(a.getStudents()));
		
		String teachName = classroomOptional.map(ClassRoom::getTeacher)
				.map(Teacher::getTeachName)
				.orElse("教室班主任不存在");
		System.out.println(teachName);
		
		
		
//		if(classroom != null) {
//			Teacher teacher = classroom.getTeacher();
//			if (teacher != null) {
//				String teachName = teacher.getTeachName();
//				if (StringUtils.isNotBlank(teachName)) {
//					System.out.println(teachName);
//				}else {
//					System.out.println("教室班主任姓名为空");
//				}
//			}else {
//				System.out.println("教室班主任不存在");
//			}
//		}
		
		
	}
	
	
	
	
	
}
