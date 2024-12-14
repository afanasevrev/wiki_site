package com.students.Server.Service;

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
        return null;
    }
    @Override
    public List<MaterialsEntity> readMaterial() {
        return null;
    }
    @Override
    public MaterialsEntity readMaterial(Long id) {
        return null;
    }
    @Override
    public String deleteMaterial(Long id) {
        return null;
    }
    @Override
    public String updateMaterial(MaterialsEntity entity, Long id) {
        return null;
    }
}
