package com.students.Server.Repository;

import com.students.Server.Entity.MaterialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MaterialsRepository extends JpaRepository<MaterialsEntity, Long> {}