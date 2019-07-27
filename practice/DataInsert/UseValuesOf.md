# 数据插入



## 插入数据的方式（二）



#### 使用 Values.of()系列方法生成随机取值范围



Values类共有以下8种生成随机取值范围方法，如下表：

|                  方法名                  |                           取值范围                           |         示例值         |
| :--------------------------------------: | :----------------------------------------------------------: | :--------------------: |
|          Values.of(可变长数组)           |                 从可变长数组中任意抽取一个值                 | "优品", "良品", "次品" |
|     Values.ofIntRange(起始值,结束值)     |             在[起始值, 结束值]的范围内取一个整数             |           33           |
|    Values.ofLongRange(起始值,结束值)     |           在[起始值, 结束值)的范围内取一个长整型数           |       777777777L       |
|    Values.ofFloatRange(起始值,结束值)    | 在[起始值, 结束值]的范围内取一个单精度浮点数，默认精确到小数点后2位 |         22.22f         |
| Values.ofFloatRange(起始值,结束值,精度)  | 在[起始值, 结束值]的范围内取一个单精度浮点数，精度根据参数设置，最多6位 |      123.333333f       |
|   Values.ofDoubleRange(起始值,结束值)    | 在[起始值, 结束值]的范围内取一个双精度浮点数，默认精确到小数点后2位 |        788.31d         |
| Values.ofDoubleRange(起始值,结束值,精度) | 在[起始值, 结束值]的范围内取一个双精度浮点数，精度根据参数设置，最多6位 |       1820.4231d       |
|  Values.ofTimeRange(开始时间，结束时间)  |      在[开始时间, 结束时间]的范围内取一个时间，精确到秒      |  2018-03-14 13:21:11   |

另外，Times类中还有用于设定时间的两个方法：

|           方法名            |          说明          |
| :-------------------------: | :--------------------: |
|     Times.of(年,月,日)      | 用于生成时间，精确到日 |
| Times.of(年,月,日,时,分,秒) | 用于生成时间，精确到秒 |



使用示例：



```java
// 给product表的9个字段填充1条数据
Faker.tableName("product")
      .param("type", Values.of("优品", "良品", "次品"))
      .param("person_count", Values.ofIntRange(20, 50))
      .param("total_count", Values.ofLongRange(555555555L, 888888888L))
      .param("enter_price", Values.ofFloatRange(12.33f, 34.57f))
      .param("outcome_price", Values.ofFloatRange(100.004132f, 240.281424f, 6))
      .param("speed", Values.ofDoubleRange(750.34d, 800.27d))
      .param("salary", Values.ofDoubleRange(1980.3415d, 2700.2315d, 4))
      .param("firstTime", Values.ofTimeRange(Times.of(2018,3,22), Times.of(2018,10,22)))
      .param("secondTime", 
             Values.ofTimeRange(
                Times.of(2018,3,22,11,23,24), 
                Times.of(2018,10,22,22,15,17)
             )
       )
      .insertCount(1)
      .execute();
```

对应生成的SQL语句如下：

```sql
insert into 
product(
  type, person_count, total_count,
  enter_price, outcome_price, speed,
  salary, firstTime, secondTime
) 
values(
  '良品', 33, 777777777,
  22.22, 123.333333, 788.31,
  1820.4231, '2018-03-14 00:00:00', '2018-03-14 13:21:11'
)
```

