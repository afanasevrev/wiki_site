package com.students.Server;

import com.students.Server.Service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/**
 * Точка запуска приложения
 */
@SpringBootApplication
@EnableAutoConfiguration
public class ServerApplication {
	@Bean
	public AdminsService photoService() {
		return new AdminsServiceImpl();
	}
	@Bean
	public StudentService studentService() {
		return new StudentServiceImpl();
	}
	@Bean
	public MaterialsService materialsService() {
		return new MaterialsServiceImpl();
	}
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
}
