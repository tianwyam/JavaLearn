package com.tianya.java.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 
 * 老师 实体类
 * @author: TianwYam
 * @date 2021年4月14日 下午9:22:55
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
	
	// 教师编号
	private int teachNum ;
	
	// 教师姓名
	private String teachName ;

}
