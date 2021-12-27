package com.tianya.java.entity;

import java.time.LocalDate;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Builder;
import lombok.Data;

/**
 * @description
 *	日志配置类
 * @author TianwYam
 * @date 2021年12月27日下午9:13:20
 */
@Data
@Builder
public class LogBean {
	
	private long id;
	
	private String appType ;
	
	private String desc;
	
	@JSONField(format = "yyyy-MM-dd")
	private LocalDate createTm ;

}
