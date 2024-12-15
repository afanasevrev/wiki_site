package com.students.Server.Controller;

import com.students.Server.Entity.AdminsEntity;
import com.students.Server.Entity.StudentEntity;
import com.students.Server.Service.AdminsService;
import com.students.Server.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
/**
 * Контроллер - отвечает на запросы пользователей через браузер
 */
@Controller
public class WebController {
    @Autowired
    private AdminsService adminsService;
    @Autowired
    private StudentService studentService;
    /**
     * Главная страница сайта
     * @return home_page.html
     */
    @GetMapping("/")
    private String getInfo() {
        return "home_page";
    }
    /**
     * Страница для администраторов системы
     * @return admins_page.html
     */
    @GetMapping("/admins_page")
    private String getAdminsPage() {
        return "admins_page";
    }
    /**
     * Откроется форма для добавления администратора
     * @return add_admin.html
     */
    @GetMapping("/admins_page/add")
    private String addFormAdmin(Model model) {
        model.addAttribute("admins", new AdminsEntity());
        return "add_admin";
    }
    /**
     * Post - запрос от администратора на добавление администратора в БД
     * @param admins
     * @param model
     * @return home_page.html
     */
    @PostMapping("/admins_page/add")
    private String addAdmin(@ModelAttribute AdminsEntity admins, Model model) {
        model.addAttribute("admins", admins);
        adminsService.createAdmin(admins);
        return "add_admin";
    }
    /**
     * Страница список студентов для
     * администраторов системы
     * @param model список студентов
     * @return students.html
     */
    @GetMapping("/students")
    private String getStudents(Model model) {
        List<StudentEntity> students = studentService.readStudents();
        model.addAttribute("students", students);
        return "students";
    }
}
