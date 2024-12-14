package com.students.Server.Service;

import com.students.Server.Entity.StudentEntity;
import com.students.Server.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Класс для операций над данными студентов
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public String createStudent(StudentEntity entity) {
        studentRepository.save(entity);
        return "Студент добавлен в БД";
    }
    @Override
    public List<StudentEntity> readStudents() {
        return studentRepository.findAll();
    }
    @Override
    public StudentEntity readStudent(Long id) {
        return studentRepository.findById(id).get();
    }
    @Override
    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Студент удален из БД";
    }
    @Override
    public String updateStudent(StudentEntity entity, Long id) {
        StudentEntity studentEntity = studentRepository.findById(id).get();
        studentEntity.setFaculty(entity.getFaculty());
        studentEntity.setLogin(entity.getLogin());
        studentEntity.setPassword(entity.getPassword());
        studentEntity.setSurname(entity.getSurname());
        studentEntity.setName(entity.getName());
        studentEntity.setPatronymic(entity.getPatronymic());
        studentRepository.save(studentEntity);
        return "Данные студента обновлены";
    }
}
