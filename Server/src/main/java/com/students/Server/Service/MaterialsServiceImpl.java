package com.students.Server.Service;

import com.students.Server.Repository.MaterialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
public class MaterialsServiceImpl implements MaterialsService {
    @Autowired
    private MaterialsRepository materialsRepository;
}
