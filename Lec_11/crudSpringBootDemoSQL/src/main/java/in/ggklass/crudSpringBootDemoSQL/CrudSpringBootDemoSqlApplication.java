package in.ggklass.crudSpringBootDemoSQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class CrudSpringBootDemoSqlApplication {

	public static void main(String[] args) {
		System.out.println("hello world");
		SpringApplication.run(CrudSpringBootDemoSqlApplication.class, args);
	}

}
