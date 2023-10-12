package com.omidmohebbise.sp.modulith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringModulithApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringModulithApplication.class, args);

//		ApplicationModules.of(SpringModulithApplication.class);




	}

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String msg) {
		kafkaTemplate.send("person-creation", msg);
	}


	@Override
	public void run(String... args) throws Exception {
		sendMessage("Hey ...");
	}
}
