package com.students.Server.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * Контроллер - отвечает на запросы пользователей через браузер
 */
@Controller
public class WebController {
    /**
     * Главная страница сайта
     * @return home_page.html
     */
    @GetMapping
    private String getInfo() {
        return "home_page";
    }
}
