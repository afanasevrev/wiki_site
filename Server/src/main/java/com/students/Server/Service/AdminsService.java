package com.students.Server.Service;

import com.students.Server.Entity.AdminsEntity;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface AdminsService {
    String createAdmin(AdminsEntity entity);
    List<AdminsEntity> readAdmins();
    AdminsEntity readAdmin(Long id);
    String deleteAdmin(Long id);
    String updateAdmin(AdminsEntity entity, Long id);
}
