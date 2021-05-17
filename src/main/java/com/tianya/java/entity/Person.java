package com.tianya.java.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * @Description: 
 * 序列化对象，方式一：实现接口 java.io.Serializable
 * @author: TianwYam
 * @date 2021年5月17日 下午8:53:44
 */
@Data
@Builder
public class Person implements Serializable{
	
	private static final long serialVersionUID = -5227964019276779512L;

	private int pid ;
	
	private String name ;
	
	private String addr ;

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", name=" + name + ", addr=" + addr + "]";
	}

}
