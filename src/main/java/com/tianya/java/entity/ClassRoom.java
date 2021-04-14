package com.tianya.java.entity;

import java.util.List;

import com.alibaba.fastjson.JSON;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 
 * 教室 实体类
 * @author: TianwYam
 * @date 2021年4月14日 下午8:43:20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassRoom {
	
	// 教室编号
	private int roomId ;
	
	// 教室名称
	private String roomName;
	
	// 班主任
	private Teacher teacher ;
	
	// 班级学生
	private List<Student> students ;

	@Override
	public String toString() {
		return JSON.toJSONString(this, true);
	}
	
	
}
