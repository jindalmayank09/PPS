/*

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class PPSApplication {

	public static void main(String[] args) {
		SpringApplication.run(PPSApplication.class, args);
	}
}*/
package com.pps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PPSApplication extends SpringBootServletInitializer {

	@Override

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(PPSApplication.class);

	}

	public static void main(String[] args) throws Exception {

		SpringApplication.run(PPSApplication.class, args);

	}

}

/*
 * @SpringBootApplication
 * 
 * public class SpringBootWebApplication {
 * 
 * 
 * 
 * public static void main(String[] args) throws Exception {
 * 
 * SpringApplication.run(SpringBootWebApplication.class, args);
 * 
 * }
 * 
 * 
 * 
 * }
 */