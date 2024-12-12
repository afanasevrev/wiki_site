package com.students.Server;

import com.students.Server.Service.AdminsService;
import com.students.Server.Service.AdminsServiceImpl;
import com.students.Server.Service.StudentsService;
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
		return new StudentsService() {};
	}
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
}
