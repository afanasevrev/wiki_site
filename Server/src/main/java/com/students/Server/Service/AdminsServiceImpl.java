package com.students.Server.Service;

import com.students.Server.Repository.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
public class AdminsServiceImpl implements AdminsService {
    @Autowired
    private AdminsRepository adminsRepository;
}
