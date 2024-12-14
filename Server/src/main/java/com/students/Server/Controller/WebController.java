package com.students.Server.Controller;

import com.students.Server.Entity.AdminsEntity;
import com.students.Server.Service.AdminsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    /**
     * Откроется форма для добавления администратора
     * @return add_admin.html
     */
    @GetMapping("/admins_page/add")
    private String addAdmin(Model model) {
        model.addAttribute("admins", new AdminsEntity());
        return "add_admin";
    }
    /**
     * Post - запрос от администратора на добавление администратора в БД
     * @param adminsEntity
     * @param model
     * @return home_page.html
     */
    @PostMapping("/admins_page/add")
    private String addAdmin(@ModelAttribute AdminsEntity adminsEntity, Model model) {
        adminsServiceImpl.createAdmin(adminsEntity);
        return "add_admin";
    }
}
