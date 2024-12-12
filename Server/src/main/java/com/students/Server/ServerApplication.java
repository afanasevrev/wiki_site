package com.students.Server;

import com.students.Server.Service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/**
 * Точка запуска приложения
 */
@SpringBootApplication
public class ServerApplication {
	@Bean
	public AdminsService photoService() {
		return new AdminsServiceImpl();
	}
	@Bean
	public StudentsService userService() {
		return new StudentsServiceImpl();
	}
	@Bean
	public MaterialsService materialsService() {
		return new MaterialsServiceImpl();
	}
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
}
