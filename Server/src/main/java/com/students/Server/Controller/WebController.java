package com.students.Server.Controller;

import com.students.Server.Entity.AdminsEntity;
import com.students.Server.Entity.MaterialsEntity;
import com.students.Server.Entity.StudentEntity;
import com.students.Server.Service.AdminsService;
import com.students.Server.Service.MaterialsService;
import com.students.Server.Service.StudentService;
import com.students.Server.Temp.MaterialsTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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
    @Autowired
    private MaterialsService materialsService;
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
        model.addAttribute("admins", new AdminsEntity());
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
    /**
     * Страница форма для администратора на добавление студента в БД
     * @param model
     * @return add_student.html
     */
    @GetMapping("/admins_page/student/add")
    private String addStudentForm(Model model) {
        model.addAttribute("students", new StudentEntity());
        return "add_student";
    }
    /**
     * POST - запрос от администратора на добавление студента в БД
     * @param students
     * @param model
     * @return add_student.html
     */
    @PostMapping("/admins_page/student/add")
    private String addStudent(@ModelAttribute StudentEntity students, Model model) {
        model.addAttribute("students", students);
        studentService.createStudent(students);
        model.addAttribute("students", new StudentEntity());
        return "add_student";
    }
    /**
     * Метод удаляет из БД студента
     * @param id
     * @return students.html
     */
    @GetMapping("/students/delete/{id}")
    private String deleteStudent(@PathVariable String id) {
        Long studentId = Long.parseLong(id);
        studentService.deleteStudent(studentId);
        return "student_dismiss";
    }
    /**
     * Страница со списком учебных материалов
     * @param model список материалов
     * @return materials.html
     */
    @GetMapping("/materials")
    private String getMaterials(Model model) {
        List<MaterialsEntity> materials = materialsService.readMaterial();
        List<MaterialsTemp> materialsTemp = new ArrayList<>();
        for (MaterialsEntity material: materials) {
            materialsTemp.add(new MaterialsTemp(material.getId(), material.getMaterial_name()));
        }
        model.addAttribute("materialsTemp", materialsTemp);
        return "materials";
    }
    /**
     * Страница со списком материалов для администраторов
     * @param model список материалов
     * @return materials_for_admins.html
     */
    @GetMapping("/materials_for_admins")
    private String getMaterialsForAdmins(Model model) {
        List<MaterialsEntity> materials = materialsService.readMaterial();
        List<MaterialsTemp> materialsTemp = new ArrayList<>();
        for (MaterialsEntity material: materials) {
            materialsTemp.add(new MaterialsTemp(material.getId(), material.getMaterial_name()));
        }
        model.addAttribute("materialsTemp", materialsTemp);
        return "materials_for_admins";
    }
    @GetMapping("/materials_for_admins/delete/{id}")
    private String deleteMaterial(@PathVariable String id, Model model) {
        Long material_id = Long.parseLong(id);
        materialsService.deleteMaterial(material_id);
        return "material_is_delete";
    }
    /**
     * Страница материалов для администраторов
     * @param model список материалов
     * @return materials_for_admins.html
     */
    @GetMapping("/materials_for_admins/add")
    private String addMaterialForm(Model model) {
        model.addAttribute("materials", new MaterialsEntity());
        return "add_material";
    }
    /**
     * POST - запрос от администратора системы на добавление материала в БД
     * @param file
     * @return add_material.html
     */
    @PostMapping("/materials_for_admins/add")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        // Здесь добавьте логику для обработки файла
        try {
            byte[] filePDF = file.getBytes();
            materialsService.createMaterial(new MaterialsEntity(file.getOriginalFilename(), filePDF));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "add_material"; // Перенаправление или возврат ответа после обработки файла
    }
    @GetMapping("/materials/download/{id}")
    private ResponseEntity<byte[]> downloadDocument(@PathVariable String id) {
        Long documentId = Long.parseLong(id);
        byte[] resource = materialsService.readMaterial(documentId).getPdf_file();
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=material.pdf").body(resource);
    }
}
