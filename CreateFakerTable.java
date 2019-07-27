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
		long startTime = System.currentTimeMillis();

		// 创建数据库连接
		DBTools.url("jdbc:common://localhost:3306/facker")
				.username("root")
				.password("123456")
				.driverClassName("com.common.cj.jdbc.Driver")
				.connect();

		// 产品表
		Faker.tableName("product")
				.param("id", DataType.ID)
				.param("name", Values.of("example1", "example2", "example3"))
				.param("price", Values.ofIntRange(1, 18))
				.param("tenant_id", DataType.ID)
				.param("created_by", Values.of("example1", "example2", "example3"))
				.param("updated_by", Values.of("example1", "example2", "example3"))
				.param("created_at", Values.ofTimeRange(Times.of(2019, 1, 1), Times.of(2019, 5, 1)))
				.param("updated_at", Values.ofTimeRange(Times.of(2019, 1, 1), Times.of(2019, 5, 1)))
				.param("dr", Values.ofIntRange(1, 18))
				.insertCount(100000000)
				.execute();

		long endTime = System.currentTimeMillis();

		System.out.println("总共执行： " + (endTime - startTime) + " 秒");

	}

}
