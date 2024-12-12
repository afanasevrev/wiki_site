package com.students.Server.Repository;

import com.students.Server.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {}