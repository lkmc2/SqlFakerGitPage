# 使用教程

## 反向生成Java文件

**注意**：目前仅针为**MySQL**、**SQL Server**、**Oracle**、**Sqlite**和**H2**数据库设计了Faker表创建器。

以下的例子仅针对MySQL，其他数据库请参考对应数据库区域的例子。



### 使用示范

如test数据库中含有如下两张表。

```sql
create table user_table
(
  id   varchar(32) primary key,
  name varchar(120),
  age  int
) comments '用户表';

create table product
(
  id         varchar(32) primary key,
  name       varchar(32),
  price      int,
  tenant_id  varchar(32),
  created_by varchar(32),
  updated_by varchar(32),
  created_at date,
  updated_at date,
  dr         int(1)
) comments '产品表';
```



使用如下代码即可使用Faker表创建器快速为test数据库中的所有表生成带有Faker结构的java文件。

```java
// 为 MySQL 数据库的所有表生成带 Faker 表结构的 java 文件

// 方式1：简单设置数据库名，并创建Faker表结构
// 使用方式1时，会使用如下默认的数据库参数进行连接
// url: jdbc:mysql://localhost:3306/数据库名
// 数据库驱动：com.mysql.jdbc.Driver
// 用户名：root
// 密码：123456
FakerCreator.mysql().dbName("test").build();

// 方式2：完整设置数据库信息，并创建Faker表结构
FakerCreator.mysql()
            .url("jdbc:mysql://localhost:3306/facker")
            .driverClassName("com.mysql.jdbc.Driver")
            .username("root")
            .password("123456")
            .build();
```



执行上述代码中的其中一个方式，生成的java文件内容如下：

``` java
package com.lin.creator;

import com.lin.datatype.DataType;
import com.lin.faker.Faker;
import com.lin.utils.DBTools;
import com.lin.value.Times;
import com.lin.value.Values;

/**
* Faker生成的表结构
*/
public class CreateFakerTable {

   public static void main(String[] args) {
      // 创建数据库连接
      DBTools.url("jdbc:mysql://localhost:3306/test")
            .username("root")
            .password("123456")
            .driverClassName("com.mysql.jdbc.Driver")
            .connect();

      // 用户表
      Faker.tableName("user_table")
            .param("id", DataType.ID)
            .param("name", Values.of("example1", "example2", "example3"))
            .param("age", Values.ofIntRange(1, 18))
            .insertCount(5)
            .onlyShowSql();
      
      // 产品表
      Faker.tableName("product")
            .param("id", DataType.ID)
            .param("name", Values.of("example1", "example2", "example3"))
            .param("price", Values.ofIntRange(1, 18))
            .param("tenant_id", Values.of("example1", "example2", "example3"))
            .param("created_by", Values.of("example1", "example2", "example3"))
            .param("updated_by", Values.of("example1", "example2", "example3"))
            .param("created_at", Values.ofTimeRange(Times.of(2019, 1, 1), Times.of(2019, 5, 1)))
            .param("updated_at", Values.ofTimeRange(Times.of(2019, 1, 1), Times.of(2019, 5, 1)))
            .param("dr", Values.ofIntRange(1, 18))
            .insertCount(5)
            .onlyShowSql();
   }

}
```

可以在此文件的基础上对进行开发。