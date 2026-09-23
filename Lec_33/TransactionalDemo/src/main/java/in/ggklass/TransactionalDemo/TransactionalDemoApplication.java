package in.ggklass.TransactionalDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionalDemoApplication {

	public static void main(String[] args) {
		System.out.println("hello world!!");
		SpringApplication.run(TransactionalDemoApplication.class, args);
	}

}
