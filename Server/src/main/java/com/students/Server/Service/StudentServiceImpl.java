package com.students.Server.Service;

import com.students.Server.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
}
