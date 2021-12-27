package com.tianya.java.stream;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.alibaba.fastjson.JSON;
import com.tianya.java.entity.LogBean;

/**
 * @description
 *	java 8 新语法
 * @author TianwYam
 * @date 2021年12月27日下午9:14:59
 */
public class Java8Stream {
	
	
	@Test
	public void removeRepeat() {
		
		List<LogBean> logList = new ArrayList<>();
		logList.add(LogBean.builder().id(100).appType("抖音").desc("应用日志").createTm(LocalDate.parse("2021-12-12", DateTimeFormatter.ofPattern("yyyy-MM-dd"))).build());
		logList.add(LogBean.builder().id(100).appType("抖音").desc("应用日志").createTm(LocalDate.parse("2021-12-11", DateTimeFormatter.ofPattern("yyyy-MM-dd"))).build());
		logList.add(LogBean.builder().id(101).appType("快手").desc("应用日志").createTm(LocalDate.parse("2021-12-13", DateTimeFormatter.ofPattern("yyyy-MM-dd"))).build());
		logList.add(LogBean.builder().id(102).appType("UC").desc("应用日志").createTm(LocalDate.parse("2021-12-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"))).build());
		logList.add(LogBean.builder().id(104).appType("QQ音乐").desc("应用日志").createTm(LocalDate.parse("2021-12-12", DateTimeFormatter.ofPattern("yyyy-MM-dd"))).build());
		
		
		// 方式一
		TreeSet<LogBean> treeSet = new TreeSet<LogBean>((a,b)-> a.getId() == b.getId() && a.getAppType() == b.getAppType() ? 0 : 1 );
		treeSet.addAll(logList);
		
		
		System.out.println(" 方式一: ");
		System.out.println(" TreeSet: ");
		System.out.println(JSON.toJSONString(new ArrayList<>(treeSet), true));
		
		
		Map<String, LogBean> groupByMap = logList.stream().collect(Collectors.groupingBy(a->a.getId()+a.getAppType(), 
				Collectors.collectingAndThen(
						Collectors.reducing((a,b) -> a.getCreateTm().isBefore(b.getCreateTm()) ? b : a), 
						Optional::get)));
		
		System.out.println(" 方式二: ");
		System.out.println(" groupByMap: ");
		
		
		System.out.println(JSON.toJSONString(groupByMap.values(), true));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
