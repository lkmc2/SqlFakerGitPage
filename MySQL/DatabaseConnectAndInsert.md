# MySQL数据库



## 数据库连接

#### 一、连接属性设置

在进行插入数据之前需要设置数据库属性进行连接，如代码所示：

```java
// 创建数据库连接
DBTools.url("jdbc:mysql://localhost:3306/facker")
        .username("root")
        .password("123456")
        .driverClassName("com.mysql.jdbc.Driver")
        .connect();
```

可设置的属性如下表：

|     属性名      |      说明      |                            默认值                            |
| :-------------: | :------------: | :----------------------------------------------------------: |
|       url       | 数据库连接地址 | jdbc:mysql://localhost:3306/数据库名?useSSL=true&characterEncoding=utf8 |
|    username     |  数据库用户名  |                             root                             |
|       url       |   数据库密码   |                            123456                            |
| driverClassName |  数据库驱动名  |                    com.mysql.jdbc.Driver                     |

#### 二、特殊情况

1. 当数据库属性值等于默认值时，可省略该属性的设置(如用户名等于root、驱动名为com.mysql.jdbc.Driver时，可只设置url和密码)：

```java
// 创建数据库连接
DBTools.url("jdbc:mysql://localhost:3306/facker")
        .password("OoOo00Oo00OoOo")
        .connect();
```

2. 当数据库属性值都等于默认值时，可只设置数据库名（此时的url自动拼接为：jdbc:mysql://localhost:3306/facker?useSSL=true&characterEncoding=utf8）：

```java
DBTools.dbName("facker").connect();
```

**注意** ：数据库连接只需要设置一次，之后可以多次调用Faker进行插入数据操作。



## 数据插入

使用示例：

```java
// 创建 MySQL 数据库连接
DBTools.url("jdbc:mysql://localhost:3306/facker")
       .driverClassName("com.mysql.jdbc.Driver")
       .username("root")
       .password("123456")
       .connect();

// 给 user_table 表的 3 个字段填充 5 条数据
Faker.tableName("user_table")
     .param("id", DataType.ID)
     .param("name", DataType.USERNAME)
     .param("age", DataType.AGE)
     .insertCount(5)
     .execute();

// 给 product 表的 9 个字段填充 5 条数据
Faker.tableName("product")
     .param("id", DataType.ID)
     .param("name", DataType.USERNAME)
     .param("price", Values.ofIntRange(10, 100))
     .param("tenant_id  ", DataType.ID)
     .param("created_by", DataType.USERNAME)
     .param("updated_by", DataType.USERNAME)
     .param("created_at", Values.ofTimeRange(
          Times.of(2018, 7, 12),
          Times.of(2019, 9, 22, 18, 22, 33)
     ))
     .param("updated_at", DataType.TIME)
     .param("dr", Values.of("0", "1"))
     .insertCount(5)
     .execute();
```

执行如上代码，即可为数据库批量生成数据。



更详细的插入数据的例子，请参考【使用教程】->【数据插入】。