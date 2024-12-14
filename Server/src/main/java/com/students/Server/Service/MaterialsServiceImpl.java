package com.students.Server.Service;

import com.students.Server.Entity.AdminsEntity;
import com.students.Server.Entity.MaterialsEntity;
import com.students.Server.Repository.MaterialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/**
 * Класс для работы с данными материалов
 */
public class MaterialsServiceImpl implements MaterialsService {
    @Autowired
    private MaterialsRepository materialsRepository;
    @Override
    public String createMaterial(MaterialsEntity entity) {
        materialsRepository.save(entity);
        return "Новый материал добавлен";
    }
    @Override
    public List<MaterialsEntity> readMaterial() {
        return materialsRepository.findAll();
    }
    @Override
    public MaterialsEntity readMaterial(Long id) {
        return materialsRepository.findById(id).get();
    }
    @Override
    public String deleteMaterial(Long id) {
        materialsRepository.deleteById(id);
        return "Материал удалён из БД";
    }
    @Override
    public String updateMaterial(MaterialsEntity entity, Long id) {
        MaterialsEntity materialsEntity = materialsRepository.findById(id).get();
        materialsEntity.setMaterial_name(entity.getMaterial_name());
        materialsEntity.setPdf_file(entity.getPdf_file());
        materialsRepository.save(entity);
        return "Материал успешно обновлён в БД";
    }
}
