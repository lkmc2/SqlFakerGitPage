# 安装与使用

## 安装

#### Maven

在项目的pom.xml的dependencies中加入如下内容：

``` xml
<!-- SqlFaker 数据库数据生成器 -->
<dependency>
  <groupId>com.github.lkmc2</groupId>
  <artifactId>sql-faker</artifactId>
  <version>1.0.5</version>
</dependency>
```



#### Gradle

```groovy
compile 'com.github.lkmc2:sql-faker:1.0.5'
```



本开源库已包含commons-dbcp2(2.0.1)、commons-dbutils(1.6)、junit(4.1.2)以及mysql-connector-java(5.1.46)、sqlite-jdbc(3.28.0)、h2(1.4.199)的依赖。



**注意**：默认使用MySQL数据库，如需更换成Oracle、SQL Server等commons-dbcp2连接池支持的数据库，可另行添加依赖，并在DBTools的driverClassName(数据库驱动名)方法中指定数据库驱动名。


