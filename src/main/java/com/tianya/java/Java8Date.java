package com.tianya.java;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.Test;

/**
 * @Description: 
 * Java 8 新特性 日期API
 * @author: TianwYam
 * @date 2021年4月17日 下午9:50:23
 */
public class Java8Date {
	
	
	@Test
	public void testLocalDateTime() {
		
		// 获取 当前的 日期时间
		LocalDateTime time = LocalDateTime.now();
		System.out.println(time);
		
		
		// 日期时间格式化
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(time.format(format));
		
		
		// 字符串时间的格式，必须保持一致
		// 转 LocalDateTime 必须是 日期+时间
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		// 对字符串时间，进行转换
		LocalDateTime strDate = LocalDateTime.parse("2020/08/01 10:30", dateFormat);
		System.out.println(strDate);
		
		// 自定义时间日期
		LocalDateTime customDateTime = LocalDateTime.of(2021, 10, 01, 8, 0, 0);
		System.out.println(customDateTime);
		
		
		// 转LocalDate 只有日期
		LocalDate localDate = time.toLocalDate();
		System.out.println(localDate);
		
		
		// 转LocalTime 只有时间
		LocalTime localTime = time.toLocalTime();
		System.out.println(localTime);
		
		System.out.println("Instant:");
		// 转Instant
		Instant instant = time.toInstant(ZoneOffset.UTC);
		System.out.println(instant);
		
		ZoneOffset offset = OffsetDateTime.now().getOffset();
		System.out.println(offset);
		System.out.println(time.toInstant(offset));
		System.out.println(OffsetDateTime.now());
		
		
		System.out.println("转Date:");
		ZoneOffset zoneOffset = OffsetDateTime.now().getOffset();
		Instant instant2 = time.toInstant(zoneOffset);
		System.out.println(instant2);
		System.out.println(time.toInstant(ZoneOffset.UTC));
		long milli = instant2.toEpochMilli();
		Date date = new Date(milli);
		System.out.println(date);
		// 格式化 Date 输出格式
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(simpleDateFormat.format(date));
		

		
		// Date 转 LocalDateTime
		Instant instant3 = new Date().toInstant();
		LocalDateTime dateTime = LocalDateTime.ofInstant(instant3, ZoneId.systemDefault());
		System.out.println(dateTime);
		
		
	
	
		
	}
	
	
	
	@Test
	public void testLocalDate() {
		
		// 获取 当前的 日期，没有时间
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		
		// 自定义日期
		LocalDate customLocalDate = LocalDate.of(2021, 10, 1);
		System.out.println(customLocalDate);
		
		// 格式化输出
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年M月d日");
		String format = dateTimeFormatter.format(localDate);
		System.out.println(format);
		
		// 解析字符串
		LocalDate parseStrDate = LocalDate.parse("2020年7月10日", dateTimeFormatter);
		System.out.println(parseStrDate);
		
		// 转 LocalDateTime
		LocalDateTime localDateTime = localDate.atTime(LocalTime.now());
		// 2021-04-18T21:41:16.195
		System.out.println(localDateTime);
		
		
		// 转 Date
		Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		Date date = Date.from(instant);
		System.out.println(date);
		
		// Date 转 LocalDate
		Instant instant2 = new Date().toInstant();
		LocalDateTime dateTime = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault());
		LocalDate localDate2 = dateTime.toLocalDate();
		// 2021-04-18
		System.out.println(localDate2);
		
		
	}
	
	
	
	@Test
	public void testLocalTime() {
		
		// 获取 当前的 时间，没有日期
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		
		
		// 自定义时间
		LocalTime customTime = LocalTime.of(12, 30, 10);
		System.out.println(customTime);
		
		// 解析字符串
		LocalTime parse = LocalTime.parse("14点20分30秒", DateTimeFormatter.ofPattern("HH点mm分ss秒"));
		System.out.println(parse);
		
		
		// 格式化输出
		String format = localTime.format(DateTimeFormatter.ofPattern("HH点mm分ss秒"));
		// 22点18分58秒
		System.out.println(format);
		
		
		LocalDateTime localDateTime = localTime.atDate(LocalDate.now());
		// 2021-04-18T22:23:51.692
		System.out.println(localDateTime);
		
		
		// 转 Date
		LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), localTime);
		Instant instant = dateTime.toInstant(OffsetDateTime.now().getOffset());
		Date date = Date.from(instant);
		// Sun Apr 18 22:30:54 CST 2021
		System.out.println(date);
		
		
		
		// Date 转 LocalTime
		Instant instant2 = new Date().toInstant();
		LocalDateTime localDateTime2 = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault());
		LocalTime localTime2 = localDateTime2.toLocalTime();
		// 22:33:26.249
		System.out.println(localTime2);
		
	}
	
	
	
	@Test
	public void testInstant() {
		
		// 获取当前时刻
		Instant instant = Instant.now();
		// 2021-04-18T14:35:40.372Z
		System.out.println(instant);
		
		
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		// 2021-04-18T22:37:06.950
		System.out.println(localDateTime);

		
		Date date = Date.from(instant);
		// Sun Apr 18 22:38:27 CST 2021
		System.out.println(date);
		
		
		Instant instant2 = new Date().toInstant();
		// 2021-04-18T14:40:01.481Z
		System.out.println(instant2);
		
	}
	
	
	
	
	@Test
	public void date2Instant() {
		
		Date date = new Date();
		
		// 类似：Instant.ofEpochMilli(new Date().getTime());
		Instant instant = date.toInstant();
		System.out.println(instant);
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(instant));
		
	}
	
	
	@Test
	public void date2LocalDateTime() {
		
		Date date = new Date();
		Instant instant = date.toInstant();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		System.out.println(localDateTime);
	}
	
	

}
