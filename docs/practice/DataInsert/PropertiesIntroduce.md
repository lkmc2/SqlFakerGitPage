# 数据插入

### 属性介绍

可设置的属性如下表：

|             属性名             |                    说明                    |
| :----------------------------: | :----------------------------------------: |
|     tableName(数据库表名)      |               设置数据库表名               |
| param(字段名, 数据生成器类型①) | 设置数据库字段名，以及对应的数据生成器类型 |
|     insertCount(插入条数)      |              设置插入数据条数              |
|           execute( )           |  生成SQL，显示在控制台，并在数据库中执行   |
|         onlyShowSql( )         |          生成SQL，并显示在控制台           |
|           ignored( )           |               不执行任何操作               |

注意：① 数据生成器类型，必须是DataType枚举值，或实现了Random接口的类。

使用示例：

```java
// 给user表的四个字段填充5条数据
Faker.tableName("user")
      .param("name", DataType.USERNAME)
      .param("age", DataType.AGE)
      .param("sex", DataType.SEX)
      .param("birthday", DataType.TIME)
      .insertCount(5)
      .execute();

// 给user表的两个字段生成5条SQL，并显示在控制台
Faker.tableName("user")
      .param("name", DataType.USERNAME)
      .param("age", DataType.AGE)
      .insertCount(5)
      .onlyShowSql();

// 不执行任何操作，不生成SQL，不显示在控制台
Faker.tableName("user")
      .param("name", DataType.USERNAME)
      .param("age", DataType.AGE)
      .insertCount(5)
      .ignored();
```

