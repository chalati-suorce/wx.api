package com.demo.system;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo.system.dao")
public class DemoApplication {
	/*public static void main(MysqlxDatatypes.Scalar.String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}*/
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
