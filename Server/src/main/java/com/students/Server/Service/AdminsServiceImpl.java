package com.students.Server.Service;

import com.students.Server.Entity.AdminsEntity;
import com.students.Server.Entity.StudentEntity;
import com.students.Server.Repository.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/**
 * Класс для операций над данными администраторов
 */
public class AdminsServiceImpl implements AdminsService {
    @Autowired
    private AdminsRepository adminsRepository;
    @Override
    public String createAdmin(AdminsEntity entity) {
        adminsRepository.save(entity);
        return "Администратор добавлен в БД";
    }
    @Override
    public List<AdminsEntity> readAdmins() {
        return adminsRepository.findAll();
    }
    @Override
    public AdminsEntity readAdmin(Long id) {
        return adminsRepository.findById(id).get();
    }
    @Override
    public String deleteAdmin(Long id) {
        adminsRepository.deleteById(id);
        return "Администратор удалён из БД";
    }
    @Override
    public String updateAdmin(AdminsEntity entity, Long id) {
        AdminsEntity adminsEntity = adminsRepository.findById(id).get();
        adminsEntity.setLogin(entity.getLogin());
        adminsEntity.setPassword(entity.getPassword());
        adminsEntity.setName(entity.getName());
        adminsEntity.setSurname(entity.getSurname());
        adminsEntity.setPatronymic(entity.getPatronymic());
        adminsEntity.setPosition(entity.getPosition());
        adminsRepository.save(adminsEntity);
        return "Данные администратора обновлены";
    }
}
