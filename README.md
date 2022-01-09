# JavaLearn


java 学习过程中的一些实践实例代码



# Java1.8新特性



## 新日期



查看实例代码：com.tianya.java.Java8Date.java





### 日期时间对象 LocalDateTime



获取当前时间

~~~java
LocalDateTime time = LocalDateTime.now();
~~~

格式化输出

~~~java
DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
System.out.println(time.format(format));
~~~

解析时间格式字符串

~~~java
DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
// 对字符串时间，进行转换
LocalDateTime strDate = LocalDateTime.parse("2020/08/01 10:30", dateFormat);
System.out.println(strDate);
~~~

自定义日期时间

~~~java
LocalDateTime customDateTime = LocalDateTime.of(2021, 10, 01, 8, 0, 0);
System.out.println(customDateTime);
~~~



Date转LocalDateTime

~~~java
// Date 转 LocalDateTime
Instant instant3 = new Date().toInstant();
LocalDateTime dateTime = LocalDateTime.ofInstant(instant3, ZoneId.systemDefault());
System.out.println(dateTime);
~~~



LocalDateTime转Date

~~~java
ZoneOffset zoneOffset = OffsetDateTime.now().getOffset();
Instant instant2 = time.toInstant(zoneOffset);
System.out.println(instant2);
System.out.println(time.toInstant(ZoneOffset.UTC));
long milli = instant2.toEpochMilli();
Date date = new Date(milli);
~~~







## lambda



com.tianya.java.Java8Lambda.java





## optional



com.tianya.java.Java8Optional.java







## JDK序列化



com.tianya.java.JavaSerializable.java





