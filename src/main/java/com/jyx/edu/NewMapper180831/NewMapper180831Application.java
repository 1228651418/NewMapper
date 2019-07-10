package com.jyx.edu.NewMapper180831;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = { "com.jyx.edu.NewMapper180831.basemapper.mapper" })
public class NewMapper180831Application {

	public static void main(String[] args) {
		SpringApplication.run(NewMapper180831Application.class, args);
	}

	@Bean
	public InternalResourceViewResolver setupViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		/** 设置视图路径的前缀 */
		resolver.setPrefix("/");
		/** 设置视图路径的后缀 */
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
