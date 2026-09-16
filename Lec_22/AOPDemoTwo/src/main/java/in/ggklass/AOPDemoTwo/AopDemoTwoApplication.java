package in.ggklass.AOPDemoTwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopDemoTwoApplication {

	public static void main(String[] args) {
		System.out.println("hello");
		SpringApplication.run(AopDemoTwoApplication.class, args);
	}
}
