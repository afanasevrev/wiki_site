package com.students.Server.Service;

import com.students.Server.Entity.StudentEntity;
import com.students.Server.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    String createStudent(StudentEntity entity);
    List<StudentEntity> readStudents();
    StudentEntity readStudent(Long id);
    String deleteStudent(Long id);
    String updateStudent(StudentEntity entity, Long id);
}
