package com.students.Server.Repository;

import com.students.Server.Entity.AdminsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdminsRepository extends JpaRepository<AdminsEntity, Long> {}