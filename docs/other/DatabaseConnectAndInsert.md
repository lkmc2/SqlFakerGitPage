# 其他数据库



**注意**：需要手动添加对应数据库类型的Maven依赖，理论上支持所有DBCP2数据库连接池所支持的数据库类型。



## 数据库连接与数据插入



使用示例：

```java
// 创建 DB2 数据库连接
DBTools.url("jdbc:db2://192.9.200.21:6789/test")
       .driverClassName("com.ibm.db2.jdbc.net.DB2Driver")
       .username("sa")
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