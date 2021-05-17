package com.tianya.java;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.tianya.java.entity.People;

/**
 * @Description: 
 * Java 序列化
 * @author: TianwYam
 * @date 2021年5月17日 下午8:39:31
 */
public class JavaSerializable {
	
	
	
	/**
	 * @Description: 
	 * 序列化 对象
	 * @author: TianwYam
	 * @date 2021年5月17日 下午8:48:05
	 * @param object
	 * @return
	 */
	public static byte[] serialize(Object object) {
		
		try ( ByteArrayOutputStream out = new ByteArrayOutputStream();
				ObjectOutputStream writer = new ObjectOutputStream(out) ; ){
			writer.writeObject(object);
			return out.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new byte[0] ;
	}
	
	
	
	/**
	 * @Description: 
	 * 反序列化 
	 * @author: TianwYam
	 * @date 2021年5月17日 下午8:52:05
	 * @param obj
	 * @return
	 */
	public static Object unserialize(byte[] obj) {
		
		try ( ByteArrayInputStream input = new ByteArrayInputStream(obj);
				ObjectInputStream reader = new ObjectInputStream(input); ){
			return reader.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null ;
	}
	
	
	
	
	public static void main(String[] args) {
		
//		方式一：
//		Person person = Person.builder().pid(10).name("大卫").addr("成都").build();
//		
//		byte[] serialize = serialize(person);
//		System.out.println(new String(serialize));
//		
//		Object obj = unserialize(serialize);
//		System.out.println(obj);
		
		
//		方式二：
		People people = People.builder().pid(11).name("张三").addr("成都").build();
		
		byte[] serialize = serialize(people);
		System.out.println(new String(serialize));
		
		Object obj = unserialize(serialize);
		System.out.println(obj);
		
	}
	

}
