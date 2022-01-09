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







## lambda & Stream



com.tianya.java.Java8Lambda.java





### 过滤 filter





过滤

```java
// 查询大于 25岁的 学生
System.out.println("查询大于 25岁的 学生：");
List<Student> collect = students.stream()
    .filter(student -> student.getAge() > 25)
    .collect(Collectors.toList());
```





### 排序 sorted



排序

```java
System.out.println("按照年龄排序(从小到大)：");
List<Student> sortList = students.stream()
    .sorted( (a,b)-> a.getAge() - b.getAge())
    .collect(Collectors.toList());
```



### 最大 max



最大值

```java
// 获取最高的学生
System.out.println("获取最高的学生：");
Student maxHeightStudent = students.stream()
    .max((a,b)->a.getHeight() - b.getHeight())
    .get();
System.out.println(maxHeightStudent);
```





### 合并 reduce

```java
// 获取所有学生的年龄和
Integer ageSum = students.stream()
    .reduce(0, 
            (a,b)-> a + b.getAge(), 
            (a,b)-> a + b);
System.out.println("所有学生的年龄总和：" + ageSum);
```



```java
// 还可以：
Integer allStudentAge = students.stream()
    .map(Student::getAge)
    .reduce(0, Integer::sum);
System.out.println("获取所有人年龄之和：" + allStudentAge);
```





### 转MAP

```java
// 转换成MAP
Map<Integer, String> mapList = students.stream()
    .collect(
    Collectors.toMap(Student::getSid, 
                     Student::getName));
mapList.forEach((k,v)->System.out.println(k + ": " + v));

```



```java
System.out.println("同一个地方的人：");
Map<String, List<Student>> addrMap = students.stream()
    .collect(Collectors.groupingBy(Student::getAddr));
System.out.println(JSON.toJSONString(addrMap, SerializerFeature.PrettyFormat));
```





### 分组 groupingBy

```java
// 根据 地方分组，求出 每个 地方最高的 身高
Map<String, Optional<Integer>> groupByList = students.stream()
    .collect(Collectors.groupingBy(Student::getAddr, 
    	Collectors.mapping(Student::getHeight, 
        	Collectors.maxBy((a,b)->a-b))));

groupByList.forEach((k,v)->System.out.println(k + " : " + v.get()));
```



```java
// 先分组，然后 求身高最大的 学生
System.out.println("求各个地方最高的人：");
Map<String, Optional<Student>> groupMaxHeightStudentMap = students.stream()
    .collect(Collectors.groupingBy(Student::getAddr, 
		Collectors.mapping(a->a, 
        	Collectors.maxBy((a,b)->a.getHeight() - b.getHeight()))));

groupMaxHeightStudentMap.forEach((k,v)->System.out.println(k + " : " + v.get()));
```







### flatMap

~~~java
// 获取全部学生 （求list下的所有list）
List<Student> studentList = classRoomList.stream()
    .map(ClassRoom::getStudents)
    .filter(CollectionUtils::isNotEmpty)
    .flatMap(List::stream)
    .filter(Objects::nonNull)
    .collect(Collectors.toList());

studentList.forEach(System.out::println);
~~~











## Optional



com.tianya.java.Java8Optional.java















## JDK序列化



com.tianya.java.JavaSerializable.java





