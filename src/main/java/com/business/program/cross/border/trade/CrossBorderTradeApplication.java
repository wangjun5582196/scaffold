package com.business.program.cross.border.trade;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@MapperScan(basePackages = "com.business.program.cross.border.trade.repository.mapper")
public class CrossBorderTradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrossBorderTradeApplication.class, args);
	}

}
