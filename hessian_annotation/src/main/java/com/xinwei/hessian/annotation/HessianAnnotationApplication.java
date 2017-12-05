package com.xinwei.hessian.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan ("com.xinwei.hessian.annotation")
public class HessianAnnotationApplication
{
	
	public static void main(String[] args)
	{
		SpringApplication.run(HessianAnnotationApplication.class, args);
	}
}
