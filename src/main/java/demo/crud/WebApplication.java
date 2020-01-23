/*
 * 
 */
package demo.crud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("demo.crud")
public class WebApplication {
	public static void main(String argv[]) {
		SpringApplication.run(WebApplication.class, argv);
	}
}
