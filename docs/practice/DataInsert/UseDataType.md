# 数据插入



## 插入数据的方式（一）



#### 使用DataType指定数据类型

DataType一共支持8种枚举类型，如下表所示：

|  属性名  |  说明  |                 类型                 |            示例值             |
| :------: | :----: | :----------------------------------: | :---------------------------: |
|    ID    | 用户ID |        19位的数字型UUID字符串        |      1049120504188764160      |
| USERNAME | 用户名 |        长度为2到4个字的中文名        |            武叹霜             |
|   TIME   |  时间  | 一年前到现在的时间范围内任意一个时刻 |      2018-03-01 12:41:00      |
|  PHONE   | 手机号 |              11位手机号              |          13192668109          |
| ADDRESS  |  地址  |        国内地址，详细到门牌号        | 四川省绵阳市盐亭县北利路738号 |
|   AGE    |  年龄  |            18到60岁的数字            |              19               |
|   SEX    |  性别  |          字符，0：男，1：女          |              '1'              |
|  EMAIL   |  邮箱  |            常见邮箱字符串            |       Alex705@gmail.com       |

使用示例：

```java
// 给user表的8个字段填充1条数据
Faker.tableName("user")
      .param("id", DataType.ID)
      .param("name", DataType.USERNAME)
      .param("birthday", DataType.TIME)
      .param("phone", DataType.PHONE)
      .param("address", DataType.ADDRESS)
      .param("age", DataType.AGE)
      .param("sex", DataType.SEX)
      .param("email", DataType.EMAIL)
      .insertCount(1)
      .execute();
```

对应生成的SQL语句如下：

```sql
insert into 
user(
  id, name, birthday,
  phone, address, age,
  sex, email
) 
values(
  '1049120504188764160', '武叹霜', '2018-03-01 12:41:00',
  '13192668109', '四川省绵阳市盐亭县北利路73号', 19,
   '1', 'Alex705@gmail.com'
)
```

