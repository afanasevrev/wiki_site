package com.students.Server.Controller;

import com.students.Server.Entity.AdminsEntity;
import com.students.Server.Service.AdminsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * Контроллер - отвечает на запросы пользователей через браузер
 */
@Controller
public class WebController {
    private AdminsServiceImpl adminsServiceImpl = new AdminsServiceImpl();
    /**
     * Главная страница сайта
     * @return home_page.html
     */
    @GetMapping("/")
    private String getInfo() {
        return "home_page";
    }
    @GetMapping("/admins_page/add")
    private String addAdmin(Model model) {
        model.addAttribute("admins", new AdminsEntity());
        return "add_admin";
    }
}
