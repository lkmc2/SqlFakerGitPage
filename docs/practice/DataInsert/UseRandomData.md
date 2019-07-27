# 数据插入



## 插入数据的方式（四）



#### 实现RandomData接口，提供可随机生成的返回值

RandomData接口的代码如下：

```java
public interface RandomData<T> {
    T next();
}
```

实现该接口，并重写next( )方法提供一个返回值，该返回值就是数据库字段对应插入的值。

使用示例：

1. 创建一个自定义类EnglishNameRandom，实现RandomData<T>（泛型T可以是任意类型）接口，并提供一个随机生成的返回值。

```java
// 英文名数据生成器
public class EnglishNameRandom implements RandomData<String> {
    // 候选值数组，从该数组中随机抽一个作为返回值
    private static final String[] names = {"Kim Lily", "Andy Wang", "July Six"};
    
    @Override
    public String next() {
        // 从数组中随机选取一个值
        return RandomUtils.selectOneInArray(names);
    }
}
```

2. 在Faker中给字段指定使用EnglishNameRandom.class类型的生成器。

```java
// 指定name字段使用EnglishNameRandom类进行随机值的生成
Faker.tableName("user")
       .param("name", EnglishNameRandom.class)
       .param("age", Values.ofIntRange(20, 50))
       .param("address", DataType.ADDRESS)
       .insertCount(1)
       .execute();
```

对应生成的SQL语句如下：

```sql
insert into user(name, age, address) 
values('Andy Wang', 23, '四川省绵阳市盐亭县北利路73号')
```

