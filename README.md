# 前言



## SqlFaker

#### 轻量级、易拓展的数据库智能填充Java开源库

[![Maven Central](https://img.shields.io/maven-central/v/com.github.lkmc2/sql-faker.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.lkmc2%22%20AND%20a:%22sql-faker%22)[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)



Github地址：<https://github.com/lkmc2/SqlFaker>



## 简介

SqlFaker是一个Java开发的可快速为数据库生成大量仿真的工具，仅需简单的配置，即可为数据库表批量插入有规律的类似真实数据的内容，可用于数据库调优等操作。



## 开源库特性

+ 支持主流的MySQL、Oracle、SQL Server、Sqlite、H2等数据库

+ 支持8种常见数据库字段类型的智能填充，并支持自定义拓展

+ 支持一次性插入亿万级别的数据

+ 支持JDK1.6及以上版本

+ 支持事务

  

## 使用示范

``` java
// 创建数据库连接
DBTools.url("jdbc:mysql://localhost:3306/facker")
        .username("root")
        .password("123456")
        .connect();

// 给user表的四个字段填充5条数据
Faker.tableName("user")
      .param("name", DataType.USERNAME)
      .param("age", DataType.AGE)
      .param("sex", DataType.SEX)
      .param("birthday", DataType.TIME)
      .insertCount(5)
      .execute();
```

上述代码将生成如下SQL语句，并在数据库中执行：

```sql
insert into user(name,age,sex,address,birthday) values('武叹霜',21,'山西省晋城市泽州县庆达路463号','2018-02-24 10:56:37')
insert into user(name,age,sex,address,birthday) values('顾什可',50,'广西壮族自治区柳州市融水苗族自治县德堡路419号','2018-04-09 08:10:22')
insert into user(name,age,sex,address,birthday) values('蔡静随',46,'河南省郑州市巩义市广延路240号','2018-06-11 23:02:19')
insert into user(name,age,sex,address,birthday) values('韦丸赤',27,'河南省焦作市博爱县浦润路148号','2018-02-22 15:52:50')
insert into user(name,age,sex,address,birthday) values('任徐',54,'河南省新乡市延津县汉源路14号','2018-07-07 03:48:51')
```



## 更新日志

+ v1.0.5：支持一次性插入亿万级别的数据。
+ v1.0.4：添加针对Oracle、Sqlite、H2的FakerCreator，并添加可生成有序数据的Generator类。
+ v1.0.3：添加针对SQL Server的FakerCreator。
+ v1.0.2：添加针对MySQL的FakerCreator。
+ v1.0.1：提高数据插入执行速度。
+ v1.0.0：可一次插入百万级别的仿真数据到数据库中。



PS：如果有任何建议，可以在Github的Issues中提出，如添加DataType的默认类型等。



## License

The SqlFaker is released under version 2.0 of the [Apache License](http://www.apache.org/licenses/LICENSE-2.0).