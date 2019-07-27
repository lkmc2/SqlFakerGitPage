# 数据插入



## 插入数据的方式（三）



#### 使用 Generator.of()系列方法生成有序取值范围

#### 

Generator类共有以下3种生成有序取值范围方法，如下表：

|            方法名             |                取值范围                |         示例值         |
| :---------------------------: | :------------------------------------: | :--------------------: |
|   Generator.of(可变长数组)    | 从可变长数组中依次抽取一个元素，可循环 | "1001", "1002", "1003" |
| Generator.ofIntStart(起始值)  |  在[起始值, 结束值]的范围内取一个整数  |          500           |
| Generator.ofLongStart(起始值) |       从起始值开始，每次取值都+1       |          1000          |


另外，Generator.of(可变长数组)方法中还有用于设定可变长数组中每个元素出现次数的方法：

|           方法名            |                 说明                 |
| :-------------------------: | :----------------------------------: |
|    repeatCount(出现次数)    | 用于设定可变长数组中每个元素出现次数 |



**使用示例1**：

```java
// 给user表的1个字段填充10条数据
// Generator.of()方法中的值会依次出现，抵达最后一个元素后将从第一个元素开始循环
Faker.tableName("user")
     .param("deptNo", Generator.of("1001", "1002", "1003"))
     .insertCount(10)
     .execute();
```

对应生成的SQL语句如下：

```sql
insert into user(deptNo) values('1001')
insert into user(deptNo) values('1002')
insert into user(deptNo) values('1003')
insert into user(deptNo) values('1001')
insert into user(deptNo) values('1002')
insert into user(deptNo) values('1003')
insert into user(deptNo) values('1001')
insert into user(deptNo) values('1002')
insert into user(deptNo) values('1003')
insert into user(deptNo) values('1001')
```



**使用示例2**：

```java
// 给user表的2个字段填充10条数据
// Generator.of()方法中的值会依次出现，抵达最后一个元素后将从第一个元素开始循环
// repeatCount()方法可指定Generator.of()参数中的每个值出现的次数
// 如jack会出现3次后，再轮到andy出现3次，wang出现3次，以此类推
Faker.tableName("user")
     .param("name", Generator.of("jack", "andy", "wang").repeatCount(3))
     .param("deptNo", Generator.of("1001", "1002", "1003"))
     .insertCount(10)
     .execute();
```

对应生成的SQL语句如下：

```sql
insert into user(name,deptNo) values('jack','1001')
insert into user(name,deptNo) values('jack','1002')
insert into user(name,deptNo) values('jack','1003')
insert into user(name,deptNo) values('andy','1001')
insert into user(name,deptNo) values('andy','1002')
insert into user(name,deptNo) values('andy','1003')
insert into user(name,deptNo) values('wang','1001')
insert into user(name,deptNo) values('wang','1002')
insert into user(name,deptNo) values('wang','1003')
insert into user(name,deptNo) values('jack','1001')
```



**使用示例3**：

```java
// 给user表的4个字段填充10条数据
// Generator.ofLongStart()和Generator.ofIntStart()方法，在指定初始值后，每次取值都会+1
Faker.tableName("user")
     .param("id", Generator.ofLongStart(10000L))
     .param("name", Generator.of("jack", "andy", "wang").repeatCount(3))
     .param("deptNo", Generator.of("1001", "1002", "1003"))
     .param("serialNum", Generator.ofIntStart(500))
     .insertCount(10)
     .execute();
```

对应生成的SQL语句如下：

```sql
insert into user(id,name,deptNo,serialNum) values('10000','jack','1001','500')
insert into user(id,name,deptNo,serialNum) values('10001','jack','1002','501')
insert into user(id,name,deptNo,serialNum) values('10002','jack','1003','502')
insert into user(id,name,deptNo,serialNum) values('10003','andy','1001','503')
insert into user(id,name,deptNo,serialNum) values('10004','andy','1002','504')
insert into user(id,name,deptNo,serialNum) values('10005','andy','1003','505')
insert into user(id,name,deptNo,serialNum) values('10006','wang','1001','506')
insert into user(id,name,deptNo,serialNum) values('10007','wang','1002','507')
insert into user(id,name,deptNo,serialNum) values('10008','wang','1003','508')
insert into user(id,name,deptNo,serialNum) values('10009','jack','1001','509')
```

