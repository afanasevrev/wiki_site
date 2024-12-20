package com.students.Server.Service;

import com.students.Server.Entity.StudentEntity;
import java.util.List;
public interface StudentService {
    String createStudent(StudentEntity entity);
    List<StudentEntity> readStudents();
    StudentEntity readStudent(Long id);
    String deleteStudent(Long id);
    String updateStudent(StudentEntity entity, Long id);
}
