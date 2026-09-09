package in.ggklass.CRUDSpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CrudSpringBootDemoApplication {

	public static void main(String[] args) {
		System.out.println("hello");
		SpringApplication.run(CrudSpringBootDemoApplication.class, args);
	}

}
