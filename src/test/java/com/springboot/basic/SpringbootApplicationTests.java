package com.springboot.basic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootTest
@Configuration
@PropertySource("classpath:foo.properties")

class SpringbootApplicationTests {

	@Test
	void contextLoads() {

	}

}

