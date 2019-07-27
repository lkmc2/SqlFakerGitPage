# 使用教程



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


