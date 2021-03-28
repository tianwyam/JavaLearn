package com.tianya.java.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @Description: 
 *  学生 实体类 测试用
 * @author: TianwYam
 * @date 2021年3月28日 下午1:03:24
 */
@Data
@Builder
@ToString
public class Student {
	
	private int sid ;
	
	private String name ;
	
	private String addr ;
	
	private int age ;
	
	private int height ;
	

}
