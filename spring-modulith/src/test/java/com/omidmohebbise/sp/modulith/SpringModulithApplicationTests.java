package com.omidmohebbise.sp.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

//@SpringBootTest
class SpringModulithApplicationTests {

	@Test
	void contextLoads() {
		ApplicationModules modules = ApplicationModules.of(SpringModulithApplication.class);
		modules.forEach(System.out::println);
	}

}
