package com.students.Server.Service;

import com.students.Server.Entity.MaterialsEntity;
import java.util.List;
public interface MaterialsService {
    String createMaterial(MaterialsEntity entity);
    List<MaterialsEntity> readMaterial();
    MaterialsEntity readMaterial(Long id);
    String deleteMaterial(Long id);
    String updateMaterial(MaterialsEntity entity, Long id);
}
