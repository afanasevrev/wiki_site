package com.students.Server.Security;

import com.students.Server.Entity.AdminsEntity;
import com.students.Server.Entity.StudentEntity;
import com.students.Server.Service.AdminsService;
import com.students.Server.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import java.util.ArrayList;
import java.util.List;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private AdminsService adminsService;
    @Autowired
    private StudentService studentService;
    private final PasswordEncoder pwEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    @Bean
    UserDetailsService authentication() {
        List<AdminsEntity> admins = adminsService.readAdmins();
        List<StudentEntity> students = studentService.readStudents();

        List<UserDetails> roots = new ArrayList<>();
        for (AdminsEntity admin: admins) {
            UserDetails root = User.builder().username(admin.getLogin()).password(pwEncoder.encode(admin.getPassword())).roles("STUDENT","ADMIN").build();
            System.out.println(">>> Administrator's password: " + root.getPassword());
            roots.add(root);
        }
        for (StudentEntity student: students) {
            UserDetails user1 = User.builder().username(student.getLogin()).password(pwEncoder.encode(student.getPassword())).roles("STUDENT").build();
            System.out.println(">>> Student's password: " + user1.getPassword());
            roots.add(user1);
        }
        return new InMemoryUserDetailsManager(roots);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authz -> authz
                        .requestMatchers("/").hasRole("STUDENT")
                        .requestMatchers("/materials/**").hasRole("STUDENT")
                        .requestMatchers("/css/**").hasRole("STUDENT")
                        .requestMatchers("/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin().and() // Настройка формы логина
                .httpBasic(); // Включение базовой аутентификации
        return http.build();
    }
}
